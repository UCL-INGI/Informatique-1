/**
 *  Copyright (c) 2015, 2016 Bastien Bodart, Fran√ßois Michel, Cl√©mentine Munyabarenzi
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
 * Un temps réalisé par un Coureur, sous forme de trois nombres: heures,
 * minutes, secondes. Un temps est valide si et seulement si les minutes et les
 * secondes sont comprises entre 0 et 59.
 * 
 * @author Benoit Donnet et Charles Pecheur, UCLouvain
 * @version Septembre 2013
 */
public class Temps implements Comparable {

	// Le nombre d'heures.
	private int heures;

	// Le nombre de minutes, entre 0 et 59.
	private int minutes;

	// Le nombre de secondes, entre 0 et 59.
	private int secondes;

	/**
	 * Normalise les données de ce temps pour obtenir un temps valide. Convertit
	 * 60 secondes en 1 minute et 60 minutes en 1 heure si nécessaire pour
	 * ramener les minutes et les secondes entre 0 et 59.
	 * 
	 * @pre -
	 * @post Le temps global résultant est inchangé, ce Temps est valide.
	 * 
	 *       Par exemple, 100:200:300 devient 103:25:00.
	 */
	private void normalise() {
		minutes = minutes + secondes / 60;
		secondes = secondes % 60;
		heures = heures + minutes / 60;
		minutes = minutes % 60;
	}

	/**
	 * Construit un nouveau temps.
	 * 
	 * @pre h >= 0, m >= 0, s >= 0
	 * @post crée un temps de {h} heures, {m} minutes et {s} secondes, normalisé
	 *       pour obtenir un temps valide.
	 */
	public Temps(int h, int m, int s) {
		this.secondes = s;
		this.minutes = m;
		this.heures = h;

		normalise();
	}

	/**
	 * @pre -
	 * @post retourne le nombre d'heures.
	 */
	public int getH() {
		return this.heures;
	}

	/**
	 * @pre -
	 * @post retourne le nombre de minutes.
	 */
	public int getM() {
		return this.minutes;
	}

	/**
	 * @pre -
	 * @post retourne le nombre de secondes.
	 */
	public int getS() {
		return this.secondes;
	}

	/**
	 * @pre -
	 * @post retourne le temps total en secondes.
	 */
	public int secondes() {
		return (this.heures * 60 + this.minutes) * 60 + this.secondes;
	}

	/**
	 * @pre -
	 * @post retourne ce Temps courant sous la forme de texte. Par exemple,
	 *       "05:02:10" pour 5 heures, 2 minutes et 10 secondes.
	 */
	public String toString() {
		return String.format("%02d:%02d:%02d", heures, minutes, secondes);
	}

	/**
	 * @pre -
	 * @post retourne un nombre positif/nul/négatif si ce Temps est plus
	 *       grand/égal/plus petit au temps {o}. Lance une
	 *       {IllegalArgumentException} si {o} n'est pas un temps ou est nul.
	 */
	public int compareTo(Object o) {
		if (o == null) {
			throw new IllegalArgumentException("comparaison à null");
		} else if (o == this) {
			return 0;
		} else if (o instanceof Temps) {
			Temps t = (Temps) o;
			return this.secondes() - t.secondes();
		} else {
			throw new IllegalArgumentException("comparaison illégale");
		}
	}
	
	/**
	 * @pre -
	 * @post retourne {true} ssi {o} est un Temps égal à ce temps.
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Temps)) { return false; }
		Temps t = (Temps) o;
		return this.secondes() == t.secondes();
	}
	/**
	 * @pre -
	 * @post le Temps {t} a été ajouté à ce Temps.
	 */
	public void ajout(Temps t) {
		this.secondes += t.secondes;
		this.minutes += t.minutes;
		this.heures += t.heures;
		normalise();
	}
}
