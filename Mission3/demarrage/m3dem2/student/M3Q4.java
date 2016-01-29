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

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;


/**
 * Ecrivez la signature et le corps d’une méthode baptisée
 * afficheMax qui prendre deux   nombres     entiers comme 
 * arguments et affiche le plus grand    de ces    nombres. 
 * La spécification de cette méthode est :
 * 
 ∗ @pre −
 * @post affiche le maximmum entre les nombres entiers a et b
 * 
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M3Q4.M3Q4Tests.class
})
public class M3Q4 {


	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(M3Q4Tests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		while(failures.hasNext()){
			f = failures.next();
			System.err.println(f.getMessage());
		}
		if(result.wasSuccessful() == true){
			/**127 : nombre magique afin de signaler
			 * que tout les tests sont passés **/
			System.exit(127);

		}
	}
	
	public static class M3Q4Tests extends junit.framework.TestCase{
		
		Random gen = new Random();
		int a ;
		int b ;
		public static String rep1;
		public static String rep2;
        final int ITER = 3;
		private M3Q4Stu m3q4stu = new M3Q4Stu();
		private M3Q4Corr m3q4corr = new M3Q4Corr();
		
        /**
         * Vérifie que la méthode  de l' étudiant contenue
         * dans la classe "<code exercice>Stu" affiche bien
         * ce qu 'il faut sur le flux System.out. La compa-
         * raison est faite avec le code fourni en corrigé.
         * Le code est exécuté ITER fois au cas ou l'étudiant
         * aurait (exprès ou pas) codé en dur le résultat.
         * @pre gen est initilaisé
         * @post -
         */
		public void testCorrectnessWhenAEqualsB(){
        
            /**initialisation des valeurs de test**/
          	a = gen.nextInt();
            b = a;
      
			/**lancement d'une routine de test qui vérifie
			 * les réponses en sortie standard**/
			assertPrintsRIghtAnswer();
      }

		/**
         * Vérifie que la méthode  de l' étudiant contenue
         * dans la classe "<code exercice>Stu" affiche bien
         * ce qu 'il faut sur le flux System.out. La compa-
         * raison est faite avec le code fourni en corrigé.
         * Le code est exécuté ITER fois au cas ou l'étudiant
         * aurait (exprès ou pas) codé en dur le résultat.
         * @pre gen est initilaisé
         * @post -
         */
		public void testCorrectnessWhenAGreaterThanB(){
        
            /**initialisation des valeurs de test**/
	        a = gen.nextInt();
    	    while(a <= b){
        	 	b = gen.nextInt();
            }

    	    /**lancement d'une routine de test qui vérifie
    	     * les réponses en sortie standard */
			assertPrintsRIghtAnswer();
		}

      
        /**
         * Vérifie que la méthode  de l' étudiant contenue
         * dans la classe "<code exercice>Stu" affiche bien
         * ce qu 'il faut sur le flux System.out. La compa-
         * raison est faite avec le code fourni en corrigé.
         * Le code est exécuté ITER fois au cas ou l'étudiant
         * aurait (exprès ou pas) codé en dur le résultat.
         * @pre gen est initilaisé
         * @post -
         */
		public void testCorrectnessWhenASmallerThanB(){
        
            /**initialisation des valeurs de test**/
            a = gen.nextInt();
   	        while(a >= b){
   	        	b = gen.nextInt();
            }
    	    /**lancement d'une routine de test qui vérifie
    	     * les réponses en sortie standard */
			assertPrintsRIghtAnswer();
      }

		private void assertPrintsRIghtAnswer() {
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
			m3q4corr.afficheMax(a, b);
			//Change the stream again
		    System.out.flush();
		    System.setOut(ps2);
			try{
				m3q4stu.afficheMax(a, b);
			}
			catch(Throwable e){
				fail("Vous effectuez une opération "
						+ "illégale dans votre code "+translateMsg(e)+":"+e.toString());
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
        
        /**
		 * Renvoie un String qui représente une
		 * explication en français de l'objet 
		 * Throwable passé en argument.
		 * @pre e != null
		 * @post -
		 * @return -Un String qui représente le Throwable e.
		 */
		private String translateMsg(Throwable e){

			if(e instanceof IOException){
				return ":une IOException est apparue, or, votre "
						+ "code ne fait rien pour la traiter ";
			}
			if( e instanceof ArithmeticException){
				return ":il est interdit de diviser par zéro ";
			}
			if( e instanceof ClassCastException){
				return ":certaines variables ont été mal castées ";
			}
			if( e instanceof StringIndexOutOfBoundsException){
				return ":vous tentez de lire en dehors "
						+ "des limites d'un String ";
			}
			if( e instanceof ArrayIndexOutOfBoundsException){
				return ":vous tentez de lire en dehors "
						+ "des limites d'un tableau ";
			}
			if( e instanceof NullPointerException){
				return ":vous faites une opération sur un "
						+ "objet qui vaut null ";
			}
			return "";
		}
	}
}