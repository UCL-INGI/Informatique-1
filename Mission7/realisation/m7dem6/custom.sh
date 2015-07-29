#Recherche d'une erreur précise... 
touch logOther.out
GREPED=$(grep "@Override" student/M7Q6Stu.java)

if [ "$GREPED" = "" ]; then
	# feedback du fait qu'il n'y a pas de redéfinition dans le code
    feedback -i q1 -r failed -f "Vous devez implémenter une **redéfinition** de la méthode demandée."
    echo 1
else
	echo 0
fi

