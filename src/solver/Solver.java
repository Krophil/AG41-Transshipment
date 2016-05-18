package solver;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Solver {
	private Graph<Node, Edge> graph;
	private int maxTime;
	private long computationTime, initTime, improvementTime, readingTime;

	public Solver() {
		maxTime = -1;
		graph = null;
		computationTime = -1;
		initTime = -1;
		improvementTime = -1;
	}

	public void solve(String problemFile, long computationTime) {
		this.computationTime = computationTime;
		long start = System.currentTimeMillis();

		System.out.println("READING FILE------------------------------------------------");
		loadProblemFile(problemFile);
		System.out.print(graph);
		readingTime = System.currentTimeMillis() - start;
		System.out.println("(reading time = " + readingTime + ")-----------------------------------------");
		
		System.out.println("FINDING AN INITIAL SOLUTION--------------------------------");
		//init solution ....
		//TODO
		
		initTime = System.currentTimeMillis() - start - readingTime;
		
		System.out.println("(init time = " + initTime + ")-------------------------------------------");
		System.out.println("IMPROVING SOLUTION------------------------------------------");
		while (System.currentTimeMillis() - start < computationTime) {
			//improving the solution ...
			//TODO
			// if finished -> break
		}
		
		improvementTime = System.currentTimeMillis() - start - initTime - readingTime;

		System.out.println("(improvement time = " + improvementTime + ")------------------------------------");
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
			nbrNodes = Integer.valueOf(currLine.split(" ")[2]);
			currLine = br.readLine(); //nbrNodes
			nbrEdges = Integer.valueOf(currLine.split(" ")[2]);
			currLine = br.readLine(); //maxTime
			maxTime = (Double.valueOf(currLine.split(" ")[2])).intValue();
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
	
	
	public long getReadingTime() {
		return readingTime;
	}
}
