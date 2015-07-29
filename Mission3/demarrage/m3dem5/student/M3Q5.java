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

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


/**
 * La méthode main de cette classe exécute les tests
 * et imprime les tests qui ont échoué sur la sortie
 * d'erreurs. Le nombre magique 127 est retourné
 * lorque les tests se sont déroulés comme prévu.
 */
public class M3Q5 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M3Q5TestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.getMessage());
		}
		if(result.wasSuccessful()){
        	System.exit(127);
        }
	}
}

