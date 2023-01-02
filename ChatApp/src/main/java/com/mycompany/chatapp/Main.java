package com.mycompany.chatapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

public class Main extends javax.swing.JFrame implements Runnable {

    private boolean stop;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm");
    private final String HOST = "localhost";
    private final int PORT = 8888;
    private String pseudo;
    private Socket client;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private InetSocketAddress socketAdress;
    private ObjectChat currentChat;
    
    
    public Main() {
        initComponents();
        chatPanel.setLayout(new MigLayout("fillx"));
        stop = false;
    }
    
     public void arret() throws IOException {
        in.close();
        out.close();
        stop = true;
        System.exit(0);
    }
     
    public void setClient(Socket client) {
        this.client = client;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    public void setCurrentChat(ObjectChat currentChat) {
        this.currentChat = currentChat;
    }
    
    
    public void createField(ObjectChat cO, int type) {
        String message = cO.getMessage();
        String infos = cO.getEnvoyeur() + " | " + cO.getTime();
        if(type == 0) 
        {
            //ajout d'un item_recep
            item_recep recep = new item_recep(message, infos);
            chatPanel.add(recep, "wrap, w ::80%");
            
        }
        else if(type == 1) {
            //ajout d'unh item_send
            item_send send = new item_send(message, infos);
            chatPanel.add(send, "wrap, al right, w ::80%");
        }
        
        chatPanel.repaint();
        chatPanel.revalidate();
        
        //on utilise invokelater pour etre sur que le chatScroll se remette bien tout en bas à chaque ajout de chat (ça ne fonctionnait pas sans)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JScrollBar verticalScrollBar = chatScroll.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMaximum());
            }
        });
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        chatScroll = new javax.swing.JScrollPane();
        chatPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        menuLabel = new javax.swing.JLabel();
        closeButton = new com.mycompany.chatapp.Boutton();
        jPanel2 = new javax.swing.JPanel();
        AppTitle = new javax.swing.JLabel();
        responseServerArea = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageBox = new javax.swing.JTextArea();
        sendButton = new com.mycompany.chatapp.Boutton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 750));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        chatScroll.setBackground(new java.awt.Color(255, 255, 255));
        chatScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatScroll.setToolTipText("");
        chatScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        chatPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout chatPanelLayout = new javax.swing.GroupLayout(chatPanel);
        chatPanel.setLayout(chatPanelLayout);
        chatPanelLayout.setHorizontalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        chatPanelLayout.setVerticalGroup(
            chatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );

        chatScroll.setViewportView(chatPanel);

        jPanel1.setBackground(new java.awt.Color(55, 73, 85));
        jPanel1.setToolTipText("");

        menuLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuLabel.setForeground(new java.awt.Color(255, 255, 255));
        menuLabel.setText("MENU");

        closeButton.setBackground(new java.awt.Color(235, 153, 41));
        closeButton.setText("×");
        closeButton.setColor(new java.awt.Color(235, 153, 41));
        closeButton.setColorClick(new java.awt.Color(235, 186, 119));
        closeButton.setColorOver(new java.awt.Color(235, 169, 79));
        closeButton.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        closeButton.setMargin(new java.awt.Insets(-4, 14, 3, 14));
        closeButton.setMaximumSize(new java.awt.Dimension(64, 64));
        closeButton.setMinimumSize(new java.awt.Dimension(64, 64));
        closeButton.setPreferredSize(new java.awt.Dimension(64, 64));
        closeButton.setRadius(100);
        closeButton.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(menuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(572, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(235, 153, 41));

        AppTitle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        AppTitle.setForeground(new java.awt.Color(55, 73, 85));
        AppTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AppTitle.setText("CHAT-APP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(AppTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        responseServerArea.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        responseServerArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        responseServerArea.setText("infos");

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        messageBox.setColumns(20);
        messageBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        messageBox.setRows(5);
        jScrollPane2.setViewportView(messageBox);

        sendButton.setBackground(new java.awt.Color(235, 153, 41));
        sendButton.setText("ENVOYER");
        sendButton.setColor(new java.awt.Color(235, 153, 41));
        sendButton.setColorClick(new java.awt.Color(235, 191, 131));
        sendButton.setColorOver(new java.awt.Color(235, 173, 89));
        sendButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sendButton.setRadius(25);
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(responseServerArea, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(responseServerArea, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chatScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                            .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String message = messageBox.getText().trim();

        if(!message.isEmpty()) {
            ObjectChat chat = new ObjectChat(LocalTime.now().format(dateFormat), message, pseudo);
            setCurrentChat(chat);
            try {
                System.out.println("Chat envoye a " + HOST);
                out.writeObject(currentChat);
                messageBox.setText("");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        try {
            arret();
        }catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }//GEN-LAST:event_closeButtonActionPerformed

    
    @Override
    public void run() {
        final int timeout = 3000;

        try {
            setClient(new Socket());
            socketAdress = new InetSocketAddress(InetAddress.getByName(HOST), PORT);
            client.connect(socketAdress, timeout);
            setIn(new ObjectInputStream(client.getInputStream()));
            setOut(new ObjectOutputStream(client.getOutputStream()));
            ObjectChat confirmation = (ObjectChat) in.readObject();
            responseServerArea.setText(confirmation.getMessage());//confirmation de connexion du server

            setIn(new ObjectInputStream(client.getInputStream()));
            
            //saisie du pseudo et attente de validation du server:
            ObjectChat responseServer;
            ObjectChat testPseudo;
            
            //affichage de la fenetre de login:
            LoginPage log = new LoginPage(this);
            log.setLocationRelativeTo(null);
            log.setVisible(true);
            boolean ok = false;
            do {
                //envoi du pseudo:
                testPseudo = log.getChatObject();   
                if(testPseudo != null && testPseudo.getMessage() != pseudo) {
                    setPseudo(testPseudo.getMessage());
                    out.writeObject(testPseudo);
                    
                    //reception de la demande/validation de pseudo du server:
                    responseServer = (ObjectChat) in.readObject();
                    setCurrentChat(responseServer);
                    if((currentChat.getMessage()).contains("Bienvenue")) {
                        ok = true;
                        log.dispose();
                    }
                    else if((currentChat.getMessage()).contains("pris")) {
                        JOptionPane.showMessageDialog(log, currentChat.getMessage());
                    }
                    else {
                        JOptionPane.showMessageDialog(log, currentChat.getMessage());
                    }
                }
                Thread.sleep(100);
                

            } while (!ok);

            //demarrage du processus de reception
            Thread.sleep(1000);
            ChatRecep recep = new ChatRecep();
            Thread recepThread = new Thread(recep);
            recepThread.start();


        } catch (IOException e) {
            System.err.println("connexion impossible avec " + HOST);
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    class ChatRecep implements Runnable {

        @Override
        public void run() {
            try {
                //reception et affichage des Chats
                ObjectChat chatIn;
                chatIn = (ObjectChat) in.readObject();
                if (chatIn != null) {
                    do {
                        if (!Objects.equals(chatIn.getEnvoyeur(), pseudo)) {
                            createField(chatIn, 0
                            );
                        }
                        else {
                            createField(chatIn, 1);
                        }

                        chatIn = (ObjectChat) in.readObject();
                    } while (chatIn != null && !stop);
                }

            } catch (IOException e) {
                System.exit(1);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }
    
    
    public static void main(String args[]) {
        Main client = new Main();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                client.setVisible(true);
            }
        });
        client.run();
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppTitle;
    private javax.swing.JPanel chatPanel;
    private javax.swing.JScrollPane chatScroll;
    private com.mycompany.chatapp.Boutton closeButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel menuLabel;
    private javax.swing.JTextArea messageBox;
    private javax.swing.JLabel responseServerArea;
    private com.mycompany.chatapp.Boutton sendButton;
    // End of variables declaration//GEN-END:variables
}
