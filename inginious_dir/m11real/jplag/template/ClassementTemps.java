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
 * Une implémentation primitive de classement, non ordonnée et de capacité fixe.
 * 
 * @author Charles Pecheur
 * @version septembre 2013
 */
public class ClassementTemps implements Classement {

    private static final int CAPACITY = 10;

    private Resultat[] liste; // contenu de la liste
    private int size; // nombre de résultats

    public ClassementTemps() {
        liste = new Resultat[CAPACITY];
    }

    /** @see Classement#add */
    public void add(Resultat r) {
        // insère en fin de liste, pas ordonné
        liste[size] = r; // exception si size >= CAPACITY
        size++;
    }

    /** @see Classement#get */
    public Resultat get(Coureur c) {
        for (int i = 0; i < size; i++) {
            if (liste[i].getCoureur().equals(c)) {
                return liste[i];
            }
        }
        return null;
    }

    /** @see Classement#getPosition */
    public int getPosition(Coureur c) {
        // liste non triée
        for (int i = 0; i < size; i++) {
            if (liste[i].getCoureur().equals(c)) {
                return i + 1;
            }
        }
        return -1;
    }

    /** @see Classement#remove */
    public boolean remove(Coureur c) {
        int i = 0;
        while (i < size && !liste[i].getCoureur().equals(c)) {
            i++;
        }

        if (i >= size) {
            // pas trouvé le coureur
            return false;
        }

        // coureur en liste[i]
        for (int j = i+1; j < size; j++) {
            liste[j-1] = liste[j];

        }
        size--;
        return true;
    }

    /** @see Classement#size */
    public int size() {
        return size;
    }

    /** @see Classement#toString */
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i=0; i < size; i++) {
            buf.append(liste[i]);
            buf.append("\n");
        }
        return buf.toString();
    }
}
