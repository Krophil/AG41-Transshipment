package Solver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Transshipment.Graph.Edge;
import Transshipment.Graph.Graph;
import Transshipment.Graph.Node;

public class Solver {
	private Graph<Node, Edge> graph;
	private int maxTime;
	private long computationTime, initTime, improvementTime;
	
	public Solver() {
		maxTime = -1;
		graph = null;
		computationTime = -1;
		initTime = -1;
		improvementTime = -1;
	}

	private void solve(String problemFile, long computationTime) {
		this.computationTime = computationTime;
		long start = System.currentTimeMillis();

		loadProblemFile(problemFile);
		//init solution ....
		//TODO
		
		initTime = System.currentTimeMillis() - start;
		start += initTime;
		
		while (System.currentTimeMillis() - start < computationTime) {
			//improving the solution ...
			//TODO
		}
		
		improvementTime = System.currentTimeMillis() - start;
	}
	
	public void saveSolution(String saveFile) {
		//TODO
	}
	
	private void loadProblemFile(String file) {
		BufferedReader br = null;
		graph = new Graph<Node, Edge>();
		try {
			String currLine;
			int nbrNodes, nbrEdges;
			
			br = new BufferedReader(new FileReader(file));

			br.readLine(); // name
			currLine = br.readLine(); //nbrNodes
			nbrNodes = Integer.getInteger(currLine.split(" ")[2]);
			currLine = br.readLine(); //nbrNodes
			nbrEdges = Integer.getInteger(currLine.split(" ")[2]);
			currLine = br.readLine(); //maxTime
			maxTime = Integer.getInteger(currLine.split(" ")[2]);
			for (int i = 0; i < 5; i++) { //comments
				br.readLine();
			}
			for (int i = 0; i < nbrNodes; i++) { //nodes
				currLine = br.readLine();
				String[] parse = currLine.split(" ");
				graph.setNode(Integer.valueOf(parse[1]), new Node(Integer.valueOf(parse[4]),
								Double.valueOf(parse[5]), Double.valueOf(parse[6])));
			}
			for (int i = 0; i < 7; i++) { //comments
				br.readLine();
			}
			for (int i = 0; i < nbrEdges; i++) { //edges
				currLine = br.readLine();
				String[] parse = currLine.split(" ");
				graph.setEdge(Integer.valueOf(parse[2]), Integer.valueOf(parse[3]),
								new Edge(Integer.valueOf(parse[4]), Double.valueOf(parse[5]),
										Double.valueOf(parse[6]), Double.valueOf(parse[7])));
			}
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public long getComputationTime() {
		return computationTime;
	}

	public long getInitTime() {
		return initTime;
	}

	public long getImprovementTime() {
		return improvementTime;
	}
}
