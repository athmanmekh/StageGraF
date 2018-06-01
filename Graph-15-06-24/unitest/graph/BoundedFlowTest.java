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
package graph;

import static org.junit.Assert.assertTrue;
import graph.Graph.Edge;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import util.Graphs;
import util.Graphs.FlowResults;

public class BoundedFlowTest {
	
	
	static final String s = "s";
	static final String t = "t";
	static final String w = "w";
	static final String x = "x";
	static final String y = "y";
	static final String z = "z";
	
	static Graph<String, Graph.Edge<String>> g;
	static Map<Graph.Edge<String>, Integer> b;
	static Map<Graph.Edge<String>, Integer> c;
	
	@Before
	public void setUp() throws Exception {
		String[] vertices3 = {w,x,y,z,s,t};
		String[][][] edges3 = {
								{{s,w}, {"1","3"}},{{s,y}, {"0","10"}},
								{{w,x}, {"5","7"}},{{y,z}, {"2","8"}},
								{{x,y}, {"1","3"}},{{x,t}, {"3","5"}},
								{{z,w}, {"2","4"}},{{z,t}, {"2","6"}},
							};
		
		b	= new HashMap<Graph.Edge<String>, Integer>();
		c	= new HashMap<Graph.Edge<String>, Integer>();
		g = new MultiGraph<String, Graph.Edge<String>>();
		for (String v : vertices3) g.addVertex(v);
		for (String[][] e : edges3){
			Edge<String> edge = new DirectedEdge<String>(e[0][0], e[0][1]); 
			g.addEdge(edge);
			b.put(edge, Integer.valueOf(e[1][0]));
			c.put(edge, Integer.valueOf(e[1][1]));
		}
	}	
	
	@Test
	public void test() throws Exception {
		FlowResults<Graph.Edge<String>> result = Graphs.networkLowerUpperBound(g, s, t, b, c);
		assertTrue(result.value==11);
	}
}
