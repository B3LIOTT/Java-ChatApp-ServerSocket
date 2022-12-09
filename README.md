# Java-ChatApp-ServerSocket



I-Application sans interface graphique (uniquement dans le terminal...)

1/
-> creation des classes Server, Client et de ChatObject dans les grandes lignes
   
    => les objets ChatObject permettent de recuperer plus de données qu'une simple
       chaine de caractere, comme une date d'envoi etc...
       ChatObjet implemente serializable pour pouvoir etre envoyé

    => server implemente runnable pour pouvoir creer un thread par nouvelle
       connexion


2/
-> approfondissement de la classe Server

    => creation d'une sous-classe "socketConnexion" qui defini chaque connexion

    => methode "sendChat" qui envoie le message et qui le diffuse a tous les utilisateurs

    => methode "arret" qui permet d'arreter le thread associé au client et le server

    => creation d'un ThreadGroup pour recuperer le nombre de connexions en temps réel avec la
       methode activeCount()

3/
-> approfondissement de la classe Client
	
	=> methode arret():
            -> lorsque le client envoie au server "!exit", le serveur envoie un ordre de deconnexion
               au client et cet ordre appel la methode stop() qui va fermer le client


II-Application avec interface graphique

1/
-> J'utilise Jframe pour creer l'interface de l'app, je me renseigne sur internet pour apprendre a utiliser
   Jframe

-> J'ai decouvert qu'il etait possible d'importer des icons pour le design de l'app, j'ai donc créé mes propres
   icons/logo... sur after effect pour les importer dans mon projet et ameliorer son design


2/
-> J'ai au des problemes d'affichage des bulles avec PaintComponent:
	=>les bulles qui s'affiche en dehors de le zone dédiée ne permettent pas d'agrandir le JPanel
	  des chat, et donc le ScrollPane ne fonctionnait pas.

-> J'ai découvert sur internet une librairie externe nommée MigLayout qui permet de resoudre ce probleme

-> Je suis passé sur NetBeans car IntelliJ me posait de nombreuses contraintes par rapport à NetBeans,
	NetBeans possède une interface de personnalisation java swing bien plus simple et maniable


--------------------------------------Problemes rencontres--------------------------------------

-> Lorsque l'on creer un ois/ous cote server et client, il sont reliés par un header. Ainsi lorsque
   l'on creer des nouveayx ois/ous d'un coté, il faut en creer des nouveaux de l'autre.
       
       => Les methodes setIn() et setOut() permettent d'avoir des ois/ous accessibles partout
           dans la classe ClientChat sans avoir a en recreer

-> le chatArea occupe un grand espace mais le texte ne s'affiche pas partout...

-> Lors de la transition Jframe->JavaFX, je me suis rendu compte que la structure du projet devait changer:
	=> il faut creer un controller pour le client pour bien implementer JavaFX dans ce projet.
	   J'ai trouvé cette solution en cherchant sur internet la structure d'un code en javaFX
	   car je voyais JavaFX venait imposer beacoup de contraintes sur mon code...

--------------------------------------Conclusion--------------------------------------

=> Ce projet m'a permis d'apprendre enormements de choses, notement comment structurer une application comportant une interface graphique, 
   ce qui m'etait totalement inconnu.
   
