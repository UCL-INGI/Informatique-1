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

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.util.Random;
import java.lang.Math;

/**
 * Les messages des violations d'assertions et des
 * exceptions lancées doivent absolument respecter
 * le format suivant "Question <num> : \n.*". Seul
 * le premier message d'erreur de chaque test sera
 * montré à l'étudiant.
 */
public class M5Q5Tests {

	
	/**Class variables*/
	Random gen = new Random();
	int l = gen.nextInt(10);
	int k = gen.nextInt(10);
	
    /**
     * Vérifie que la méthode de l'étudiant effectue bien
     * une opération qui provoquera le compotement attendu
     * par test (t1==t2).
     */
	@Test
	public void testequalequalSucceeds() {
    	try{
		M5Q5Stu.equalequalSucceeds();
        }
   		catch(Throwable e){
			Assert.fail("Question 1 : \n"
		+"attention vous effectuez une opération illégale dans votre code : \n"+
					e.toString());
		}
		Assert.assertTrue("Question 1 : \n"+"le test t1 == t2 devrait réussir.", M5Q5Stu.t1 == M5Q5Stu.t2);
	}
	
    /**
     * Vérifie que la méthode  de l' étudiant contenue
     * dans la classe "<code exercice>Stu" renvoie bien
     * la valeur qu'il faut. La comparaison est faite 
     * avec le code fourni en corrigé dans la classe 
     * "<code exercice>Corr". Les valeurs de test sont
     * fixes.
     * @pre -
     * @post -
     */
	@Test
	public void testTheProperWay(){
		double[] t3 = {0.1, 0.2};
		double[] t4 = {0.4, 0.5};
		double[] t5 = {0.1, 0.2};
		try{
			Assert.assertEquals("Question 2 : \n"+"Votre méthode devrait renvoyer true quand t1 et t2 sont les mêmes vecteurs.",M5Q5Stu.egal(t3, t5), M5Q5Corr.egal(t3, t5));
			Assert.assertEquals("Question 2 : \n"+"Votre méthode devrait renvoyer false quand t1 et t2 sont des vecteurs différents.",M5Q5Stu.egal(t4, t5), M5Q5Corr.egal(t4, t5));
		}
		catch(Throwable e){
        	if(!(e instanceof AssertionError)){
				Assert.fail("Question 2 : \n"
				+"attention vous effectuez une opération illégale dans votre code : \n"+
					e.toString());
            }else{
            	throw e;
            }
		}

	}

}
