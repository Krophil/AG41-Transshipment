package solver;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class Solver {
	private Graph<Node, Edge> graph;
	private int maxTime;
	private long computationTime, initTime, improvementTime, readingTime;
	private LinkedList<Integer> oldPlatforms, leftPlatforms, rightPlatforms, suppliers, clients;
	
	public Solver() {
		maxTime = -1;
		graph = new Graph<>();
		computationTime = -1;
		initTime = -1;
		improvementTime = -1;
		readingTime = -1;
		leftPlatforms = new LinkedList<>();
		rightPlatforms = new LinkedList<>();
		suppliers = new LinkedList<>();
		clients = new LinkedList<>();
		oldPlatforms = new LinkedList<>();
	}

	public void solve(String problemFile, long computationTime) {
		leftPlatforms = new LinkedList<>();
		rightPlatforms = new LinkedList<>();
		suppliers = new LinkedList<>();
		clients = new LinkedList<>();
		oldPlatforms = new LinkedList<>();
		this.computationTime = computationTime;
		
		//starting time counter
		long start = System.currentTimeMillis();

		//reading input file and building the corresponding graph
		System.out.println("READING FILE------------------------------------------------");
		loadProblemFile(problemFile);
		System.out.print(graph);
		readingTime = System.currentTimeMillis() - start;
		System.out.println("(reading time = " + readingTime + ")-----------------------------------------");
		
		//build an initial solution. this step is always completed even it exceeds the time limit.
		System.out.println("FINDING AN INITIAL SOLUTION--------------------------------");
        separatePlatforms();

		//TODO init solution ....
		initTime = System.currentTimeMillis() - start - readingTime;
		System.out.println("(init time = " + initTime + ")-------------------------------------------");
		
		//find a better solution as long as there is time left
		System.out.println("IMPROVING SOLUTION------------------------------------------");
		while (System.currentTimeMillis() - start < computationTime) {
			//TODO improving the solution ...
		}
		improvementTime = System.currentTimeMillis() - start - initTime - readingTime;
		System.out.println("(improvement time = " + improvementTime + ")------------------------------------");
	}
	
	public void saveSolution(String saveFile) {
		//TODO
	}
	
	private void loadProblemFile(String file) {
		BufferedReader br = null;
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
				int index = Integer.valueOf(parse[1]);
				int demand = graph.getNode(Integer.valueOf(parse[1])).getDemand();
				if (demand > 0)
					clients.add(index);
				else if (demand < 0)
					suppliers.add(index);
				else
					oldPlatforms.add(index);
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
			System.out.println("Problem file structure is not respected.");
			e.printStackTrace();
		} catch (NullPointerException e) { 
			System.out.println("Problem file structure is not respected.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) 
					br.close();
				else
					System.out.println("Problem file does not exist.");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void separatePlatforms() {
        for (int n : oldPlatforms) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            for (int s : suppliers) {
				if(graph.getEdge(s,n).getCapacity() != 0) {
					int v = graph.nextValidKey();
					leftPlatforms.add(v);
					graph.setNode(v, new Node(0, 0, 0)); // add a left platform
					System.out.println(s + "->" + v + "\n");
					graph.setEdge(s, v, new Edge(graph.getEdge(s, n))); // add an edge
					left.add(v);
				}
            }

            System.out.println(clients);
            for(int c : clients) {
                if(graph.getEdge(n,c).getCapacity() != 0) {
                    int v = graph.nextValidKey();
                    System.out.println(v + "->" + c);
                    System.out.println(n);
                    rightPlatforms.add(v);
                    graph.setNode(v, new Node(0, 0, 0)); // add a right platform
                    graph.setEdge(v, c, new Edge(graph.getEdge(n, c)));
                    right.add(v);
                }
            }
            for(int l : left) {
                for(int r : right) {
                    graph.setEdge(l, r, new Edge(Integer.MAX_VALUE, 0, graph.getNode(n).getUnitCost(), graph.getNode(n).getTransboardingTime()));
                    int sup = graph.getInEdges(l).getFirst(); //get the supplier
                    int cl = graph.getOutEdges(r).getFirst(); //get the client
                    if(getTime(graph, sup, l, r, cl) > maxTime) { //test travelling + transboarding time between the two nodes
                        graph.removeNode(l);
                        graph.removeNode(r);
                    }

                }
            }
            graph.removeNode(n);
        }

        System.out.println(leftPlatforms);
        System.out.println(graph);

	}



    private int getCap(Graph g, int a, int b, int c, int d) { //get capacity and return the minimum maximum capacity of the path
        int max = 0;
        if(g.getInEdges(b) != null)
            max = ((Edge) g.getEdge(a,b)).getCapacity();
        max = (g.getInEdges(c) != null && ((Edge) g.getEdge(b,c)).getCapacity() < max ? ((Edge) g.getEdge(b,c)).getCapacity() : max); //version ternaire

        if(g.getInEdges(d) != null && ((Edge)g.getEdge(c,d)).getCapacity() < max)
            max = ((Edge)g.getEdge(c,d)).getCapacity(); // version normale

        return max;
    }

    private double getTime(Graph g, int a, int b, int c, int d) { //return time of a path
        return ((Edge)g.getEdge(a,b)).getTravellingTime() + ((Edge)g.getEdge(b,c)).getTravellingTime() + ((Edge)g.getEdge(c,d)).getTravellingTime();
    }


    private void fordfulk () { //https://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
        int s = 0;
        int t = graph.nextValidKey();
        graph.setNode(s, new Node(0,0,0));
        graph.setNode(t, new Node(0,0,0));
        for(int n : suppliers)
            graph.setEdge(s, n, new Edge(-(graph.getNode(n).getDemand()), 0, 0, 0));

        for(int n : clients)
            graph.setEdge(n, t, new Edge(graph.getNode(n).getDemand(), 0, 0, 0));
        Graph resid = graph.getResidualGraph();


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
