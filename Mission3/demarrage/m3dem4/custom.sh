#! /bin/bash


# # # # # # # # # # # # # # # # # # # # # # # # # # #
# Ce script sert à vérifier que la signature de     #
# la méthode soumise par l'étudiant respecte bien   #
# les consignes de l'exercice par une analyse       #
# gramaticale propre à cet exercice du code source  #
# et des messages d'erreur de compilation.          #
# @author : Clémentine Munyabarenzi                 #
# # # # # # # # # # # # # # # # # # # # # # # # # # #
 
EXERCICE="M3Q6"
CODELITTERAL="::\n\n"
JAVAC="javac -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar"

GREPED=$(grep -e "\s*void\s*lettre_l\s*(\s*char\s*.*\s*,\s*int\s*.*\s*,\s*int\s*.*\s*).*" student/${EXERCICE}Stu.java )
if [ "$GREPED" = "" ]; then
	# feedback
   	feedback -i q1 -r failed -f "La signature de votre méthode est inexistante ou in correcte."
    exit 1
fi

# On compile la tâche et on récupère le résultat dans un fichier
${JAVAC} student/${EXERCICE}.java 2> logOther.out
${JAVAC} student/${EXERCICE}Stu.java 2> log.out

#Recherche d'une erreur précise... 
touch logOther.out
GREPED=$(grep ".*reached end of file while parsing.*" logOther.out )
if [ "$GREPED" != "" ]; then
	# feedback
    feedback -i q1 -r failed -f "Auriez-vous oublié ou mis au mauvais endroit une accolade?"
    
    #clean files
    $(echo "" > logOther.out)
    $(echo "" > log.out)
    
    exit 1
else
    #clean files
    $(echo "" > logOther.out)
  	$(echo "" > log.out)

	exit 0
fi

