package com.mycompany.chatapp;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class ServerChat implements Runnable {

    private HashMap<String, socketConnexion> connexionMap;
    private boolean stop;
    private ThreadGroup connexionGroup = new ThreadGroup("connexions");
    private ServerSocket server;
    private ObjectOutputStream outConfirm;
    private int nbConnexions;
    private static final int PORT = 8888;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");


    public ServerChat() {
        connexionMap = new HashMap<>();
        stop = false;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public void diffuseChat(ObjectChat chat) throws IOException {
        System.out.println( chat.getTime() + " | " + chat.getEnvoyeur() + " a envoye " + chat.getMessage() + "\n");//verification du trafic sur le serveur
        for(socketConnexion client:connexionMap.values()) {
            client.out.writeObject(chat);
        }
    }

    public void arret() throws IOException {
        for(socketConnexion socket:connexionMap.values()) {
            if(!socket.client.isClosed()) {
                socket.in.close();
                socket.out.close();
                socket.client.close();
            }
        }
        outConfirm.close();
        stop = true;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(PORT);
            while(!stop) {
                Socket client = server.accept();
                ObjectChat newCon = new ObjectChat(LocalTime.now().format(dateFormat), "Connecté à " + InetAddress.getLocalHost().getHostAddress(), "Server");
                System.out.println("Nouvelle connexion etablie");
                outConfirm = new ObjectOutputStream(client.getOutputStream());
                outConfirm.writeObject(newCon);//reponse au client
                socketConnexion socketClient = new socketConnexion(client);
                new Thread(connexionGroup, socketClient).start();

                //affichage du nombre des connexions (a changer)
                nbConnexions = connexionGroup.activeCount();
                System.out.println("Nombre de clients connectes: "+ nbConnexions);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    class socketConnexion implements Runnable {

        private final Socket client;
        private String userPseudo;
        private ObjectInputStream in;
        private ObjectOutputStream out;

        public socketConnexion(Socket client) {
            this.client = client;
        }

        public String getUserPseudo() {
            return userPseudo;
        }

        public void sendChat(ObjectChat chat) throws IOException {
            out.writeObject(chat);
        }

        @Override
        public void run() {
            try {
                in = new ObjectInputStream(client.getInputStream());
                out = new ObjectOutputStream(client.getOutputStream());

                //reception du pseudo et test si le pseudo est acceptable:
                ObjectChat pseudoClient;
                String pseudo;
                boolean ok = false;
                int count;
                ObjectChat alrdyTaken = new ObjectChat(LocalTime.now().format(dateFormat), "Ce pseudo est deja pris", "Server");
                ObjectChat wrongPseudo = new ObjectChat(LocalTime.now().format(dateFormat), "Le pseudo ne peut contenir que des lettres et des chiffres\nExemple: Chris123", "Server");
                //Demande de pseudo:
                while(!ok) {
                    pseudoClient = (ObjectChat) in.readObject();
                    pseudo = pseudoClient.getMessage();
                    count = 0;
                    if(!pseudo.toLowerCase().isEmpty()) {//test si il n'est pas vide
                        //test si il contient bien uniquement des lettres et des chiffres:
                        Pattern pattern = Pattern.compile("^[a-zA-Z]{1,20}[0-9]{0,3}$");
                        if(!pattern.matcher(pseudo).matches()) {
                            sendChat(wrongPseudo);
                        }
                        
                        for (String ps : connexionMap.keySet()) {//test si le pseudo est deja pris:
                            if (Objects.equals(ps, pseudo)) {
                                sendChat(alrdyTaken);
                                break;
                            }
                            else count++;
                        }
                        if (count == connexionMap.size()) {
                            userPseudo = pseudo;
                            ok = true;
                        }
                    }
                }//le pseudo est maintenant bon
                connexionMap.put(this.getUserPseudo(), this);
                sendChat(new ObjectChat(LocalTime.now().format(dateFormat), "Bienvenue " + userPseudo, "Server")); //renvoi du pseudo validé pour le sauvegarder

                //reception du message du client:
                ObjectChat chat;
                chat = (ObjectChat) in.readObject();
                if(chat != null) {
                    do {
                        diffuseChat(chat);
                        chat = (ObjectChat) in.readObject();
                    } while(client.isConnected());
                    connexionMap.remove(userPseudo);//On enleve le client de la HashMap si il se deconnecte
                }

            }catch (IOException e) {
                connexionMap.remove(userPseudo);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        InetAddress IP = InetAddress.getLocalHost();
        System.out.println("----------------------------------");
        System.out.println("| IP de ce serveur: " + IP.getHostAddress() + " |");
        System.out.println("| Port de ce serveur: " + PORT + "       |");
        System.out.println("----------------------------------");
        ServerChat server = new ServerChat();
        server.run();
    }
}

