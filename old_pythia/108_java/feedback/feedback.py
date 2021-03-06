# -*- coding: utf-8 -*

import sys,os

errpath = 'output/files/q1.err'
if os.path.exists(errpath):
    with open(errpath, 'r', encoding = 'utf-8') as file:
        error = file.read()
        if error != '':
             with open('feedback.xml', 'w', encoding = 'utf-8') as file:
                file.write('<feedback>')
                file.write('<general><![CDATA[<p>Votre fichier n\'a pas compilé ou une erreur d\'exécution s\'est produite :</p><pre>{}</pre>]]> </general>'.format(error))                
                file.write('<verdict>KO</verdict>')
                file.write('</feedback>')
                sys.exit(0)

resultpath = 'output/files/resultat.txt'
if os.path.exists(resultpath):
    with open(resultpath, 'r', encoding = 'utf-8') as file:
        currLine = file.readline().strip()
        if currLine=="OK": 
            with open('feedback.xml', 'w', encoding = 'utf-8') as feedbackfile:
                feedbackfile.write('<feedback>')
                feedbackfile.write('<general><![CDATA[<p>Votre code a passé avec succès tous les tests pour cette mission. </p>]]></general>')
                feedbackfile.write('<verdict>OK</verdict>')
                feedbackfile.write('</feedback>')
            sys.exit(0)
        else :     
            errors=""     
            for currLine in file:   
                errors += currLine + "\n"
            with open('feedback.xml', 'w', encoding = 'utf-8') as feedbackfile:
                feedbackfile.write('<feedback>')
                feedbackfile.write('<general><![CDATA[<p>{}</p>]]></general>'.format(errors))
                feedbackfile.write('<verdict>KO</verdict>')
                feedbackfile.write('</feedback>')                                
            sys.exit(0)
                    
            
        
        