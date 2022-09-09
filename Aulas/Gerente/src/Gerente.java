
public class Gerente {
	private double payment = 5500.00;
	private String managerName;
	
	public Gerente(String n, double p) {
		this.managerName = n;
		this.payment = p;
	}
	
	public double getPayment() {
		return payment;
	}
	
	public void increasePayment() { // aumento fixo de 10% 
		double add = payment/100 * 10;
		payment = payment + add;
	}
	
	public void increasePayment(double i) {
		double add = payment/100 * i;
		payment = payment + add;
	}

	public String getName() {
		return managerName;
	}
}
