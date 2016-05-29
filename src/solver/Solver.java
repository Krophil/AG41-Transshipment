package solver;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Solver {
	private Graph<Node, Edge> graph;
	private int maxTime;
	private long computationTime, initTime, improvementTime, readingTime;
	private LinkedList<Integer> oldPlatforms, leftPlatforms, rightPlatforms, suppliers, clients;
	private HashMap<Integer, Integer> platformMap;
	private double bestCost;
    private LinkedList<LinkedList<Integer>> cycles = new LinkedList<>();
    private long start = 0;
	
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
		bestCost = -1;
	}

	public double solve(String problemFile, long computationTime) {
		leftPlatforms = new LinkedList<>();
		rightPlatforms = new LinkedList<>();
		suppliers = new LinkedList<>();
		clients = new LinkedList<>();
		oldPlatforms = new LinkedList<>();
		platformMap = new HashMap<>();
		this.computationTime = computationTime;
		
		//starting time counter
		start = System.currentTimeMillis();

		//reading input file and building the corresponding graph
		System.out.println("READING FILE----------------------------------------------------------------");
		int k = loadProblemFile(problemFile);
		if (k == -2) {
			System.out.println("File structure problem");
			return -1;
		} else if (k == -1) {
			System.out.println("File reading problem");
			return -1;
		} else if (k != 0) {
			System.out.println("Total demand is not null");
			return -1;
		}
		//System.out.print(graph);
		readingTime = System.currentTimeMillis() - start;
		System.out.println("(reading time = " + readingTime + ")-------------------------------------------------------------");
		
		//build an initial solution. this step is always completed even it exceeds the time limit.
		System.out.println("FINDING AN INITIAL SOLUTION--------------------------------------------------");
        int leftdemand = fillEdges(separatePlatforms());
        System.out.println("Remaining demand not yet answered : " + leftdemand);
        leftdemand = maxFlow(leftdemand);
        if (leftdemand > 0) {
        	System.out.println("Cannot meet demand : unanswered demand : " + leftdemand);
        	return -1;
        }
        System.out.println("Total cost : " + getTotalCost());
		//TODO init solution ....
		initTime = System.currentTimeMillis() - start - readingTime;
		System.out.println("(init time = " + initTime + ")--------------------------------------------------------");
		
		//find a better solution as long as there is time left
		System.out.println("IMPROVING SOLUTION---------------------------------------------------------");


            //TODO improving the solution ...
            coutmin(computationTime-readingTime-initTime);


        improvementTime = System.currentTimeMillis() - start - initTime - readingTime;
		System.out.println("(improvement time = " + improvementTime / 60 + ")-----------------------------------------------");
		System.out.println("BEST SOLUTION------------------------------------------------------");
		double total = getTotalCost();
		System.out.println(total);
		bestCost = total;
		return total;
	}
	
	private void mergePlatforms() {
		for (int i : oldPlatforms) {
			graph.setNode(i, new Node(0, 0, 0));
			for (int sup : suppliers) {
				graph.setEdge(sup, i, 
						new Edge(-graph.getNode(sup).getDemand(), 0, 0, 0));
			}
			for (int cli : clients) {
				graph.setEdge(i, cli, 
						new Edge(graph.getNode(cli).getDemand(), 0, 0, 0));
			}
		}

		for(int i = 0; i < leftPlatforms.size(); i++) {
			int plt = graph.getInEdges(leftPlatforms.get(i)).getFirst();
			int flow = graph.getEdge(plt, leftPlatforms.get(i)).getNbrProduct();
			int newPlt = platformMap.get(leftPlatforms.get(i));
			graph.getEdge(plt, newPlt).setNbrProduct(
					graph.getEdge(plt, newPlt).getNbrProduct() + flow);
			graph.removeNode(leftPlatforms.get(i));
		}
		for(int i = 0; i < rightPlatforms.size(); i++) {
			int cli = graph.getOutEdges(rightPlatforms.get(i)).getFirst();
			int flow = graph.getEdge(rightPlatforms.get(i), cli).getNbrProduct();
			int newPlt = platformMap.get(rightPlatforms.get(i));
			graph.getEdge(newPlt, cli).setNbrProduct(
					graph.getEdge(newPlt, cli).getNbrProduct() + flow);
			graph.removeNode(rightPlatforms.get(i));
		}
	}
	
	public void saveSolution(String saveFile) {
		System.out.println("SAVING SOLUTION-----------------------------------------");
		mergePlatforms();
		BufferedWriter bw = null;
		try {
			
			File file = new File(saveFile);
			if (!file.exists()) {
				System.out.println("Creating file " + saveFile);
				file.createNewFile();
			} else
				System.out.println("File already exists\nWriting to " + saveFile);
			FileWriter fw = new FileWriter(saveFile);
			bw = new BufferedWriter(fw);
			
            bw.write("TOTAL TIME : " + Double.toString(((double) System.currentTimeMillis() - (double) start)/1000.0) + "s\n");
			bw.write("TOTAL COST : " + bestCost +"\n");
			
			bw.write("NODES :\n");
			
			for(int i : graph.getNodeKeys()) {
				bw.write(i + " : demand = " + graph.getNode(i).getDemand() + "\n");
			}
			

			bw.write("EDGES :\n");
			for(int i : graph.getNodeKeys()) {
				for(int j : graph.getNodeKeys()) {
					Edge e = graph.getEdge(i, j);
					if (e != null)
						bw.write(i + "->" + j+" : " + graph.getEdge(i, j).getNbrProduct() +
								"/" + graph.getEdge(i, j).getCapacity() + "\n");
				}
			}
		} catch (FileAlreadyExistsException x) {
			x.printStackTrace();
		} catch (IOException x) {
			x.printStackTrace();
		} finally {
			try {
				if (bw != null) 
					bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
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
			System.out.println("Loading nodes");
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
			System.out.println("Loading edges");
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
			e.printStackTrace();
			return -2;
		} catch (NullPointerException e) { 
			e.printStackTrace();
			return -2;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (br != null) 
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				return -1;
			}
		}
		return totalDemand;
	}

	private LinkedList<ArrayList<Integer>> separatePlatforms() {
		System.out.println("Separating platforms");
		LinkedList<ArrayList<Integer>> newEdges = new LinkedList<>();

        for (int n : oldPlatforms) {
            LinkedList<Integer> left = new LinkedList<>();
            LinkedList<Integer> right = new LinkedList<>();
            for (int s : graph.getInEdges(n)) {
				int v = graph.nextValidKey();
				leftPlatforms.add(v);
				graph.setNode(v, new Node(0, 0, 0)); // add a left platform
				graph.setEdge(s, v, new Edge(graph.getEdge(s, n))); // add an edge
				left.add(v);
            	platformMap.put(v, n);	
            }
            for(int c : graph.getOutEdges(n)) {
                int v = graph.nextValidKey();
                rightPlatforms.add(v);
                graph.setNode(v, new Node(0, 0, 0)); // add a right platform
                graph.setEdge(v, c, new Edge(graph.getEdge(n, c)));
                right.add(v);
            	platformMap.put(v, n);
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
            // System.out.println(n + " is now " + left + right);
        }
        
        return newEdges;
	}

	private int maxFlow(int demand) {
		System.out.println("FINDING AMELIORATING PATH :");
		if (demand != 0) {
			//init graph for max flow
			int source = graph.nextValidKey();
			graph.setNode(source, new Node(0, 0, 0));
			int sink = graph.nextValidKey();
			graph.setNode(sink, new Node(0, 0, 0));
			for (int sup : suppliers) {
				int dem = graph.getNode(sup).getDemand();
		        int out = 0;
		        for (int i : graph.getOutEdges(sup)) {
		        	out += graph.getEdge(sup, i).getNbrProduct();
		        }
				graph.setEdge(source, sup, new Edge(-dem, 0, 0, 0));
				graph.getEdge(source, sup).setNbrProduct(out);
			}
			for (int cli : clients) {
				int dem = graph.getNode(cli).getDemand();
				int in = 0;
		        for (int i : graph.getInEdges(cli)) {
		        	in += graph.getEdge(i, cli).getNbrProduct();
		        }
				graph.setEdge(cli, sink, new Edge(dem, 0, 0, 0));
				graph.getEdge(cli, sink).setNbrProduct(in);
			}
			
			//find an ameliorating path
			LinkedList<Integer> path = new LinkedList<>();
			Graph<Node, Edge> resGraph = getResidualGraph();
			do {
				path = flowDFS(source, sink, resGraph);
				if (!path.isEmpty()) { //modifying graph and residual graph
					int flow = getMaxCapacity(path, resGraph);
					System.out.println("Amelioration path for " + flow +" product(s) : " +path);
					for (int i = 0; i < path.size()-1; i++) {
						int a = path.get(i);
						int b = path.get(i+1);
						//set graph
						if (graph.containsEdge(a, b)) {
							graph.getEdge(a,b).setNbrProduct(graph.getEdge(a, b).getNbrProduct() + flow);
						} else {
							graph.getEdge(b,a).setNbrProduct(graph.getEdge(b, a).getNbrProduct() - flow);
						}
						//set residual graph
						if (resGraph.getEdge(a, b).getCapacity() - flow == 0)
							resGraph.removeEdge(a, b);
						else
							resGraph.getEdge(a,b).setCapacity(resGraph.getEdge(a, b).getCapacity() - flow);
						if (resGraph.containsEdge(b, a))
							resGraph.getEdge(b,a).setCapacity(resGraph.getEdge(b, a).getCapacity() + flow);
						else
							resGraph.setEdge(b, a, new Edge(flow, 0, 0, 0));
					}
					demand -= flow;
				}
			} while (!path.isEmpty() && demand != 0);
			
			//reverse graph to normal
			graph.removeNode(source);
			graph.removeNode(sink);
		}
		return demand;
	}
	
	public LinkedList<Integer> flowDFS(int source, int sink,
			Graph<Node, Edge> resGraph) {
		LinkedList<Integer> bestPath = new LinkedList<>();
			
		//init dfs
		Stack<LinkedList<Integer>> stack = new Stack<>();
		LinkedList<Integer> sourceList = new LinkedList<>();
		sourceList.add(source);
		stack.push(sourceList);
		
		//loop
		while (!stack.isEmpty()) {
			LinkedList<Integer> path = stack.pop();
			for (int next : resGraph.getOutEdges(path.getLast())) {
				LinkedList<Integer> tmpPath = new LinkedList<>(path);
				tmpPath.add(next);
				if (!path.contains(next)) {
					stack.push(tmpPath);
				}
				if (next == sink && (bestPath.isEmpty() ||
							getMaxCapacity(bestPath, resGraph) < getMaxCapacity(tmpPath, resGraph))) {
					bestPath = tmpPath;
				}
			}
		}
		return bestPath;
	}
	
    private int getPathCapacity(int a, int b, int c, int d) { //return the maximum capacity of the path
        int max = 0;
        int out = 0;
        for (int i : graph.getOutEdges(a)) {
        	out += graph.getEdge(a, i).getNbrProduct();
        }
        int in = 0;
        for (int i : graph.getInEdges(d)) {
        	in += graph.getEdge(i, d).getNbrProduct();
        }
        
        max = Math.min(graph.getEdge(a, b).getAvailableFlow(),
        			graph.getEdge(b, c).getAvailableFlow());
        max = Math.min(max, graph.getEdge(c, d).getAvailableFlow());
        max = Math.min(max, -out - graph.getNode(a).getDemand());
        max = Math.min(max, graph.getNode(d).getDemand() - in);
        return max;
    }

    private int getMaxCapacity(LinkedList<Integer> c, Graph<Node, Edge> g) {
        int max = Integer.MAX_VALUE;
        for(int i = 1 ; i<c.size() ; i++) {
            max = Math.min(max, g.getEdge(c.get(i-1),c.get(i)).getCapacity());
        }
        return max;
    }


    private double getPathCost(LinkedList<Integer> path, int i) {
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
    	System.out.println("Filling edges :");
    	int totalDemand = 0;
    	
    	for (Integer i : clients) {
			totalDemand += graph.getNode(i).getDemand();
		}
    	
    	System.out.println("total demand before filling : " + totalDemand);
    	for (ArrayList<Integer> p : platformEdges) {
    		if (totalDemand != 0) {
				int s = graph.getInEdges(p.get(0)).getFirst();
				int c = graph.getOutEdges(p.get(1)).getFirst();
				int maxFlow = getPathCapacity(s, p.get(0), p.get(1), c);
				if (maxFlow != 0) {
					//System.out.println("filling " + p.get(0) + "->" + p.get(1) + " with " + maxFlow + " product(s)");
					totalDemand -= maxFlow;
					graph.getEdge(s, p.get(0)).setNbrProduct(graph.getEdge(s, p.get(0)).getNbrProduct() + maxFlow);
					graph.getEdge(p.get(0), p.get(1)).setNbrProduct(graph.getEdge(p.get(0), p.get(1)).getNbrProduct() + maxFlow);
					graph.getEdge(p.get(1), c).setNbrProduct(graph.getEdge(p.get(1), c).getNbrProduct() + maxFlow);
				}
    		} else
    			break;
		}
    	
    	return totalDemand;    	
    }
    
    public Graph<Node, Edge> getResidualGraph() {
		Graph<Node, Edge> g = new Graph<>();
		
		for (int n : graph.getNodeKeys()) {
			g.setNode(n, graph.getNode(n));
		}
		
		for (int i : graph.getNodeKeys()) {
			for (int j : graph.getNodeKeys()) {
				if (graph.containsEdge(i, j)) {
					Edge e = graph.getEdge(i, j);
					if (e.getNbrProduct() > 0) {
						Edge opp = new Edge(e.getNbrProduct(), -e.getFixedCost(), 
											-e.getUnitCost(), -e.getTravellingTime());
						g.setEdge(j, i, opp);
					}
					if (e.getCapacity() > e.getNbrProduct()) {
						Edge rem = new Edge(e.getCapacity() - e.getNbrProduct(), e.getFixedCost(), 
								e.getUnitCost(), e.getTravellingTime());
						g.setEdge(i, j, rem);
					}
				}
			}
		}
		
		return g;
	}


    private void GraphCycles(Graph<Node,Edge> g) {
        LinkedList<Integer> visited = new LinkedList<>();
        LinkedList<Integer> candidates = new LinkedList<>();
        for(int v : g.getNodeKeys()){
            if(!visited.contains(v) && !candidates.contains(v))
                dfs(g, v, visited, candidates);
        }
    }

    private void dfs(Graph<Node, Edge> g, int v, LinkedList<Integer> visited, LinkedList<Integer> candidates) {
        candidates.add(v);
        for(int adj : g.getOutEdges(v)) {
            if(candidates.contains(adj)) {
                int i = v;
                LinkedList<Integer> c = new LinkedList<>();
                do {
                    c.add(i);
                    i = g.getNode(i).getParent();
                } while (i != adj);

                c.add(adj);
                c.add(c.getFirst());
                c = revertC(c);

                if(!sameCycles(c)) {
                    cycles.add(c);
                }
            } else {
                g.getNode(adj).setParent(v);
                dfs(g, adj, visited, candidates);
            }
        }
        candidates.remove(candidates.indexOf(v));
        visited.add(v);

    }

    private boolean sameCycles(LinkedList<Integer> a) {
        boolean hasall = true;
        for(LinkedList<Integer> b : cycles) {
            if(b.size() == a.size()) {
                boolean found = true;
                for (int it : a) {
                    if (!b.contains(it)) {
                        found = false;
                        break;
                    }
                }
                if (found)
                    return true;
            }
        }
        return false;
    }

    private LinkedList<Integer> revertC (LinkedList<Integer> c) {
        LinkedList<Integer> cp = new LinkedList<>();
        do {
            cp.addFirst(c.pop());
        } while (!c.isEmpty());
        return cp;
    }

    private void coutmin(long remTime) {
        Graph<Node,Edge> resid;
        int maxCap;
        double cost = 0;
        boolean negativeCost = true;
        long start = System.currentTimeMillis();
        while (negativeCost && (System.currentTimeMillis() - start < remTime)) {
            System.out.println("Current time : " + ((Double.toString((((double) System.currentTimeMillis() - (double) start)) / 1000.0))) + "s");
            resid = getResidualGraph();
            cycles.clear();
            GraphCycles(resid);
            negativeCost = false;
            for (LinkedList<Integer> c : cycles) {
                if (c.size() > 3) {
                    maxCap = getMaxCapacity(c, resid);
                    cost = 0;
					for (int i = 1; i < c.size(); i++) {

                        cost += resid.getEdge(c.get(i - 1), c.get(i)).getUnitCost() * maxCap; //add cost linked to products

                        if (resid.getEdge(c.get(i - 1), c.get(i)).getFixedCost() > 0) { //check if it is an add or a remove on the edge
                            if (graph.getEdge(c.get(i - 1), c.get(i)).getNbrProduct() == 0) //don't forget fixed cost to add if edge unused
                                cost += resid.getEdge(c.get(i - 1), c.get(i)).getFixedCost();
                        } else {
                            if (resid.getEdge(c.get(i - 1), c.get(i)).getCapacity() == maxCap)
                                cost += resid.getEdge(c.get(i - 1), c.get(i)).getFixedCost(); //remove fixed cost if we empty the edge
                        }
                    }

                    if (cost < 0) {
                        negativeCost = true;
                        for(int i = 1 ; i<c.size() ; i++) {
                            if(graph.containsEdge(c.get(i-1),c.get(i))) { //is it a residual edge or an edge from the usual graph
                                graph.getEdge(c.get(i-1), c.get(i)).setNbrProduct(graph.getEdge(c.get(i-1), c.get(i)).getNbrProduct()+maxCap);

                            } else { //if it is a residual edge
                                graph.getEdge(c.get(i), c.get(i-1)).setNbrProduct(graph.getEdge(c.get(i), c.get(i-1)).getNbrProduct()-maxCap);
                            }
                        }
						System.out.println("Better solution found : " + getTotalCost());
                        break;
                    }
                }
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
