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

public class M6Q7{
	
	
	@Test
	public void testSameNull(){
		String str = "Il semble que votre méthode same contienne des erreurs : ";
		try{
			M6Q7Stu.Drapeau d = null;
			M6Q7Stu.Drapeau d2 = new M6Q7Stu.Drapeau(true);
			assertFalse("Votre méthode same devrait renvoyer false lorsque d = null, or, ce n'est pas le cas.", d2.same(d));
			d2.set(false);
			assertFalse("Votre méthode same devrait renvoyer false lorsque d = null, or, ce n'est pas le cas.", d2.same(d));
		}catch(ArithmeticException e){
			fail(str+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str+"Attention, certaines variables ont été mal castées !");
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
	public void testSame(){
		String str = "Il semble que votre méthode same contienne des erreurs : ";
		try{
			M6Q7Stu.Drapeau d = new M6Q7Stu.Drapeau(true);
			M6Q7Stu.Drapeau d2 = new M6Q7Stu.Drapeau(true);
			assertTrue(str + "lorsque d a l'état true et que la variable drapeau vaut true, votre méthode devrait retourner true"
						   + " mais ce n'est pas le cas.", d2.same(d));
			d.set(false);
			assertFalse(str + "lorsque d a l'état false et que la variable drapeau vaut true, votre méthode devrait retourner false"
						   + " mais ce n'est pas le cas.", d2.same(d));
			d2.set(false);
			assertTrue(str + "lorsque d a l'état false et que la variable drapeau vaut false, votre méthode devrait retourner true"
						   + " mais ce n'est pas le cas.", d2.same(d));
			d.set(true);
			assertFalse(str + "lorsque d a l'état true et que la variable drapeau vaut false, votre méthode devrait retourner false"
						   + " mais ce n'est pas le cas.", d2.same(d));
		}catch(ArithmeticException e){
			fail(str+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str+"Attention, certaines variables ont été mal castées !");
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
		Result result = JUnitCore.runClasses(M6Q7.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
