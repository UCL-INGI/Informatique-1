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



import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public final class TestItem
{
	private static final String[] authors = {"James", "Charly", "Sofia", "Kenneth", "Georges", "Marie-Isabelle", "Mark"};
	private static final String[] titles = {"How to code with Java?", "Good writing", "QR Codes are everywhere!", "The fourth dimension", "How to fly a Boeing?"};
	
	public static void main (String[] args)
	{
		try
		{
			PrintWriter writer = new PrintWriter ("resultat-q1.txt", "UTF-8");
			
			// Testing toString
			String author = authors[(int) (Math.random() * authors.length)];
			String title = titles[(int) (Math.random() * titles.length)];
			int serial = (int) (Math.random() * 100000);
			Item i1 = new Item (author, title, serial);
			String s1 = i1.toString();
			if (String.format ("[%d] %s, %s", serial, author, title).equals (s1))
			{
				writer.println ("success");
			}
			else
			{
				writer.println (String.format ("failed:%s,%s,%s:%s", String.valueOf (serial), author, title, s1));
			}
			
			writer.close();
		}
		catch (java.io.FileNotFoundException fne) {}
		catch (java.io.UnsupportedEncodingException use) {}
	}
}