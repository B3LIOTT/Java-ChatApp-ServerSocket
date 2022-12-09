# Deroulement de la création du projet



## I-Application sans interface graphique (uniquement dans le terminal)

### 1/ Creation des classes Server, Client et de ChatObject dans les grandes lignes
   
	=> les objets ChatObject permettent de recuperer plus de données qu'une simple
       	   chaine de caractere, comme une date d'envoi etc...
           ChatObjet implemente serializable pour pouvoir etre envoyé

	=> server implemente runnable pour pouvoir creer un thread par nouvelle
           connexion


### 2/ Approfondissement de la classe Server

	=> creation d'une sous-classe "socketConnexion" qui defini chaque connexion

	=> methode "sendChat" qui envoie le message et qui le diffuse a tous les utilisateurs

	=> methode "arret" qui permet d'arreter le thread associé au client et le server

	=> creation d'un ThreadGroup pour recuperer le nombre de connexions en temps réel avec la
           methode activeCount()

### 3/ Approfondissement de la classe Client
	
	=> methode arret():
            -> lorsque le client envoie au server "!exit", le serveur envoie un ordre de deconnexion
               au client et cet ordre appel la methode stop() qui va fermer le client


## II-Application avec interface graphique

### 1/
	=> J'utilise Jframe pour creer l'interface de l'app, je me renseigne sur internet pour apprendre a utiliser
   	   Jframe


### 2/
	=> J'ai au des problemes d'affichage des bulles avec PaintComponent:
		-> les bulles qui s'affiche en dehors de le zone dédiée ne permettent pas d'agrandir le JPanel
	  	   des chat, et donc le ScrollPane ne fonctionnait pas.

	=> J'ai découvert sur internet une librairie externe nommée MigLayout qui permet de resoudre ce probleme

	=> Je suis passé sur NetBeans car IntelliJ me posait de nombreuses contraintes par rapport à NetBeans,
	   NetBeans possède une interface de personnalisation java swing bien plus simple et maniable


--------------------------------------Problemes rencontres--------------------------------------



--------------------------------------Conclusion--------------------------------------

=> Ce projet m'a permis d'apprendre enormements de choses, notement comment structurer une application comportant une interface graphique, 
   ce qui m'etait totalement inconnu.
   
