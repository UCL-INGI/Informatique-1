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



package student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M3Q6.M3Q6Tests.class
})
public class M3Q6 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M3Q6Tests.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.getMessage());
		}
		if(result.wasSuccessful()){
			System.out.println("\nVotre réponse: "+M3Q6Tests.rep2+
					"\nLa réponse attendue : "+M3Q6Tests.rep1);
            System.exit(127);
		}
	}
	
	public static class M3Q6Tests extends junit.framework.TestCase{

		
		/**Class variables*/
		Random gen = new Random();
		M3Q6Stu m3q6stu = new M3Q6Stu();
		public static String rep1;
		public static String rep2;

		/**
         * Vérifie que la méthode  de l' étudiant contenue
         * dans la classe "<code exercice>Stu" affiche bien
         * ce qu 'il faut sur le flux System.out. La compa-
         * raison est faite avec le code fourni en corrigé
         */
		@Test
		public void testSuccessLettre_l() {
			String abc = "ABCDEFGHIJK";
			char c = abc.charAt(gen.nextInt(11));
			int h = 0;
			int l = 0;
            while(h == 0 && l == 0){
				h = Math.abs(gen.nextInt(15));
				l = Math.abs(gen.nextInt(15));
			}
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
			// exécution code correcte
			M3Q6Corr.lettre_l(c, h, l);
			//Change the stream again
		    System.out.flush();
		    System.setOut(ps2);
			try{
				M3Q6Stu.lettre_l(c, h, l);
			}
			catch(Throwable e){
				fail("Vous effectuez une opération "
						+ "illégale dans votre code: "+e.getMessage());
			}
		    // Put things back
		    System.out.flush();
		    System.setOut(old);
		    //use the answers
		    rep1 = baos1.toString();
			rep2 = baos2.toString();
			//comparer les résultats
			assertTrue("Votre réponse n'est pas la réponse attendue."
					+ "\nVotre réponse: "+rep2+
					"\nLa réponse attendue : "+rep1, rep1.equals(rep2));

		}
	}

}

