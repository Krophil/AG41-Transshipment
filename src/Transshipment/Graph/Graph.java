package Transshipment.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph<N, E> {
	private HashMap<Integer, N> nodes;
	private HashMap<Integer, HashMap<Integer, E>> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashMap<>();
	}
	
	public N getNode(int i) {
		return nodes.get(i);
	}
	
	public ArrayList<E> getOutEdges(int i) {
		return new ArrayList<E>(edges.get(i).values());
	}
	
	public LinkedList<E> getInEdges(int i) {
		LinkedList<E> ed = new LinkedList<>();
		for (int n : nodes.keySet()) {
			E e = edges.get(n).get(i);
			if (e != null)
				ed.add(e);
		}
		return ed;
	}
	
	public E getEdge(int i,  int j) {
		if (edges.get(i) != null) {
			return edges.get(i).get(j);
		}
		return null;	
	}
	
	public boolean addNode(int i, N n) {
		if (!nodes.containsKey(i)) {
			nodes.put(i, n);
			edges.put(i, new HashMap<Integer, E>());
			return true;
		}
		return false;
	}
	
	public boolean addEdge(int i, int j, E e) {
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
