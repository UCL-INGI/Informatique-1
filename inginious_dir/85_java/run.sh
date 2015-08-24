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

cp -R input/Q1.java Q1.java

javac -cp ".:input/lib/pythia.jar" Q1.java 2> output/q1.err
java -cp ".:input/lib/opencsv-2.3.jar:input/lib/pythia.jar" Q1 1> output/q1.out 2> output/q1.err
