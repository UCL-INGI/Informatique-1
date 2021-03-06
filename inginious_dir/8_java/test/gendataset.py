# -*- coding: utf-8 -*-
# Test dataset script
# Author: Sébastien Combéfis
# Date: November 17, 2012
# Problem: Mission 4 : Question de bilan final

from lib.pythia import *
import random
import string

class TestDataSetQ1(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'subproblems', 100)
    
    def genTestData(self):
        length = random.randint(2,15)
        string = ''.join(random.choice('ACTG') for x in range(length))
        pattern = ''.join(random.choice('ACTG?') for x in range(random.randint(1, length // 2)))
        return [pattern, string]

TestDataSetQ1().generate()