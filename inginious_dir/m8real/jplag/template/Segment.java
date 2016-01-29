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
 * Une classe permettant de repr�senter un segment de droite
 * 
 * @author O. Bonaventure, Ch. Pecheur
 * @version 3 Nov 2012
 */

import java.awt.Color;
import java.awt.Graphics;

public class Segment
{
   private int x0,y0; // coordonees de la premiere extremite
   private int x1,y1; // coordonnees de la seconde extremite

   /**
     * @pre x0,y0,x1,y1 >=0 et <512
     * @post a construit un segment de droite reliant x0,y0 a x1,y1
     */
    public Segment(int x0, int y0, int x1, int y1)
    {
        this.x0=x0;
        this.y0=y0;
        this.x1=x1;
        this.y1=y1;
    }
    
    // voir interface Shape
    public void draw(Graphics g)
    {
        // affichage du segment de droite
        g.drawLine(x0,y0,x1,y1);
    }

    // A COMPLETER
}
