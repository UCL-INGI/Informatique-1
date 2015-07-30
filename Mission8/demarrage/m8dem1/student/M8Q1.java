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

public class M8Q1{
	
	private String q1 = "Question 1 :\n";
	private String q2 = "Question 2 :\n";
	private String str = "Il semblerait que votre code comporte des erreurs : ";
		
	@Test
	public void testSetBool(){
		try{
			M8Q1Stu.Drapeau d = new M8Q1Stu.Drapeau(false);
			d.set(true);
			assertTrue(q1 + str + "après l'appel à set(true) avec drapeau qui valait false avant, le drapeau vaut false", d.toBoolean());
			d.set(true);
			assertTrue(q1 + str + "après l'appel à set(true) avec drapeau qui valait true avant, le drapeau vaut false", d.toBoolean());
			d.set(false);
			assertFalse(q1 + str + "après l'appel à set(false) avec drapeau qui valait true avant, le drapeau vaut true", d.toBoolean());
			d.set(false);
			assertFalse(q1 + str + "après l'appel à set(false) avec drapeau qui valait false avant, le drapeau vaut true", d.toBoolean());
		}catch(ArithmeticException e){
			fail(q1+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(q1+"Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(q1+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(q1+"Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(q1 + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSetChar(){
		try{
			M8Q1Stu.Drapeau d = new M8Q1Stu.Drapeau('F');
			// Avec V
			d.set('V');
			assertTrue(q2 + str + "après l'appel à set('V') avec drapeau qui valait false avant, le drapeau vaut false", d.toBoolean());
			d.set('V');
			assertTrue(q2 + str + "après l'appel à set('V') avec drapeau qui valait true avant, le drapeau vaut false", d.toBoolean());
			for(char c = 'a' ; c <= 'z' ; c++){
				if(c == 'v' || c == 'V') c++;
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait true avant, le drapeau vaut true", d.toBoolean());
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait false avant, le drapeau vaut true", d.toBoolean());
			}
			for(char c = 'A' ; c <= 'Z' ; c++){
				if(c == 'v' || c == 'V') c++;
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait true avant, le drapeau vaut true", d.toBoolean());
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait false avant, le drapeau vaut true", d.toBoolean());
			}
			for(char c = Character.MIN_VALUE ; c < Character.MAX_VALUE ; c++){
				if(c == 'v' || c == 'V') c++;
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait true avant, le drapeau vaut true", d.toBoolean());
				d.set(c);
				assertFalse(q2 + str + "après l'appel à set('"+c+"') avec drapeau qui valait false avant, le drapeau vaut true", d.toBoolean());
			}
			// Avec v
			d.set('v');
			assertTrue(q2 + str + "après l'appel à set('v') avec drapeau qui valait false avant, le drapeau vaut false", d.toBoolean());
			d.set('v');
			assertTrue(q2 + str + "après l'appel à set('v') avec drapeau qui valait true avant, le drapeau vaut false", d.toBoolean());
		}catch(ArithmeticException e){
			fail(q2+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(q2+"Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(q2+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(q2+"Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(q2 + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(M8Q1.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
	
