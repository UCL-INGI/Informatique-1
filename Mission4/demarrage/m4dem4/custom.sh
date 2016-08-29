#! /bin/bash

EXERCICE="M1Q9"
TRICHE=$(cat student/M4Q10Stu.java | grep "Character.toUpperCase")
if [ "$TRICHE" = "" ];	then
	feedback -r failed -f "Vous n'avez pas bien répondu à au moins une question"
	feedback -i q1 -r failed -f "Vous n'utilisez pas la méthode Character.toUpperCase"
	exit 1
else
	TRICHE=$(cat student/M4Q10Stu.java | grep "toUpperCase" | grep -v "Character.toUpperCase")
	if [ "$TRICHE" != "" ]; then
		feedback -r failed -f "Vous n'avez pas bien répondu à au moins une question"
		feedback -i q1 -r failed -f "Il est interdit d'utiliser autre chose que Character.toUpperCase(), même en commentaires"
		exit 1
	else
		exit 0
	fi
fi
