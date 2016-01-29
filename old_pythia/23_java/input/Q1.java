/**
 *  Copyright (c) 2015, 2016 Sébastien Combéfis, Virginie Van den Schrieck
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



import lib.pythia.TestSuite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class Q1 extends TestSuite
{
	public Q1()
	{
		super ("q1", new Object[][] {{"input/nonexisting.txt"}, {"input/empty.txt"}, {"input/novalidline.txt"}, {"input/normal.txt"}});
	}
	
	private static double getMax (String filename)
	{
@		@q1@@
	}
	
	public Object studentCode (Object[] data)
	{
		try
		{
			return getMax ((String) data[0]);
		}
		catch (ComputationException exception)
		{
			return "exception|C";
		}
		catch (NumberFormatException exception)
		{
			return "exception|NF";
		}
	}
	
	public Object[] parseTestdata (String[] data)
	{
		return new Object[] {data[0]};
	}
	
	public static void main (String[] args)
	{
		new Q1().run();
	}
}