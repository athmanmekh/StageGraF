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
import static graph.Graph.Edge;

public class Test {
	static Graph<String, Edge<String>> g;
	static final String ONE = "one";
	static final String TWO = "two";
	static final String THREE = "three";
	static final String FOUR = "four";
	static Edge<String> E1;

	public static void main(String[] args) {
		// Graph ({1, 2, 3, 4}, {(1,2), (1,3), (2,1), (2,2), (3,2)})

		String[] vertices = { ONE, TWO, THREE, FOUR };
		String[][] edges = { { ONE, TWO }, { ONE, THREE }, { TWO, ONE },
				{ TWO, TWO }, { THREE, TWO } };
		g = new MultiGraph<String, Edge<String>>();
		for (String v : vertices)
			g.addVertex(v);
		for (String[] e : edges)
			g.addEdge(new DirectedEdge<String>(e[0], e[1]));

		System.out.println("waiting for graph :");
		System.out.print("vertices =");
		for (String s : vertices)
			System.out.print(" " + s);
		System.out.println();
		System.out.print("edges =");
		for (String[] e : edges)
			System.out.print(" (" + e[0] + "," + e[1] + ")");
		System.out.println();
		System.out.println();

		System.out.println(g);

		System.out.print("Successors of " + TWO + " :");
		for (String v : g.successors(TWO))
			System.out.print(" " + v);
		System.out.println();

		for (String v : g.successors(TWO)) {
			System.out.println("removing " + v);
			g.removeVertex(v);
		}
		System.out.println(g);
	}
}
