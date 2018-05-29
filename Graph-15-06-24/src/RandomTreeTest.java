import graph.Graph;
import static graph.Graph.Edge;
import util.RandomGraphs;


public class RandomTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph<Integer, Edge<Integer>> tree = RandomGraphs.randomTree(10);
		System.out.println(tree);
	}

}
