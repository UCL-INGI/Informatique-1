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
 * Classe de test initiale pour la classe Facture
 * 
 * @author Charles Pecheur
 * @version 27 octobre 2012
 */
public class TestFactureInitial {

    static Article[] articles = {
        new Article("laptop 15\" 4Gb", 4.50),
        new Article("stage LaTeX", 12.0),
        new Article("installation wifi", 45.22),
        new Article("carte graphique", 119.49),
        new ArticleReparation(3.5),
        new ArticlePiece(3,new Piece("ventirads", 39.45))
    };
    
    public static void main(String[] args) {
        Facture fac = new Facture("PC store 22 octobre", articles);
        fac.printFacture();
    }
    
}
