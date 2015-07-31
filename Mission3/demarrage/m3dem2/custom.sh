#!/bin/bash
#   Copyright (c) 2015 François Michel, Clémentine Munyabarenzi
#   This program is free software: you can redistribute it and/or modify
#   it under the terms of the GNU Affero General Public License as published by
#   the Free Software Foundation, either version 3 of the License, or
#   (at your option) any later version.
#
#   This program is distributed in the hope that it will be useful,
#   but WITHOUT ANY WARRANTY; without even the implied warranty of
#   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#   GNU Affero General Public License for more details.
#
#   You should have received a copy of the GNU Affero General Public License
#   along with this program.  If not, see <http://www.gnu.org/licenses/>.




# # # # # # # # # # # # # # # # # # # # # # # # # # #
# Ce script sert à vérifier que la signature de     #
# la méthode soumise par l'étudiant respecte bien   #
# les consignes de l'exercice par une analyse       #
# gramaticale propre à cet exercice du code source  #
# et des messages d'erreur de compilation.          #
# @author : Clémentine Munyabarenzi                 #
# # # # # # # # # # # # # # # # # # # # # # # # # # #
 
EXERCICE="M3Q4"
CODELITTERAL="::\n\n"
JAVAC="javac -cp .:/usr/share/java/junit.jar:/usr/share/java/hamcrest-core.jar"


GREPED=$(grep -e "\s*void\s*afficheMax\s*(\s*int\s*a\s*,\s*int\s*b.*)" student/${EXERCICE}Stu.java)
if [ "$GREPED" == "" ]; then
	feedback -i q1 -r failed -f "La **signature** de votre méthode est **inexistante** ou **incorrecte.**"
    echo 1
	exit
fi

# On compile la tâche et on récupère le résultat dans un fichier
${JAVAC} student/${EXERCICE}.java 2> logOther.out

#Recherche d'une erreur précise... 
touch logOther.out
OUTERR=$( cat logOther.out )
GREPED=$(grep "reached end of file while parsing" logOther.out & grep "illegal start of type" logOther.out )
if [ "$GREPED" != "" ]; then
   	
    # feedback n'aime pas les "\n", donc on contourne le probleme en l'écrivant dans un 		fichier puis en le lisant.
	# sed permet d'indenter chaque ligne de son input avec une tabulation
	OUTERR=$(printf "$OUTERR" | sed -e 's/^/\t/')
	FEED=$(printf "Votre programme ne compile pas: \n **Auriez-vous oublié ou mis au mauvais endroit une ou plusieurs accolade(s)?** \n ${CODELITTERAL}$OUTERR\n")
	feedback -r failed -f "$FEED"
  
    #clean files
    $(echo "" > logOther.out)
    $(echo "" > log.out)
    
    echo 1
else
    #clean files
    $(echo "" > logOther.out)
  	$(echo "" > log.out)

	echo 0
fi

