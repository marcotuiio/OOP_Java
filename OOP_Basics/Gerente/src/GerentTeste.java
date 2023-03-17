
public class GerentTeste {

	public static void main(String[] args) {
		Gerente g1 = new Gerente("Brunao", 12000);
		Gerente g2 = new Gerente("Pedrao", 8900);

		System.out.println("Manager " + g1.getName() + " Payment = " + g1.getPayment());
		System.out.println("Manager " + g2.getName() + " Payment = " + g2.getPayment());
		
		g1.increasePayment();
		g2.increasePayment();
		System.out.println("\nManager " + g1.getName() + " Payment = " + g1.getPayment());
		System.out.println("Manager " + g2.getName() + " Payment = " + g2.getPayment());
		
		g1.increasePayment(25);
		g2.increasePayment(25);
		System.out.println("\nManager " + g1.getName() + " Payment = " + g1.getPayment());
		System.out.println("Manager " + g2.getName() + " Payment = " + g2.getPayment());
		 
	}

}
