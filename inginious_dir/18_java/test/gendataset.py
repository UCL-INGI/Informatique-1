# -*- coding: utf-8 -*-
# Test dataset script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 1

from lib.pythia import *
import random

class TestDataSetQ1(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'q1', 5)
    
    def genTestData(self):
        A = random.randint(1, 100)
        return [A]

TestDataSetQ1().generate()