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

public class M5Q6Corr {
	
	/**
	 * @pre n>0
	 * @post retourne la matrice unité d'ordre n, c'est-à-dire la matrice
	 *       carrée de n lignes/colonnes dont les éléments de la diagonale 
	 *       principale valent 1 et tous les autres valent 0
	 */
	public static int[][] unite(int n){
		
		assert n>0;
		int[][] m=new int[n][n];
		// la matrice est intialisée à 0
		for(int i = 0;i < n; i++)
		{
		   m[i][i]=1;
		}
		return m;
	}

}
