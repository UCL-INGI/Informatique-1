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

public class M6Q4{
	
	
	@Test
	public void pairTesterNotNull(){
		String str = "Il semblerait que votre méthode renvoie un objet null : ";
		try{
			Random r = new Random();
			int a = 0;
			int b = 0;
			for(int i = 0 ; i < 1001 ; i++){
				assertNotNull(str+"lorsque l'instance de Pair qui appelle cette méthode possède un a = "+a+" et b = "+b+".",
							 (new M6Q4Stu.Pair(a,b)).opposite());
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
	
	
	@Test
	public void pairTester(){
		String str = "Il semblerait que votre méthode renvoie un résultat incorrect : ";
		try{
			Random r = new Random();
			int a = 0;
			int b = 0;
			for(int i = 0 ; i < 1001 ; i++){
				M6Q4Stu.Pair p = new M6Q4Stu.Pair(a,b);
				M6Q4Stu.Pair res = p.opposite();
				assertNotSame(str + "la méthode doit renvoyer une nouvelle instance de la classe Pair et non l'instance qui y fait appel.",
								p, res);
				assertEquals(str+"lorsque l'instance de Pair qui appelle cette méthode possède un a = "+a+" et b = "+b+", la méthode renvoie une Paire où"
									+" a = "+res.getA()+" et b = "+res.getB()+" au lieu de a = "+-a+" et b = "+-b+".",
							 new M6Q4Stu.Pair(-a, -b), res);
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
	
	@Test
	public void pairTesterHasChanged(){
		String str = "Votre méthode semble modifier les variables d'instance de l'instance appelante : ";
		try{
			Random r = new Random();
			int a = 0;
			int b = 0;
			for(int i = 0 ; i < 1001 ; i++){
				M6Q4Stu.Pair p = new M6Q4Stu.Pair(a,b);
				assertEquals(str + "a valait"+a+" et vaut maintenant "+p.getA()+".", a, p.getA());
				assertEquals(str + "b valait"+b+" et vaut maintenant "+p.getB()+".", b, p.getB());
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
		Result result = JUnitCore.runClasses(M6Q4.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
	
}
