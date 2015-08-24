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

public class M6Q5{
	private static String str = "Votre code semble produire des erreurs : ";

	/**
	 * 	@pre	-
	 * 	@post	Vérifie le code de l'étudiant en regard de la question 1 (méthode setA()). On vérifie la valeur de la variable ordered.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testOrderedA(){
		Random r = new Random();
		try{
			M6Q5Stu.OrderedPair p = new M6Q5Stu.OrderedPair();
			int b = r.nextInt(Integer.MAX_VALUE);
			int a = r.nextInt(Integer.MAX_VALUE);
			boolean ordered = (a <= b);
			for(int i = 0 ; i < 100 ; i++){
				p.setA(a);
				ordered = (p.getA() <= p.getB());
				//	On met ici "Question 1 : " devant le message d'erreur pour que le script exécutant les tests
				//	Puisse associer le message d'erreur à la question désirée.
				assertEquals("Question 1 :\n"+str + "après l'appel à setA("+a+"), lorsque a = "+p.getA()+" et b = "+p.getB()+", ordered devrait valoir "+ordered+" car "
						+Math.min(p.getA(), p.getB())+" <= "+Math.max(p.getA(), p.getB())+", or, ce n'est pas le cas.",ordered, p.getOrdered());
				p.setA(-a);
				ordered = (p.getA() <= p.getB());
				assertEquals("Question 1 :\n"+str + "après l'appel à setB("+-a+"), lorsque a = "+p.getA()+" et b = "+p.getB()+", ordered devrait valoir "+ordered+" car "
						+Math.min(p.getA(), p.getB())+" <= "+Math.max(p.getA(), p.getB())+", or, ce n'est pas le cas.",ordered, p.getOrdered());
				a = r.nextInt(Integer.MAX_VALUE);
				b = r.nextInt(Integer.MAX_VALUE);
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
	
	/**
	 * 	@pre	-
	 * 	@post	Vérifie le code de l'étudiant en regard de la question 2 (setB()). On vérifie ici la valeur de la variable ordered.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testOrderedB(){
		Random r = new Random();
		try{
			M6Q5Stu.OrderedPair p = new M6Q5Stu.OrderedPair();
			int b = r.nextInt(Integer.MAX_VALUE);
			int a = r.nextInt(Integer.MAX_VALUE);
			boolean ordered = (a <= b);
			for(int i = 0 ; i < 10000 ; i++){
				p.setB(b);
				ordered = (p.getA() <= p.getB());
				assertEquals("Question 2 :\n"+str + "après l'appel à setB("+b+"), lorsque a = "+p.getA()+" et b = "+p.getB()+", ordered devrait valoir "+ordered+" car "
						+Math.min(p.getA(), p.getB())+" <= "+Math.max(p.getA(), p.getB())+", or, ce n'est pas le cas.",ordered, p.getOrdered());
				p.setB(-b);
				ordered = (p.getA() <= p.getB());
				assertEquals("Question 2 :\n"+str + "après l'appel à setB("+-b+"), lorsque a = "+p.getA()+" et b = "+p.getB()+", ordered devrait valoir "+ordered+" car "
						+Math.min(p.getA(), p.getB())+" <= "+Math.max(p.getA(), p.getB())+", or, ce n'est pas le cas.",ordered, p.getOrdered());				
				a = r.nextInt(Integer.MAX_VALUE);
				b = r.nextInt(Integer.MAX_VALUE);
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

	/**
	 * 	@pre	-
	 * 	@post	Teste le code de l'étudiant en regard de la question 1 (setA()) : On vérifie si la variable a bien été mise à jour.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testSetA(){
		Random r = new Random();
		try{
			M6Q5Stu.OrderedPair p = new M6Q5Stu.OrderedPair();
			int b = r.nextInt(Integer.MAX_VALUE);
			int a = r.nextInt(Integer.MAX_VALUE);
			int oldA = p.getA();
			int oldB = p.getB();
			int newA;
			int newB;
			for(int i = 0 ; i < 10000 ; i++){
				p.setA(a);
				newA = p.getA();
				assertEquals("Question 1 :\n"+ str + "après l'appel setA("+a+"), a vaut "+newA+" au lieu de "+a+".", a, newA);
				newB = p.getB();
				assertEquals("Question 1 :\n"+ str + "après l'appel setA("+a+"), b a changé et est passé de "+oldB+" à "+newB+".", oldB, newB);
				oldA = newA;
				p.setA(-b);
				newA = p.getA();
				assertEquals("Question 1 :\n"+str + "après l'appel setA("+-b+"), a vaut "+newA+" au lieu de "+-b+".", -b, newA);
				newB = p.getB();
				assertEquals("Question 1 :\n"+str + "après l'appel setA("+-b+"), b a changé et est passé de "+oldB+" à "+newB+".", oldB, newB);
				oldA = newA;
				b = r.nextInt(Integer.MAX_VALUE);
				a = r.nextInt(Integer.MAX_VALUE);
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


	/**
	 * 	@pre	-
	 * 	@post	Vérifie le code de l'éudiant en regard de la question2 (setB()). On vérifie ici si la variable a bien été mise à jour.
	 * 			Lance une AssertionError lorsqu'une réponse est incorrecte.
	 */
	@Test
	public void testSetB(){
		Random r = new Random();
		try{
			M6Q5Stu.OrderedPair p = new M6Q5Stu.OrderedPair();
			int b = r.nextInt(Integer.MAX_VALUE);
			int a = r.nextInt(Integer.MAX_VALUE);
			int oldA = p.getA();
			int oldB = p.getB();
			int newA;
			int newB;
			for(int i = 0 ; i < 10000 ; i++){
				p.setB(b);
				newB = p.getB();
				assertEquals("Question 2 :\n"+str + "après l'appel setB("+b+"), b vaut "+newB+" au lieu de "+b+".", b, newB);
				newA = p.getA();
				assertEquals("Question 2 :\n"+str + "après l'appel setB("+b+"), a a changé et est passé de "+oldA+" à "+newA+".", oldA, newA);
				oldB = newB;
				p.setB(-a);
				newB = p.getB();
				assertEquals("Question 2 :\n"+str + "après l'appel setB("+-a+"), b vaut "+newB+" au lieu de "+-a+".", -a, newB);
				newA = p.getA();
				assertEquals("Question 2 :\n"+str + "après l'appel setB("+-a+"), a a changé et est passé de "+oldA+" à "+newA+".", oldA, newA);
				oldB = newB;
				b = r.nextInt(Integer.MAX_VALUE);
				a = r.nextInt(Integer.MAX_VALUE);
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
		Result result = JUnitCore.runClasses(M6Q5.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
