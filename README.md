# Deroulement de la création du projet



## I-Application sans interface graphique (uniquement dans le terminal)

### 1/ Creation des classes Server, Client et de ChatObject dans les grandes lignes
   
	=> les objets ChatObject permettent de recuperer plus de données qu'une simple
       	   chaine de caractere, comme une date d'envoi etc...
           ChatObjet implemente serializable pour pouvoir etre envoyé

	=> server implemente runnable pour pouvoir creer un thread par nouvelle
           connexion


### 2/ Approfondissement de la classe Server (ServerChat.java)

	=> creation d'une sous-classe "socketConnexion" qui defini chaque connexion

	=> methode "sendChat" qui envoie le message et qui le diffuse a tous les utilisateurs

	=> methode "arret" qui permet d'arreter le thread associé au client et le server

	=> creation d'un ThreadGroup pour recuperer le nombre de connexions en temps réel avec la
           methode activeCount()
	   

### 3/ Approfondissement de la classe Client (Main.java)
	
	=> methode arret():
            -> 1ere version: lorsque le client envoie au server "!exit", le serveur envoie un ordre de deconnexion
               au client et cet ordre appel la methode stop() qui va fermer le client
	       

## II-Application avec interface graphique

### 1/ JFrame

	=> J'utilise Jframe pour creer l'interface de l'app, je me renseigne sur internet pour apprendre a utiliser
   	   Jframe

	=> J'ai au des problemes d'affichage des bulles avec PaintComponent:
		-> les bulles qui s'affiche en dehors de le zone dédiée ne permettent pas d'agrandir le JPanel
	  	   des chat, et donc le ScrollPane ne fonctionnait pas.

	=> J'ai découvert sur internet une librairie externe nommée MigLayout qui permet de resoudre ce probleme

	=> Je suis passé sur NetBeans car IntelliJ me posait de nombreuses contraintes par rapport à NetBeans,
	   NetBeans possède une interface de personnalisation java swing bien plus simple et maniable
	
	=> Mise en place d'une interface graphique:
		-> textfield pour ecrire le message
		-> bouton personnalisé pour divers usages
		-> la classe Chat.java dessine les bulles de chat
		-> les classes (item_send et item_recep).java definissent les bulles + le pseudo + l'heure d'envoi
		   en fonction d'un envoi ou d'une reception (variation de couleur et de position)
		-> 
	
### 2/ Approfondissement

	=> methode arret():
		-> 2eme version (finale): j'ai préféré remplacer le "!exit" par un bouton qui permet de fermer le client,
	           le server se charge de supprimer le socket du client qui s'est deconnecté de sa liste de sockets
	           (en utilisant la methode isConnected() le server est informé de la deconnexion)

	=> la classe LoginPage.java permet au client de recevoir à travers une interface le pseudo de l'utilisateur:
		-> le pseudo voulu est envoyé au client qui le renvoie au server pour une verification
		-> le server verifie si le pseudo est valide et si il n'est pas déjà utilisé
		-> le client attend la validation du server et actualise ensuite son pseudo associé
	   
	=> à chaque nouveau message (reçu ou envoyé) la bar de scroll est remise automatiquement en bas pour eviter de forcer 
	   l'utilisateur à suivre le fil de la discussion manuellement
