#Recherche d'une erreur précise... 
touch logOther.out
GREPED=$(grep "static" student/M7Q7Stu.java)

if [ "$GREPED" = "" ]; then
echo "Question 1 : \nPrennez garde à ne pas confondre variables de classe et variables d'instance." >> err.txt
fi
exit 0
