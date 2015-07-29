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
import java.util.List;
import java.util.ArrayList;


public class M6Q9{
	
	private String q1 = "Question 1 :\n";
	private String q2 = "Question 2 :\n";
	
	
	@Test
	public void testAllFileRead(){
		try{
			List<M6Q9Stu> l = M6Q9Stu.lireCotes();
			assertTrue(q2 + "Attention, vous ne lisez pas toutes les lignes du fichier, vérifiez la condition. ", l.size() == 4);
		}catch(ArithmeticException e){
			fail(q1+"Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		}catch(ClassCastException e){
			fail(q1+"Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		}catch(StringIndexOutOfBoundsException e){
			fail(q1+"Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		}catch(IllegalArgumentException e){
			fail(q1 + "Erreur : " + e.getMessage());
		}catch(NullPointerException e){
			fail(q1+"Attention, vous faites une opération sur un objet qui vaut null !");
			e.printStackTrace();
		}catch(Exception e){
			fail(q1 + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void outputCorrect(){
		try{
			ArrayList<M6Q9Stu> l = (ArrayList<M6Q9Stu>) M6Q9Stu.lireCotes();
			assertEquals(q1 + "Le fichier student/cotes.txt n'est pas lu correctement. Vérifiez la condition de boucle !", l.get(0),
																                                                   new M6Q9Stu("Charles", 
																															   "Pecheur",
																															    12));
			assertEquals(q1 + "Le fichier student/cotes.txt n'est pas lu correctement. Vérifiez la condition de boucle !", l.get(1),
																                                                   new M6Q9Stu("Olivier", 
																															   "Bonaventure",
																															    15));
			assertEquals(q1 + "Le fichier student/cotes.txt n'est pas lu correctement. Vérifiez la condition de boucle !", l.get(2),
																                                                   new M6Q9Stu("Jean-Pierre", 
																															   "Kof",
																															    19));
			assertEquals(q1 + "Le fichier student/cotes.txt n'est pas lu correctement. Vérifiez la condition de boucle !", l.get(3),
																                                                   new M6Q9Stu("Johnny", 
																															   "Hallyday",
																															    3));
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
		}catch(IllegalArgumentException e){
			fail(q1 + "Erreur : " + e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e){
			fail(q2+ "Attention, vous ne lisez pas toutes les lignes du fichier, vérifiez la condition. ");
		}catch(Exception e){
			fail(q1 + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args){
		Result result = JUnitCore.runClasses(M6Q9.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.toString());
		}
		if(result.wasSuccessful()){
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
