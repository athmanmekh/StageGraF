package graph;

import java.util.Collection;
import java.util.Set;

import static graph.Graph.Edge;

class PartialMultiGraph<V, E extends Edge<V>> extends SubMultiGraph<V, E>
		implements PartialGraph<V, E> {

	public PartialMultiGraph(MultiGraph<V, E> supergraph, Set<E> edges) {
		super(supergraph, supergraph.vertices(), edges);
	}

	@Override
	public boolean addVertex(V vertex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAllVertices(Collection<V> vertices) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeVertex(V vertex) {
		throw new UnsupportedOperationException();
	}
}
