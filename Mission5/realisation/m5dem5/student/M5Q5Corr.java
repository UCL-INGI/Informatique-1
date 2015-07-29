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

import java.util.Arrays;

public class M5Q5Corr {
	
	static double[] t1 = {1.0, 2.0, -3.0};
	static double[] t2 = {1.0, 3.0, 9.0 };
	
    /**
     * Modifie l'environnement de sorte que t1 == t2 renvoie true
     */
	public static void equalequalSucceeds(){
			t2 = t1;
	}
	
   	/**
     * @pre t1 et t2 != null
     * @return true si t1 et t2 contiennent les memes valeurs, false sinon.
     */
	public static boolean egal(double[] t1, double[] t2) {
		return Arrays.equals(t1, t2);
	}
}
