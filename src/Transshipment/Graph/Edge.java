package Transshipment.Graph;

public class Edge {
	private final int capacity;
	private final double fixedCost, unitCost, travellingTime;
	private int nbrProduct;
	
	public Edge(int capacity, double fixedCost, double unitCost, double travellingTime) {
		this.capacity = capacity;
		this.fixedCost = fixedCost;
		this.unitCost = unitCost;
		this.travellingTime = travellingTime;
		nbrProduct = 0;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public double getFixedCost() {
		return fixedCost;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public double getTravellingTime() {
		return travellingTime;
	}

	public int getNbrProduct() {
		return nbrProduct;
	}
	
	public double getCost() {
		if (nbrProduct == 0)
			return 0;
		else
			return fixedCost + nbrProduct*unitCost;
	}
	
	public boolean setNbrProduct(int nbrProd) {
		if (nbrProd < capacity && nbrProd >= 0) {
			nbrProduct = nbrProd;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "products=" + nbrProduct + "/" + capacity + ";cost=" + getCost() 
				+ ";time=" + travellingTime + "\n";
	}
}