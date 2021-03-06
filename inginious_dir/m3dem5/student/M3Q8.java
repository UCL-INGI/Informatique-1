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

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class M3Q8 {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(M3Q8TestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.err.println(failure.getMessage());
		}
		if(result.wasSuccessful() == true){
            System.exit(127);//127 : nombre magique pour signaler que tout est passé
        }
	}

}

