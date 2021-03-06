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
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class TestRunner {
  public static void main(String[] args) throws UnsupportedEncodingException {
	PrintStream out = new PrintStream(System.out, true, "UTF-8"); 
    Result result = JUnitCore.runClasses(Mission4Test.class);
	if (result.wasSuccessful())
		out.println("OK");
	else{	
		out.println("KO");
		for (Failure failure : result.getFailures()) {
			if(failure.getException().getClass()==java.lang.AssertionError.class){	
				String msg = "";
				//Obtention des infos sur l'echec
				String meth = getMethodName(failure);				
				//System.out.println(failure.getMessage());				
				String [] desc = failure.getMessage().trim().split("\n");
				if(desc.length==3){
					msg = desc[0];
				}
				String [] values = getValues(failure);			
				String output = "F:"+meth + ":"+values[1]+":"+ values[0];
				if(msg!="") output+=(":"+msg); 
      	  		out.println(output);
			}
			else if(failure.getException().getClass()==java.lang.reflect.InvocationTargetException.class){
				String [] desc = failure.toString().split("\\n");
				String where = desc[0];
				//String classe = where.split("_")[0];
				//classe = Character.toUpperCase(classe.charAt(0)) + classe.substring(1);
				String method = getMethodName(failure);
				out.println("E:" +method + ":"+ failure.getException().getCause().toString().replace("\n", " "));
			}
			else 
				out.println(failure + " "+ failure.getException().getCause().toString().replace("\n", " "));
		}
		
    }
	
  }
  public static String getMethodName(Failure f){
	  String header = f.getTestHeader();
	  //On retire les parenthèses et leur contenu
	  header = header.split("\\(")[0];
	  //Le test est de la forme <methodeTestée>_<detail>
	  if(header.contains("_")){
		  header = header.split("_")[0];
	  }
	  return header;
  }
  public static String[] getValues(Failure f){
	String [] val = new String[2];  
	//Obtention des valeurs attendues/obtenues
	
	Pattern p1=Pattern.compile("Expected: (.*)");
	Pattern p2=	Pattern.compile("but: was (.*)");
	Matcher m=p1.matcher(f.toString());
	if(m.find())
		val[0]=m.group(1).replace("<", "").replace(">", "").trim();
	m=p2.matcher(f.toString());
	if(m.find())
		val[1]=m.group(1).replace("<", "").replace(">", "").trim();
	return val;
  
  }
} 