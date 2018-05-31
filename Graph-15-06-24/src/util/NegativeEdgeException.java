package util;

import static graph.Graph.Edge;

@SuppressWarnings("serial")
public class NegativeEdgeException extends Exception {
	private Edge<?> e;
	private double weight;
	
	public NegativeEdgeException(Edge<?> e, double weight) {
		this.e = e;
		this.weight = weight;
	}
	
	public Edge<?> edge() {
		return e;
	}
	
	public double weight() {
		return weight;
	}
	
	public String getMessage() {
		return "Edge " + e + " with a negative weight " + weight; 
	}
}
