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

import graph.Graph;

import org.junit.Test;

public class RandomGraphsTest {

	@Test
	public void testRandomTree() {
		Graph<Integer, Graph.Edge<Integer>> tree = RandomGraphs.randomTree(10);
		assertTrue(tree.order() == 10);
		assertTrue(Graphs.isTree(tree));
	}

}
