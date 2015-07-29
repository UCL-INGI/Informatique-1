/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



package student;
/**
 *  @author François MICHEL
 */

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import java.util.Random;
import org.junit.runner.notification.Failure;
import java.io.*;
import java.util.Arrays;


public class M9Q13{
	
	private static String str = "Votre code semble comporter des erreurs : ";
	
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	@Test
	public void testIOException(){
		Random r = new Random();
		int res = 10;
		try{
			String filename = "student/"+generateString(7);
			File f = new File(filename);
			if(!f.createNewFile()){
				fail("Erreur de création de fichier, veuillez réessayer plus tard ou prévenir un responsable");
			}
			if(!f.setReadable(false)){
				fail("Erreur de changement de permission de fichier, veuillez réessayer plus tard ou prévenir un responsable");
			}
			res = M9Q13Stu.premierPrenom(filename);
			assertEquals(str + "lorsqu'une erreur apparait, la méthode doit retourner -1, or, elle retourne "+res+".", -1, res);
		}catch(IOException e){
			fail(str+"Une IOException est apparue, or, votre code ne fait rien pour la traiter.");
			e.printStackTrace();
		}catch(ArithmeticException e){
			fail(str+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str+"Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str+"Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str+"Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCorrectOutput(){
		Random r = new Random();
		PrintStream ps = null;
		BufferedReader br = null;
		BufferedReader br_fichier_a_lire = null;
		// On sauvegarde System.out
		PrintStream out = System.out;
		// On s'apprête à récupérer une AssertionError si l'une d'elle est lancée.
		AssertionError a_err = null;
		String filename = "student/noms.txt";
		try{
			ps = new PrintStream(new FileOutputStream("student/reponse.out"), true);
			// On redirige la sortie de System.out;
			System.setOut(ps);
			String s = null;
			String line = null;
			String line_fichier_a_lire = null;
			int res;
			res = M9Q13Stu.premierPrenom(filename);
			br = new BufferedReader(new FileReader("student/reponse.out"));
			br_fichier_a_lire = new BufferedReader(new FileReader(filename));
			line = br.readLine();
			line_fichier_a_lire = br_fichier_a_lire.readLine();
			while(line_fichier_a_lire != null){
				assertNotNull(str + "votre code semble ne pas afficher un résultat par ligne (trop peu de lignes affichées).", line);
				String premierprenom = line_fichier_a_lire.split("-")[0];
				assertEquals(str + "pour le nom composé \""+line_fichier_a_lire+"\", votre code affiche \""+line+"\" au lieu de \""+premierprenom+"\".",
																												premierprenom, line);
				line = br.readLine();
				line_fichier_a_lire = br_fichier_a_lire.readLine();
			}
			line = br.readLine();
			if(line != null && !line.equals("")){
				fail(str + "Vous affichez plus de lignes que nécessaire.  N'affichez rien d'autre que le résultat demandé.");
			}
		}catch(FileNotFoundException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie standard. "+e.getMessage());
			System.setOut(out);
		}catch(IOException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie standard. "+e.getMessage());
		}catch(AssertionError ae){
			// S'il faut lancer une AssertionError, on s'assure d'abord de fermer les flux et de tout remettre en ordre avant de la lancer en tant qu'erreur du programme
			a_err = ae;
		}catch(NumberFormatException e){
			a_err = new AssertionError("Une NumberFormatException s'est lancée, or, vous devez catcher cette exception. "+e.getMessage());
		}catch(ArithmeticException e){
			a_err = new AssertionError(str+"Le code est incorrect : Une ArithmeticException est survenue, or, vous devez la gérer !");
		}catch(ClassCastException e){
			a_err = new AssertionError(str+"Attention, certaines variables ont été mal castées	!");
		}catch(StringIndexOutOfBoundsException e){
			a_err = new AssertionError(str+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
		}catch(NullPointerException e){
			a_err = new AssertionError(str+"Attention, vous faites une opération sur un objet qui vaut null !");
		}catch(Exception e){
			a_err = new AssertionError(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
		// Fermer les flux et lancer l'AssertionError si elle a été détectée
		finally{
			try{
				System.setOut(out);
				if(ps != null)
					ps.close();
				if(br != null)
					br.close();	
				if(br_fichier_a_lire != null)
					br_fichier_a_lire.close();				
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
		Result result = JUnitCore.runClasses(M9Q13.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
