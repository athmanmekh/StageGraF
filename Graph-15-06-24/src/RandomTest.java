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
import java.util.HashMap;
import java.util.Map;

import graph.Graph;
import graph.MultiGraph;
import util.RandomGraphVietnam;
import static graph.Graph.Edge;

public class RandomTest {

	public static void main(String[] args) {
		//printString(randomMatrixGraph(10));
		//printString(randomMatrixDiGraph(10));		
		Graph<String, Edge<String>> g1 = new MultiGraph<String, Edge<String>>();
		Map<Edge<String>,Integer> w1 = new HashMap<Edge<String>, Integer>();
		//RandomGraph.randomGraph(g1, 10, w1, 0 , 9);		
		RandomGraphVietnam.randomGraph(g1, 10, null, w1, 9);
		System.out.println(g1);
		System.out.println(w1);
		System.out.println();
		
		Graph<String, Edge<String>> g2 = new MultiGraph<String, Edge<String>>();
		Map<Edge<String>,Integer> w2 = new HashMap<Edge<String>, Integer>();
		//RandomGraph.randomDiGraph(g2, 10, w2, 0, 9);
		RandomGraphVietnam.randomDiGraph(g2, 10, null, w2, 9);
		System.out.println(g2);
		System.out.println(w2);
		System.out.println();
		Graph<String, Edge<String>> g3 = new MultiGraph<String, Edge<String>>();
		Map<Edge<String>,Integer> l3 = new HashMap<Edge<String>, Integer>();
		Map<Edge<String>,Integer> u3 = new HashMap<Edge<String>, Integer>();
		//RandomGraph.randomNetwork(g3, 10, l3, u3, 11, 99);
		RandomGraphVietnam.randomNetwork(g3, 10, null, l3, u3, 11, 99);
		System.out.println(g3);
		System.out.println(l3);
		System.out.println(u3);
		
	}
}
