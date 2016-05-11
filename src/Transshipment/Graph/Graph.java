package Transshipment.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph<Node, Edge> {
	private HashMap<Integer, Node> nodes;
	private HashMap<Integer, HashMap<Integer, Edge>> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashMap<>();
	}
	
	public Node getNode(int i) {
		return nodes.get(i);
	}
	
	public ArrayList<Edge> getOutEdges(int i) {
		return new ArrayList<Edge>(edges.get(i).values());
	}
	
	public LinkedList<Edge> getInEdges(int i) {
		LinkedList<Edge> ed = new LinkedList<>();
		for (int n : nodes.keySet()) {
			Edge e = edges.get(n).get(i);
			if (e != null)
				ed.add(e);
		}
		return ed;
	}
	
	public Edge getEdge(int i,  int j) {
		if (edges.get(i) != null) {
			return edges.get(i).get(j);
		}
		return null;	
	}
	
	public boolean addNode(int i, Node n) {
		if (!nodes.containsKey(i)) {
			nodes.put(i, n);
			edges.put(i, new HashMap<Integer, Edge>());
			return true;
		}
		return false;
	}
	
	public boolean addEdge(int i, int j, Edge e) {
		if (nodes.containsKey(i) && nodes.containsKey(j) && !edges.get(i).containsKey(j)) {
			edges.get(i).put(j, e);
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
		if (nodes.containsKey(i)) {
			nodes.remove(i);
			for (int n : nodes.keySet()) {
				edges.get(n).remove(i);
			}
			edges.remove(i);
			return true;
		}
		return false;
	}
}
