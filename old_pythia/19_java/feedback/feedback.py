# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 2

from lib.pythia import *
from lib.french import *
import os, csv

class Q1Feedback (BasicFeedbackSuite):
    
    def __init__(self):
        BasicFeedbackSuite.__init__(self, 'q1', feedbackMsg = FrenchFeedbackMessage())
    
    def checkStdout(self, qid, out):
        lines = out.splitlines()
        outpath = 'output/files/{}.out'.format(qid)
        if os.path.exists(outpath):
            with open(outpath, 'r', encoding = 'utf-8') as outfile:
                # Check predefined test
                predefined = [(1,), (2,), (5,), (7,), (12,)]
                for input in predefined:
                    expected = self.listProperDivisors(input[0])
                    value = self.readList(len(expected), outfile)
                    if expected != value:
                        return ('<p>Attention, lorsque <code>n</code> vaut {}, vous devriez avoir :</p><pre>{}</pre><p>Mais votre programme affiche :</p><pre>{}</pre>'.format(input[0], self.formatList(expected), self.formatList(value)), 'KO')
                # Tests aléatoires
                testpath = 'input/{}.csv'.format(qid)
                if os.path.exists(testpath):
                    with open(testpath, 'r', encoding = 'utf-8') as infile:
                        inreader = csv.reader(infile, delimiter=';', quotechar='"')
                        for row in inreader:
                            args = self.parseTestdata(row)
                            expected = self.listProperDivisors(args[0])
                            value = self.readList(len(expected), outfile)
                            if expected != value:
                                return ('<p>Attention, lorsque <code>n</code> vaut {}, vous devriez avoir :</p><pre>{}</pre><p>Mais votre programme affiche :</p><pre>{}</pre>'.format(input[0], self.formatList(expected), self.formatList(value)), 'KO')
        return ('', 'OK')

    def formatList(self, list):
        str = ''
        for elem in list:
            str += '{}\n'.format(elem)
        return str[:-1]

    def readList(self, size, outfile):
        value = []
        for i in range(size):
            line = outfile.readline().strip()
            if line == '':
                return value
            value.append(line)
        return value

    def parseTestdata(self, data):
        return tuple(int(x) for x in data)

    def listProperDivisors(self, n):
        list = []
        i = 1
        while i <= n:
            list.append('{}:{}'.format(i, self.nbProperDivisors(i)))
            i += 1
        return list

    def nbProperDivisors(self, n):
        nb = 0
        i = 1
        while i < n:
            if n % i == 0:
                nb += 1
            i += 1
        return nb

Feedback([Q1Feedback()], FrenchFeedbackMessage()).generate()