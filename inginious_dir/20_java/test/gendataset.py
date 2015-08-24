# -*- coding: utf-8 -*-
# Test dataset script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 3

from lib.pythia import *
import random
import string

class TestDataSetQ1(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'subproblems', 100)
    
    def genTestData(self):
        n = random.randint(1, 2147483647)
        return [n]

TestDataSetQ1().generate()