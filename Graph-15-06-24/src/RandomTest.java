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
