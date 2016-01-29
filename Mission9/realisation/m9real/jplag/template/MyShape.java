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



import java.awt.Graphics;
import java.awt.Color;

/**
 * Un exemple de figure
 * 
 * @author Charles Pecheur
 * @version 3 Nov 2012
 */
public class MyShape 
{

    private int n;  // nombre d'intervalles à dessiner

    /**
     * @pre  ---
     * @post cree un {@code MyShape} de 10 intervalles
     */
    public MyShape() {
        this(10);
    }
    
    /**
     * @pre  {@code n > 0}
     * @post cree un {@code MyShape} de {@code n} intervalles
     */
    public MyShape(int n) {
        this.n = n;
    }
    
    /**
     * @pre  {@code g} est initialise
     * @post dessine cette figure sur {@code g}. 
     */
    public void draw(Graphics g) {
        for (int i = 0; i <= n; i++) {

            Segment seg1 = new Segment(20, 20, 20 + (480 * i / n), 400);
            g.setColor(Color.RED);
            seg1.draw(g);

            Segment seg2 = new Segment(500, 20, 20 + (480 * i / n), 400);
            g.setColor(Color.BLUE);
            seg2.draw(g);
        }        
    }

    // A COMPLETER
    
    public static void main (String args[])
    {
        // Une fois définie l'interface Shape, la ligne [1] par la ligne [2]
        Shape shape = new Shape(30);        // [1]  
        //Shape shape = new MyShape(30);      // [2]
        DrawPanel panel = new DrawPanel(shape);         
    }

}
