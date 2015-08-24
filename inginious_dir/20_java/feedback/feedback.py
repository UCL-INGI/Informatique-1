# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 3

from lib.pythia import *
from lib.french import *

class Q1Feedback (BasicFeedbackSuite):
    
    def __init__(self):
        predefined = [(0,), (1,), (9,), (10,), (283,)]
        BasicFeedbackSuite.__init__(self, 'subproblems', predefined, FrenchFeedbackMessage())
    
    def parseTestdata(self, data):
        return tuple(int(x) for x in data)
    
    def parseAnswer(self, answer):
        return answer == 'true'
    
    def badvalue(self, args, value, exp):
        return '<p>Lorsque <code>n</code> vaut &#171;&#160;{}&#160;&#187;, votre méthode <code>chiffresPairs</code> renvoie <code>{}</code> alors qu\'elle devrait renvoyer <code>{}</code>.</p>'.format(args[0], str(value).lower(), str(exp).lower())
    
    def teacherCode(self, n):
        return len(str(n)) % 2 == 0

Feedback([Q1Feedback()], FrenchFeedbackMessage()).generate()