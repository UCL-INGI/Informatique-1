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



public class Test
{
    public static void main (String[] args)
    {
        System.out.println ("\f");
        

        LibrairieImage.show (LibrairieImage.createCross (890));
        System.out.println ("La premiere fenetre presente une photo celebre d'Albert Einstein");
        LibrairieImage.show (LibrairieImage.imageGrayFromFile ("einstein.jpg"));
    }
}
