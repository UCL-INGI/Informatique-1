/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
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



package student;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
/** for deprecation */
//import junit.framework.Assert;
import org.junit.Assert;

import java.util.Random;
import java.lang.Math;

public class M3Q8Tests {

	
	/**Class variables*/
	
	Random gen = new Random();

	/**
     * Vérifie que la méthode  de l' étudiant contenue
     * dans la classe "<code exercice>Stu" renvoie bien
     * la valeur qu'il faut. La comparaison est faite 
     * avec le code fourni en corrigé dans la classe 
     * "<code exercice>Corr". Les valeurs de test sont
     * choisies de façon aléatoire.
     */
	@Test
	public void testSuccessNDIV() {
		
		int n = 0;
		while(n == 0){
			n = Math.abs(gen.nextInt(500));
		}
		int s = M3Q8Stu.nDiv(n);
		int r = M3Q8Corr.nDiv(n);
		assertEquals("Votre réponse est différente de la réponse correcte",s,r);		
	}
}
