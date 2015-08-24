# -*- coding: utf-8 -*-
# Test dataset script
# Author: Sébastien Combéfis
# Date: December 29, 2012
# Problem: Question de Bilan Final : Mission 9

from lib.pythia import *
import random

class TestDataSetQ1(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'q1', 10)
        self._next = 0
    
    def genTestData(self):
        for i in range(10):
            with open('input/data{}.txt'.format(i), 'w', encoding = 'utf-8') as testfile:
                lines = random.randint(1, 20)
                for j in range(lines):
                    testfile.write('{}\n'.format(random.randint(-1000, 1000) * random.random()))
        self._next += 1
        return ['input/data{}.txt'.format(self._next - 1)]

TestDataSetQ1().generate()