/*******************************************************************************
 * Copyright (C) 2018 Olivier Baudon
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package util;


import static org.junit.Assert.assertTrue;
import graph.DirectedEdge;
import graph.Graph;
import graph.MultiGraph;

import org.junit.Before;
import org.junit.Test;

public class GraphAlgorithmsTest {

	static Graph<Integer, Graph.Edge<Integer>> g;

	@Before
	public void setUp() throws Exception {
		g = new MultiGraph<Integer, Graph.Edge<Integer>>();
		for (int i = 0; i < 12; i++) {
			g.addVertex(i);
		}
		int[][] edges = {{0,1}, {0,5}, {1,2}, {2,3}, {2,7},{3,4}, {4,1}, {5,6}, 
				{6, 0},{9, 10}, {10,11},{11,9}}; 
	for (int[] e : edges)
		g.addEdge(new DirectedEdge<Integer>(e[0], e[1]));
	} 

	@Test
	public void testDepthFirstSearch() {
		assertTrue(! Graphs.isConnected(Graphs.breadthFirstSearch(g, 0)));
	}

}
