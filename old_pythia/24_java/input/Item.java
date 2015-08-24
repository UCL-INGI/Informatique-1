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



public class Item
{
	private final String author, title;
	private final int serial;

	/**
	 * Constructeur
	 * @pre author != null , title != null , serial > 0
	 * @post Une instance de la classe est créée, et représente un objet ayant comme
	 *       auteur author, comme titre title et comme numéro de série serial
	 */
	public Item (String author, String title, int serial)
	{
		this.author = author; this.title = title; this.serial = serial;
	}
	
	/**
	 * @pre -
	 * @post La valeur renvoyée contient une représentation de cet objet
	 *       sous la forme : [num série] Auteur, Titre
	 */
	public String toString()
	{
@		@q1@@
	}
}