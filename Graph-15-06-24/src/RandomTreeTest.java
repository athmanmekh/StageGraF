import graph.Graph;
import util.RandomGraphs;


public class RandomTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph<Integer, Graph.Edge<Integer>> tree = RandomGraphs.randomTree(10);
		System.out.println(tree);
	}

}
