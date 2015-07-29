

Description du script d'exécuton des test
-----------------------------------------

Pour qu'INGInious puisse lancer les exercices, il faut lui fournir un script écrit en ``bash`` qui lui donnera les instructions sur comment compiler, exécuter et traiter les valeurs de retour des classes java.

Pas de panique, inutile d'avoir des connaissances en bash, nous vous avons écrit un template dans lequel il suffira de modifier une ou deux variables d'entête pour le faire fonctionner correctement, **pour peu que vous aiyez respecté les conventions énoncées dans la section qui leur est dédiée**.

Ce template est le fichier ``run`` disponible **ICI** *insérer lien*. Il vous suffira de le télécharger (ou de le copier/coller), puis de la modifier sur votre ordinateur puis qu'il corresponde à vos tests.

Comment utiliser le template
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Pour faire en sorte que le template fonctionne avec vos tests, il suffit de modifier ces variables :

- La variable ``EXERCICE`` qui contient un String avec le nom de la classe principale dans laquelle sont écrits les méthodes de tests et la méthode ``main``. Si la classe principale s'appelle par exemple ``ClasseInginious``, vous modifierez la valeur de la variable comme ceci : 

  .. code-block:: bash
  
      EXERCICE="ClasseInginious"
      
  C'est tout ce qu'il faut faire pour que le script puisse parser le fichier ``ClasseInginiousVide``, le mettre dans  un nouveau fichier ``ClasseInginiousStu`` qu'il aura créé et exécuter la méthode ``main``, de la classe ``ClasseInginious`` contenant les tests. La variable ``EXERCICE`` est donc la seule variable  qu'il faut modifier si vous faites un test classique (une seule sous-question, pas de classe ``Corr``, pas de script custom à exécuter) et que vous avez respecté toutes les conventions.

- La variable 
