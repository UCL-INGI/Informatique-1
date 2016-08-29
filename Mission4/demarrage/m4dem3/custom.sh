#!/bin/bash

for file in student/*.java; do
	CHARSET=$(file -b --mime-encoding ${file})
	iconv -f ${CHARSET} -t utf-8 "$file" -o "abc.out"
    cat abc.out > "$file"
done
exit 0
