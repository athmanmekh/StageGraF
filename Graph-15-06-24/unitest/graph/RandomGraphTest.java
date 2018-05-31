/*******************************************************************************
 * Copyright (C) 2018 Baudon Olivier
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package graph;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import util.RandomGraphVietnam;

public class RandomGraphTest {
	
	static Graph<String, Graph.Edge<String>> g1;
	static Map<Graph.Edge<String>,Integer> w1;
	static Graph<String, Graph.Edge<String>> g2;
	static Map<Graph.Edge<String>,Integer> w2;
	static Graph<String, Graph.Edge<String>> g3;
	static Map<Graph.Edge<String>,Integer> l3;
	static Map<Graph.Edge<String>,Integer> u3;
	
	@Before
	public void setUp() throws Exception {
		g1 = new MultiGraph<String, Graph.Edge<String>>();
		w1 = new HashMap<Graph.Edge<String>, Integer>();
		g2 = new MultiGraph<String, Graph.Edge<String>>();
		w2 = new HashMap<Graph.Edge<String>, Integer>();
		g3 = new MultiGraph<String, Graph.Edge<String>>();
		l3 = new HashMap<Graph.Edge<String>, Integer>();
		u3 = new HashMap<Graph.Edge<String>, Integer>();
	}	
	
	@Test
	public void testGraph() throws Exception {
		RandomGraphVietnam.randomGraph(g1, 10, null, w1, 9);
		assertTrue((g1.order()>9)&&g1.order()<10*10/2-10);
	}
	
	@Test
	public void testDiGraph() throws Exception {
		RandomGraphVietnam.randomDiGraph(g2, 10, null, w2, 9);
		assertTrue((g2.order()>9)&&g2.order()<10*10/2-10);
	}
	
	@Test
	public void testNetwork() throws Exception {
		RandomGraphVietnam.randomNetwork(g3, 10, null, l3, u3, 11, 99);
		assertTrue((g3.order()>9)&&g3.order()<10*10/2-10);
	}
}
