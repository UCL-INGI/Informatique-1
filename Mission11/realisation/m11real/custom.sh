#   Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
#   This program is free software: you can redistribute it and/or modify
#   it under the terms of the GNU General Public License as published by
#   the Free Software Foundation, either version 3 of the License, or
#   (at your option) any later version.
#
#   This program is distributed in the hope that it will be useful,
#   but WITHOUT ANY WARRANTY; without even the implied warranty of
#   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#   GNU General Public License for more details.
#
#   You should have received a copy of the GNU General Public License
#   along with this program.  If not, see <http://www.gnu.org/licenses/>.



#!/bin/bash

for file in student/*.java; do
	CHARSET=$(file -b --mime-encoding ${file})
	iconv -f ${CHARSET} -t utf-8 "$file" -o "$file"
done
echo 0
