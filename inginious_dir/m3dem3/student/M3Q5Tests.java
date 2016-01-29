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

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.util.Random;

public class M3Q5Tests {

	
	/**Class variables*/
	M3Q5Stu m3q5stu = new M3Q5Stu();
	final int ITER = 10;
    Random gen = new Random();
    
    /**
     * Vérifie que la méthode de l'étudiant renvoie
     * true quand il le faut, la méthode de l'étudiant
     * est testée ITER fois au cas ou l'étudiant aurait
     * codé en dur (volontairement ou non) des valeurs
     * ou écrit un code correcte seulement pour un
     * certain nombre de valeurs.
     */
	@Test
	public void testSuccessImpair() {
    		int i = 0;
    	for(int j = 0; j < ITER; j++){
			i = gen.nextInt(1000);
            while(i%2 == 0){
            	i = gen.nextInt(1000);
            }
            boolean res = false;
            try{
            	res = m3q5stu.impair(i);
            }
            catch(Throwable e){
  				Assert.fail("Vous effectuez une opération illégale dans votre code: "+e.toString());
           }
			Assert.assertTrue("Votre méthode devrait renvoyer true lorsque n est paire mais renvoie false",res);
        }
	}
	
    /**
     * Vérifie que la méthode de l'étudiant renvoie
     * false quand il le faut, la méthode de l'étudiant
     * est testée ITER fois au cas ou l'étudiant aurait
     * codé en dur (volontairement ou non) des valeurs
     * ou écrit un code correcte seulement pour un
     * certain nombre de valeurs.
     */
	@Test
	public void testFailImpair() {
		
    		int i = 0;
    	for(int j = 0; j < ITER; j++){
			i = gen.nextInt(1000);
            while(i%2 == 1){
            	i = gen.nextInt(1000);
            }
            boolean res = true;
            try{
            	res = m3q5stu.impair(i);
            }
            catch(Throwable e){
 				Assert.fail("Vous effectuez une opération illégale dans votre code: "+e.toString());
            }
		Assert.assertFalse("Votre méthode devrait renvoyer false lorsque n est impaire mais renvoie true.", res);
		}
	}
}
