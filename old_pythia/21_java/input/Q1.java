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

public final class Q1 extends TestSuite
{
	public Q1()
	{
		super ("q1", new Object[][] {{new int[0]}, {new int[] {1}}, {new int[] {2, 3}}, {new int[] {4, 5, 6}}});
	}
	
	private static void rotateRightOne (int[] tab)
	{
@		@q1@@
	}
	
	private static void rotateRight (int[] tab, int n)
	{
@		@q2@@
	}
	
	public Object studentCode (Object[] data)
	{
		int[] tab = (int[]) data[0];
		try
		{
			rotateRightOne (tab);
			return tab;
		}
		catch (ArrayIndexOutOfBoundsException exception)
		{
			return "exception|OOB";
		}
	}
	
	public Object[] parseTestdata (String[] data)
	{
		String[] tokens = data[0].substring (1, data[0].length() - 1).split (",");
		int[] tab = new int[tokens.length];
		for (int i = 0; i < tab.length; i++)
		{
			tab[i] = Integer.parseInt (tokens[i].trim());
		}
		return new Object[] {tab};
	}
	
	public static void main (String[] args)
	{
		new Q1().run();
	}
}