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
 * Classe simple contenant quelques methodes utilisant la methode subtract
 * de la classe ImageGray
 * 
 * @author O. Bonaventure
 * @version Octobre 2012
 */
public class TestSubtract
{
    /**
     * @pre -
     * @post effectue un test de la methode subtract en utilisant des images
     *       simples en noir et blanc. Affiche le temps d'execution du test
     */
    public static void main(String[] args)
    {
        int[][] image=LibrairieImage.createGrid(600,10);
        int[][] background=LibrairieImage.createLines(600,10);        

        System.out.println("Voici les deux images utilisees par ce test");
        LibrairieImage.show(image);
        LibrairieImage.show(background);
        long start = System.currentTimeMillis();
        int[][] result=ImageGray.subtract(image,background,0);
        if(result!=null)
        {
            long elapsed = System.currentTimeMillis() - start;
            System.out.println("Votre methode subtract a retourne l'image suivante et a pris "+elapsed+" millisecondes pour s'executer");
            LibrairieImage.show(result);
        }
        else
        {
           System.out.println("Votre methode subtract a retourne null !");
        }
    }
}
