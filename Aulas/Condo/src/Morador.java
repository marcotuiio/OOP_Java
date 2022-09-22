import java.util.ArrayList;

public class Morador {
	private String name;
	private int apto;
	private ArrayList<Car> carro = new ArrayList<Car>();
		
	public Morador (String n, int a) {
		this.name = n;
		this.apto = a;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getApto() {
		return this.apto;
	}
	
	public void setCar(Car c1) {
		this.carro.add(c1);
	}
	
	public Car getCar(int vaga) {
		return this.carro.get(vaga);
	}
}