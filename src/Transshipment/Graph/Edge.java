package Transshipment.Graph;

public class Edge {
	private final int capacity, fixedCost, unitCost, travellingTime;
	private int nbrProduct;
	
	public Edge(int capacity, int fixedCost, int unitCost, int travellingTime) {
		super();
		this.capacity = capacity;
		this.fixedCost = fixedCost;
		this.unitCost = unitCost;
		this.travellingTime = travellingTime;
		nbrProduct = 0;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public int getFixedCost() {
		return fixedCost;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public int getTravellingTime() {
		return travellingTime;
	}

	public int getNbrProduct() {
		return nbrProduct;
	}
	
	public int getCost() {
		if (nbrProduct == 0)
			return 0;
		else
			return fixedCost + nbrProduct*unitCost;
	}
	
	public boolean setNbrProduct(int nbrProd) {
		if (nbrProd < capacity) {
			nbrProduct = nbrProd;
			return true;
		}
		return false;
	}
	
}