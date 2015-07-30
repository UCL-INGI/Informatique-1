/**
 *  Copyright (c) 2015 François Michel, Clémentine Munyabarenzi
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.Test;
import org.junit.Assert;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Un exemple de test avec JUNIT
 *
 * @author Clémentine Munyabarenzi Juillet 2015
 * @original version O. Bonaventure Decembre 2008
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui    constituent    la   TesteSuite
	 */
	M11Q7Stu.DListTest.class
})
public class M11Q7Stu {

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(DListTest.class);
   		Result result2 = JUnitCore.runClasses(DListParseTest.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
        int count = 0; boolean match = false;
		while(failures.hasNext()){
			f = failures.next();
           	if(f.getMessage().matches(".*\n.*assertion devrait bien être lancée.*")){
            	System.out.println(f.getMessage());
                match = true;
            }else{
				count++;
				System.err.println(f.getMessage());
			}
		}
        Iterator<Failure> failures2 = result2.getFailures().iterator();
		while(failures2.hasNext()){
			f = failures2.next();
			System.err.println(f.getMessage());
			//System.err.println(f.getTrace());
		}

        if(count == 0 && match == false){
        	System.err.println("Question 12 :\nL'assertion relative aux réponses 12 et 13 devrait lancer une erreur.");
        }else
		if(count == 0 && match == true && result2.wasSuccessful()){
			//System.out.println(true);
			/**127 : nombre magique afin de signaler que tout les tests sont passés */
            System.exit(127);
        }
	}

public static class DListTest extends junit.framework.TestCase
{

    /**
     * @pre
     * @post verification du bon fonctionnement de la methode remove:
     * 		 vérification de la réussite de cette méthode quand il le faut.
     */
    public void testReussiteRemove()
    {
        // Creation de la liste
        DList l=new DList();
        
        // ajout de trois elements a la liste
        l.add(new Double(2.3));
        l.add(new Double(2.4));
        l.add(new Double(2.4));
        
        // retrait de ces trois elements
        try{
        assertEquals("Question 1 :\nCette assertion ne devrait pas être lancée : Le retrait d'un element se trouvant dans la liste "
        		+ "devrait renvoyer true", @@q1@@, @@q2@@);
           }
        catch(Throwable e){
	        if(!(e instanceof AssertionError)){
    	    	fail("Question 1 :\nVotre code provoque une exception, Relisez votre code des réponses 1 et 2:"+e.toString());
        	}else{
        		throw e;
        	}
        }
		try{
        assertEquals("Question 3 :\nCette assertion ne devrait pas être lancée : Le retrait d'un element se trouvant deux fois dans la liste"
        		+ " devrait renvoyer true", @@q3@@, @@q4@@);
        }
        catch(Throwable e){
        	if(!(e instanceof AssertionError)){
        		fail("Question 3 :\nVotre code provoque une exception, Relisez votre code des réponses 3 et 4: "+e.toString());
        	}else{
        		throw e;
        	}
        }
    }
    
    /**
     * @pre
     * @post verification du bon fonctionnement de la methode remove:
     * 		 vérification de l'échec de cette méthode quand il le faut.
     */
    public void testEchecRemove(){

		// Creation de la liste
        DList l=new DList();
        // Retrait d'un element d'une liste vide
		try{
        assertEquals("Question 5 :\nCette assertion ne devrait pas être lancée : Le retrait d'un element ne se trouvant pas dans la liste"
        		+ " devriat renvoyer false", @@q5@@, @@q6@@);
        }
        catch(Throwable e){
        	if(!(e instanceof AssertionError)){
        		fail("Question 5 :\nVotre code provoque une exception, Relisez votre code des réponses 5 et 6:"+e.toString());
        	}else{
          		throw e;
       		}
		}
        // Ajout de trois elements a la liste
        l.add(new Double(2.3));
        try{
			@@q7@@
        }
        catch(Throwable e){
   		    if(!(e instanceof AssertionError)){
        		fail("Question 7 :\nVotre code provoque une exception, Relisez votre code de la réponse 7:"+e.toString());
        	}else{
          		throw e;
        	}
		}

		l.add(new Double(2.4));
        
        // Retrait de ces trois elements
        l.remove(new Double(2.3));
        try{
        assertEquals("Question 8 :\nCette assertion ne devrait pas être lancée : Le retrait d'un element ne se trouvant plus dans la liste "
        		+ "devrait renvoyer false", @@q8@@, @@q9@@);
        }
        catch(Throwable e){
   		    if(!(e instanceof AssertionError)){
        		fail("Question 8 :\nVotre code provoque une exception, Relisez votre code des réponses 8 et 9: "+e.toString());
        	}else{
          		throw e;
        	}
		}
        try{
        assertEquals("Question 10 :\nCette assertion ne devrait pas être lancée : Le retrait d'un element ne se trouvant pas dans la liste "
        		+ "devriat renvoyer false", @@q10@@, @@q11@@);
        }
        catch(Throwable e){
   		    if(!(e instanceof AssertionError)){
        		fail("Question 10 :\nVotre code provoque une exception, Relisez votre code des réponses 10 et 11: "+e.toString());
        	}else{
          		throw e;
        	}
		}
        l.remove(new Double(2.4));
        try{
        assertEquals("Question 12 :\nCette assertion devrait bien être lancée : Le retrait d'un element dont les deux exemplaires "
        		+ "ne sont plus dans la liste devrait renvoyer false", @@q12@@, @@q13@@);
        }        
        catch(Throwable e){
        	if(!(e instanceof AssertionError)){
        		fail("Question 12 :\nVotre code provoque une exception, Relisez votre code des réponses 12 et 13:"+e.toString());
        	}else{
	          	throw e;
        	}
		}
    }
}

/**
 * 
 * Nous voudrions restreindre le contenu possible des réponses
 */
public static  class DListParseTest extends junit.framework.TestCase{
	
	public String msg = "Ce n'est pas la réponse attendue.";
	
	public void testrep1(){
		assertTrue("Question 1 :\n"+msg, "@@q1@@".matches(".*true.*") );
	}
	
	public void testrep2(){
		assertTrue("Question 2 :\n"+msg, "@@q2@@".matches(".*l.remove.*2.3.*"));
	}

	public void testrep3(){
		assertTrue("Question 3 :\n"+msg, "@@q3@@".matches(".*true.*"));
	}

	public void testrep4(){
		assertTrue("Question 4 :\n"+msg, "@@q4@@".matches(".*l.remove.*2.4.*"));
	}

	public void testrep5(){
		assertTrue("Question 5 :\n"+msg, "@@q5@@".matches(".*false.*"));
	}

	public void testrep6(){
		assertTrue("Question 6 :\n"+msg, "@@q6@@".matches(".*l.remove.*"));
	}

	public void testrep7(){
		assertTrue("Question 7 :\n"+msg, "@@q7@@".matches(".*l.add.*2.4.*"));
	}

	public void testrep8(){
		assertTrue("Question 8 :\n"+msg, "@@q8@@".matches(".*false.*"));
	}

	public void testrep9(){
		assertTrue("Question 9 :\n"+msg, "@@q9@@".matches(".*l.remove.*2.3.*"));
	}

	public void testrep10(){
		assertTrue("Question 10 :\n"+msg, "@@q10@@".matches(".*false.*"));
	}

	public void testrep11(){
		assertFalse("Question 11 :\n"+msg, "@@q11@@".matches(".*l.remove.*2.4\\s.*"));
	}

	public void testrep12(){
		assertTrue("Question 12 :\n"+msg, "@@q12@@".matches(".*false.*"));
	}

	public void testrep13(){
		assertTrue("Question 13 :\n"+msg, "@@q13@@".matches(".*l.remove.*2.4.*"));
	}
}

}

/**
 * Une petite classe permettant de manipuler une liste de Double
 * Cette classe contient une erreur. Cette classe ne fait pas partie
 * de la mission mais est un exemple d'utilisation de JUnit. Voir egalement
 * le chapitre 6 dans NH3
 * 
 * @author O. Bonaventure
 * @version Dec. 2008
 */
class DList
{
    List<Double> l;
    
    /**
     * @pre 
     * @post a construit une liste initialement vide
     */
    public DList()
    {
        l=new LinkedList<Double>();
    }
    
    /**
     * @pre d!=null
     * @post a ajout le Double d dans la liste
     */
    public void add(Double d)
    {
        assert d!=null;
        l.add(d);
    }
    /**
     * @pre d!=null
     * @post retourne true si d se trouvait dans la liste et false sinon
     *       a retire de la liste toutes les instances de Double egales 
     *       a d
     */
    public boolean remove(Double d)
    {
        assert d!=null;
        int i=l.indexOf(d);
        if(i>=0)
        {
            Double d1=l.remove(i);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * @pre d!=null
     * @post retourne true si d se trouve dans la liste et false sinon
     */
    public boolean contains(Double d)
    {
        return l.contains(d);
    }
    
    /**
     * @pre -
     * @post retourne le nombre de Double se trouvant dans la liste
     */
    public int size()
    {
        return l.size();
    }
}
