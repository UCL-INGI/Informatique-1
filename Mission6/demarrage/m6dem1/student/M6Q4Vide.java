/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
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

public class M6Q4Stu{
	public static class Pair{
		private int a;	// le premier élément de la paire
		private int b;	// le second élément de la paire
		
		/**
		 * 	@pre 	-
		 * 	@post	crée une paire avec a et b non-initialisés
		 */
		 public Pair(){
			 
		 }
		 
		/**
		 * @pre	-
		 * @post	crée une paire composée de x et y
		 */
		 public Pair(int x, int y){
			a = x;
			b = y;
		 }
		 
		/**
		 * @pre	-
		 * @post	donne au premier élément de la paire la valeur nA
		 */
		 public void setA(int nA){
			a = nA;
		 }
		
		/**
		 * @pre	-
		 * @post	donne au second élément de la paire la valeur nB
		 */
		 public void setB(int nB){
			b = nB;
		 }
		 
		/**
		 * @pre 	-
		 * @post	retourne le premier élément de la paire
		 */
		 public int getA(){
			return a;
		 }
		 
		/**
		 * @pre	-
		 * @post	retourne le second élément de la paire
		 */
		 public int getB(){
			return b;
		 }
			
			
		/**
		 * @pre		-
		 * @post	retourne une nouvelle instance de Pair dont les deux
		 * 			éléments sont les opposés de ceux de cette paire-ci 
		 */	
		 public Pair opposite(){
@			@q1@@
		 }
		 
		 public boolean equals(Object o){
			 if(o instanceof Pair){
				 return (((Pair) o).getA() == a) && (((Pair) o).getB() == b);
			 }
			 return false;
		 }
	}
}
