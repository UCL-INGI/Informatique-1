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



import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import java.lang.reflect.Constructor;

public final class TestCD
{
	private static final String[] authors = {"James", "Jonas", "Lucia", "Marvin", "Tony", "Veronic", "Georges"};
	private static final String[] titles = {"Glorious", "Where is my son?", "You're so beautiful!", "Here comes the rain... again", "Fried or fired?"};
	public static void main (String[] args)
	{
		try
		{
			PrintWriter writer = new PrintWriter ("resultat-q2.txt", "UTF-8");
			
			// Testing if Constructor well defined
			try
			{
				Class<CD> cdClass = (Class<CD>) Class.forName ("CD");
				Constructor<CD> constructor = cdClass.getDeclaredConstructor (String.class, String.class, int.class);
				writer.println ("success");
				
				// Testing toString
				try
				{
					String author = authors[(int) (Math.random() * authors.length)];
					String title = titles[(int) (Math.random() * titles.length)];
					int duration = (int) (Math.random() * 3000);
					CD cd1 = constructor.newInstance (author, title, duration);
					String s1 = cd1.toString();
					if (String.format ("[100001] %s, %s (%d s)", author, title, duration).equals (s1))
					{
						writer.println ("success");
					}
					else
					{
						writer.println (String.format ("failed:%s,%s,%s:%s", String.valueOf (duration), author, title, s1));
					}
					
					// Testing serial ID
					int loop = (int) (Math.random() * 100) + 1;
					for (int i = 0; i < loop; i++)
					{
						constructor.newInstance ("", "", 0);
					}
					author = authors[(int) (Math.random() * authors.length)];
					title = titles[(int) (Math.random() * titles.length)];
					duration = (int) (Math.random() * 3000);
					CD cd2 = constructor.newInstance (author, title, duration);
					String s2 = cd2.toString();
					if (String.format ("[%d] %s, %s (%d s)", 100002 + loop, author, title, duration).equals (s2))
					{
						writer.println ("success");
					}
					else
					{
						writer.println (String.format ("failed:%s,%s,%s,%s:%s", loop, String.valueOf (duration), author, title, s2));
					}
				}
				catch (Exception exception)
				{
					writer.println ("failure");
				}
			}
			catch (ClassNotFoundException exception)
			{
				writer.println ("failure");
			}
			catch (NoSuchMethodException exception)
			{
				writer.println ("failure");
			}
			
			writer.close();
		}
		catch (java.io.FileNotFoundException fne) {}
		catch (java.io.UnsupportedEncodingException use) {}
	}
}