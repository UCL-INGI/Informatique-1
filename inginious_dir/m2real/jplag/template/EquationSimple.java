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
 * Ce programme calcule toutes les racines d'une equation diophantienne simple de type
 * a*x + b*y = c avec a,b,c et x,y sont des entiers strictement positifs. Ces equations
 * n'admettent des solutions que si le PGCD(a,b) est un diviseur de c
 * 
 * @author O. Bonaventure
 * @version Septembre 2011
 */
public class EquationSimple
{
    public static void main(String [] args)
    {

        int max;
        int a;
        int b;
        int c;
        int solutions=0;
	System.out.print("Entrez la valeur du coefficient a :");
        a=TextIO.getlnInt();

	System.out.print("Entrez la valeur du coefficient b :");
        b=TextIO.getlnInt();
        
	System.out.print("Entrez la valeur du coefficient c :");
        c=TextIO.getlnInt();

	System.out.print("Entrez la valeur maximale pour x et y :");
        max=TextIO.getlnInt();
       
        for(int x=1;x<max;x=x+1)
        {
            for(int y=1; y<max; y=y+1)
            {
                
                   if(a*x+b*y==c) 
                    {
                      System.out.print("X=");
                      System.out.print(x);
                      System.out.print(", Y=");
                      System.out.print(y);
                      solutions=solutions+1;
                    }
                    
                
            }
        }
        if(solutions==0)
        {
            System.out.println("Aucune solution trouvee");
        }
	else 
	{
	    System.out.print(solutions);
	    System.out.println(" solutions trouvees");
	}


    }
}
