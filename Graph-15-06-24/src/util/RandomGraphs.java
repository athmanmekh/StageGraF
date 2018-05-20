package util;

import graph.DirectedEdge;
import graph.Graph;
import graph.MultiGraph;

import java.util.Random;

public class RandomGraphs {

	private static Random rand = new Random();
	
	public static void setSeed(long seed) {
		rand.setSeed(seed);
	}
	
	public static void setRandom(Random rand) {
		RandomGraphs.rand = rand;
	}
	
	/**
	 * 
	 * @author baudon
	 *
	 * pseudo-random tree generator. 
	 */
	public static Graph<Integer, Graph.Edge<Integer>> randomTree(int n) {
		int[] code = new int[n-2];
		for (int i = 0; i < n-2; i++) {
			code[i] = rand.nextInt(n-2);
		}
		Graph<Integer, Graph.Edge<Integer>> tree = new MultiGraph<Integer, Graph.Edge<Integer>>();
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			tree.addVertex(i);
			d[i] = 0;
		}
		int index = 0;
		for (int i = 0; i < n-2; i++) {
			d[code[i]]++;
			if (code[i] == index) {
				while (d[index] > 0) {
					index++;
				}
			}
		}
		int v = index;
		for (int i = 0; i < n-2; i++) {
			int w = code[i];
			tree.addEdge(new DirectedEdge<Integer>(v, w));
			d[w]--;
			if (w < index && d[w] == 0) {
				v = w;
			} else {
				index++;
				while (d[index] > 0) {
					index++;
				}
				v = index;
			}
		}
		tree.addEdge(new DirectedEdge<Integer>(v, n-1));
		return tree;
	}
	
	public static Graph<Integer, Graph.Edge<Integer>> randomDirectedGraph(
			int n, double p) {
		if (p < 0 || p > 1)
			throw new IllegalArgumentException("The probability " + p
					+ "is not between 0 and 1");
		Graph<Integer, Graph.Edge<Integer>> g = new MultiGraph<Integer, Graph.Edge<Integer>>();
		for (int i = 0; i < n; i++) {
			g.addVertex(i);
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (rand.nextDouble() < p) {
					g.addEdge(new DirectedEdge<Integer>(i, j));
				}
			}
		return g;
	}

}
