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
/** because of deprecation */
//import junit.framework.Assert;
import org.junit.Assert;

import java.util.Random;


@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M5Q6.M5Q6Tests.class
})
/**
 * La méthode main de cette classe exécute les tests. Vu
 * que cet exercice demande de vérifier l'emploi d'assertions,
 * certaines assertions lancées ne sout pas considérées comme
 * des erreurs.
 *
 */
public class M5Q6 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M5Q6Tests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		int count = 0;
        /**
         * Une failure entière doit absolument être écrite sur une seule ligne
         * car .next()   semble  ne récupérer que des éléments ligne par ligne
         * dans l'objet f.
         **/
		while(failures.hasNext()){
			f = failures.next();
			
			String msg = f.getMessage();
			if(msg.matches(".*transgresse bien une de vos assertions avec le message suivant.*")){
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

	public static class M5Q6Tests extends junit.framework.TestCase{


		/**Class variables*/
		Random gen = new Random();
		int n;

       	/**
         * Vérifie que la méthode écrite par l'étudiant renvoie
         * bien le résultat attendu.
         * On tente de réduire la problabilité que des valeurs
         * codées en dur par l'étudiant ne coincident avec la 
         * valeur pseudo-aléatoire de n en exécutant trois fois
         * le test.
         * @pre gen est initialisé
         * @post -
         **/
		@Test
		public void testCorrectness() {
			for(int k = 0; k < 3; k++){
                n = gen.nextInt(9)+1;
                int[][] u = null;
                try{
                	u = M5Q6Stu.unite(n);
                }
                catch(Throwable e){
                	fail("Vous permettez une opération illégale dans votre code: "+e.toString());
                }
                try{
                	Assert.assertTrue("Votre matrice devrait être "
                        + "carrée", u.length == u[0].length );
                	Assert.assertTrue("Votre matrice devrait être "
                        + "d'ordre n", u.length == n );
                }
                catch(NullPointerException e){
                    fail("La valeur renvoyée par votre méthode n'est pas une matrice: elle est égale à null.");
                }
                catch(AssertionError e){
                	throw e;
                }
                catch(Throwable e){
                	fail("La matrice renvoyée par votre méthode devrait avoir au moins une ligne.");
                }
                int val = -1;
                for(int i=0; i < u.length; i++){
                    for(int j=0; j < u[0].length; j++){
      	                try{
	                	 	val = u[i][j];
    	        	    }catch(Throwable e){
        	        		fail("Les dimensions de votre matrice sont incorrectes.");
            	    	}
                        if(i != j){
                            Assert.assertEquals("Seuls les éléments de la diagonale principale"
                                    + " devraient avoir une valeur différente de zéro.", 0, val);
                        }else{
                            Assert.assertEquals("Les éléments de la diagonale principale "
                                    + "devraient valoir 1", 1, val);
                        }
                    }
                }
            }
		}

		@Test
		public void testRobustness1(){
			n = gen.nextInt(9)+1;
            int [][] u = null;
			try{
				u = M5Q6Stu.unite(-n);
			}
			catch(Throwable e){
				if(e instanceof AssertionError){
                	/**Il ne doit pas y avoir de retour à la ligne dans le message fail*/
					Assert.fail("Un input négatif transgresse bien une de vos assertions avec le message suivant :"+
								e.getMessage());
				}else
					Assert.fail("Attention vous permettez une opération illégale "
							+ "dans votre code qui n'est pas prise ne charge par "
							+ "une assertion: \n"+
							e.toString());
			}
		}
		
		@Test
		public void testRobustness2(){
			n = gen.nextInt(9)+1;
            int [][] u = null;
			try{
				u = M5Q6Stu.unite(0);
			}
			catch(Throwable e){
				if(e instanceof AssertionError){
                  	/**Il ne doit pas y avoir de retour à la ligne dans le message fail*/
					Assert.fail("L'input 0 transgresse bien une de vos assertions avec le message suivant :"+
							e.getMessage());
				}else
					Assert.fail("Attention vous permettez une opération illégale "
							+ "dans votre code qui n'est pas prise en charge par "
							+ "une assertion: \n"+
							e.toString());
			}

		}

	}

}

