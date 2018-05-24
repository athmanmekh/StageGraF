package util;

import graph.DirectedEdge;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomGraphVietnam {

	public static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void randomGraph(Graph<String, Graph.Edge<String>> g,
			Integer numberOfVertices, Integer numberOfEdges,
			Map<Graph.Edge<String>, Integer> w, int wMax) {
		Random rd = new Random();
		List<Position> list = new ArrayList<Position>();

		for (int i = 1; i <= numberOfVertices; i++) {
			for (int j = i + 1; j <= numberOfVertices; j++) {
				list.add(new Position(i, j));
			}
		}

		if (numberOfEdges == null) {
			int max = (numberOfVertices * numberOfVertices) / 2
					- numberOfVertices;
			int min = numberOfVertices - 1;
			numberOfEdges = rd.nextInt(max - min) + min;
			;
		}

		for (int i = 1; i <= numberOfVertices; i++) {
			g.addVertex(String.valueOf(i));
		}
		int number = 0;
		while (number <= numberOfEdges) {
			int rdp = rd.nextInt(list.size());
			Position p = list.get(rdp);
			Graph.Edge<String> e = new DirectedEdge<String>(
					String.valueOf(p.x), String.valueOf(p.y));
			g.addEdge(e);
			w.put(e, rd.nextInt(wMax - 1) + 1);
			++number;
			list.remove(rdp);
		}
	}

	public static void randomDiGraph(Graph<String, Graph.Edge<String>> g,
			Integer numberOfVertices, Integer numberOfEdges,
			Map<Graph.Edge<String>, Integer> w, int wMax) {
		Random rd = new Random();
		List<Position> list = new ArrayList<Position>();

		for (int i = 1; i <= numberOfVertices; i++) {
			for (int j = 1; j <= numberOfVertices; j++) {
				if (i == j)
					continue;
				list.add(new Position(i, j));
			}
		}

		if (numberOfEdges == null) {
			int max = (numberOfVertices * numberOfVertices) / 2
					- numberOfVertices;
			int min = numberOfVertices - 1;
			numberOfEdges = rd.nextInt(max - min) + min;
			;
		}

		for (int i = 1; i <= numberOfVertices; i++) {
			g.addVertex(String.valueOf(i));
		}
		int number = 0;
		while (number <= numberOfEdges) {
			int rdp = rd.nextInt(list.size());
			Position p = list.get(rdp);
			Graph.Edge<String> e = new DirectedEdge<String>(
					String.valueOf(p.x), String.valueOf(p.y));
			g.addEdge(e);
			w.put(e, rd.nextInt(wMax - 1) + 1);
			++number;
			list.remove(rdp);
		}
	}

	public static void randomNetwork(Graph<String, Graph.Edge<String>> g,
			Integer numberOfVertices, Integer numberOfEdges,
			Map<Graph.Edge<String>, Integer> l,
			Map<Graph.Edge<String>, Integer> u, int min, int max) {
		Random rd = new Random();
		List<Position> list = new ArrayList<Position>();

		for (int i = 1; i <= numberOfVertices; i++) {
			for (int j = 1; j <= numberOfVertices; j++) {
				if (i == j)
					continue;
				list.add(new Position(i, j));
			}
		}

		if (numberOfEdges == null) {
			int m1 = (numberOfVertices * numberOfVertices) / 2
					- numberOfVertices;
			int m2 = numberOfVertices - 1;
			numberOfEdges = rd.nextInt(m1 - m2) + m1;
			;
		}

		for (int i = 1; i <= numberOfVertices; i++) {
			g.addVertex(String.valueOf(i));
		}
		int number = 0;
		while (number <= numberOfEdges) {
			int rdp = rd.nextInt(list.size());
			Position p = list.get(rdp);
			Graph.Edge<String> e = new DirectedEdge<String>(
					String.valueOf(p.x), String.valueOf(p.y));
			g.addEdge(e);
			int mid = (max + min) / 2;
			l.put(e, rd.nextInt(mid - min) + min);
			u.put(e, rd.nextInt(max - mid) + mid);
			++number;
			list.remove(rdp);
		}
	}
}