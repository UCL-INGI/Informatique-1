#! /bin/bash

# # # # # # # # # # # # # # # # # # # # # # # # # # #
# Ce script sert à vérifier que la signature de     #
# la méthode soumise par l'étudiant respecte bien   #
# les consignes de l'exercice par une analyse       #
# gramaticale propre à cet exercice du code source  #
# et des messages d'erreur de compilation.          #
# @author : Clémentine Munyabarenzi                 #
# # # # # # # # # # # # # # # # # # # # # # # # # # #
 
EXERCICE="M5Q7"
CODELITTERAL="::\n\n"
JAVAC="javac -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar"

# On compile la tâche et on récupère le résultat dans un fichier
${JAVAC} student/${EXERCICE}.java 2> logOther.out

#Recherche d'une erreur précise... 
touch logOther.out
OUTERR=$( cat logOther.out )
GREPED=$(grep "reached end of file while parsing" logOther.out & grep "illegal start of type" logOther.out & grep "class, interface, or enum expected" logOther.out )
if [ "$GREPED" != "" ]; then
   	
    # feedback n'aime pas les "\n", donc on contourne le probleme en l'écrivant dans un 		fichier puis en le lisant.
	# sed permet d'indenter chaque ligne de son input avec une tabulation
	OUTERR=$(printf "$OUTERR" | sed -e 's/^/\t/')
	FEED=$(printf "Votre programme ne compile pas: \n **Auriez-vous oublié ou mis au mauvais endroit une ou plusieurs accolade(s)?** \n ${CODELITTERAL}$OUTERR\n")
	feedback -r failed -f "$FEED"
  
    #clean files
    $(echo "" > logOther.out)
    
    exit 1
else
    #clean files
    $(echo "" > logOther.out)

	exit 0
fi

