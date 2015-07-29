/**
 *  Copyright (c) 2015 Olivier Bonaventure, François Michel, Clémentine Munyabarenzi
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */



package student;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.util.Random;
import java.lang.Math;

/**
 * Cette classe vérifie que les méthodes de l'étudiant
 * contenues  dans  la  classe "<code exercice>Stu" 
 * effectuent  bien  l ' opération  qu ' il  faut.
 * Les valeurs de test en dehors des tests de cas 
 * particuliers sont choisies de façon aléatoire.
 *
 * Il  est  important  que  chaque  message  d' erreur comporte
 * le format indiqué pour la question:"Question <num> :\n ...".
 * Seul le premier message d' erreur sera indiqué aux étudiants.
 */
public class M5Q1Tests extends junit.framework.TestCase{

	
	/**Class variables*/
	Random gen = new Random();
	int l = gen.nextInt(9)+1;
	int k = gen.nextInt(9)+1;
	
	@Test
	public void testArrayDeclaration() {
		int n = gen.nextInt(10);
        int[] v = null;
        try{
		 v = M5Q1Stu.createIntArray(n);
        }
        catch(Throwable e){
        	fail("Question 1 :\n Attention, vous effectuez une opération illégale dans votre code: "+e.toString());
        }
        try{
		assertEquals("Question 1 :\n "+"Le tableau devrait pouvoir contenir "+n+" entiers", n, v.length);
        }
        catch(Throwable e){
        	if(e instanceof NullPointerException){
	        	fail("Question 1 :\n La valeur que vous renvoyez n'est pas un tableau valide: "+e.toString());
            }else{
            	throw e;
            }
        }
	}
	
	@Test
	public void testMatrixDeclaration(){
    	double[][] m = null;
        try{
			m = M5Q1Stu.createDoubleMatrix(l, k);
        }
        catch(Throwable e){
        	fail("Question 2 :\n Attention, vous effectuez une opération illégale dans votre code: "+e.toString());
        }
        try{
		assertEquals("Question 2 :\n "+"La matrice devrait avoir "+l+" lignes", l, m.length);
        }
        catch(Throwable e){
        	if(e instanceof NullPointerException){
	        	fail("Question 2 :\n La valeur que vous renvoyez n'est pas une matrice valide: "+e.toString());
            }else{
            	throw e;
            }
        }
        assertEquals("Question 2 :\n "+"La matrice devrait avoir "+k+" colonnes", k, m[0].length);
	}
	
	@Test
	public void testMatrixDimensionLookup(){
		double[][] m = new double[l][k];
        try{
 		assertEquals("Question 3 :\n "+"Vous n'effectuez pas la bonne opération pour obtenir le nombre de lignes", m.length, M5Q1Stu.getNumLines(m));
        }
        catch(Throwable e){
        	if(!(e instanceof AssertionError)){
	        	fail("Question 3 :\n Attention, vous effectuez une opération illégale dans votre code: "+e.toString());
            }else{
            	throw e;
            }
        }
        try{
		assertEquals("Question 4 :\n "+"Vous n'effectuez la bonne opération pour obtenir le nombre de colonnes", m[0].length, M5Q1Stu.getNumColumns(m));
        }
        catch(Throwable e){
        	if(!(e instanceof AssertionError)){
	        	fail("Question 4 :\n Attention, vous effectuez une opération illégale dans votre code: "+e.toString());
            }else{
            	throw e;
            }
        }
	}
}
