/**
 *  Copyright (c) 2015, 2016 Sébastien Combéfis, Virginie Van den Schrieck
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Testing the basic method of the class Stack 
 * 
 * @author V. Van den Schrieck
 * @version 20 Nov 2013
 */
public class Test
{
	private static PrintWriter writer;

	//Test 1 : Constructeurs.  
	//Test 2 : Test de la méthode toString()
	//Test 3 : Test des getters et des setters
	//Test 4 : Test de l'augmentation de salaire

    public static void testConstructorAndGetters()
    {
		
		Employe p1 = new Employe("Tartempion", 1200); 
		
		try {
			if(!p1.getNom().equals("Tartempion")){
				writeReport(false, "Votre méthode getNom ou votre constructeur n'est pas correct.  Le nom de l'employé n'est pas correctement initialisé ou renvoyé par getNom");
				return;
			}
			if(p1.getSalaire()!=1200){
				writeReport(false, "Votre méthode getNom ou votre constructeur n'est pas correct.  Le nom de l'employé n'est pas correctement initialisé ou renvoyé par getNom");
				return;
			}			
    	} catch (Exception e) {
    	    writeReport(false, "Votre classe ne fonctionne pas (Exception lancée lors de la création ).");
			return;
    	}
    	/* If we reach this point tests are ok. */
    	writeReport(true, "Votre constructeur et vos méthodes getNom et getSalaire semblent fonctionner correctement.");
    }
    
    public static void testAugmente() {
		Employe p1 = new Employe("Tartempion", 1000);    	
    	/* Test : Try to raise the salary */
    	try {
			p1.augmente(100); 
			if(p1.getSalaire()!=2000){
	    	    writeReport(false, "Votre méthode augmente ne fonctionne pas. Une augmentation de 100% d'un salaire de 1000 ne donne pas 2000 mais "+p1.getSalaire());
				return;
			}
			p1.augmente(-50); 
			if(p1.getSalaire()!=1000){
	    	    writeReport(false, "Votre méthode augmente ne fonctionne pas. Une augmentation de -50% d'un salaire de 2000 ne donne pas 1000 mais "+p1.getSalaire());
				return;
			}
			p1.augmente(200); 
			if(p1.getSalaire()!=3000){
	    	    writeReport(false, "Votre méthode augmente ne fonctionne pas. Une augmentation de 200% d'un salaire de 1000 ne donne pas 3000 mais "+p1.getSalaire());
				return;
			}
			p1.augmente(0); 
			if(p1.getSalaire()!=3000){
	    	    writeReport(false, "Votre méthode augmente ne fonctionne pas. Une augmentation de 0% d'un salaire de 3000 ne donne pas 3000 mais "+p1.getSalaire());
				return;
			}
    	} catch (Exception e) {
 
    		writeReport(false, "Votre méthode augmente() ne fonctionne pas correctement, une exception est lançée");
    		return;
    	}
    	/****** END OF TEST 1 ********/
    	writeReport(true, "Votre méthode augmente semble fonctionner correctement.");

    	/* The rest of the method has already been tested by testPush */
    }


    public static void main (String[] args) {
    	try { 
//			writer = new PrintWriter (new BufferedWriter (new OutputStreamWriter (new FileOutputStream ("resultat.txt"), "UTF-8")));
			writer = new PrintWriter ("resultat.txt", "UTF-8");
			testConstructorAndGetters();
			testAugmente();
		}
		catch (java.io.FileNotFoundException fne) {}
		catch (java.io.UnsupportedEncodingException use) {}
//		catch (Exception e) {
//			writeReport(false, "Attention un de vos méthodes a lancé une Exception inattendue.");
//		}
		
		writer.close();
    }
    public static void writeReport(boolean success, String message) {
    	String status = "OK";
    	
    	if (!success)
    		status = "KO";
    		
    	 writer.println(status+":"+message);
    }
    
    public static class FailedTestException extends Exception {
  		public FailedTestException() { super(); }
  		public FailedTestException(String message) { super(message); }
  		public FailedTestException(String message, Throwable cause) { super(message, cause); }
  		public FailedTestException(Throwable cause) { super(cause); }
  	}
}