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



import static org.hamcrest.CoreMatchers.equalTo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Mission9Test
{
	Class<?> word;
	Class<?> dictionary;
	Class<?> dico;
	Constructor<?> constructor;
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void before() throws ClassNotFoundException
	{
		word = Class.forName("Word");
		dictionary = Class.forName("Dictionary");
		dico = Class.forName("Dico");
	}
	
	public boolean fieldTypePresence(List<Field> list, Class<?> cl)
	{	
		for(Field field : list)
			if(field.getType().isArray() && field.getType().getComponentType().equals(cl))
				return true;
		return false;
	}
	
	public boolean methodNamePresence(List<Method> list, String name)
	{
		for(Method method : list)
			if(method.getName().equals(name))
				return true;
		return false;
	}
	
	@Test
	public void word() throws Throwable
	{
		collector.checkThat(methodNamePresence(Arrays.asList(word.getMethods()), "compareTo"), equalTo(true));
		collector.checkThat(methodNamePresence(Arrays.asList(word.getMethods()), "equals"), equalTo(true));
	}
	
	@Test
	public void dictionary() throws Throwable
	{
		collector.checkThat(fieldTypePresence(Arrays.asList(dictionary.getDeclaredFields()), word), equalTo(true));		
	}
	
	@Test
	public void dico() throws Throwable
	{
		collector.checkThat(methodNamePresence(Arrays.asList(dico.getMethods()), "main"), equalTo(true));
	}
}