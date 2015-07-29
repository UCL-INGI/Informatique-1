===================================
Publier des exercices sur INGInious
===================================

Introduction
============

Ce manuel vous permettra de comprendre de quelle manière ont été rédigés
les exercices sur INGInious et comment vous pourrez en soumettre de
nouveau vous-même. En plus de contribuer à un projet Open Source,
publier un exercice sur INGInious constitue un excellent entraînement,
non seulement en Java, mais aussi dans la maîtrise de différents outils
informatiques qui vous seront certainement utiles par après.

Pour corriger un exercice, INGInious va démarrer ce que l'on appelle un
*container*. Cela correspond à une sous-machine virtuelle, permettant
d'exécuter du code, comme sur un ordinateur à part. La correction de
l'exercice INGInious se fait donc en résupérant le code écrit par
l'étudiant et en l'insérant dans la méthode/classe qu'il a du compléter.
Ensuite, le container exécute le programme Java comme n'importe quel
ordinateur. Le programme que le container exécute correspond à la suite
de tests qui a été écrite par l'équipe enseignante ou encore par les
étudiants qui auront lu ce manuel.

Même si en pratique, rien ne l'y oblige, pour le cours de
LFSAB1401/SINF1101, les tests unitaires sont en général écrits avec la
librairie ``JUnit``, qui permet d'écrire des tests avec des méthodes
simples à comprendre.

Ce manuel abordera des bonnes pratiques en Java pour écrire des classes
de tests ainsi que la façon d'intégrer ces classes de Test avec
INGInious. En effet, pour que le travail soit le plus simple possible,
il sera important de respecter certaines conventions, par exemple pour
le nom des fichiers, pour les valeurs de retour de certaines fonctions
ou encore pour l'affichage des erreurs sur INGInious. Personne n'est
obligé de suivre ces conventions, mais nous les avons établies pour que
vous ayiez plus facile à publier de nouveaux exercices.

Installer JUnit
===============

``JUnit`` est déjà intégré dans ``BlueJ`` et ``Eclipse``. Les notes du
cours expliquent déjà comment utiliser JUnit sur ``BlueJ``. Les
explications suivantes vous intéresseront si vous compilez vos programme
avec le terminal (ce qui est un bon entraînement et vous permettra de
comprendre comment fonctionne le container).

Pour installer ``Junit``, il vous faudra télécharger les deux fichiers
JAR contenant la librairie : ``hamcrest-core.jar`` et ``junit.jar``,
disponibles sur le site de
`Junit <https://github.com/junit-team/junit/wiki/Download-and-Install>`__.

Une fois ces deux fichiers téléchargés, il vous suffira de les ajouter à
votre classpath. Pour ce faire, il suffira d'ajouter l'option ``-cp``
lors de la compilation et de l'exécution du programme, avec comme
argument l'emplacement des deux fichiers. Par exemple, si vous avez
placés ces deux fichiers dans le répertoire ``/usr/share/java/``
(location standard), il vous suffit de compiler vos fichiers comme ceci
:

.. code:: bash

    javac -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1.java MonFichier2.java

Vous pourrez ensuite exécuter votre programme comme ceci :

.. code:: bash

    java -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1

*Notez que les ":" dans les chemins des fichiers .jar permettent
d'indiquer à l'option -cp que l'on donne le chemin d'un nouveau fichiers
.jar contenant une librairie Java.*

Une classe de tests en Java
===========================

Lorsque les exercices ne sont pas trop conséquents (une seule ou
quelques questions seulement), on retrouvera souvent une classe Java qui
contient tous les tests à exécuter par le container et une classe
séparée qui contiendra le code de l'étudiant.

Avant de publier vos exercices, vous remplirez vous-même la classe du
code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur
et de vérifier s'il n'y a pas d'erreur de compilation et si les tests
fonctionnent correctement. Le fait de séparer le code de l'étudiant des
codes de test permet d'éviter que des erreurs de compilation du code de
l'étudiant n'affiche une partie des tests exécutés pour le tester.

Pour ce qui est de la classe de tests, c'est elle qui contiendra la
méthode main que le container exécutera. En général, la classe de tests
utilisera ``JUnit``. Pour se faciliter la tâche, la méthode ``main``
aura toujours la même forme. Vous pourrez donc la copier-coller
directement dans votre classe de test :

.. code:: java

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

Suivez le guide
===============

Je voudrais écrire un exercice que mes camarades pourront s'amuser à
faire etc

Conventions utilisées
=====================

Nous nous sommes servis d'un certain nombre de conventions dans la
structure de nos classes de test etc

Une classe de tests en Java
---------------------------

Lorsque les exercices ne sont pas trop conséquents (une seule ou
quelques questions seulement), on retrouvera souvent une classe Java qui
contient tous les tests à exécuter par le container et une classe
séparée qui contiendra le code de l'étudiant.

Avant de publier vos exercices, vous remplirez vous-même la classe du
code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur
et de vérifier s'il n'y a pas d'erreur de compilation et si les tests
fonctionnent correctement. Le fait de séparer le code de l'étudiant des
codes de test permet d'éviter que des erreurs de compilation du code de
l'étudiant n'affiche une partie des tests exécutés pour le tester.

Pour ce qui est de la classe de tests, c'est elle qui contiendra la
méthode main que le container exécutera. En général, la classe de tests
utilisera ``JUnit``.

La méthode main
~~~~~~~~~~~~~~~

Pour se faciliter la tâche, la méthode ``main`` aura toujours la même
forme. Vous pourrez donc la copier-coller directement dans votre classe
de test :

.. code:: java

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

La méthode ``main`` retourne 127 lorsque tout s'est passé correctement.
Cela permettra a INGInious de constater que l'exercice a été réussi et
d'afficher un feedback "vert". Chaque erreur sera affichée sur
``System.err``. Cela permettra à INGInious d'afficher à l'étudiant les
erreurs survenues lors des tests effectués si l'exercice n'a pas été
réussi. Si l'exercice n'est pas réussi, INGinious affichera à l'étudiant
tout ce qui aura été écrit sur ``System.err``, donc n'affichez pas
d'informations inutiles pour l'étudiant et encore moins des "flags" pour
débugger vos tests. La méthode ``JUnitCore.runClasses`` est la méthode
qui lancera toutes les méthodes de tests que vous aurez rédigées.

Les méthodes de test
~~~~~~~~~~~~~~~~~~~~

Comme nous utilisons JUnit pour les méthodes de Test, la manière la plus
simple de rédiger les tests est de faire une méthode par test unitaire.
Pour que la méthode ``JUnitCore.runClasses`` sache quelle méthode
exécuter pour les tests, la signature de chaque méthode de Test doit
avoir le label ``@Test`` sur la ligne au-dessus. Prenons un exemple
d'une courte méthode de test :

.. code:: java

    @Test
    public void testPos(){
        try{
            int sum = 0;
            for(int i = 0 ; i < 20 ; i++){
                sum += i*2;
                int res = M1Q7Stu.sumFirstEvenIntegers(i);
                assertEquals(str + "pour les "+i+" premiers entiers pairs, la somme devrait "+ 
                         "donner+" +sum+" mais le résultat obtenu est "+res+".",
                         sum, res);
            }
        }catch (ArithmeticException e){
            fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
            e.printStackTrace();
        }catch(ClassCastException e){
            fail(str + "Attention, certaines variables ont été mal castées  !");
            e.printStackTrace();
        }catch(StringIndexOutOfBoundsException e){
            e.printStackTrace();
            fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
            e.printStackTrace();
        }catch(NullPointerException e){
            fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
            e.printStackTrace();
        }catch(Exception e){
            fail(str + "\n" + e.getMessage());
            e.printStackTrace();
        }
    }

On peut constater plusieurs choses :

-  Tout d'abord, le préfixe ``@Test`` est bien sur la ligne précédant la
   signature de la méthode.
-  Ensuite, la méthode est de type ``void`` et ne prend aucun argument.
-  Finalement, la méthode n'est pas ``static``.

Toutes les méthodes de test devront avoir ces caractéristiques.

Best practices
==============

Un certain nombre de bonnes pratiques sont importantes etc

Utilisation de JUnit
====================

Installer JUnit
---------------

``JUnit`` est déjà intégré dans ``BlueJ`` et ``Eclipse``. Les notes du
cours expliquent déjà comment utiliser JUnit sur ``BlueJ``. Les
explications suivantes vous intéresseront si vous compilez vos programme
avec le terminal (ce qui est un bon entraînement et vous permettra de
comprendre comment fonctionne le container).

Pour installer ``Junit``, il vous faudra télécharger les deux fichiers
JAR contenant la librairie : ``hamcrest-core.jar`` et ``junit.jar``,
disponibles sur le site de
`Junit <https://github.com/junit-team/junit/wiki/Download-and-Install>`__.

Une fois ces deux fichiers téléchargés, il vous suffira de les ajouter à
votre classpath. Pour ce faire, il suffira d'ajouter l'option ``-cp``
lors de la compilation et de l'exécution du programme, avec comme
argument l'emplacement des deux fichiers. Par exemple, si vous avez
placés ces deux fichiers dans le répertoire ``/usr/share/java/``
(location standard), il vous suffit de compiler vos fichiers comme ceci
:

.. code:: bash

    javac -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1.java MonFichier2.java

Vous pourrez ensuite exécuter votre programme comme ceci :

.. code:: bash

    java -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1

*Notez que les ":" dans les chemins des fichiers .jar permettent
d'indiquer à l'option -cp que l'on donne le chemin d'un nouveau fichiers
.jar contenant une librairie Java.*
