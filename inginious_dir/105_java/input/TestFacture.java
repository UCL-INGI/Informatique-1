/**
 *  Copyright (c) 2015, 2016 Sébastien Combéfis, Virginie Van den Schrieck
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
 * Classe de test pour la classe Facture
 * 
 * @author Charles Pecheur
 * @version 27 octobre 2012
 */
public class TestFacture {

	static Piece[] pieces = {
		new Piece("disque dur 350 Gb", 49.99, 0.355, true, false),
		new Piece("souris bluetooth", 15.99, 0.176, false, false),
		new Piece("adaptateur DVI - VGA", 12.00),
		new Piece("Java in a Nutshell", 24.00, 0.321, false, true),
	};

    static Article[] articles = {
        new Article("laptop 15\" 4Gb", 4.50),
        new Article("stage LaTeX", 12.0),
        new Article("installation wifi", 45.22),
        new Article("carte graphique", 119.49),
        /**/new ArticlePiece(1,pieces[0]),
        new ArticlePiece(3,pieces[1]),
        new ArticleReparation(0.75),
        new ArticlePiece(5,pieces[2]),
        new ArticlePiece(2,pieces[3]),
        new ArticlePiece(5,pieces[1]),
    };
    
    public static void main(String[] args) {
        Facture fac = new Facture("PC store 22 octobre", articles);
        fac.printFacture();
        /**/fac.printLivraison();
        /**/for (int i = 0; i < pieces.length; i++) {
        	int n = fac.getNombre(pieces[i]);
        	System.out.printf("  %3d * %s\n", n, pieces[i].getDescription());
        }
    }
    
}
