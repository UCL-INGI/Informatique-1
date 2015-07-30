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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Random;

@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M5Q9.M5Q9Tests.class
})
public class M5Q9 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M5Q9Tests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		while(failures.hasNext()){
			f = failures.next();
			System.err.println(f.getMessage());
		}
		if(result.wasSuccessful() == true){
			/**127 : nombre magique afin de signaler que tout le tests sont passés */
            System.exit(127);
        }
	}

	public static class M5Q9Tests {
    
   		/**Variables de classe*/
		private final int LENGTH = 5;
		private final String chars = "abcdefghijklmnopqrstuvwxyz";
		private Random gen = new Random();

		/**
         * Vérifie que la méthode de l'étudiant imprime une
         * réponse identique à celle du code fourni en corrigé.
         * pour la question 1 de l'exercice.
         * @pre -
         * @post -
         */
		@Test
		public void testCorrectness(){
			String[] args = {gen(gen, chars, LENGTH), 
					gen(gen, chars, LENGTH),
					gen(gen, chars, LENGTH)};
			// create a stream to hold the output
		    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		    PrintStream ps1 = new PrintStream(baos1);
		    PrintStream ps2 = new PrintStream(baos2);
		    // save the old System.out!
		    PrintStream old = System.out;
		    // Tell Java to use your special stream
		    System.setOut(ps1);
		    // Print some output: goes to your special stream
			M5Q9Stu.main(args);
			//Change the stream again
		    System.out.flush();
		    System.setOut(ps2);
			M5Q9Corr.main(args);
		    // Put things back
		    System.out.flush();
		    System.setOut(old);
		    //use the answers
		    String rep1 = baos1.toString();
			String rep2 = baos2.toString();
			Assert.assertTrue("Question 1 : \nVotre réponse ne correspond pas "
		    		+ "à la réponse attendue. \nVotre réponse: \n"+rep1
		    		+"\nLa réponse attendue: \n"+rep2, rep1.equals(rep2));
		}

		/**
         * Vérifie que la méthode de l'étudiant imprime une
         * réponse identique à celle du code fourni en corrigé.
         * pour la question 2 de l'exercice.
         * @pre -
         * @post -
         */
        @Test
		public void testCorrectness2(){
			
			int a = gen.nextInt(10);
			int b = gen.nextInt(10);
			String[] args =  {a+"", b+""};
			// create a stream to hold the output
		    ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
		    ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		    PrintStream ps1 = new PrintStream(baos1);
		    PrintStream ps2 = new PrintStream(baos2);
		    // save the old System.out!
		    PrintStream old = System.out;
		    // Tell Java to use your special stream
		    System.setOut(ps1);
		    // Print some output: goes to your special stream
			M5Q9StuBis.main(args);
			//Change the stream again
		    System.out.flush();
		    System.setOut(ps2);
			M5Q9CorrBis.main(args);
		    // Put things back
		    System.out.flush();
		    System.setOut(old);
		    //use the answers
		    String rep1 = baos1.toString();
			String rep2 = baos2.toString();
			Assert.assertTrue("Question 2 : \nVotre réponse ne correspond pas "
		    		+ "à la réponse attendue. \nVotre réponse: \n"+rep1
		    		+"\nLa réponse attendue: \n"+rep2, rep1.equals(rep2));
		}
        
        /**
		 * Author : Jon Skeet, stackoverflow
		 * Génère aléatoirement un string
		 * @pre un générateur random existe est et initialisé
         * 
		 */
		private String gen(Random rng, String characters, int length) {
			char[] text = new char[length];
			for (int i = 0; i < length; i++)
			{
				text[i] = characters.charAt(rng.nextInt(characters.length()));
			}
			return new String(text);
		}
	}
}