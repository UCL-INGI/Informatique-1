#! /bin/bash

sudo rm complete.rst
 
pandoc -s -t rst --toc *.rst -o complete.rst
