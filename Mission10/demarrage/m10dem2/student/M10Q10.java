/**
 *  Copyright (c) 2015 François Michel, Clémentine Munyabarenzi
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
import org.junit.Test;
import java.util.Random;
import org.junit.runner.notification.Failure;
import java.io.*;

public class M10Q10{
	
	private String str = "Il semblerait que votre programme comporte des erreurs : ";
	
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
	 * 	@post	Vérifie que le code de l'étudiant gère bien les erreurs d'IO et retourne la bonne valeur (-1)
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
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
			if(!f.setWritable(false)){
				fail("Erreur de changement de permission de fichier, veuillez réessayer plus tard ou prévenir un responsable");
			}
			res = M10Q10Stu.write(r.nextInt(10) + 5, filename);
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
	
	/**
	 * 	@pre	-
	 * 	@post	Vérifie que la méthode de l'étudiant écrit bien le bon output dans le bon fichier et retourne la bonne valeur.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testOutputCorrect(){
		Random r = new Random();
		String filename = null;
		int n = 0;
		int res = -1;
		try{
			for(int j = 0 ; j < 100 ; j++){
				filename = "student/"+generateString(r.nextInt(7) + 3);
				n = r.nextInt(20) + 1;
				res = M10Q10Stu.write(n, filename);
				assertEquals(str + "lorsque tout s'est bien déroulé, la méthode doit retourner 0, or, elle retourne "+res+".", 0, res);
				String line = null;
				int i = 0;
				BufferedReader br = null;
				try{
					br = new BufferedReader(new FileReader(filename));
					for(i = 1 ; i <= n ; i++){
						line = br.readLine();
						if(line == null){
							fail(str + "avec n = "+n+", votre programme devrait afficher "+n+" ligne(s), or, il affiche "+(i-1)+" ligne(s). ");
						}
						int rep = Integer.parseInt(line);
						assertEquals(str + "à la "+i+"ème ligne, votre programme devrait écrire \""+i+"\", or, il affiche \""+rep+"\". ",
																																 i, rep);
					}
					line = br.readLine();
					if(line != null && !line.equals("")){
						fail(str + "Attention, n'écrivez pas plus de lignes que nécessaire dans le fichier.");
					}
				}catch(NumberFormatException e){
					fail(str + "à la "+i+"ème ligne, votre programme devrait écrire \""+i+"\", or, il affiche \""+line+"\". ");
				}catch(IOException e){
					fail(str + "Une erreur IO interne est survenue, veuillez réessayer plus tard ou contacter un responsable.");
				}finally{
					try{
						if(br != null){
							br.close();
						}
					}catch(IOException e){
						fail(str + "erreur d'IO Interne. veuillez réessayer plus tard ou contacter un responsable. ");
					}
				}
			}
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
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(M10Q10.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
	
}

