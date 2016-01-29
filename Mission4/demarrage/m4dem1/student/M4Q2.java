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




/**
 *  @author François MICHEL
 */

package student;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;


import org.junit.runner.notification.Failure;
public class M4Q2 {
	
	/**
	 * 	@pre	-
	 * 	@post	Vérifie la réponse à la question 1 (si un char correspond à un chiffre ou non).
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	 @Test 
	public void testIsDigit(){ 
		// Cette chaine de caractères est obligatoire devant chaque message d'erreur pour que le message d'erreur soit attaché
		// à la question voulue.
		String str = "Question 1 :\n";
		try{
			for(int i = 0 ; i < 10 ; i++){
				assertEquals(str+"le caractère '"+i+"' est un chiffre, pourtant, votre code ne le considère pas comme tel.\n", 
							true, M4Q2Stu.isDigitStudent(Character.forDigit(i, 10)));
			}
			for(int i = 0 ; i < Character.MAX_VALUE ; i++){
				boolean exp = Character.isDigit((char) i);
				assertEquals(str + "quand c = '"+(char) i + "', b devrait valoir "+exp+", or, il vaut "+!exp+".\n", 
							exp, M4Q2Stu.isDigitStudent((char) i));
			}
		}catch(ArithmeticException e){
			fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * 	@pre	-
	 * 	@post	Vérifie le code de l'étudiant en regard de la question 2. (Méthode toUpper)
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	 @Test 
	public void testToUpper(){
		String str = "Question 2 :\n";
		try{
			for(char d = 'a' ; d != 'z' + 1 ; d++){
				char exp = Character.toUpperCase(d);
				char res = M4Q2Stu.toUpper(d);
				assertEquals(str + "Avec d = '"+d+"', e devrait valoir '"+exp+"', or, e vaut '"+res+"'.", exp, res);
			}
			
			for(char d = 'A' ; d != 'A' + 1 ; d++){
				char exp = Character.toUpperCase(d);
				char res = M4Q2Stu.toUpper(d);
				assertEquals(str + "Avec d = '"+d+"', e devrait valoir '"+exp+"', or, e vaut '"+res+"'.", exp, res);
			}
		}catch(ArithmeticException e){
			fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
			Result result = JUnitCore.runClasses(M4Q2.class);
			for (Failure failure : result.getFailures()) {
				System.err.println(failure.toString());
			}
			if(result.wasSuccessful()){
				System.out.println("Tous les tests se sont passés sans encombre");
				System.exit(127);
			}
	}
}
