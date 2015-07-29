#! /bin/bash

EXERCICE="M1Q9"

COUNT=$(grep -c Math.pow student/${EXERCICE}Stu.java)
if [ $COUNT -gt 0 ]; then
	feedback -i q1 -r failed -f "Il est interdit d'utiliser Math.pow, même en commentaires"
	echo 1
else
	echo 0
fi

