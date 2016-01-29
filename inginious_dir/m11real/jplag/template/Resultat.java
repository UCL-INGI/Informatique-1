/**
 *  Copyright (c) 2015, 2016 Bastien Bodart, François Michel, Clémentine Munyabarenzi
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



/**
 * Un r�sultat d'un Coureur sur une course cycliste: le coureur, son temps et son nombre
 * de points.
 * 
 * @author Benoit Donnet et Charles Pecheur, UCLouvain
 * @version Septembre 2013
 */
public class Resultat {

	// le coureur
	private Coureur coureur;
	
	// le temps effectu�
	private Temps temps;
	
	/**
	 * Cr�e un Resultat.
	 * 
	 * @pre c != null, t != null
	 * @post cr�e un r�sultat de temps {t} pour le coureur {c}.
	 */
	public Resultat(Coureur c, Temps t) {
		this.coureur = c;
		this.temps = t;
	}

	/**
	 * @pre -
	 * @post retourne le coureur.
	 */
	public Coureur getCoureur() {
		return this.coureur;
	}

	/**
	 * @pre -
	 * @post retourne le temps.
	 */
	public Temps getTemps() {
		return this.temps;
	}

	/**
	 * @pre other != null
	 * @post compare {this} et {other}, sur base du temps.
	 */
	public int compareTo(Resultat other) {
		return this.temps.compareTo(other.temps);
	}
	
	/**
	 * @pre -
	 * @post retourne ce Resultat sous forme de texte.
	 * 
	 * Exemple: "Alfred: 1:23:45"
	 */
	public String toString() {
		return String.format("%30s : %s", coureur.getNom(), temps);
	}

}