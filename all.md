-   Publier des exercices sur INGInious
    -   Introduction
    -   Installer JUnit
    -   Une classe de tests en Java
-   Utilisation de JUnit
-   Best practices
-   Conventions utilisées
    -   Une classe de tests en Java
        -   La méthode main
        -   Les méthodes de test
        -   Nommage des fichiers classes Java
-   Démarrage rapide avec git
    -   Comment utiliser le template
-   A propos du yaml
-   Suivez le guide

Publier des exercices sur INGInious
===================================

Introduction
------------

Ce manuel vous permettra de comprendre de quelle manière ont été rédigés les exercices sur INGInious et comment vous pourrez en soumettre de nouveau vous-même. En plus de contribuer à un projet Open Source, publier un exercice sur INGInious constitue un excellent entraînement, non seulement en Java, mais aussi dans la maîtrise de différents outils informatiques qui vous seront certainement utiles par après.

Pour corriger un exercice, INGInious va démarrer ce que l'on appelle un *container*. Cela correspond à une sous-machine virtuelle, permettant d'exécuter du code, comme sur un ordinateur à part. La correction de l'exercice INGInious se fait donc en résupérant le code écrit par l'étudiant et en l'insérant dans la méthode/classe qu'il a du compléter. Ensuite, le container exécute le programme Java comme n'importe quel ordinateur. Le programme que le container exécute correspond à la suite de tests qui a été écrite par l'équipe enseignante ou encore par les étudiants qui auront lu ce manuel.

Même si en pratique, rien ne l'y oblige, pour le cours de LFSAB1401/SINF1101, les tests unitaires sont en général écrits avec la librairie `JUnit`, qui permet d'écrire des tests avec des méthodes simples à comprendre.

Ce manuel abordera des bonnes pratiques en Java pour écrire des classes de tests ainsi que la façon d'intégrer ces classes de Test avec INGInious. En effet, pour que le travail soit le plus simple possible, il sera important de respecter certaines conventions, par exemple pour le nom des fichiers, pour les valeurs de retour de certaines fonctions ou encore pour l'affichage des erreurs sur INGInious. Personne n'est obligé de suivre ces conventions, mais nous les avons établies pour que vous ayiez plus facile à publier de nouveaux exercices.

Installer JUnit
---------------

`JUnit` est déjà intégré dans `BlueJ` et `Eclipse`. Les notes du cours expliquent déjà comment utiliser JUnit sur `BlueJ`. Les explications suivantes vous intéresseront si vous compilez vos programme avec le terminal (ce qui est un bon entraînement et vous permettra de comprendre comment fonctionne le container).

Pour installer `Junit`, il vous faudra télécharger les deux fichiers JAR contenant la librairie : `hamcrest-core.jar` et `junit.jar`, disponibles sur le site de [Junit](https://github.com/junit-team/junit/wiki/Download-and-Install).

Une fois ces deux fichiers téléchargés, il vous suffira de les ajouter à votre classpath. Pour ce faire, il suffira d'ajouter l'option `-cp` lors de la compilation et de l'exécution du programme, avec comme argument l'emplacement des deux fichiers. Par exemple, si vous avez placés ces deux fichiers dans le répertoire `/usr/share/java/` (location standard), il vous suffit de compiler vos fichiers comme ceci :

~~~~ {.sourceCode .bash}
javac -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1.java MonFichier2.java
~~~~

Vous pourrez ensuite exécuter votre programme comme ceci :

~~~~ {.sourceCode .bash}
java -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1
~~~~

*Notez que les ":" dans les chemins des fichiers .jar permettent d'indiquer à l'option -cp que l'on donne le chemin d'un nouveau fichiers .jar contenant une librairie Java.*

Une classe de tests en Java
---------------------------

Lorsque les exercices ne sont pas trop conséquents (une seule ou quelques questions seulement), on retrouvera souvent une classe Java qui contient tous les tests à exécuter par le container et une classe séparée qui contiendra le code de l'étudiant.

Avant de publier vos exercices, vous remplirez vous-même la classe du code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur et de vérifier s'il n'y a pas d'erreur de compilation et si les tests fonctionnent correctement. Le fait de séparer le code de l'étudiant des codes de test permet d'éviter que des erreurs de compilation du code de l'étudiant n'affiche une partie des tests exécutés pour le tester.

Pour ce qui est de la classe de tests, c'est elle qui contiendra la méthode main que le container exécutera. En général, la classe de tests utilisera `JUnit`. Pour se faciliter la tâche, la méthode `main` aura toujours la même forme. Vous pourrez donc la copier-coller directement dans votre classe de test :

~~~~ {.sourceCode .java}
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
~~~~

Utilisation de JUnit
====================

`JUnit` est déjà intégré dans `BlueJ` et `Eclipse`. Les notes du cours expliquent déjà comment utiliser JUnit sur `BlueJ`. Les explications suivantes vous intéresseront si vous compilez vos programme avec le terminal (ce qui est un bon entraînement et vous permettra de comprendre comment fonctionne le container).

Pour installer `Junit`, il vous faudra télécharger les deux fichiers JAR contenant la librairie : `hamcrest-core.jar` et `junit.jar`, disponibles sur le site de [Junit](https://github.com/junit-team/junit/wiki/Download-and-Install).

Une fois ces deux fichiers téléchargés, il vous suffira de les ajouter à votre classpath. Pour ce faire, il suffira d'ajouter l'option `-cp` lors de la compilation et de l'exécution du programme, avec comme argument l'emplacement des deux fichiers. Par exemple, si vous avez placés ces deux fichiers dans le répertoire `/usr/share/java/` (location standard), il vous suffit de compiler vos fichiers comme ceci :

~~~~ {.sourceCode .bash}
javac -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1.java MonFichier2.java
~~~~

Vous pourrez ensuite exécuter votre programme comme ceci :

~~~~ {.sourceCode .bash}
java -cp .:/usr/share/java/junit.jar:/usr/share/hamcrest-core.jar MonFichier1
~~~~

*Notez que les ":" dans les chemins des fichiers .jar permettent d'indiquer à l'option -cp que l'on donne le chemin d'un nouveau fichiers .jar contenant une librairie Java.*

Best practices
==============

Un certain nombre de bonnes pratiques sont importantes etc

Conventions utilisées
=====================

Dans cette section, nous abordons un bon nombre de conventions que nous avons utilisées lors de la création des tests sur INGInious. Nous vous recommandons de les respecter car cela vous facilitera la création des tests ainsi que leur mise en place sur INGInious.

Une classe de tests en Java
---------------------------

Tout d'abord, et c'est important, toutes vos classes de test devront se retrouver dans le package `student`, c'est impératif pour qu'INGInious puisse lancer le code de l'étudiant de manière plus sécurisée pour qu'il ne puisse pas interférer avec vos fichiers.

Lorsque les exercices ne sont pas trop conséquents (une seule ou quelques questions seulement), on retrouvera souvent une classe Java qui contient tous les tests à exécuter par le container et une classe séparée qui contiendra le code de l'étudiant.

Avant de publier vos exercices, vous remplirez vous-même la classe du code de l'étudiant pour pouvoir exécuter vos tests sur votre ordinateur et de vérifier s'il n'y a pas d'erreur de compilation et si les tests fonctionnent correctement. Le fait de séparer le code de l'étudiant des codes de test permet d'éviter que des erreurs de compilation du code de l'étudiant n'affiche une partie des tests exécutés pour le tester.

Pour ce qui est de la classe de tests, c'est elle qui contiendra la méthode main que le container exécutera. En général, la classe de tests utilisera `JUnit`.

N'oubliez pas d'importer les packages nécessaires de JUnit pour lancer vos tests. Vous pouvez copier-coller les imports que nous avons faits dans la plupart de nos fichiers tests, c'est à dire :

~~~~ {.sourceCode .java}
import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;
import org.junit.runner.notification.Failure;
~~~~

### La méthode main

Pour se faciliter la tâche, la méthode `main` aura toujours la même forme. Vous pourrez donc la copier-coller directement dans votre classe de test :

~~~~ {.sourceCode .java}
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
~~~~

La méthode `main` retourne 127 lorsque tout s'est passé correctement. Cela permettra a INGInious de constater que l'exercice a été réussi et d'afficher un feedback "vert". Chaque erreur sera affichée sur `System.err`. Cela permettra à INGInious d'afficher à l'étudiant les erreurs survenues lors des tests effectués si l'exercice n'a pas été réussi. Si l'exercice n'est pas réussi, INGinious affichera à l'étudiant tout ce qui aura été écrit sur `System.err`, donc n'affichez pas d'informations inutiles pour l'étudiant et encore moins des "flags" pour débugger vos tests. La méthode `JUnitCore.runClasses` est la méthode qui lancera toutes les méthodes de tests que vous aurez rédigées.

### Les méthodes de test

Comme nous utilisons JUnit pour les méthodes de Test, la manière la plus simple de rédiger les tests est de faire une méthode par test unitaire. Pour que la méthode `JUnitCore.runClasses` sache quelle méthode exécuter pour les tests, la signature de chaque méthode de Test doit avoir le label `@Test` sur la ligne au-dessus. Prenons un exemple d'une courte méthode de test :

~~~~ {.sourceCode .java}
private static String str = "Le code semble comporter des erreurs : ";

/**
 *  @pre    -
 *  @post   Teste le code de l'étudiant avec un n positif valant de 0 à 20
 *          Lance une AssertionError lorsque le code est incorrect.
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
        fail(str + "Attention, certaines variables ont été mal castées  !");
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
~~~~

On peut constater plusieurs choses :

-   Tout d'abord, le préfixe `@Test` est bien sur la ligne précédant la signature de la méthode.
-   Ensuite, la méthode est de type `void` et ne prend aucun argument.
-   Finalement, la méthode n'est pas `static`.

Toutes les méthodes de test devront avoir ces caractéristiques.

Le principe de base est qu'une méthode de test devra lancer une `AssertionError` lorsque l'étudiant a fourni une réponse incorrecte sur INGInious. Le but n'est pas de lancer directement une `AssertionError` avec l'instruction `throw` mais d'utiliser les méthodes de `JUnit` comme `AssertEquals` qui lanceront une `AssertionError` lorsque la réponse reçue ne correspond pas à ce qui est attendu.

La méthode `runClasses` qui lance les classes de test `catch` automatiquement les exceptions survenues dans les méthodes de test. Le souci est que le message diffusé sur System.err n'est pas clair du tout et pas forcément compréhensible par un étudiant de BAC1, surtout en début d'année. Par convention, on s'occupera d'entourer les tests dans les méthodes de test par un `try ...catch` pour fournir un message d'erreur plus clair pour l'étudiant. En général, il vous suffira de nouveau de copier/coller le `try ...catch` de la méthode de test ci-dessus pour l'intégrer à vos méthodes de test. Encore une fois, il n'est pas obligatoire d'utiliser des `try ...catch` dans les méthodes de test mais c'est important pour faciliter la compréhension des étudiants. Dans les clauses `catch`, l'instruction `fail` de JUnit suffira à indiquer qu'une erreur est survenue, mais, cette fois, avec un message d'erreur plus clair.

### Nommage des fichiers classes Java

Une fois vos classes écrites, il faut ensuite pouvoir les porter sur INGInious. Pour cela, nous avons écrit un template d'un script écrit en `bash`. Le but est que vous puissiez l'utiliser sans pour autant avoir des connaissances en `bash` qui est un langage qui peut s'avérer désagréable à utiliser et que vous n'êtes pas forcément sensé connaître en fin de 1ère BAC. Si vous respectez les conventions énoncées plus bas, vous ne devrez modifier qu'une ou deux variables dans l'entête du script, ce qui vous facilitera grandement la tâche. Vous pouvez aussi ne pas du tout les respecter et modifier le template pour qu'il convienne à vos exigeances, c'est un bon entraînement mais aussi un vecteur d'erreurs, nous vous recommandons vivement de respecter les conventions de nommages des fichiers ci-dessous si vous ne vous y connaissez pas ou peu en `bash`.

Idéalement, les classes de test seront décomposées en trois fichiers distincts :

-   La classe principale, qui contient la méthode `main` ainsi que les classes de test. C'est cette classe qui sera exécutée par INGInious. Vous pouvez choisir son nom, prenons par exemple `ClasseInginious`. Le fichier du code source devra alors s'appeler `ClasseInginious.java`.
-   La classe contenant la réponse correcte à l'exercice, séparée de la classe principale pour ne pas qu'une erreur mal placée puisse afficher le code des méthodes de test lors de la compilation. Cette classe aura le même nom que la classe principale, mais avec le suffixe "`Stu`", pour indiquer qu'il s'agit de la classe contenant le code de l'étudiant, mais vide car sans ce dernier. La classe s'appellera donc `ClasseInginiousStu` et le fichier du code source devra alors s'appeler `ClasseInginiousStu.java`. Ce fichier ne sera pas utile en tant que tel à INGInious mais il sera utile pour exécuter vos tests sur votre ordinateur. Écrivez vos tests comme si c'était une vraie réponse d'étudiant.
-   Une copie du fichier "`Stu`", à l'identique ( **La classe doit aussi avoir le suffixe Stu** ), mais vous enleverez la réponse à l'exercice que l'étudiant doit écrire lui-même et vous la remplacez par cette ligne-là :

~~~~ {.sourceCode .bash}
@   @q1@@
~~~~

Vous remplacerez `q1` par l'id de la sous-question de l'exercice. Si l'exercice n'a qu'une seule sous-question (cas idéal), laissez `q1`. S'il y a plusieurs endroits où l'étudiant doit répondre, et donc plusieurs sous-questions, mettez la même ligne avec `q1` pour la première sous-question, `q2` pour la deuxième, etc.

Cette ligne indiquera à INGInious d'insérer la réponse de l'étudiant à la sous-question `q1` à cet endroit précis.

Ce fichier aura comme nom le nom du fichier principal, avec le suffixe "`Vide`", par exemple `ClasseInginiousVide.java`. Le nom de la **classe** , lui, doit être le même que le fichier "`Stu`", à savoir `ClasseInginiousStu`

Voici un exemple des fichiers à fournir, pour que vous compreniez mieux :

-   Fichier M1Q7.java, trouvable **ICI** *insérer lien*
-   Fichier M1Q7Stu.java, trouvable **ICI** *insérer lien*
-   Fichier M1Q7Vide.java, trouvable **ICI** *insérer lien*

Le template du script prévoir encore l'ajout éventuel d'un quatrième fichier java, au cas où vous voudriez par exemple exécuter une méthode contenant la version correcte de la réponse à l'exercice, pour comparer avec celle que l'étudiant à écrite. Cette troisième classe aura le même nom que la classe principale, mais avec le suffixe "`Corr`". La classe s'appellera donc `ClasseInginiousCorr` et le fichier du code source devra alors s'appeler `ClasseInginiousCorr.java`.

Démarrage rapide avec git
=========================

Avec très peu de commandes il est déjà possible de etc

Description du script d'exécution des test -----------------------------------------

Pour qu'INGInious puisse lancer les exercices, il faut lui fournir un script écrit en `bash` qui lui donnera les instructions sur comment compiler, exécuter et traiter les valeurs de retour des classes java.

Pas de panique, inutile d'avoir des connaissances en bash, nous vous avons écrit un template dans lequel il suffira de modifier une ou deux variables d'entête pour le faire fonctionner correctement, **pour peu que vous aiyez respecté les conventions énoncées dans la section qui leur est dédiée**.

Ce template est le fichier `run` disponible **ICI** *insérer lien*. Il vous suffira de le télécharger (ou de le copier/coller), puis de la modifier sur votre ordinateur puis qu'il corresponde à vos tests.

Comment utiliser le template
----------------------------

Pour faire en sorte que le template fonctionne avec vos tests, il suffit de modifier ces variables :

-   La variable `EXERCICE` qui contient un String avec le nom de la classe principale dans laquelle sont écrits les méthodes de tests et la méthode `main`. Si la classe principale s'appelle par exemple `ClasseInginious`, vous modifierez la valeur de la variable comme ceci :

    ~~~~ {.sourceCode .bash}
    EXERCICE="ClasseInginious"
    ~~~~

    C'est tout ce qu'il faut faire pour que le script puisse parser le fichier `ClasseInginiousVide`, le mettre dans un nouveau fichier `ClasseInginiousStu` qu'il aura créé et exécuter la méthode `main`, de la classe `ClasseInginious` contenant les tests. La variable `EXERCICE` est donc la seule variable qu'il faut modifier si vous faites un test classique (une seule sous-question, pas de classe `Corr`, pas de script custom à exécuter) et que vous avez respecté toutes les conventions.

-   La variable

A propos du yaml
================

yaml c'est etc

Suivez le guide
===============

Je voudrais écrire un exercice que mes camarades pourront s'amuser à faire etc
