package Transshipment.Graph;

public class Node {
	private final int demand, unitCost, tranbordingTime;

	public Node(int demand, int unitCost, int tranbordingTime) {
		this.demand = demand;
		this.unitCost = unitCost;
		this.tranbordingTime = tranbordingTime;
	}

	public int getDemand() {
		return demand;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public int getTranbordingTime() {
		return tranbordingTime;
	}
}
