# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: December 29, 2012
# Problem: Question de Bilan Final : Mission 9

from lib.pythia import *
from lib.french import *
import os

class Q1Feedback (BasicFeedbackSuite):

    def __init__(self):
        predefined = [('input/nonexisting.txt',), ('input/empty.txt',), ('input/novalidline.txt',), ('input/normal.txt',)]
        BasicFeedbackSuite.__init__(self, 'q1', predefined, FrenchFeedbackMessage())
    
    def parseTestdata(self, data):
        return (str(data[0]),)
    
    def parseAnswer(self, answer):
        if answer.startswith('exception|'):
            return answer
        return float(answer)
    
    def badvalue(self, args, value, exp):
        if args[0] == 'input/nonexisting.txt':
            return '<p>Votre méthode <code>getMax</code> a été appelée avec un fichier qui n\'existe pas, et elle a renvoyé {} alors qu\'elle devrait quitter le programme.</p>'.format(str(value))
        if args[0] == 'input/empty.txt':
            if value == 'exception|C':
                return '<p>Votre méthode <code>getMax</code> a été appelée avec un fichier vide, et elle a quitté la programme alors qu\'elle devrait renvoyer -&#8734;.</p>'.format(str(value))
            return '<p>Votre méthode <code>getMax</code> a été appelée avec un fichier vide, et elle a renvoyé {} alors qu\'elle devrait renvoyer -&#8734;.</p>'.format(str(value))
        # Opening the test file
        content = ''
        with open(args[0], 'r', encoding = 'utf-8') as file:
            content = '<p>Soit le fichier suivant :</p><pre>{}</pre>'.format(file.read())
        if value == 'exception|C':
            return '{}<p>Votre méthode <code>getMax</code> a quitté le programme au lieu de renvoyer &#171;&#160;{}&#160;&#187;.</p>'.format(content, str(exp))
        elif value == 'exception|NF':
            return '{}<p>Attention, une exception de type <code>NumberFormatException</code> s\'est produite lors de l\'exécution de votre méthode. Véfifiez bien d\'avoir try-catché l\'appel à <code>Double.parseDouble</code></p>'.format(content)
        return '{}<p>Votre méthode <code>getMax</code> renvoie &#171;&#160;{}&#160;&#187; alors qu\'elle devrait renvoyer &#171;&#160;{}&#160;&#187;.</p>'.format(content, str(value), str(exp))
    
    def teacherCode(self, path):
        if os.path.exists(path):
            maxval = float('-inf')
            with open(path, 'r', encoding = 'utf-8') as file:
                for line in file:
                    try:
                        maxval = max(maxval, float(line))
                    except ValueError:
                        pass
            return maxval
        else:
            return 'exception|C'

Feedback([Q1Feedback()], FrenchFeedbackMessage()).generate()