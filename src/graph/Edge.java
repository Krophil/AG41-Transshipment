package graph;

public class Edge implements EdgeType {
	private int capacity;
	private final double fixedCost, unitCost, travellingTime;
	private int nbrProduct;
	
	public Edge(int capacity, double fixedCost, double unitCost, double travellingTime) {
		this.capacity = capacity;
		this.fixedCost = fixedCost;
		this.unitCost = unitCost;
		this.travellingTime = travellingTime;
		nbrProduct = 0;
	}

	public Edge(Edge e) {
        this.capacity = e.getCapacity();
        this.fixedCost = e.getFixedCost();
        this.unitCost = e.getUnitCost();
        this.travellingTime = e.getTravellingTime();
        this.nbrProduct = 0;
    }
	
	public int getAvailableFlow() {
		return capacity - nbrProduct;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int c) {
		capacity = c;
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
				+ "(" + fixedCost + " + x" + unitCost + ")" + ";time=" + travellingTime + "\n";
	}
	
	@Override
	public Edge getOpposite() {
		if (nbrProduct == 0)
			return null;
		else {
			return new Edge(nbrProduct, -fixedCost, -unitCost, -travellingTime);
		}
	}

	@Override
	public EdgeType getRemaining() {
		if (capacity == nbrProduct)
			return null;
		else {
			return new Edge(capacity - nbrProduct, fixedCost, unitCost, travellingTime);
		}
	}
}