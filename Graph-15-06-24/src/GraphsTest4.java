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
import graph.DirectedEdge;
import graph.Graph;
import graph.MultiGraph;
import static graph.Graph.Edge;

import java.util.HashMap;
import java.util.Map;

import util.Graphs;
import util.Graphs.FlowResults;
import util.NotLegalFlowException;


public class GraphsTest4 {

	/**
	 * @param args
	 * @throws NotLegalFlowException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		final String a = "a";
//		final String b = "b";
//		final String c = "c";
//		final String d = "d";
		final String s = "s";
		final String t = "t";
		
//		String[] vertices2 = {a,b,c,d,s,t};
//		String[][][] edges2 = {
//								{{s,a}, {"15"}},{{s,c}, {"4"}},
//								{{a,b}, {"12"}},{{c,d}, {"10"}},
//								{{b,c}, {"3"}},{{b,t}, {"7"}},
//								{{d,a}, {"5"}},{{d,t}, {"10"}},
//							};
//		Map<Edge<String>, Integer> w2	= new HashMap<Edge<String>, Integer>();
//		Graph<String, Edge<String>> g2 = new MultiGraph<String, Edge<String>>();
//		for (String v : vertices2) g2.addVertex(v);
//		for (String[][] e : edges2){
//			Edge<String> edge = new DirectedEdge<String>(e[0][0], e[0][1]); 
//			g2.addEdge(edge);
//			w2.put(edge, Integer.valueOf(e[1][0]));
//		}
//		
//		FlowResults<Edge<String>> result = Graphs.fordFulkersonV01(g2, s, t, w2);
//		System.out.println(result);
//		
		final String w = "w";
		final String x = "x";
		final String y = "y";
		final String z = "z";
		
		String[] vertices3 = {w,x,y,z,s,t};
		String[][][] edges3 = {
								{{s,w}, {"1","3"}},{{s,y}, {"0","10"}},
								{{w,x}, {"5","7"}},{{y,z}, {"2","8"}},
								{{x,y}, {"1","3"}},{{x,t}, {"3","5"}},
								{{z,w}, {"2","4"}},{{z,t}, {"2","6"}},
							};
		
		Map<Edge<String>, Integer> b3	= new HashMap<Edge<String>, Integer>();
		Map<Edge<String>, Integer> c3	= new HashMap<Edge<String>, Integer>();
		Graph<String, Edge<String>> g3 = new MultiGraph<String, Edge<String>>();
		for (String v : vertices3) g3.addVertex(v);
		for (String[][] e : edges3){
			Edge<String> edge = new DirectedEdge<String>(e[0][0], e[0][1]); 
			g3.addEdge(edge);
			b3.put(edge, Integer.valueOf(e[1][0]));
			c3.put(edge, Integer.valueOf(e[1][1]));
		}
		
		FlowResults<Edge<String>> result1 = Graphs.networkLowerUpperBound(g3, s, t, b3, c3);
		System.out.println(result1);
	}

}
