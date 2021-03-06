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

public class M3Q8Corr {

	/**
	 * @pre n > 0
	 * @post retourne le nombre de diviseurs entiers du nombre entier n.
	 */
	public static int nDiv(int n){

		int divisorCount = 0;
		for(int testDivisor = 1; testDivisor <= n; testDivisor++) {
			if ( n % testDivisor == 0 )
				divisorCount++;
		}
		return divisorCount;
	}

}
