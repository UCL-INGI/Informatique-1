#!/bin/bash

for file in student/*.java; do
	CHARSET=$(file -b --mime-encoding ${file})
	iconv -f ${CHARSET} -t utf-8 "$file" -o "$file"
done
echo 0
