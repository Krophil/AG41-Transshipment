package Solver;

import Transshipment.Graph.Graph;

public class Solver {
	private Graph graph;
	private long computationTime, initTime, improvementTime;
	
	public Solver(long computationTime) {
		this.computationTime = computationTime;
	}

	private void solve(String file) {
		long start = System.currentTimeMillis();
		
		readFile(file);
		//init problem ....
		
		initTime = System.currentTimeMillis() - start;
		start += initTime;
		
		while (System.currentTimeMillis() - start < computationTime) {
			//improving the solution ...
		}
		
		improvementTime = System.currentTimeMillis() - start;
		
		writeFile(file);
	}
	
	private void writeFile(String fileName) {
		
	}
	
	private void readFile(String fileName) {
		
	}
}
