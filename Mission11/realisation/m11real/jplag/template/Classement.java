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
 * Une liste de résultats ordonnés (selon {compareTo}), représentant le
 * classement d'une course cycliste.  
 * 
 * @author Benoit Donnet et Charles Pecheur, UCLouvain
 * @version Septembre 2013
 */
public interface Classement {

	/**
	 * Ajoute un résultat dans le classement.
	 * 
	 * @pre r != null
	 * @post le résultat {r} a été inséré selon l'ordre du classement. En cas
	 *       d'ex-aequo, {r} est inséré après les autres résultats de même
	 *       ordre.
	 */
	public void add(Resultat r);

	/**
	 * Retire un résultat du classement.
	 * 
	 * @pre c != null
	 * @post retire le premier (meilleur) résultat pour le coureur {c} du classement. {c}
	 *       est comparé au sens de {equals}. Retourne {true} si un résultat a été retiré,
	 *       {false} si {c} n'est pas trouvé dans la liste.
	 */
	public boolean remove(Coureur c);

	/**
	 * Taille du classement.
	 * 
	 * @pre -
	 * @post retourne le nombre de résultats dans le classement.
	 */
	public int size();

	/**
	 * Le résultat d'un coureur.
	 * 
	 * @pre c != null
	 * @post retourne le premier (meilleur) résultat du coureur {c} dans le
	 *       classement. Retourne {null} si le coureur ne figure pas dans le
	 *       classement.
	 */
	public Resultat get(Coureur c);
	
	/**
	 * La position d'un coureur dans le classement.
	 * 
	 * @pre c != null
	 * @post retourne la position du coureur {c} dans le classement, à partir de
	 *       1 pour la tête de classement. Si le coureur figure plusieurs fois
	 *       dans le classement, la première (meilleure) position est retournée.
	 *       Retourne -1 si le coureur ne figure pas dans le classement.
	 */
	public int getPosition(Coureur c);

	/**
	 * Le classement sous forme de texte.
	 * 
	 * @pre -
	 * @post retourne le classement sous forme de texte, avec une ligne par
	 *       résultat.
	 */
	public String toString();
}
