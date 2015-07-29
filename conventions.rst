Conventions utilisées
---------------------

Nous nous sommes servis d'un certain nombre de conventions dans la structure de nos classes de test etc

Une classe de tests en Java
~~~~~~~~~~~~~~~~~~~~~~~~~~~

Tout d'abord, et c'est important, toutes vos classes de test devront se retrouver dans le package ``student``, c'est impératif pour qu'INGInious puisse lancer le code de l'étudiant de manière plus sécurisée pour qu'il ne puisse pas interférer avec vos fichiers.

Lorsque les exercices ne sont pas trop conséquents (une seule ou quelques questions seulement), on retrouvera souvent une classe Java qui contient tous les tests à exécuter par le container et une classe séparée qui contiendra le code de l'étudiant. 

Avant de publier vos exercices, vous remplirez vous-même la classe du code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur et de vérifier s'il n'y a pas d'erreur de compilation et si les tests fonctionnent correctement. Le fait de séparer le code de l'étudiant des codes de test permet d'éviter que des erreurs de compilation du code de l'étudiant n'affiche une partie des tests exécutés pour le tester. 

Pour ce qui est de la classe de tests, c'est elle qui contiendra la méthode main que le container exécutera. En général, la classe de tests utilisera ``JUnit``. 

La méthode main
^^^^^^^^^^^^^^^

Pour se faciliter la tâche, la méthode ``main`` aura toujours la même forme. Vous pourrez donc la copier-coller directement dans votre classe de test : 

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
	
La méthode ``main`` retourne 127 lorsque tout s'est passé correctement. Cela permettra a INGInious de constater que l'exercice a été réussi et d'afficher un feedback "vert". Chaque erreur sera affichée sur ``System.err``. Cela permettra à INGInious d'afficher à l'étudiant les erreurs survenues lors des tests effectués si l'exercice n'a pas été réussi. Si l'exercice n'est pas réussi, INGinious affichera à l'étudiant tout ce qui aura été écrit sur ``System.err``, donc n'affichez pas d'informations inutiles pour l'étudiant et encore moins des "flags" pour débugger vos tests.
La méthode ``JUnitCore.runClasses`` est la méthode qui lancera toutes les méthodes de tests que vous aurez rédigées.

Les méthodes de test
^^^^^^^^^^^^^^^^^^^^

Comme nous utilisons JUnit pour les méthodes de Test, la manière la plus simple de rédiger les tests est de faire une méthode par test unitaire. Pour que la méthode ``JUnitCore.runClasses`` sache quelle méthode exécuter pour les tests, la signature de chaque méthode de Test doit avoir le label ``@Test`` sur la ligne au-dessus. Prenons un exemple d'une courte méthode de test : 

.. code-block:: java
	
	
	private static String str = "Le code semble comporter des erreurs : ";

	/**
	 * 	@pre	-
	 * 	@post	Teste le code de l'étudiant avec un n positif valant de 0 à 20
	 * 			Lance une AssertionError lorsque le code est incorrect.
	 */
	@Test
	public void testPos(){
		try{
			int sum = 0;
			for(int i = 0 ; i < 20 ; i++){
				// À chaque itération, on calcule sum, qui contient la réponse que devrait fournir
				// la méthode de l'étudiant
				sum += i*2;
				// On récupère le résultat fourni par la méthode de l'étudiant
				int res = M1Q7Stu.sumFirstEvenIntegers(i);
				// On vérifie que le résultat est bien égal à sum, sinon, AssertionError.
				assertEquals(str + "pour les "+i+" premiers entiers pairs, la somme devrait "+ 
					     "donner+" +sum+" mais le résultat obtenu est "+res+".",
					     sum, res);
			}
		}catch (ArithmeticException e){
			fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
		}catch(StringIndexOutOfBoundsException e){
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
		}
	}
	
On peut constater plusieurs choses :

- Tout d'abord, le préfixe ``@Test`` est bien sur la ligne précédant la signature de la méthode. 
- Ensuite, la méthode est de type ``void`` et ne prend aucun argument. 
- Finalement, la méthode n'est pas ``static``. 

Toutes les méthodes de test devront avoir ces caractéristiques.

Le principe de base est qu'une méthode de test devra lancer une ``AssertionError`` lorsque l'étudiant a fourni une réponse incorrecte sur INGInious. Le but n'est pas de lancer directement une ``AssertionError`` avec l'instruction ``throw`` mais d'utiliser les méthodes de ``JUnit`` comme ``AssertEquals`` qui lanceront une ``AssertionError`` lorsque la réponse reçue ne correspond pas à ce qui est attendu.

La méthode ``runClasses`` qui lance les classes de test ``catch`` automatiquement les exceptions survenues dans les méthodes de test. Le souci est que le message diffusé sur System.err n'est pas clair du tout et pas forcément compréhensible par un étudiant de BAC1, surtout en début d'année. Par convention, on s'occupera d'entourer les tests dans les méthodes de test par un ``try ...catch`` pour fournir un message d'erreur plus clair pour l'étudiant.  En général, il vous suffira de nouveau de copier/coller le ``try ...catch`` de la méthode de test ci-dessus pour l'intégrer à vos méthodes de test. Encore une fois, il n'est pas obligatoire d'utiliser des ``try ...catch`` dans les méthodes de test mais c'est important pour faciliter la compréhension des étudiants. Dans les clauses ``catch``, l'instruction ``fail`` de JUnit suffira à indiquer qu'une erreur est survenue, mais, cette fois, avec un message d'erreur plus clair.

Nommage des fichiers classes Java
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Une fois vos classes écrites, il faut ensuite pouvoir les porter sur INGInious. Pour cela, nous avons écrit un template d'un script écrit en ``bash``. Le but est que vous puissiez l'utiliser sans pour autant avoir des connaissances en ``bash`` qui est un langage qui peut s'avérer désagréable à utiliser et que vous n'êtes pas forcément sensé connaître en fin de 1ère BAC. Si vous respectez les conventions énoncées plus bas, vous ne devrez modifier qu'une ou deux variables dans l'entête du script, ce qui vous facilitera grandement la tâche. Vous pouvez aussi ne pas du tout les respecter et modifier le template pour qu'il convienne à vos exigeances, c'est un bon entraînement mais aussi un vecteur d'erreurs, nous vous recommandons vivement de respecter les conventions de nommages des fichiers ci-dessous.

Idéalement, les classes de test seront décomposées en deux fichiers distincts :

- La classe principale, qui contient la méthode ``main`` ainsi que les classes de test. C'est cette classe qui sera exécutée par INGInious. Vous pouvez choisir son nom, prenons par exemple ``ClasseInginious``. Le fichier du code source devra alors s'appeler ``ClasseInginious.java``.
- La classe contenant le code de l'étudiant, séparée de la classe principale pour ne pas qu'une erreur mal placée puisse afficher le code des méthodes de test lors de la compilation. Cette classe aura le même nom que la classe principale, mais avec le suffixe "``Stu``", pour indiquer qu'il s'agit de la classe contenant le code de l'étudiant. La classe s'appellera donc ``ClasseInginiousStu`` et le fichier du code source devra alors s'appeler ``ClasseInginiousStu.java``.

.. pas fini
