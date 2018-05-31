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
import graph.Graph.Edge;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import util.Graphs;
import util.Graphs.FlowResults;

public class MaxFlowTest {
	
	static final String _1 = "1";
	static final String _2 = "2";
	static final String _3 = "3";
	static final String _4 = "4";
	static final String S = "S";
	static final String T = "T";
	
	static Graph<String, Graph.Edge<String>> g;
	static Map<Graph.Edge<String>, Integer> c;
	
	@Before
	public void setUp() throws Exception {
		String[] vertices4 = {_1, _2, _3, _4, S, T };
		String[][][] edges4 = {
								{{S, _1}, {"16"}},{{S, _2}, {"13"}},
								{{_1, _2}, {"10"}},{{_1, _3}, {"12"}},
								{{_2, _1}, {"4"}},{{_2, _4}, {"14"}},
								{{_3, _2}, {"9"}},{{_3, T}, {"20"}},
								{{_4, _3}, {"7"}},{{_4, T}, {"4"}}
							};
		c	= new HashMap<Graph.Edge<String>, Integer>();
		g = new MultiGraph<String, Graph.Edge<String>>();
		for (String v : vertices4) g.addVertex(v);
		for (String[][] e : edges4){
			Edge<String> edge = new DirectedEdge<String>(e[0][0], e[0][1]); 
			g.addEdge(edge);
			c.put(edge, Integer.valueOf(e[1][0]));
		}
	}	
	
	@Test
	public void testFulkersonV1() throws Exception {
		FlowResults<Graph.Edge<String>> result = Graphs.fordFulkersonV01(g, S, T,null,c);
		assertTrue(result.value==23);
	}
	
	@Test
	public void testFulkersonV2() throws Exception {
		FlowResults<Graph.Edge<String>> result = Graphs.fordFulkersonV01(g, S, T,null,c);
		assertTrue(result.value==23);
	}
}
