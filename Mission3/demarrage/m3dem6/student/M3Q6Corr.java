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

/**
 * Un étudiant montre à son tuteur la méthode main ci-dessous :
 * 
 * public static void main(String[] args){
 * 	int hauteur;
 * 	int largeur;
 * 	char c = 'X';
 * 	System.out.println("Hauteur du L");
 * 	hauteur = TextIO.getInt();
 * 	System.out.println();
 * 	System.out.println("largeur du L ");
 * 	largeur = TextIO.getInt();
 * 	lettre_l(c, hauteur);
 * }
 * 
 * Lors de son exécution elle affiche les caractères suivants à l'écran:
 * 
 * java lettre L
 * hauteur de la lettre
 * 7
 * largeur de la lettre
 * 5
 * 
 * X
 * X 
 * X
 * X
 * X
 * X
 * XXXXX
 * 
 * Réécrivez la spécification la signature et le code de la
 * méthode lettre_l utilisée par cet étudiant.
 * 
 * @author clementine
 */
public class M3Q6Corr {

	/**
	 * @param c
	 * @param hauteur
	 * @param largeur
	 * @pre hauteur >= 0
	 * @pre largeur >=0
	 */

static void lettre_l(char c, int hauteur, int largeur){

		System.out.println("java lettre L");
		System.out.println("hauteur de la lettre");
		System.out.println(hauteur);
		System.out.println("largeur de la lettre");
		System.out.println(largeur);
		System.out.println();

		for(int i = 0; i != hauteur; i++){
			for(int j = 0; j != largeur; j++){
				if(i != (hauteur-1)){
					if(j != (0)){
						System.out.print(' ');
					}
					else{
						System.out.print(c);
					}
				}
				else{
					System.out.print(c);
				}

			}
			System.out.println();
		}

	}
}
