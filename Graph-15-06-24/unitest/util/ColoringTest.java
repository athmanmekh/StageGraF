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

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ColoringTest {

	static Graph<Integer, Graph.Edge<Integer>> g;
	static int N = 4;

	@Before
	public void setUp() throws Exception {
		// Complete graph with N vertices
		g = new MultiGraph<Integer, Graph.Edge<Integer>>();
		for (int i = 0; i < N; i++) {
			g.addVertex(i);
		}
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				g.addEdge(new DirectedEdge<Integer>(i, j));
	}

	@Test
	public void testComputeImproperColoring() {
		Integer[] colors = new Integer[N];
		for (int i = 0; i < N; i++)
			colors[i] = i;
		Map<Integer, Integer> coloring = Coloring.computeImproperColoring(g,
				colors);
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				assertTrue(coloring.get(i) != coloring.get(j));
	}

	@Test
	public void testComputeColoring() {
		Map<Integer, Integer> coloring = Coloring.computeColoring(g);
		for (int i = 0; i < N - 1; i++)
			for (int j = i + 1; j < N; j++)
				assertTrue(coloring.get(i) != coloring.get(j));
		for (int i = 0; i < N; i++)
			assertTrue(coloring.get(i) < N);
	}

}
