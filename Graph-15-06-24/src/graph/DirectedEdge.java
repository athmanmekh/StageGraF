package graph;

/**
 * 
 * @author amekhzoumi
 *
 * static import to replace Graph.Edge by Edge
 */
import static graph.Graph.Edge;

public class DirectedEdge<V> implements Edge<V> {
	private V source;
	private V target;

	public DirectedEdge(V source, V target) {
		this.source = source;
		this.target = target;
	}

	public V getOpposite(V vertex) {
		if (vertex == null) {
			if (source == null)
				return target;
			else if (target == null)
				return source;
			else
				throw new IllegalArgumentException();
		}
		if (vertex.equals(source))
			return target;
		else if (vertex.equals(target))
			return source;
		else
			throw new IllegalArgumentException();
	}

	public V source() {
		return source;
	}

	public V target() {
		return target;
	}

	public String toString() {
		return "(" + source + ", " + target + ")";
	}
}