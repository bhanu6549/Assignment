package entity;

public class Furniture {
	private String name;
	private double cost;
	private int quantity;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Furniture(String name, double cost, int quantity, int id) {
		super();
		this.name = name;
		this.cost = cost;
		this.quantity = quantity;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Furniture [name=" + name + ", cost=" + cost + ", quantity=" + quantity + "]";
	}

}
