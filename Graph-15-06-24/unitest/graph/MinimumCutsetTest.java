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

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import util.Graphs;

public class MinimumCutsetTest {
	
	static final String ONE = "one";
	static final String TWO = "two";
	static final String THREE = "three";
	static final String FOUR = "four";
	static final String SOURCE = "source";
	static final String SINK = "sink";
	
	static Graph<String, Graph.Edge<String>> g;
	
	@Before
	public void setUp() throws Exception {
		String[] v5 = { SOURCE, SINK, ONE, TWO, THREE, FOUR};
		String[][] e5 = { {SOURCE,ONE},{SOURCE,TWO},
				{ONE,TWO},{ONE,THREE},{ONE,FOUR},
				{TWO,FOUR},
				{THREE,SINK},{FOUR,THREE},{FOUR,SINK},{SINK,SOURCE}};
		g = new MultiGraph<String, Graph.Edge<String>>();
		for (String v : v5)
			g.addVertex(v);
		for (String[] edge : e5)
			g.addEdge(new DirectedEdge<String>(edge[0], edge[1]));
	}	
	
	@Test
	public void testMinimumCutset() throws Exception {
		Set<String> result = Graphs.minimumCutset(g);
		assertTrue(result.size()==3);
	}
	
	@Test
	public void testMinimumEdgeCutset() throws Exception {
		Set<Graph.Edge<String>> result = Graphs.minimumEdgeCutset(g);
		assertTrue(result.size()==3);
	}
	
	@Test
	public void testMinimumDigraphCutset() throws Exception {
		Set<String> result = Graphs.minimumDigraphCutset(g);
		assertTrue(result.size()==1);
	}
	
	@Test
	public void testMinimumDigraphEdgeCutset() throws Exception {
		Set<Graph.Edge<String>> result = Graphs.minimumDigraphEdgeCutset(g);
		assertTrue(result.size()==1);
	}
}
