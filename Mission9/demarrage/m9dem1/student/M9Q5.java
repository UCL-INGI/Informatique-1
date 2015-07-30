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
/**
 *  @author François MICHEL
 */

import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;
import java.util.Random;
import org.junit.runner.notification.Failure;
import java.io.*;

public class M9Q5 {

	@Test
	public void testCompareTo() {
		String str = "Votre code semble comporter des erreurs : ";
		try {
			Random r = new Random();
			int exp, res, a, b;
			M9Q5Stu a_m;
			for (int i = 0; i < 50000; i++) {
				a = r.nextInt(100000);
				a_m = new M9Q5Stu(a);
				b = r.nextInt(100000);
				res = a_m.compareTo((Object) b);
				if (a > b) {
					assertTrue(str + a + " est plus grand que " + b + ", or, votre méthode retourne " + res + " au lieu d'une valeur strictement positive. ", res > 0);
				} else if (a == b) {
					assertTrue(str + a + " est égal à " + b + ", or, votre méthode retourne " + res + " au lieu de 0. ", res == 0);
				} else {
					assertTrue(str + a + " est plus petit que " + b + ", or, votre méthode retourne " + res + " au lieu d'une valeur strictement négative. ", res < 0);
				}
				res = a_m.compareTo((Object) (-b));
				if (a > -b) {
					assertTrue(str + a + " est plus grand que " + -b + ", or, votre méthode retourne " + res + " au lieu d'une valeur strictement positive. ", res > 0);
				} else if (a == -b) {
					assertTrue(str + a + " est égal à " + -b + ", or, votre méthode retourne " + res + " au lieu de 0. ", res == 0);
				} else {
					assertTrue(str + a + " est plus petit que " + -b + ", or, votre méthode retourne " + res + " au lieu d'une valeur strictement négative. ", res < 0);
				}
				res = a_m.compareTo((Object) a);
				assertTrue(str + a + " est égal à " + a + ", or, votre méthode retourne " + res + " au lieu de 0. ", res == 0);
			}
		} catch (ArithmeticException e) {
			fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
			e.printStackTrace();
		} catch (ClassCastException e) {
			fail(str + "Attention, certaines variables ont été mal castées	!");
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
			e.printStackTrace();
		} catch (NullPointerException e) {
			fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
			e.printStackTrace();
		} catch (Exception e) {
			fail(str + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(M9Q5.class);
		for (Failure failure: result.getFailures()) {
			System.err.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
