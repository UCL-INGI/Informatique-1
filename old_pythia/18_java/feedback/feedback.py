# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: November 17, 2012
# Problem: Mission 4 : Question de bilan final

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
                predefined = [(1,), (2,), (5,), (11,)]
                for input in predefined:
                    expected = self.syracuse(input[0])
                    value = self.readList(len(expected), outfile)
                    if expected != value:
                        return ('<p>Attention, lorsque <code>s0</code> vaut {}, vous devriez avoir la suite {}, alors que votre programme affiche la suite {}.</p>'.format(input[0], expected, value), 'KO')
                # Tests aléatoires
                testpath = 'input/{}.csv'.format(qid)
                if os.path.exists(testpath):
                    with open(testpath, 'r', encoding = 'utf-8') as infile:
                        inreader = csv.reader(infile, delimiter=';', quotechar='"')
                        for row in inreader:
                            args = self.parseTestdata(row)
                            expected = self.syracuse(args[0])
                            value = self.readList(len(expected), outfile)
                            if expected != value:
                                return ('<p>Attention, lorsque <code>s0</code> vaut {}, vous devriez avoir la suite {}, alors que votre programme affiche la suite {}.</p>'.format(args[0], expected, value), 'KO')
        return ('', 'OK')

    def readList(self, size, outfile):
        value = []
        for i in range(size):
            line = outfile.readline().strip()
            if line == '':
                return value
            try:
                value.append(int(line))
            except ValueError:
                pass
        return value

    def parseTestdata(self, data):
        return tuple(int(x) for x in data)

    def syracuse(self, s0):
        list = [s0]
        while s0 != 1:
            if s0 % 2 == 0:
                s0 = s0 // 2
            else:
                s0 = 3 * s0 + 1
            list.append(s0)
        return list

Feedback([Q1Feedback()], FrenchFeedbackMessage()).generate()