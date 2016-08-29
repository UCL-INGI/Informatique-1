#! /bin/bash

EXERCICE="M8Q9"
TRICHE=$(cat student/M8Q8Stu.java | grep -v "import java.lang.StringBuffer;" | grep "StringBuffer")
if [ "$TRICHE" = "" ];	then
	feedback -r failed -f "Vous n'avez pas bien répondu à au moins une question"
	feedback -i q1 -r failed -f "Vous devez utilisez un StringBuffer"
	exit 1
else
	exit 0
fi
