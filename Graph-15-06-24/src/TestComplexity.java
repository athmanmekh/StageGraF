/*******************************************************************************
 * Copyright (C) 2018 Baudon Olivier
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
import graph.Graph;
import static graph.Graph.Edge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import util.Graphs;
import util.RandomGraphs;

public class TestComplexity {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileWriter f = new FileWriter(args[0]);
		for (int i = 10; i < 1000; i += 10) {
			Graph<Integer, Edge<Integer>> g = RandomGraphs
					.randomDirectedGraph(i, 0.1);
			Date d1 = new Date();
			Graphs.breadthFirstSearch(g, 0);
			Date d2 = new Date();
			f.write(Long.toString(d2.getTime() - d1.getTime()));
			f.write(";");
			if (i % 100 == 0) 
				System.out.println(i);
		}
		f.close();
		System.out.println("The End !");
	}

}
