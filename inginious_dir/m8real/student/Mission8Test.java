/**
 *  Copyright (c) 2015, 2016 Bastien Bodart, François Michel, Clémentine Munyabarenzi
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
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

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
public class Mission8Test
{
	Class<?> shape;
	Class<?> triangle;
	Class<?> equilateral;
	Class<?> rectangle;
	Class<?> square;
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@SuppressWarnings("unchecked")
	@Before
	public void before() throws ClassNotFoundException
	{
		shape = Class.forName("Shape");
		triangle = Class.forName("Triangle");
		equilateral = Class.forName("Equilateral");
		rectangle = Class.forName("Rectangle");
		square = Class.forName("Square");
	}
	
	@Test
	public void triangle() throws Throwable
	{
		collector.checkThat("La classe Triangle n'implémente pas l'interface Shape. ", 
							Arrays.asList(triangle.getInterfaces()).contains(shape), equalTo(true));
	}
	
	@Test
	public void equilateral() throws Throwable
	{
		collector.checkThat("La classe Equilateral n'est pas une sous-classe de la classe Triangle. ", 
							equilateral.getSuperclass().equals(triangle), equalTo(true));
	}
	
	@Test
	public void rectangle() throws Throwable
	{
		collector.checkThat("La classe Rectangle n'implémente pas l'interface Shape. ", 
							Arrays.asList(rectangle.getInterfaces()).contains(shape), equalTo(true));
	}
	
	@Test
	public void square() throws Throwable
	{
		collector.checkThat("La classe Square n'est pas une sous-classe de la classe Rectangle. ", 
							square.getSuperclass().equals(rectangle), equalTo(true));
	}
}
