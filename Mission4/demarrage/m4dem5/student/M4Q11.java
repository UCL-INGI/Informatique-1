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

public class M4Q11{
	
	private String str = "Question 1 :\nIl semblerait que votre code comporte des erreurs : ";
	public static String generateString(int length){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			s += (char) ((r.nextInt('z' - 'a') + 'a'));
		}
		return s;
	}
	
	public static String generateString(int length, String excepted){
		String s = "";
		Random r = new Random();
		for(int i = 0 ; i < length ; i++){
			char carac = (char) ((r.nextInt('z' - 'a') + 'a'));
			boolean ok = true;
			for(int j = 0 ; j < excepted.length() ; j++){
				if(carac == excepted.charAt(j)){
					ok = false;
					j = excepted.length();
				}
			}
			if(ok){
				s += carac;
			}
			else{
				i--;
			}
		}
		return s;
	}
	
	public static String createContainer(String toContain, int cLength){
		String s = generateString(cLength);
		s = insertInto(toContain, s);
		return s;
	}
	
	/**
	 * 	@pre s.length() > toInsert.length()
	 */
	public static String insertInto(String toInsert, String s){
		if(s.length() == 0)	return toInsert;
		Random r = new Random();
		for(int i = 0 ; i < toInsert.length() ; i++){
			int pos = r.nextInt(s.length());
			s = s.substring(0,pos) + toInsert.charAt(i) + s.substring(pos, s.length());
		}
		return s;
	}
	
	@Test
	public void testContains(){
		Random r = new Random();
		try{
			String s;
			String c;
			boolean res;
			for(int i = 1 ; i < 8; i++){
				for(int j = 0 ; j < 100 ; j++){
					s = generateString(i);
					c = createContainer(s, r.nextInt(8));
					res = M4Q11Stu.containsChar(s, c);
					assertTrue(str + "la chaine \""+c+"\" contient les caractères contenus dans \""+s+"\", or, votre méthode renvoie false. ", res);
				}
			}
			s = "abc";
			c = "abclmksf";
			res = M4Q11Stu.containsChar(s, c);
			assertTrue(str + "la chaine \""+c+"\" contient les caractères contenus dans \""+s+"\", or, votre méthode renvoie false. ", res);
		
			s = "aaa";
			c = "a";
			res = M4Q11Stu.containsChar(s, c);
			assertTrue(str + "la chaine \""+c+"\" contient les caractères contenus dans \""+s+"\", or, votre méthode renvoie false. ", res);
		
			s = "abc";
			c = "dfsfrabc";
			res = M4Q11Stu.containsChar(s, c);
			assertTrue(str + "la chaine \""+c+"\" contient les caractères contenus dans \""+s+"\", or, votre méthode renvoie false. ", res);
		
			s = "abc";
			c = "dvcsqalfb";
			res = M4Q11Stu.containsChar(s, c);
			assertTrue(str + "la chaine \""+c+"\" contient les caractères contenus dans \""+s+"\", or, votre méthode renvoie false. ", res);
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
	public void testNotContains(){
		Random r = new Random();
		try{
			String s;
			String c;
			boolean res;
			for(int i = 1 ; i < 8; i++){
				for(int j = 0 ; j < 100 ; j++){
					s = generateString(i);
					c = generateString(r.nextInt(8) + 1, s);
					res = M4Q11Stu.containsChar(s, c);
					assertFalse(str + "la chaine \""+c+"\" ne contient pas tous les caractères contenus dans \""+s+"\", or, votre méthode renvoie true. ", res);
				}
			}
			s = "abcd";
			c = "abclmksf";
			res = M4Q11Stu.containsChar(s, c);
			assertFalse(str + "la chaine \""+c+"\" ne contient pas tous les caractères contenus dans \""+s+"\", or, votre méthode renvoie true. ", res);
		
			s = "aba";
			c = "a";
			res = M4Q11Stu.containsChar(s, c);
			assertFalse(str + "la chaine \""+c+"\" ne contient pas tous les caractères contenus dans \""+s+"\", or, votre méthode renvoie true. ", res);
		
			s = "voc";
			c = "dfsfrabc";
			res = M4Q11Stu.containsChar(s, c);
			assertFalse(str + "la chaine \""+c+"\" ne contient pas tous les caractères contenus dans \""+s+"\", or, votre méthode renvoie true. ", res);
		
			s = "bc";
			c = "dvsqalfb";
			res = M4Q11Stu.containsChar(s, c);
			assertFalse(str + "la chaine \""+c+"\" ne contient pas tous les caractères contenus dans \""+s+"\", or, votre méthode renvoie true. ", res);
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
		Result result = JUnitCore.runClasses(M4Q11.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
