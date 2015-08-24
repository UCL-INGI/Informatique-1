/**
 *  Copyright (c) 2015 Sébastien Combéfis, Virginie Van den Schrieck
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
 * Un article de facture simple, comprenant un descriptif et un prix.
 * 
 * @author Charles Pecheur
 * @version 27 octobre 2012
 */
public class Article {

    private static final double TAUX_TVA = 0.21;   // TVA a 21%
    private String description;
    private double prix;
    
    /**
     * @pre  -
     * @post cree un article vide.  Utilise par les extensions
     *       qui n'utilisent pas {description} et {prix}.
     */
    public Article() {
    }
    
    /**
     * @pre  description != null && prix >= 0
     * @post cree un article avec {description} et {prix}.
     */
    public Article(String description, double prix) {
        assert prix >= 0 : "ERREUR prix < 0";
        assert description != null : "ERREUR description == null";        
        
        this.description = description;
        this.prix = prix;
    }
    
    /**
     * @pre  -
     * @post retourne la description de cet article.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @pre  -
     * @post retourne le prix (HTVA) de cet article.
     */
    public double getPrix() {
        return prix;
    }
    
    /**
     * @pre  -
     * @post retourne la TVA sur cet article.
     */
    public double getTVA() {
        return getPrix() * TAUX_TVA;
    }
 
    /**
     * @pre  -
     * @post retourne le prix TVAC de cet article.
     */
    public double getPrixTVAC() {
        return getPrix() + getTVA();
    }
    
    /**
     * @pre  -
     * @post retourne un texte decrivant cet article, au format:
     *       "{description}: {prix}".
     */
    public String toString() {
        return String.format("%s: %.2f", getDescription(), getPrix());
    }
}
