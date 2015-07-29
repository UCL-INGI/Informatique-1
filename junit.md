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
