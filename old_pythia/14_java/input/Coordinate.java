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



// Coordinate.java

/**
 * Class representing a coordinate in the cartesian plane
 * 
 * @author Sebastien Combefis
 * @version 22 nov. 2008
 */
public class Coordinate
{
	// Instance variables
	private final double x, y;
	
	/**
	 * Constructor
	 * 
	 * @pre -
	 * @post An instance of this is created
	 *       This represents the (x, y) coordinate
	 */
	public Coordinate (double x, double y)
	{
		this . x = x;
		this.y = y;
	}
	
	/**
	 * Get the x-position of this coordinate
	 * 
	 * @pre -
	 * @post The returned value contains the x-coordinate of this coordinate
	 */
	public double getX()
	{
		return x;
	}

	/**
	 * Get the y-position of this coordinate
	 * 
	 * @pre -
	 * @post The returned value contains the y-coordinate of this coordinate
	 */
	public double getY()
	{
		return y;
	}
}
