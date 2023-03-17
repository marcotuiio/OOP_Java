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
	
	public double getPriceLiter(int c, int l) {
		ArrayList<Fuel> a = this.getFuel();
		Fuel f = a.get(c);
		double p = f.getPrice();
		double bill = p * l;
		return bill;
	}
	
	public double getLiterPrice(int c, int bill) {
		ArrayList<Fuel> a = this.getFuel();
		Fuel f = a.get(c);
		double price = f.getPrice();
		double litro = bill / price;
		return litro;
	}
}

	