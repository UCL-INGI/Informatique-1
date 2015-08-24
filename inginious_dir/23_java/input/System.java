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



public final class System
{
	public static final StdOutErr out = new StdOutErr();
	public static final StdOutErr err = new StdOutErr();
	
	public static void exit (int status)
	{
		throw new ComputationException ("exit|" + status);
	}
	
	public static class StdOutErr
	{
		public void print (String str){}
		public void println (String str){}
	}
}