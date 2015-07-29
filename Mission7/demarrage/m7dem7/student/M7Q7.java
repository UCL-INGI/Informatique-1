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
	M7Q7.M7Q7Tests.class
})
public class M7Q7 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M7Q7Tests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		while(failures.hasNext()){
			f = failures.next();
			System.err.println(f.getMessage());
			//System.err.println(f.getTrace());
		}
		if(result.wasSuccessful() == true){
			/**127 : nombre magique afin de signaler que tout le tests sont passés */
            System.exit(127);
        }
	}

	public static class M7Q7Tests {
    
   		/**Variables de classe*/
		Random gen = new Random();
		M7Q7Stu M7Q7 = new M7Q7Stu();
		final int ITER = gen.nextInt(100)+3;
		
		@Test
		public void testCorrectness(){

			/**
			 * Le premier ticket devrait avoir le numéro 1
			 */
			Ticket tBefore = new Ticket();
			int bNum = tBefore.getNumero();
			Assert.assertTrue("Question 1 : \nLe premier ticket devrait avoir pour numéro 1 et pas"+bNum, bNum == 1);
			
			/**
			 * Les tickets doivent être 
			 * attribués séquenciellement
			 **/
			for(int i = 0; i < ITER; i++){
				Ticket tAfter = new Ticket();
				bNum = tBefore.getNumero();
				int aNum = tAfter.getNumero();
				Assert.assertTrue("Question 2 : \nLes numéros de ticket devraient"
						+ " être attribués séquentiellement : "+aNum+" ne suit pas "+bNum,
						aNum == bNum+1);
				tBefore = tAfter;
			}
		}
 	}
}