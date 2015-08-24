# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: December 23, 2012
# Problem: Question de Bilan Final : Mission 3(a)

from lib.pythia import *
from lib.french import *

class Q1Feedback (BasicFeedbackSuite):

    def __init__(self):
        predefined = [([],), ([1],), ([2, 3],), ([4, 5, 6],)]
        BasicFeedbackSuite.__init__(self, 'q1', predefined, FrenchFeedbackMessage())
    
    def parseTestdata(self, data):
        return ([int(x) for x in data[0][1:-1].split(',')],)
    
    def parseAnswer(self, answer):
        if answer.startswith('exception|'):
            return answer
        if answer == '[]':
            return []
        return [int(x) for x in answer[1:-1].split(',')]
    
    def badvalue(self, args, value, exp):
        if args[0] == []:
            return '<p>Attention, vous n\'avez pas traité convenablement le cas où <code>tab</code> est un tableau vide. Relisez convenablement la spécification pour savoir que faire dans une telle situation.</p>'
        if value == 'exception|OOB':
            return '<p>Lorsque <code>tab</code> vaut &#171;&#160;{}&#160;&#187;, votre méthode provoque une exception de type <code>ArrayIndexOutOfBoundsException</code>. Vérifiez tous vos accès au tableau.</p>'.format(args[0])
        return '<p>Lorsque <code>tab</code> vaut &#171;&#160;{}&#160;&#187;, après appel de votre méthode <code>rotateRightOne</code>, <code>tab</code> vaut &#171;&#160;{}&#160;&#187; alors qu\'il devrait valoir &#171;&#160;{}&#160;&#187;.</p>'.format(args[0], str(value), str(exp))
    
    def teacherCode(self, tab):
        if len(tab) == 0:
            return tab
        tab = tab[:]
        i = len(tab) - 1
        last = tab[i]
        while i > 0:
            tab[i] = tab[i - 1]
            i -= 1
        tab[0] = last
        return tab

class Q2Feedback (BasicFeedbackSuite):

    def __init__(self):
        predefined = [([], 8), ([1], 2), ([1, 2, 3], 0), ([1, 2, 3], 2), ([1, 2, 3], 7)]
        BasicFeedbackSuite.__init__(self, 'q2', predefined, FrenchFeedbackMessage())

    def parseTestdata(self, data):
        return ([int(x) for x in data[0][1:-1].split(',')], int(data[1]))

    def parseAnswer(self, answer):
        if answer.startswith('exception|'):
            return answer
        if answer == '[]':
            return []
        return [int(x) for x in answer[1:-1].split(',')]

    def badvalue(self, args, value, exp):
        if args[0] == []:
            return '<p>Attention, vous n\'avez pas traité convenablement le cas où <code>tab</code> est un tableau vide. Relisez convenablement la spécification pour savoir que faire dans une telle situation.</p>'
        if value == 'exception|OOB':
            return '<p>Lorsque <code>tab</code> vaut &#171;&#160;{}&#160;&#187; et <code>n</code> vaut &#171;&#160;{}&#160;&#187;, votre méthode provoque une exception de type <code>ArrayIndexOutOfBoundsException</code>. Vérifiez tous vos accès au tableau.</p>'.format(args[0], args[1])
        return '<p>Lorsque <code>tab</code> vaut &#171;&#160;{}&#160;&#187; et <code>n</code> vaut &#171;&#160;{}&#160;&#187;, après appel de votre méthode <code>rotateRight</code>, <code>tab</code> vaut &#171;&#160;{}&#160;&#187; alors qu\'il devrait valoir &#171;&#160;{}&#160;&#187;.</p>'.format(args[0], args[1], str(value), str(exp))

    def teacherCode(self, tab, n):
        if len(tab) == 0 or n == 0:
            return tab
        tab = tab[:]
        t = 0
        while t < n:
            i = len(tab) - 1
            last = tab[i]
            while i > 0:
                tab[i] = tab[i - 1]
                i -= 1
            tab[0] = last
            t += 1
        return tab

Feedback([Q1Feedback(), Q2Feedback()], FrenchFeedbackMessage()).generate()