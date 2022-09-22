import java.util.ArrayList;

public class Bomba {
	private int id;
	private ArrayList<Fuel> fuels = new ArrayList<Fuel>();
	
	public Bomba(int i) {
		this.id = i;
	}
	
	public void addFuel(String type, double price) {
		Fuel f = new Fuel(type, price);
		this.fuels.add(f);
	}
	
	public int getId() {
		return this.id;
	}
	
	public ArrayList<Fuel> getFuel() {
		return this.fuels;
	}
}

	