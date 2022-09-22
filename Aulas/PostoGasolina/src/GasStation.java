
public class GasStation {

	public static void main(String[] args) {
		Bomba b1 = new Bomba(1);
		Bomba b2 = new Bomba(2);
		
		b1.addFuel("Diesel", 6.33);
		b1.addFuel("Gasolina", 3.29);
		
		b2.addFuel("Etanol", 2.87);
		b2.addFuel("GNV", 4.25);
		
		System.out.printf("Bomba 1 opções de compustivel:\n");
		System.out.printf("0 - %s %.2f\n", b1.getFuel().get(0).getType(), b1.getFuel().get(0).getPrice());
		System.out.printf("1 - %s %.2f\n", b1.getFuel().get(1).getType(), b1.getFuel().get(1).getPrice());
		
		System.out.printf("\nBomba 2 opções de compustivel:\n");
		System.out.printf("0 - %s %.2f\n", b2.getFuel().get(0).getType(), b1.getFuel().get(0).getPrice());
		System.out.printf("1 - %s %.2f\n", b2.getFuel().get(1).getType(), b1.getFuel().get(1).getPrice());
	}

}
