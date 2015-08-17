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
import org.junit.*;
import java.util.Random;
import org.junit.runner.notification.Failure;
import java.lang.StringBuffer;

public class M8Q8{
	
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	private static String str = "Il semble que votre méthode comporte des erreurs : ";
	
	
	/**
	 * 	@pre	-
	 * 	@post	Vérifie que la méthode de l'étudiant retourne bien null lorsque s = null ou n = 0.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testSNull(){
		try{
			assertNull(str + "lorsque s = null, votre méthode doit retourner null, or, ce n'est pas le cas. ", M8Q8Stu.repeat(null, 10));
			assertNull(str + "lorsque n = 0, votre méthode doit retourner null, or, ce n'est pas le cas. ", M8Q8Stu.repeat("hello", 0)); 
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
	 * 	@post	Vérifie que la réponse de l'étudiant correspond aux spécificatons (s est bien répété n fois).
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testCorrect(){
		Random r = new Random();
		try{
			String s;
			for(int i = 0 ; i <= 50 ; i++){
				if(i == 0){
					s = "";
				}
				else{
					s = '[' + generateString(r.nextInt(20) + 1) + ']';
				}
				StringBuffer sb = new StringBuffer();
				int n = r.nextInt(5) + 1;
				for(int j = 1 ; j <= n ; j++){
					sb.append(s);
					String res = M8Q8Stu.repeat(s, j);
					assertNotNull(str + "avec s = \""+s+"\" et n = "+j+", votre méthode devrait renvoyer le String \""+
									   sb.toString()+"\", or, elle renvoie un String null. ", res);
					assertEquals(str + "avec s = \""+s+"\" et n = "+j+", votre méthode devrait renvoyer le String \""+
									   sb.toString()+"\", or, elle renvoie le String \""+res.toString()+"\". ", sb.toString(),
																														  res);
				}
			}
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
		Result result = JUnitCore.runClasses(M8Q8.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
