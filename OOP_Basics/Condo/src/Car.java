
public class Car {
	private String model;
	private String brand;
	private int plate;
	private String color;
	
	public Car(String m, String b, int p, String c) {
		this.model = m;
		this.brand = b;
		this.plate = p;
		this.color = c;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public int getPlate() {
		return this.plate;
	}
	
	public String getColor() {
		return this.color;
	}
}

