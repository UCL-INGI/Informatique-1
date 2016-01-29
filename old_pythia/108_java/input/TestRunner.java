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



import org.junit.runner.JUnitCore;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.Description;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRunner {
  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(Mission9Test.class);
	if (result.wasSuccessful())
		System.out.println("OK");
	else{		
		for (Failure failure : result.getFailures()) {
			if(failure.getException().getClass()==java.lang.AssertionError.class){												
				String [] desc = failure.toString().split("\\n");
				String where = desc[0];
				String classe = where.split("\\(")[0];
				classe = Character.toUpperCase(classe.charAt(0)) + classe.substring(1);

			
      	  		System.out.println("Echec du test de la classe " + classe  + " : Champs ou méthodes demandés absents");
			}
			else if(failure.getException().getClass()==java.lang.reflect.InvocationTargetException.class){
				String [] desc = failure.toString().split("\\n");
				String where = desc[0];
				String classe = where.split("_")[0];
				classe = Character.toUpperCase(classe.charAt(0)) + classe.substring(1);
				String method = where.split("_")[1].split("\\(")[0];
				System.out.println("Exception lancée dans la méthode " +classe + "."+ method + "() : "+ failure.getException().getCause() );
			}
			else 
				System.out.println(failure);
		}
		
    }
	
  }
} 