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
 * Une methode permettant de tester visuellement 
 * l'implementation de la methode lighten
 * 
 * @author O. Bonaventure
 * @version octobre 2012
 */
public class TestBrighten
{
    /**
     * @pre args peut contenir des noms de fichiers aux format .jpg ou .png
     * @post si args est vide, affiche une photo de Einstein et la meme
     *       photo eclaircie
     *       si args est non vide, affiche les images contenues dans 
     *       les fichiers aux formats .jpg et .png dont les noms sont fournis
     *       applique la methode brighten a chaque image et affiche l'image
     *       eclaircie
     *       en Bluej, une facon de calculer la version eclaircie de vos images
     *       est d'executer la methode main. Par exemple: {"image1.png", "image2.png"}.
     */
    
    public static void main (String[] args)
    {      
        if(args.length==0)
        {
            System.out.println("La premiere fenetre presente une photo celebre d'Albert Einstein");
            int[][] albert=LibrairieImage.imageGrayFromFile("einstein.jpg");
            LibrairieImage.show(albert);

			System.out.println("La deuxieme fenetre presente la version eclaircie calculee avec votre methode brighten");
			long start = System.currentTimeMillis();
            int[][] image2 = ImageGray.brighten(albert);
            long elapsed = System.currentTimeMillis() - start;
			if(image2!=null)
            {
	 			LibrairieImage.show(image2);
				System.out.println("Votre methode brighten a pris "+elapsed+" millisecondes pour s'executer");
			}
            else
            {
                System.out.println("Votre methode brighten retourn null!");
            }			

            //System.out.println("La troisieme fenetre presente la version que vous devez obtenir");
            //int[][] albert2=LibrairieImage.imageGrayFromFile("einstein-bright.jpg");
            //LibrairieImage.show(albert2);
        }
        else
        {
            for(String fileName : args)
            {
                int[][] image=LibrairieImage.imageGrayFromFile(fileName);
                long start = System.currentTimeMillis();
                int[][] image2=ImageGray.brighten(image);
                long elapsed = System.currentTimeMillis() - start;
                if(image2!=null)
                {
                    System.out.println("Voici votre image (fichier : "+fileName+" ) originale");
                    LibrairieImage.show(image);
                    System.out.println("Voici l'image eclaircie");
                    LibrairieImage.show(image2);
                    System.out.println("Votre methode brighten a pris "+elapsed+" millisecondes pour s'executer");
                }
                else
                {
                    System.out.println("Votre methode brighten retourn null!");
                }
            }
        }   
    }   

}
