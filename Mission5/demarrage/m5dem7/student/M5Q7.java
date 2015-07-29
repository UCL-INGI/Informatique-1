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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.Iterator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import org.junit.Test;
import org.junit.Assert;

import java.util.Random;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M5Q7.M5Q7Tests.class
})
public class M5Q7 {
	
    static final String metaMsg = "Nous avons réussi à provoquer une de vos assertions :" ;

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M5Q7Tests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		int count = 0;
		/**Attention qu'une failure n'occupe que une et une seule ligne*/
		while(failures.hasNext()){
			f = failures.next();

			String msg = f.getMessage();
			if(msg != null && msg.matches(".*"+metaMsg+".*")){
				System.out.println(msg);
			}
			else{
				System.err.println(msg);
				count++;
			}
		}
		if(count == 0){
			/**
			 * 127  :   nombre    magique   afin    de 
			 * signaler que tout les tests sont passés
			 **/
			System.exit(127);

		}

	}

	public static class M5Q7Tests extends junit.framework.TestCase {


		/**Variables de classe*/
		Random gen = new Random();
        final int NUM_ITER = 3;
		int[][] a;
		int[][] b;

		/**
		 * Le test est répéré afin    de réduire
		 * la      probabilité   que  l 'étudiant
		 * puisse coder en dur un    résultat qui  
		 * correspond aux  données    de   tests. 
         * @pre -
         * @post -
		 */
		@Test
		public void testCorrectness() {
			for(int k = 0; k < NUM_ITER; k++){
				int n = gen();
				a = new int[n][n];
				b = new int[n][n];
				for(int i = 0; i < n; i++){
					for(int j=0;j < n; j++){
						a[i][j] = gen.nextInt(100);
						b[i][j] = gen.nextInt(100);
					}
				}
                int[][] c1 = null;
                try{
					c1 = M5Q7Stu.add(a,b);
                }
                catch(Throwable e){
                	fail("Attention, il s'effectue une opération illégale "
							+ "dans votre code \n"+
							e.toString());
                }
				int[][] c2 = M5Q7Corr.add(a,b);
				if(c1 == null) 
                	Assert.fail("Votre réponse ne correspond pas à "
								+ "la réponse correcte : vous renvoyez null.");
                else{
                    for(int i=0; i<a.length;i++)
                        for(int j=0; j<a.length;j++)
                        {
                            Assert.assertEquals("Votre méthode n'effectue pas la somme \n"
                                    + "des matrices correctement: l'une des valeurs dans\n"
                                   +" la matrice résultat n'est pas correcte: ",c1[i][j],c2[i][j]);
                        }
                    }
           }
		}
		
		/**
		 * Test sur des matrices égales à null
         * @pre -
         * @post -
    	 */
		@Test
		public void testRobustness0(){
			
			a = null;
			b = null;
			int[][] c;
			try{
				c = M5Q7Stu.add(a,b);
			}
			catch(Throwable e){
				if(e instanceof AssertionError){
                	/**le message doit être sur une seule ligne*/
					Assert.fail(metaMsg+e.getMessage());
				}else{
					Assert.fail("Attention, il s'effectue une opération illégale \n"
							+ "dans votre code qui n'est pas prise en charge par \n"
							+ "une assertion: \n"+
							e.toString());
				}
			}
		}

        
		/**
		 * Tests sur des matrices aux formats aberrants:
		 * 
		 *  * * *  et   * * *  par exemple.
		 *  * *         * * 
		 *  *           * 
         * 
    	 */
		@Test
		public void testRobustness1(){
			int [][] c;
			int n = gen();
			int[][] d = new int[n][];
			/**On crée une matrice aberrante d*/
			for(int i = 0; i < d.length; i++){
				d[i] = new int[d.length-i];
			}
			try{
				c = M5Q7Stu.add(d,d);
			}
			catch(Throwable e){
				if(e instanceof AssertionError){
					Assert.fail(metaMsg+
							e.getMessage());
				}else{
					Assert.fail("Attention, il s'effectue une opération illégale "
							+ "dans votre code qui n'est pas prise en charge par "
							+ "une assertion: \n"+
							e.toString());
				}
			}
		
		}


		/**
		 * Test sur des matrices aux foramts différents:
		 * 
		 *    * *   et  * * *  par exemple.
		 *    * *       * * *
		 *              * * *
         * 
    	 */
		@Test
		public void testRobustness2(){
			int n = gen();
			int[][] c;
			a = new int[n][n];
			/**on fait en sorte que b 'recouvre' entièrement a*/
			b = new int[2*n][2*n];
			for(int i = 0; i < a.length; i++){
				for(int j=0;j < a[0].length; j++){
					a[i][j] = gen.nextInt(100);
				}
			}
			for(int i = 0; i < b.length; i++){
				for(int j=0;j < b[0].length; j++){
					b[i][j] = gen.nextInt(100);
				}
			}
			try{
				c = M5Q7Stu.add(a,b);
				c = M5Q7Stu.add(b,a);
			}
			catch(Throwable e){
				if(e instanceof AssertionError){
					Assert.fail(metaMsg+e.getMessage());
				}else{
					Assert.fail("Attention, il s'effectue une opération illégale "
							+ "dans votre code qui n'est pas prise en charge par "
							+ "une assertion: \n"+
							e.toString());
				}
			}
		}


		/**
		 * Génère aléatoirement un entier entre 1 et 10
		 * @pre un générateur random existe est et initialisé
		 */
		private int gen() {
			return gen.nextInt(9)+1;
		}
	}

}

