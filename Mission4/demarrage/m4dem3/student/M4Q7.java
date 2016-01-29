/**
 *  Copyright (c) 2015, 2016 François Michel, Clémentine Munyabarenzi
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



package student;
/**
 *  @author Fran�ois MICHEL
 */

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import java.util.Random;
import org.junit.runner.notification.Failure;
import java.io.*;


public class M4Q7{
	
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	
	/**
	 * 	@pre	-
	 * 	@post	Cette m�thode redirige le flux de sortie standard (System.out) vers un fichier pour ensuite le lire
	 *			et v�rifier que l'output est correct et dans le bon format. System.out est remis sur la sortie de d�part 
	 * 			� la fin de la m�thode.
	 * 			Lance une AssertionError lorsqu'une r�ponse est incorrecte.
	 */
	@Test
	public void testShowLength(){
		String str = "Votre code semble comporter des erreurs : ";
		PrintStream ps = null;
		BufferedReader br = null;
		// On sauvegarde System.out
		PrintStream out = System.out;
		// On s'appr�te � r�cup�rer une AssertionError si l'une d'elle est lanc�e.
		AssertionError a_err = null;
		try{
			ps = new PrintStream(new FileOutputStream("student/reponse1.out"), true);
			br = new BufferedReader(new FileReader("student/reponse1.out"));
			// On redirige la sortie de System.out;
			System.setOut(ps);
			String s = null;
			String line = null;
			for(int i = 0 ; i < 30 ; i++){
				s = generateString(i);
				M4Q7Stu.showLength(s);
				ps.println("");
				line = br.readLine();
				assertNotNull(str + "lorsque qu'on appelle la m�thode avec l'argument \""+s+"\", rien n'est affich� sur la sortie standard.", line);
				assertNotNull(str + "votre programme n'affiche pas un nombre par ligne quand s = \""+s+"\". ", br.readLine());
				// On enl�ve les espaces �ventuels
				line = line.trim();
				assertEquals(str + "avec \""+s+"\" comme argument, votre programme devrait afficher \""+i+"\", or, il affiche \""+line+"\".", i+"", line);
			}
		}catch(FileNotFoundException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'�criture sur la sortie standard. "+e.getMessage());
			System.setOut(out);
		}catch(IOException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'�criture sur la sortie standard. "+e.getMessage());
		}catch(AssertionError ae){
			// S'il faut lancer une AssertionError, on s'assure d'abord de fermer les flux et de tout remettre en ordre avant de la lancer en tant qu'erreur du programme/
			System.setOut(out);
			a_err = ae;
		}catch(ArithmeticException e){
			a_err = new AssertionError(str+"Le code est incorrect : il est interdit de diviser par z�ro.");
		}catch(ClassCastException e){
			a_err = new AssertionError(str+"Attention, certaines variables ont �t� mal cast�es	!");
		}catch(StringIndexOutOfBoundsException e){
			a_err = new AssertionError(str+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
		}catch(NullPointerException e){
			a_err = new AssertionError(str+"Attention, vous faites une op�ration sur un objet qui vaut null !");
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
		// Fermer les flux et lancer l'AssertionError si elle a �t� d�tect�e
		finally{
			try{
				System.setOut(out);
				if(ps != null)
					ps.close();
				if(br != null)
					br.close();				
			}catch(IOException e){
				// A voir
			}
			finally{
				if(a_err != null){
					throw a_err;
				}
			}
		}
	}
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(M4Q7.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont pass�s sans encombre");
			System.exit(127);
		}
	}
}

