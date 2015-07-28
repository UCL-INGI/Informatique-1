Conventons utilisées
====================

Nous nous sommes servis d'un certain nombre de conventions dans la structure de nos classes de test...

Une classe de tests en Java
===========================

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
