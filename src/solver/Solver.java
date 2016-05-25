package solver;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Solver {
	private Graph<Node, Edge> graph;
	private int maxTime;
	private long computationTime, initTime, improvementTime, readingTime;
	private LinkedList<Integer> oldPlatforms, leftPlatforms, rightPlatforms, suppliers, clients;
	private HashMap<Integer, Integer> platformMap;
	
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
		platformMap = new HashMap<>();
	}

	public void solve(String problemFile, long computationTime) {
		leftPlatforms = new LinkedList<>();
		rightPlatforms = new LinkedList<>();
		suppliers = new LinkedList<>();
		clients = new LinkedList<>();
		oldPlatforms = new LinkedList<>();
		platformMap = new HashMap<>();
		this.computationTime = computationTime;
		
		//starting time counter
		long start = System.currentTimeMillis();

		//reading input file and building the corresponding graph
		System.out.println("READING FILE------------------------------------------------");
		if (loadProblemFile(problemFile) != 0) {
			System.out.println("Total demand is not null, the problem is not feasable.");
			return;
		}
		//System.out.print(graph);
		readingTime = System.currentTimeMillis() - start;
		System.out.println("(reading time = " + readingTime + ")-----------------------------------------");
		
		//build an initial solution. this step is always completed even it exceeds the time limit.
		System.out.println("FINDING AN INITIAL SOLUTION--------------------------------");
        int leftdemand = fillEdges(separatePlatforms());
        System.out.println("Remaining demand not yet answered : " + leftdemand);
        System.out.println("Total cost : " + getTotalCost());
        //System.out.print(graph);
		//TODO init solution ....
		initTime = System.currentTimeMillis() - start - readingTime;
		System.out.println("(init time = " + initTime + ")-------------------------------------------");
		
		//find a better solution as long as there is time left
		System.out.println("IMPROVING SOLUTION------------------------------------------");

        fordfulk();
        while (System.currentTimeMillis() - start < computationTime) {
            //TODO improving the solution ...
		}

        improvementTime = System.currentTimeMillis() - start - initTime - readingTime;
		System.out.println("(improvement time = " + improvementTime + ")------------------------------------");
	}
	
	public void saveSolution(String saveFile) {
		//TODO
	}
	
	private int loadProblemFile(String file) {
		BufferedReader br = null;
		int totalDemand = 0;
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
				int demand = graph.getNode(index).getDemand();
				totalDemand += demand;
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
				if (Integer.valueOf(parse[4]) > 0) { //checking positivity of the edge capacity
					graph.setEdge(Integer.valueOf(parse[2]), Integer.valueOf(parse[3]),
								new Edge(Integer.valueOf(parse[4]), Double.valueOf(parse[5]),
										Double.valueOf(parse[6]), Double.valueOf(parse[7])));
				}
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
		return totalDemand;
	}

	private LinkedList<ArrayList<Integer>> separatePlatforms() {
		System.out.println("SEPARATING PLATFORMS :");
		LinkedList<ArrayList<Integer>> newEdges = new LinkedList<>();
		int test0 = 0, test1 = 0;
		
        for (int n : oldPlatforms) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            for (int s : graph.getInEdges(n)) {
				if(graph.containsEdge(s, n)) {
					int v = graph.nextValidKey();
					leftPlatforms.add(v);
					graph.setNode(v, new Node(0, 0, 0)); // add a left platform
					graph.setEdge(s, v, new Edge(graph.getEdge(s, n))); // add an edge
					left.add(v);
	            	platformMap.put(v, n);
				}
            }
            for(int c : graph.getOutEdges(n)) {
                if(graph.containsEdge(n, c)) {
                    int v = graph.nextValidKey();
                    rightPlatforms.add(v);
                    graph.setNode(v, new Node(0, 0, 0)); // add a right platform
                    graph.setEdge(v, c, new Edge(graph.getEdge(n, c)));
                    test0 = v;
                    test1 = c;
                    right.add(v);
                	platformMap.put(v, n);
                }
            }
            for(int l : left) {
                for(int r : right) {
                    graph.setEdge(l, r, new Edge(Integer.MAX_VALUE, 0, graph.getNode(n).getUnitCost(), graph.getNode(n).getTransboardingTime()));
                    int maxFlow = getPathCapacity(graph.getInEdges(l).getFirst(),
                    		l, r, graph.getOutEdges(r).getFirst());
                    graph.getEdge(l, r).setCapacity(maxFlow);
                    int sup = graph.getInEdges(l).getFirst(); //get the supplier
                    int cl = graph.getOutEdges(r).getFirst(); //get the client
                    if(getTime(sup, l, r, cl) > maxTime) { //test travelling + transboarding time between the two nodes
                    	graph.removeNode(l);
                        graph.removeNode(r);
                    } else {
                    	newEdges.add(new ArrayList<Integer>(2));
                    	newEdges.getLast().add(0, l);
                    	newEdges.getLast().add(1, r);
                    }
                }
            }
            graph.removeNode(n);
            System.out.println(n + " is now " + left + right);
        }
        
        return newEdges;
	}

    private int getPathCapacity(int a, int b, int c, int d) { //return the maximum capacity of the path
        int max = 0;
        
        max = Math.min(graph.getEdge(a, b).getAvailableFlow(),
        			graph.getEdge(b, c).getAvailableFlow());
        max = Math.min(max, graph.getEdge(c, d).getAvailableFlow());
        max = Math.min(max, -graph.getNode(a).getDemand());
        max = Math.min(max, graph.getNode(d).getDemand());
        
        return max;
    }

    private double getPathCost(List<Integer> path, int i) {
        int sum = 0;
        for(int j = 0 ; j < path.size()-2 ; j++)
            sum += graph.getEdge(path.get(j), path.get(j+1)).getUnitCost()*i + graph.getEdge(path.get(j), path.get(j+1)).getCost();
        return sum;
    }

    private double getTime(int a, int b, int c, int d) { //return time of a path
        return graph.getEdge(a,b).getTravellingTime() + graph.getEdge(b,c).getTravellingTime() + graph.getEdge(c,d).getTravellingTime();
    }
    
    public double getTotalCost() {
    	double total = 0;
    	
    	for (Integer i : graph.getNodeKeys()) {
    		for (Integer j : graph.getNodeKeys()) {
        		if (graph.containsEdge(i, j)) {
        			total += graph.getEdge(i, j).getCost();
        		}
        	}
    	}
    	
    	return total;
    }
    
    private int fillEdges(LinkedList<ArrayList<Integer>> platformEdges) { //initial solution for Ford-Fulkerson
    	System.out.println("FILLING GRAPH FLOW :");
    	int totalDemand = 0;
    	
    	for (Integer i : clients) {
			totalDemand += graph.getNode(i).getDemand();
		}
    	
    	System.out.println("total demand before filling : " + totalDemand);
    	System.out.println("filling ...");
    	for (ArrayList<Integer> p : platformEdges) {
			int s = graph.getInEdges(p.get(0)).getFirst();
			int c = graph.getOutEdges(p.get(1)).getFirst();
			int maxFlow = getPathCapacity(s, p.get(0), p.get(1), c);
			if (maxFlow != 0) {
				totalDemand -= maxFlow;
				graph.getEdge(s, p.get(0)).setNbrProduct(graph.getEdge(s, p.get(0)).getNbrProduct() + maxFlow);
				graph.getEdge(p.get(0), p.get(1)).setNbrProduct(graph.getEdge(p.get(0), p.get(1)).getNbrProduct() + maxFlow);
				graph.getEdge(p.get(1), c).setNbrProduct(graph.getEdge(p.get(1), c).getNbrProduct() + maxFlow);
				graph.getNode(s).setDemand(graph.getNode(s).getDemand() + maxFlow);
				graph.getNode(c).setDemand(graph.getNode(c).getDemand() - maxFlow);
			}
		}
    	
    	return totalDemand;    	
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
        Graph<Node, Edge> resid = graph.getResidualGraph();
        graph.getResidualEdges();
        LinkedList<Integer> d = new LinkedList<>();
        cycleDfs(graph, s);
        System.out.println(d);
    }

	private LinkedList<LinkedList<Integer>> cycleDfs(Graph<Node, Edge> g, int v) {
        LinkedList<Integer> d = new LinkedList<>(); //d for discovered
        Stack<Integer> s = new Stack<>();
        LinkedList<LinkedList<Integer>> cycles = new LinkedList<>();
        s.push(v);
        int o;
        while (!s.isEmpty()) {
            v = s.pop();
            System.out.println("in my stack, I have... " + v);
            if (!d.contains(v)) { //simple dfs
                d.add(v);
                for (int w : graph.getOutEdges(v)) {
                    //System.out.println(w);
                    s.push(w);
                    System.out.println("Out edges of " + v + " : " + w);
                }
            } else { //part added to register cycles
                LinkedList<Integer> c = new LinkedList<>();
                if (v != 0) {
                    o = d.getLast();
                    System.out.println(s);
                    System.out.println(d);
                    System.out.println("v = " + v);
                    System.out.println("beginning of my cycle : " + o);
                    c.add(o);
                    int i = d.size()-2; //because the last one of d is already in c
                    while (o != v) {
                        o = d.get(i);
                        System.out.println(d.get(i));
                        c.add(o);
                        i--;
                    }
                    cycles.add(c); //c added to the linked list of cycles
                    System.out.println(cycles);
                }
            }

        }
        return cycles;
    }

    private void coutmin(Graph<Node, Edge> g) {
        int s = 0;
        int t = graph.nextValidKey();
        LinkedList<LinkedList<Integer>> cycles = new LinkedList<>();

        graph.setNode(s, new Node(0,0,0)); //source
        graph.setNode(t, new Node(0,0,0)); //target
        for(int n : suppliers)
            graph.setEdge(s, n, new Edge(-(graph.getNode(n).getDemand()), 0, 0, 0));

        for(int n : clients)
            graph.setEdge(n, t, new Edge(graph.getNode(n).getDemand(), 0, 0, 0));

        graph.getResidualEdges(); // residual edges added directly in the graph


        int i = 1;
        double min = Double.POSITIVE_INFINITY;
        LinkedList<Integer> bPath = new LinkedList<>();

        //Calculate Graph for a translation of i products
        for(int a : g.getOutEdges(0)) {
            for(int b : g.getOutEdges(a)) {
                for(int c : g.getOutEdges(b)) {
                    for(int d : g.getOutEdges(c)) {
                        List<Integer> l = Arrays.asList(a,b,c,d);
                        double test = getPathCost(l,i);
                        if(min>test) {
                            min = test;
                            if(!bPath.isEmpty())
                                bPath.removeAll(bPath);
                            bPath.addAll(Arrays.asList(a,b,c,d)); //register the best path for optimization
                        }
                    }
                }
            }
        }

        //Search of negative cycle
        cycles = cycleDfs(g, s); //every cycle in cycles
        for(LinkedList<Integer> c : cycles) {
            //List<Integer> C = new ArrayList<String>(c);
            //if(getPathCost(C), i);
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
