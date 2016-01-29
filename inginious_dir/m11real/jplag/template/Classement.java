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
 * Une liste de r�sultats ordonn�s (selon {compareTo}), repr�sentant le
 * classement d'une course cycliste.  
 * 
 * @author Benoit Donnet et Charles Pecheur, UCLouvain
 * @version Septembre 2013
 */
public interface Classement {

	/**
	 * Ajoute un r�sultat dans le classement.
	 * 
	 * @pre r != null
	 * @post le r�sultat {r} a �t� ins�r� selon l'ordre du classement. En cas
	 *       d'ex-aequo, {r} est ins�r� apr�s les autres r�sultats de m�me
	 *       ordre.
	 */
	public void add(Resultat r);

	/**
	 * Retire un r�sultat du classement.
	 * 
	 * @pre c != null
	 * @post retire le premier (meilleur) r�sultat pour le coureur {c} du classement. {c}
	 *       est compar� au sens de {equals}. Retourne {true} si un r�sultat a �t� retir�,
	 *       {false} si {c} n'est pas trouv� dans la liste.
	 */
	public boolean remove(Coureur c);

	/**
	 * Taille du classement.
	 * 
	 * @pre -
	 * @post retourne le nombre de r�sultats dans le classement.
	 */
	public int size();

	/**
	 * Le r�sultat d'un coureur.
	 * 
	 * @pre c != null
	 * @post retourne le premier (meilleur) r�sultat du coureur {c} dans le
	 *       classement. Retourne {null} si le coureur ne figure pas dans le
	 *       classement.
	 */
	public Resultat get(Coureur c);
	
	/**
	 * La position d'un coureur dans le classement.
	 * 
	 * @pre c != null
	 * @post retourne la position du coureur {c} dans le classement, � partir de
	 *       1 pour la t�te de classement. Si le coureur figure plusieurs fois
	 *       dans le classement, la premi�re (meilleure) position est retourn�e.
	 *       Retourne -1 si le coureur ne figure pas dans le classement.
	 */
	public int getPosition(Coureur c);

	/**
	 * Le classement sous forme de texte.
	 * 
	 * @pre -
	 * @post retourne le classement sous forme de texte, avec une ligne par
	 *       r�sultat.
	 */
	public String toString();
}
