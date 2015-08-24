# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: November 17, 2012
# Problem: Mission 4 : Question de bilan final

from lib.pythia import *
from lib.french import *

class Q1Feedback (BasicFeedbackSuite):
    
    def __init__(self):
        predefined = [('AB', 'CDEF'), ('?B', 'CABDEF'), ('A?', 'CABDEACF'), ('AA', 'CAAABDEAAF'), ('??', 'CAAAB')]
        BasicFeedbackSuite.__init__(self, 'subproblems', predefined, FrenchFeedbackMessage())
    
    def parseTestdata(self, data):
        return tuple(str(x) for x in data)
    
    def parseAnswer(self, answer):
        return answer == 'true'
    
    def badvalue(self, args, value, exp):
        return '<p>Pour la chaine de caractères <code>s</code> valant &#171;&#160;{}&#160;&#187; et pour le pattern <code>p</code> valant &#171;&#160;{}&#160;&#187;, votre méthode <code>count</code> renvoie <code>{}</code> alors qu\'elle devrait renvoyer <code>{}</code>.</p>'.format(args[0], args[1], str(value).lower(), str(exp).lower())
    
    def teacherCode(self, p, s):
        c = 0
        for i in range(len(s)-len(p)+1):
            if _match(p, s[i:i+len(p)]):
                c += 1
        return c
    
    def _match(self, p, s):
        for i in range(len(p)):
            if p[i] != '?' and p[i] != s[i]:
                return False
        return True

Feedback([Q1Feedback()], FrenchFeedbackMessage()).generate()