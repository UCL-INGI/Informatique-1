#!/bin/sh
#   Copyright (c) 2015 Sébastien Combéfis, Virginie Van den Schrieck
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



set -e

cp -R input/*.java .
cp -R input/junit-4.11.jar .
cp -R input/hamcrest-all-1.3.jar .


javac -encoding UTF-8 -cp "./hamcrest-all-1.3.jar:./junit-4.11.jar" *.java 2> output/q1.err

java -cp "./hamcrest-all-1.3.jar:./junit-4.11.jar:." TestRunner 1> output/resultat.txt 2> output/q1.err


