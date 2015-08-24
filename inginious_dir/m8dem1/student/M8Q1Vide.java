/**
 *  Copyright (c) 2015 François Michel, Clémentine Munyabarenzi
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

public class M8Q1Stu{
	public static class Drapeau{
		private boolean drapeau; // la valeur du drapeau

		// Constructeurs
		/**
		 * @pre : -
		 * @post : un objet de type Drapeau est créé et représente le
		 *         drapeau 'false' 
		 */
		public Drapeau()
		{
			drapeau=false;
		}

		/**
		 * @pre : -
		 * @post : un objet de type Drapeau est créé et représente le booleen
		 *         passé en argument
		 */
		public Drapeau(boolean drapeau)
		{
			this.drapeau=drapeau;
		}

		/**
		 * @pre : -
		 * @post : un objet de type Drapeau est créé. Si l'argument est 'V' ou 'v',
		 *         il représente le drapeau true. Sinon il 
		 *         représente le drapeau false 
		 */
		public Drapeau(char c)
		{
			drapeau = (c == 'V' || c == 'v'); 
		}

		public void set(boolean drapeau)
		{
@			@q1@@
		}

		public void set(char c)
		{
@			@q2@@
 		}

		public boolean toBoolean()
		{
			return drapeau;
		}

	}

	public static interface DrapeauIF
	{
		/**
		 * @pre : -
		 * @post : le drapeau prend la valeur passée en  argument 
		 */
		public void set(boolean drapeau)  ;

		/**
		 * @pre : -
		 * @post : Si l'argument est 'V' ou 'v', le drapeau prend la
		 *         valeur vrai et faux sinon
		 */
		public void set(char c);


		/**
		 * @pre : -
		 * @post : retourne le drapeau sous forme d'un booléen
		 */
		public boolean toBoolean();
	}
}
