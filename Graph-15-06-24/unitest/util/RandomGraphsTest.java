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
