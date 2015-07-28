===================================
Publier des exercices sur INGInious
===================================

.. contents:: Table des matières

Introduction
--------------

Ce manuel vous permettra de comprendre de quelle manière ont été rédigés les exercices sur INGInious et comment vous pourrez en soumettre de nouveau vous-même. En plus de contribuer à un projet Open Source, publier un exercice sur INGInious constitue un excellent entraînement, non seulement en Java, mais aussi dans la maîtrise de différents outils informatiques qui vous seront certainement utiles par après.

Pour corriger un exercice, INGInious va démarrer ce que l'on appelle un *container*. Cela correspond à une sous-machine virtuelle, permettant d'exécuter du code, comme sur un ordinateur à part. La correction de l'exercice INGInious se fait donc en résupérant le code écrit par l'étudiant et en l'insérant dans la méthode/classe qu'il a du compléter. Ensuite, le container exécute le programme Java comme n'importe quel ordinateur. Le programme que le container exécute correspond à la suite de tests qui a été écrite par l'équipe enseignante ou encore par les étudiants qui auront lu ce manuel.

Même si en pratique, rien ne l'y oblige, pour le cours de LFSAB1401/SINF1101, les tests unitaires sont en général écrits avec la librairie ``JUnit``, qui permet d'écrire des tests avec des méthodes simples à comprendre. 

Ce manuel abordera des bonnes pratiques en Java pour écrire des classes de tests ainsi que la façon d'intégrer ces classes de Test avec INGInious. En effet, pour que le travail soit le plus simple possible, il sera important de respecter certaines conventions, par exemple pour le nom des fichiers, pour les valeurs de retour de certaines fonctions ou encore pour l'affichage des erreurs sur INGInious. Personne n'est obligé de suivre ces conventions, mais nous les avons établies pour que vous ayiez plus facile à publier de nouveaux exercices.

Installer JUnit
---------------

``JUnit`` est déjà intégré dans ``BlueJ`` et ``Eclipse``. Les notes du cours expliquent déjà comment utiliser JUnit sur ``BlueJ``. Les explications suivantes vous intéresseront si vous compilez vos programme avec le terminal (ce qui est un bon entraînement et vous permettra de comprendre comment fonctionne le container).

Pour installer ``Junit``, il vous faudra télécharger les deux fichiers JAR contenant la librairie : ``hamcrest-core.jar`` et ``junit.jar``, disponibles sur le site de Junit_.

.. _Junit: https://github.com/junit-team/junit/wiki/Download-and-Install

Une fois ces deux fichiers téléchargés, il vous suffira de les ajouter à votre classpath. Pour ce faire, il suffira d'ajouter l'option ``-cp`` lors de la compilation et de l'exécution du programme, avec comme argument l'emplacement des deux fichiers. Par exemple, si vous avez placés ces deux fichiers dans le répertoire ``/usr/share/java/`` (location standard), il vous suffit de compiler vos fichiers comme ceci :

.. code-block:: bash
	
	javac -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1.java MonFichier2.java
	
Vous pourrez ensuite exécuter votre programme comme ceci : 

.. code-block:: bash

	java -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1
	
*Notez que les ":" dans les chemins des fichiers .jar permettent d'indiquer à l'option ``cp`` que l'on donne le chemin d'un nouveau fichiers .jar contenant une librairie Java.*

Une classe de tests en Java
---------------------------

Lorsque les exercices ne sont pas trop conséquents (une seule ou quelques questions seulement), on retrouvera souvent une classe Java qui contient tous les tests à exécuter par le container et une classe séparée qui contiendra le code de l'étudiant. 

Avant de publier vos exercices, vous remplirez vous-même la classe du code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur et de vérifier s'il n'y a pas d'erreur de compilation et si les tests fonctionnent correctement. Le fait de séparer le code de l'étudiant des codes de test permet d'éviter que des erreurs de compilation du code de l'étudiant n'affiche une partie des tests exécutés pour le tester. 

Pour ce qui est de la classe de tests, c'est elle qui contiendra la méthode main que le container exécutera. En général, la classe de tests utilisera ``JUnit``. Pour se faciliter la tâche, la méthode ``main`` aura toujours la même forme. Vous pourrez donc la copier-coller directement dans votre classe de test : 

.. code-block:: java

	public static void main(String[] args){
    		// On lance toutes les méthodes de test de la classe.
		Result result = JUnitCore.runClasses(M4Q7.class);
		// Pour toutes les erreurs survenues
		for (Failure failure : result.getFailures()) {
			// On affiche l'erreur sur la sortie standard
			System.err.println(failure.toString());
		}
		// Si aucune erreur n'est survenue
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			// On quitte en retournant 127 (il est important de bien retourner 127) 
			System.exit(127);
		}
	}
	
.. pas fini


