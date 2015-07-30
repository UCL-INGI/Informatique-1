/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
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


public class M10Q4{
	
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	@Test
	public void testNumberFormat(){
		String str = "Votre code semble comporter des erreurs : ";
		PrintStream ps = null;
		BufferedReader br = null;
		// On sauvegarde System.out
		PrintStream err = System.err;
		// On s'apprête à récupérer une AssertionError si l'une d'elle est lancée.
		AssertionError a_err = null;
		Random r = new Random();
		String[] t = null;
		try{
			ps = new PrintStream(new FileOutputStream("student/reponse1.out"), true);
			br = new BufferedReader(new FileReader("student/reponse1.out"));
			// On redirige la sortie de System.out;
			System.setErr(ps);
			String line = null;
			int res;
			for(int i = 0 ; i < 100 ; i++){
				t = arrayOfStrings(r.nextInt(13) + 2, 12);
				res = M10Q4Stu.RevisedRatio.div(t);
				line = br.readLine();
				assertNotNull(str + "avec comme arguments "+Arrays.toString(t)+", aucun message d'erreur n'est affiché sur la sortie d'erreur.",
																																			line);
				assertEquals(str + "Votre méthode doit se terminer en retournant -1 lors d'une erreur, or, elle retourne "+res+". ", -1, res);
				// On lit tout le message d'erreur.
				while(line != null)	line = br.readLine();																														
			}
		}catch(FileNotFoundException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie d'erreur standard. "+e.getMessage());
			System.setErr(err);
		}catch(IOException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie d'erreur standard. "+e.getMessage());
		}catch(NumberFormatException e){
			a_err = new AssertionError("Une NumberFormatException s'est lancée avec comme arguments "+Arrays.toString(t)+", or, vous devez catcher cette exception. ");
		}catch(AssertionError ae){
			// S'il faut lancer une AssertionError, on s'assure d'abord de fermer les flux et de tout remettre en ordre avant de la lancer en tant qu'erreur du programme/
			a_err = ae;
		}catch(ArithmeticException e){
			a_err = new AssertionError(str+"Le code est incorrect : il est interdit de diviser par zéro.");
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
				System.setErr(err);
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
	
	private int[] arrayOfInt(int length, int max){
		int[] tab = new int[length];
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			tab[i] = r.nextInt(max) + 1;
		}
		return tab;
	}
	
	private String[] arrayOfStrings(int length, int stringmaxlength){
		String[] tab = new String[length];
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			tab[i] = generateString(r.nextInt(stringmaxlength + 1));
		}
		return tab;
	}
	
	private String[] arrayOfIntButString(int length, int max){
		String[] tab = new String[length];
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			tab[i] = r.nextInt(max) + 1 + "";
		}
		return tab;
	}
	
	@Test
	public void testArithmetic(){
		String str = "Votre code semble comporter des erreurs : ";
		PrintStream ps = null;
		BufferedReader br = null;
		// On sauvegarde System.out
		PrintStream err = System.err;
		// On s'apprête à récupérer une AssertionError si l'une d'elle est lancée.
		AssertionError a_err = null;
		Random r = new Random();
		try{
			ps = new PrintStream(new FileOutputStream("student/reponse2.out"), true);
			br = new BufferedReader(new FileReader("student/reponse2.out"));
			// On redirige la sortie de System.out;
			System.setErr(ps);
			String line = null;
			int res;
			for(int i = 0 ; i < 100 ; i++){
				String[] tab = arrayOfIntButString(r.nextInt(15) + 2, 200);
				tab[r.nextInt(tab.length - 1) + 1] = 0 + "";
				res = M10Q4Stu.RevisedRatio.div(tab);
				line = br.readLine();
				assertNotNull(str + "avec comme arguments "+Arrays.toString(tab)+", aucun message d'erreur n'est affiché sur la sortie d'erreur standard.",
																															line);
				assertEquals(str + "Votre méthode doit se terminer en retournant -1 lors d'une erreur, or, elle retourne "+res+". ", -1, res);
				// On récupère tout le message d'erreur
				while(line != null)	line = br.readLine();																														
			
			}
		}catch(FileNotFoundException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie d'erreur standard. "+e.getMessage());
			System.setErr(err);
		}catch(IOException e){
			a_err = new AssertionError("Il semble qu'une erreur s'est produite avec l'écriture sur la sortie d'erreur standard. "+e.getMessage());
		}catch(AssertionError ae){
			// S'il faut lancer une AssertionError, on s'assure d'abord de fermer les flux et de tout remettre en ordre avant de la lancer en tant qu'erreur du programme/
			System.setErr(err);
			a_err = ae;
		}catch(ArithmeticException e){
			a_err = new AssertionError(str+"Le code est incorrect : Une ArithmeticException est survenue alors que vous devriez la gérer.");
		}catch(ClassCastException e){
			a_err = new AssertionError(str+"Attention, certaines variables ont été mal castées	!");
		}catch(NumberFormatException e){
			a_err = new AssertionError("Une NumberFormatException s'est lancée, or, vous devez catcher cette exception. "+e.getMessage());
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
				System.setErr(err);
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
	
	@Test
	public void testCorrectOutput(){
		String str = "Votre code semble comporter des erreurs : ";
		Random r = new Random();
		PrintStream ps = null;
		BufferedReader br = null;
		// On sauvegarde System.out
		PrintStream out = System.out;
		// On s'apprête à récupérer une AssertionError si l'une d'elle est lancée.
		AssertionError a_err = null;
		try{
			ps = new PrintStream(new FileOutputStream("student/reponse3.out"), true);
			br = new BufferedReader(new FileReader("student/reponse3.out"));
			// On redirige la sortie de System.out;
			System.setOut(ps);
			String s = null;
			String line = null;
			int res;
			for(int j = 0 ; j < 100 ; j++){
				String[] tab = arrayOfIntButString(r.nextInt(15) + 2, 200);
				res = M10Q4Stu.RevisedRatio.div(tab);
				for(int i = 1 ; i < tab.length ; i++){
					line = br.readLine();
					assertNotNull(str + "votre code semble ne pas afficher un résultat par ligne.", line);
					String[] egalite = line.replace(" ", "").split("=");
					if(egalite.length != 2){
						throw new AssertionError(str + "erreur de format : chaque résultat  doit être affiché sur une ligne différente et "
													 + "doit être de la forme \"a / b = c\", or, votre méthode a affiché \""+line+"\" pour "
													 + "un résultat. ");
					}
					String[] division = egalite[0].split("/");
					if(division.length != 2){
						throw new AssertionError(str + "erreur de format : chaque résultat  doit être affiché sur une ligne différente et "
													 + "doit être de la forme \"a/b = c\", or, votre méthode a affiché \""+line+"\" pour "
													 + "un résultat. ");
					}
					int aCorrect = Integer.parseInt(tab[0]);
					int bCorrect = Integer.parseInt(tab[i]);
					int cCorrect = aCorrect / bCorrect;
					try{
						int a = Integer.parseInt(division[0]);
						int b = Integer.parseInt(division[1]);
						int c = Integer.parseInt(egalite[1]);
						// Si le calcul est mauvais
						if(a != aCorrect || b != bCorrect || a/b != c || c != cCorrect){
							throw new AssertionError(str + "Erreur dans la réponse. Au lieu d'afficher \""+aCorrect+"/"+bCorrect+" = "+cCorrect+"\", "
														 + "la méthode affiche \""+ line+"\". ");
						}
					}catch(NumberFormatException e){
						throw new AssertionError(str + "Erreur dans le format. Au lieu d'afficher \""+aCorrect+"/"+bCorrect+" = "+cCorrect+"\", "
														 + "la méthode affiche \""+ line+"\". ");
					}
				}
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
		Result result = JUnitCore.runClasses(M10Q4.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
