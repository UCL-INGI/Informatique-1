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



// State.java

/**
 * Represents the state of the turtle
 * 
 * @author Sebastien Combefis
 * @version 22 nov. 2008
 */
public class State
{
	// Instance variables
	private final Coordinate coord;
	private final double dir;

	/**
	 * Constructor
	 * 
	 * @pre  --
	 * @post An instance of this is created
	 *       representing the state with (x, y) as position
	 *       and with dir as direction in degrees, measured with respect to the horizontal, anticlockwise
	 */
	public State (double x, double y, double dir)
	{
		//assert dir > 0;  BOGUS!?
		
		dir = (dir + 180.0) % 360.0 - 180.0;  // reduce to [-180, +180[
		
		coord = new Coordinate (x, y);
		this.dir = dir;
	}

	/**
	 * Get the direction of this turtle
	 * 
	 * @pre -
	 * @post The returned value contains the direction of this turtle's state
	 */
	public double getDir()
	{
		return dir;
	}
	
	/**
	 * Get the position of this turtle
	 * 
	 * @pre -
	 * @post The returned value contains the position of this turtle's state
	 */
	public Coordinate getCoord()
	{
		return coord;
	}
}
