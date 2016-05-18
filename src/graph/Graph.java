package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.lang.Math;

public class Graph<N, E extends EdgeType> {
	private HashMap<Integer, N> nodes;
	private HashMap<Integer, HashMap<Integer, E>> edges;
	private int counter;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashMap<>();
		counter = 0;
	}
	
	public int getNbrNodes() {
		return nodes.size();
	}
	
	public LinkedList<Integer> getNodeKeys() {
		return new LinkedList<Integer>(nodes.keySet());
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
	
	public int addNode(N n) {
		edges.put(counter++, new HashMap<Integer, E>());
		nodes.put(counter-1, n);
		return counter-1;
	}
	
	public boolean setNode(int i, N n) {
		if (nodes.containsKey(i)) {
			nodes.put(i, n);
			return true;
		} else
			return false;
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
	
	public Graph<N, E> getResidualGraph() {
		Graph<N, E> g = new Graph<>();
		int ind = 0;
		
		for (N n : nodes.values()) {
			g.setNode(ind++, n);
		}
		
		for (int i : nodes.keySet()) {
			for (int j : nodes.keySet()) {
				E e = getEdge(i, j);
				if (e != null) {
					E opp = (E) e.getOpposite();
					E rem = (E) e.getRemaining();
					if (opp != null)
						g.setEdge(j, i, opp);
					if (rem != null)
						g.setEdge(i, j, rem);
				}
			}
		}
		
		return g;
	}
	
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
