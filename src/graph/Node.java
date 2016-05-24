package graph;

public class Node {
	private int demand;
	private final double unitCost, transboardingTime;

	public Node(int demand, double unitCost, double transboardingTime) {
		this.demand = demand;
		this.unitCost = unitCost;
		this.transboardingTime = transboardingTime;
	}

	public int getDemand() {
		return demand;
	}
	
	public void setDemand(int d) {
		demand = d;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public double getTransboardingTime() {
		return transboardingTime;
	}
	
	public String toString() {
		return "demand=" + demand + ";unit cost=" + unitCost 
				+ ";time=" + transboardingTime + "\n";
	}
}
