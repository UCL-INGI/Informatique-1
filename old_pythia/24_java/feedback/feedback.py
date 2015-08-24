# -*- coding: utf-8 -*-
# Feedback script
# Author: Sébastien Combéfis
# Date: December 30, 2012
# Problem: Question de Bilan Final : Mission 7

import sys, os

feedbackQ1 = ''
errpath = 'output/files/q1.err'
if os.path.exists(errpath):
    with open(errpath, 'r', encoding = 'utf-8') as file:
        error = file.read()
        if error != '':
            feedbackQ1 = '<question id="q1" verdict="KO"><![CDATA[<p>Votre fichier n\'a pas compilé ou une erreur d\'exécution s\'est produite :</p><pre>{}</pre>]]></question>'.format(error)

if feedbackQ1 == '':
    resultpath = 'output/files/resultat-q1.txt'
    if os.path.exists(resultpath):
        with open(resultpath, 'r', encoding = 'utf-8') as file:
            # Test 1
            line = file.readline().strip().split(':')
            if line[0] != 'success':
                item = line[1].split(',')
                feedbackQ1 = '<question id="q1" verdict="KO"><![CDATA[<p>Votre méthode <code>toString</code> n\'est pas correcte. Pour l\'objet :</p><pre>Item item = new Item ("{}", "{}", {});</pre><p>l\'appel <code>item.toString()</code> renvoie {} au lieu de &#171;&#160;<code>[{}] {}, {}</code>&#160;&#187;.</p>]]></question>'.format(item[1], item[2], item[0], '&#171;&#160;<code>{}</code>&#160;&#187;'.format(line[2]) if line[2] != '' else 'la chaine vide', item[0], item[1], item[2])


feedbackQ2 = ''
errpath = 'output/files/q2.err'
if os.path.exists(errpath):
    with open(errpath, 'r', encoding = 'utf-8') as file:
        error = file.read()
        if error != '':
            feedbackQ2 = '<question id="q2" verdict="KO"><![CDATA[<p>Votre fichier n\'a pas compilé ou une erreur d\'exécution s\'est produite :</p><pre>{}</pre>]]></question>'.format(error)

if feedbackQ2 == '':
    resultpath = 'output/files/resultat-q2.txt'
    if os.path.exists(resultpath):
        with open(resultpath, 'r', encoding = 'utf-8') as file:
            # Test 1
            line = file.readline().strip()
            if line == 'failure':
                feedbackQ2 = '<question id="q2" verdict="KO"><![CDATA[<p>Vous n\'avez pas défini un constructeur de signature :</p><pre>public CD (String author, String title, int duration)</pre><p>dans votre classe <code>CD</code>.</p>]]></question>'
            
            # Test 2
            if feedbackQ2 == '':
                line = file.readline().strip().split(':')
                if line[0] != 'success':
                    item = line[1].split(',')
                    feedbackQ2 = '<question id="q2" verdict="KO"><![CDATA[<p>Votre méthode <code>toString</code> n\'est pas correcte. Pour l\'objet :</p><pre>CD cd = new CD ("{}", "{}", {});</pre><p>l\'appel <code>cd.toString()</code> renvoie {} au lieu de &#171;&#160;<code>[100001] {}, {} ({} s)</code>&#160;&#187;.</p>]]></question>'.format(item[1], item[2], item[0], '&#171;&#160;<code>{}</code>&#160;&#187;'.format(line[2]) if line[2] != '' else 'la chaine vide', item[1], item[2], item[0])

            # Test 3
            if feedbackQ2 == '':
                line = file.readline().strip().split(':')
                if line[0] != 'success':
                    item = line[1].split(',')
                    feedbackQ2 = '<question id="q2" verdict="KO"><![CDATA[<p>Votre gestion des serial n\'est pas correcte. Un total de {} nouveaux objets <code>CD</code> ont été créés. Ensuite, pour le {}ème :</p><pre>CD cd{} = new CD ("{}", "{}", {});</pre><p>l\'appel <code>cd{}.toString()</code> renvoie {} au lieu de &#171;&#160;<code>[{}] {}, {} ({} s)</code>&#160;&#187;.</p>]]></question>'.format(item[0], int(item[0]) + 1, int(item[0]) + 1, item[2], item[3], item[1], int(item[0]) + 1, '&#171;&#160;<code>{}</code>&#160;&#187;'.format(line[2]) if line[2] != '' else 'la chaine vide', 100002 + int(item[0]), item[2], item[3], item[1])


with open('feedback.xml', 'w', encoding = 'utf-8') as feedbackfile:
    feedbackfile.write('<feedback>{}{}<verdict>{}</verdict></feedback>'.format(feedbackQ1 if feedbackQ1 != '' else '<question id="q1" verdict="OK"></question>', feedbackQ2 if feedbackQ2 != '' else '<question id="q2" verdict="OK"></question>', 'OK' if feedbackQ1 == '' and feedbackQ2 == '' else 'KO'))