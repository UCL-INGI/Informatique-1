# -*- coding: utf-8 -*-
# Test dataset script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 3(a)

from lib.pythia import *
import random

class TestDataSetQ1(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'q1', 10)
    
    def genTestData(self):
        size = random.randint(1, 20)
        list = [random.randint(1, 100000) for x in range(size)]
        return [list]

class TestDataSetQ2(TestDataSet):
    def __init__(self):
        TestDataSet.__init__(self, 'q2', 10)

    def genTestData(self):
        size = random.randint(1, 20)
        list = [random.randint(1, 100000) for x in range(size)]
        n = random.randint(1, 2 * size)
        return [list, n]

TestDataSetQ1().generate()
TestDataSetQ2().generate()