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
public class M4Q5{
	
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	@Test
	public void testIsNull(){
		String q1 = "Question 1 :\n";
		String str = "Il semble que votre code comporte un problème : ";
		try{
			String res = M4Q5Stu.cat("ding", "dong");
			assertNotNull(str + "lorsque l'on donne s1 = \"ding\" et s2 \"dong\".\n", res);
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
			fail(q1 + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testConcat(){
		String q1 = "Question 1 :\n";
		try{
			Random r = new Random();
			String str = "Question 1 :\n Il semblerait que votre code comporte des erreurs : ";
			String s1 = null;
			String s2 = generateString(r.nextInt(20));
			String res;
			for(int i = 0 ; i < 1000 ; i++){
				s1 = generateString(r.nextInt(20));
				s2 = generateString(r.nextInt(20));
				String exp = s1+s2;
				res = M4Q5Stu.cat(s1, s2);
				assertEquals(str + "lorsque s1 = \""+s1+"\" et s2 = \""+s2+"\", votre méthode devrait renvoyer \""+exp+"\", or, elle renvoie \""+res+"\".\n", exp, res);
			}
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
			fail(q1 + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConcatChar(){
		String q2 = "Question 2 : \n";
		try{
			Random r = new Random();
			String str = "Question 2 :\n Il semblerait que votre code comporte des erreurs : ";
			String s1;
			char c;
			String res;
			for(c = 'a' ; c <= 'z' ; c++){
				s1 = generateString(r.nextInt(20));
				String exp = s1+c;
				res = M4Q5Stu.cat(s1, c);
				assertEquals(str + "lorsque s1 = \""+s1+"\" et c = '"+c+"', votre méthode devrait renvoyer \""+exp+"\", or, elle renvoie \""+res+"\".\n", exp, res);
			}
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
		Result result = JUnitCore.runClasses(M4Q5.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
	
}
