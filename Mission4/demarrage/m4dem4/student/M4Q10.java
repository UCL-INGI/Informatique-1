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
 *  @author François MICHEL
 */

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import java.util.Random;
import org.junit.runner.notification.Failure;

public class M4Q10{
	
	/**
	 * 	@pre	-
	 * 	@post	Génère un String aléatoirement, de taille length.
	 */
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
	 * 	@post	Vérifie le code de l'étudiant : sa méthode doit retourner le String s
	 * 			en version majuscules. (compare avec s.toUpperCase())
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testToUpper(){
		String str = "Il semble que votre code comporte des erreurs : ";
		try{
			String s;
			String exp;
			String res;
			for(int i = 1 ; i < 30 ; i++){
				for(int j = 0 ; i < 10 ; i++){
					s = generateString(i);
					exp = s.toUpperCase();
					res = M4Q10Stu.toUpper(s);
					assertEquals(str + "avec \""+s+"\" comme argument, votre méthode devrait renvoyer \""+exp+"\", or, elle retourne \""+res+"\".",
								exp, res);
				}
			}
		
		}catch(ArithmeticException e){
			fail(str+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str+"Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(str+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str+"Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(M4Q10.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
	
}
