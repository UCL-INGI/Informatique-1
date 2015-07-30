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
	M7Q6.M7Q6Tests.class
})
public class M7Q6 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M7Q6Tests.class);
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

	public static class M7Q6Tests {
    
   		/**Variables de classe*/
		Random gen = new Random();
		M7Q6Stu m7q6 = new M7Q6Stu();
		
        /**
         * Vérifie que la méthode equals renvoie vrai
         * pour deux Pair identiques. 
         * @pre gen est initialisé
         * @post -
         *
         */

		@Test
		public void testSuccess(){

			M7Q6Stu m7q6 = new M7Q6Stu();
			
			int x = gen.nextInt(100);
			int y = gen.nextInt(100);
			M7Q6Stu.Pair p1 = m7q6.new Pair(x, y);
			M7Q6Stu.Pair p2 = m7q6.new Pair(x, y);
			Assert.assertTrue("Votre methode equals a renvoyé false"+ 
            " en comparant les Pairs ("+x+","+y+") "+
            "et ("+x+","+y+")",
            p1.equals(p2));
		}
        
        /**
         * Vérifie que la méthode equals renvoie faux
         * pour deux Pair différentes. 
         * @pre gen est initialisé
         * @post -
         *
         */
        @Test
		public void testFail(){


        	int x1 = gen.nextInt(100);
			int y1 = gen.nextInt(100);
			M7Q6Stu.Pair p1 = m7q6.new Pair(x1, y1);
			//x différent
			int x2 = x1 + gen.nextInt(100);
			M7Q6Stu.Pair p2 = m7q6.new Pair(x2, y1);
			Assert.assertFalse("Votre methode equals a renvoyé true "
					+ "en comparant les Pairs ("+x1+","+y1+") et"
							+ " ("+x2+","+y1+")",
                            p1.equals(p2));
			//y différents
			int y2 = y1 + gen.nextInt(100);
			M7Q6Stu.Pair p3 = m7q6.new Pair(x1, y2);
			Assert.assertFalse("Votre méthode equals a renvoyé true "
					+ "en comparant les Pairs ("+x1+","+y1+") et"
							+ " ("+x1+","+y2+")",
                            p1.equals(p3));
        }
        
        /**
         * Vérifie que la méthode equals ne
         * provoque pas d'exceptions relatives
         * au type de l'objet en paramètre.
         * @pre gen est initialisé
         * @post -
         */
        @Test
        public void testRobustness(){

        	int x1 = gen.nextInt(100);
			int y1 = gen.nextInt(100);
			ClasseImpostrice dummy = new ClasseImpostrice();
			M7Q6Stu.Pair p = m7q6.new Pair(x1, y1);
            try{
			Assert.assertFalse("Votre méthode equals a renvoyé true "
					+ "en comparant une instance de la classe Pair et"
					+ " une instance d'une autre classe",
                    p.equals(dummy));
            }
            catch(Throwable e){
            	if(e instanceof AssertionError){
                	throw e;
                }else
            		Assert.fail("Votre code provoque l'erreur : "+e.toString()); 
            }
        }
        
        /**
         *Classe qui n'est pas une Pair
         */
        private class ClasseImpostrice{
        	
        	@Override
        	public String toString(){
        		return "Je suis une impostrice";
        	}
       }
	}
}