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
import graph.DirectedEdge;
import graph.Graph;
import graph.MultiGraph;
import util.Graphs;
import static graph.Graph.Edge;

public class GraphsTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		case4();
//		case6();
//		case5();
//		case311();
//		case312();
		case7();
		
	}
	
	private static Graph<String, Edge<String>> createGraph(String[] vertices, String[][] edges){
		Graph<String, Edge<String>> g = new MultiGraph<String, Edge<String>>();
		for (String v : vertices)
			g.addVertex(v);
		for (String[] edge : edges)
			g.addEdge(new DirectedEdge<String>(edge[0], edge[1]));
		System.out.println(g);
		return g;
	}
	
	@SuppressWarnings("unused")
	private static void case4(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String s2 = "s2";
		
		String[] vertices = { s1,s2,a1,a2, a3};
		String[][] edges = { {s1, a1},{s1, a2},
							{a2, s2},{a1, a3},{a3, s2}
							};
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 2, 3);
		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}
	
	@SuppressWarnings("unused")
	private static void case5(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String s2 = "s2";
		
		String[] vertices = { s1,s2,a1,a2, a3};
		String[][] edges = { {s1, a3},{s1, a2},
							{a2, s2},{a3, a1},{a1, s2}
							};
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 3, 2);
		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}
	
	@SuppressWarnings("unused")
	private static void case311(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String s2 = "s2";
		
		String[] vertices = { s1,s2,a1,a2, a3};
		String[][] edges = { {s1, a3},{s1, a2},
							{a2, a1},{a3, a1},{a2, s2},{a1, s2}
							};
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 3, 2);
		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}
	
	@SuppressWarnings("unused")
	private static void case312(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String a4 = "a4";
		final String s2 = "s2";
		
		String[] vertices = { s1,s2,a1,a2, a3, a4};
		String[][] edges = { {s1, a4},{a4, a2},{s1, a3},
							{a3,a1},{a2,a1},{a2,s2},{a1,s2}
							};
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 2, 4);
		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}
	
	
	
	@SuppressWarnings("unused")
	private static void case6(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String a4 = "a4";
		final String s2 = "s2";
		
		String[] vertices = { s1,s2,a1,a2, a3, a4};
		String[][] edges = { {s1, a1},{s1, a2},{s1, a3},{s1, a4},
							{a1, s2},{a2, s2},{a3, s2},{a4, s2}
							};
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 3, 3);
		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}
	
	private static void case7(){
		final String s1 = "s1";
		final String a1 = "a1";
		final String a2 = "a2";
		final String a3 = "a3";
		final String a4 = "a4";
		final String a5 = "a5";
		final String s2 = "s2";
		final String b1 = "b1";
		final String b2 = "b2";
		final String b3 = "b3";
		final String b4 = "b4";
		

		
		String[] vertices = { s1,s2,a1,a2,a3,a4,a5,b1,b2,b3,b4 };
		String[][] edges = { {s1, a1},{a1, a2},{a2, a3},{a3, a5},{a4, a1},{a4, a2},{a4, a3},
							{s2, b1},{s2, b4},{b2, b1},{b2, s2},{b3, s2},{b3, b4},
							{s1, b1},{b1, a1},{b2, a4},{b3, a4},{a3, b3},{b3, a5},{a5, b4}
							};
		
		Graph<String, Edge<String>> g = createGraph(vertices, edges);
		Graphs.BipartitionResult<String, Edge<String>> result = Graphs.part2(g, null, s1, s2, 6, 5);		
		System.out.println("v1:" + result.v1);
		System.out.println("v2:" + result.v2);
	}

}
