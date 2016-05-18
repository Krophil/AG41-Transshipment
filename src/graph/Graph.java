package graph;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph<N, E> {
	private HashMap<Integer, N> nodes;
	private HashMap<Integer, HashMap<Integer, E>> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashMap<>();
	}
	
	public int getNbrNodes() {
		return nodes.size();
	}
	
	public int getNbrEdges() {
		int nbr = 0;
		for (int i : nodes.keySet()) {
			nbr += edges.get(i).size();
		}
		return nbr;
	}
	
	public N getNode(int i) {
		return nodes.get(i);
	}
	
	public E getEdge(int i,  int j) {
		if (nodes.containsKey(i)) {
			return edges.get(i).get(j);
		}
		return null;	
	}
	
	public LinkedList<E> getOutEdges(int i) {
		if (nodes.containsKey(i)) {
			return new LinkedList<E>(edges.get(i).values());
		}
		return null;
	}
	
	public LinkedList<E> getInEdges(int i) {
		if (nodes.containsKey(i)) {
			LinkedList<E> ed = new LinkedList<>();
			for (int n : nodes.keySet()) {
				E e = edges.get(n).get(i);
				if (e != null)
					ed.add(e);
			}
			return ed;
		}
		return null;
	}
	
	public void setNode(int i, N n) {
		if (!nodes.containsKey(i)) {
			edges.put(i, new HashMap<Integer, E>());
		}
		nodes.put(i, n);
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
	
	public boolean setEdge(int i, int j, E e) {
		if (nodes.containsKey(i) && nodes.containsKey(j)) {
			edges.get(i).put(j, e);
			return true;
		}
		return false;
	}
	
	public void removeEdge(int i, int j) {
		if (nodes.containsKey(i)) {
			edges.get(i).remove(j);
		}
	}

	public boolean containsNode(int i) {
		return nodes.containsKey(i);
	}
	
	public boolean containsEdge(int i, int j) {
		return edges.containsKey(i) && edges.get(i).containsKey(j);
	}
	
	//TODO inverse graph
	
	public String toString() {
		String s = "NODES :\n";
		for (N n : nodes.values()) {
			s += n;
		}
		s+= "EDGES :\n";
		for (int i : nodes.keySet()) {
			for (int j : edges.get(i).keySet()) {
				s += i + "->" + j + " : " + edges.get(i).get(j);
			}
		}		
		return s;
	}
}
