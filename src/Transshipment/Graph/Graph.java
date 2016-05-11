package Transshipment.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private LinkedList<Integer> nodes;
	private HashMap<Integer, HashMap<Integer, Edge>> edges;
	private static int nodeIndex = 0;
	
	public Graph() {
		nodes = new LinkedList<>();
		edges = new HashMap<>(0);
	}
	
	public boolean containsNode(int i) {
		return nodes.contains(i);
	}
	
	public ArrayList<Edge> getOutEdges(int i) {
		return new ArrayList<Edge>(edges.get(i).values());
	}
	
	public ArrayList<Edge> getInEdges(int i) {
		ArrayList<Edge> ed = new ArrayList<>(0);
		for (int n : nodes) {
			Edge e = edges.get(n).get(i);
			if (e != null)
				ed.add(e);
		}
		return ed;
	}
	
	public int getEdgeCost(int i,  int j) {
		if (edges.get(i) != null) {
			return edges.get(i).get(j).getCost();
		}
		return -1;		
	}
	
	public void setEdgeCost(int i, int j, int cost) {
		if (edges.get(i) != null) {
			edges.get(i).get(j).setCost(cost);
		}
	}
	
	public int addNode() {
		nodes.add(nodeIndex++);
		return nodeIndex - 1;
	}
	
	public boolean addEdge(int i, int j, int cost) {
		if (nodes.contains(i) && nodes.contains(j) && !edges.get(i).containsKey(j)) {
			edges.get(i).put(j, new Edge(i, j, cost));
			return true;
		}
		return false;
	}
	
	public void removeEdge(int i, int j) {
		if (edges.get(i) != null) {
			edges.get(i).remove(j);
		}
	}
	
	public boolean removeNode(int i) {
		if (nodes.contains(i)) {
			nodes.remove((Integer)i);
			for (Edge e : getInEdges(i)) {
				edges.get(e.getStart()).remove(e.getEnd());
			}
			for (Edge e : getOutEdges(i)) {
				edges.get(e.getStart()).remove(e.getEnd());
			}
			return true;
		}
		return false;
	}
	
	private class Edge {
		private final int start;
		private final int end;
		private int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		public int getStart() {
			return start;
		}
		
		public int getEnd() {
			return end;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}
}
