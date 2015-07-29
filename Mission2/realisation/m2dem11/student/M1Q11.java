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
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;
import java.util.Random;
import org.junit.runner.notification.Failure;


public class M1Q11{
	
	
	private static String str = "Le code semble comporter des erreurs : ";

	// Code vérificateur
	@Test
	public void testPrime0(){
		try{
			assertFalse(str + 0 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(0));
		}catch (ArithmeticException e){
			fail(str + "il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrime1(){
		try{
			assertFalse(str + 1 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(1));
		}catch (ArithmeticException e){
			fail(str + "il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPrime2(){
		try{
			assertTrue(str + 2 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(2));
		}catch (ArithmeticException e){
			fail(str + "il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOther(){
		try{
			// Batterie de tests
			assertTrue(str + 11 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(11));
			assertTrue(str + 23 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(23));
			assertTrue(str + 211 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(211));
			assertTrue(str + 701 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(701));
			assertTrue(str + 227 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(227));
			assertTrue(str + 101 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(101));
			assertTrue(str + 313 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(313));
			assertTrue(str + 389 +" est un nombre premier, or, le code ne le considère pas comme premier.",M1Q11Stu.isPrime(389));
			assertFalse(str + 10 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(10));
			assertFalse(str + 100 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(100));
			assertFalse(str + 4 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(4));
			assertFalse(str + 14 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(14));
			assertFalse(str + 58 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(58));
			assertFalse(str + 169 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(169));
			assertFalse(str + 15 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(15));
			assertFalse(str + 333333 +" n'est pas un nombre premier, or, le code le considère comme premier.",M1Q11Stu.isPrime(333333));
		}catch (ArithmeticException e){
			fail(str + "il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(NullPointerException e){
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		}catch(Exception e){
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(M1Q11.class);
		for (Failure failure: result.getFailures()) {
			System.err.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
