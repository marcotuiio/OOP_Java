import java.util.Scanner;

public class GasStation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Bomba b1 = new Bomba(1);
		Bomba b2 = new Bomba(2);
		
		b1.addFuel("Diesel", 6.33);
		b1.addFuel("Gasolina", 3.29);
		
		b2.addFuel("Etanol", 2.87);
		b2.addFuel("GNV", 4.25);
		
		System.out.printf("Bomba 1 opções de compustivel:\n");
		System.out.printf("Código 0 - %s %.2f\n", b1.getFuel().get(0).getType(), b1.getFuel().get(0).getPrice());
		System.out.printf("Código 1 - %s %.2f\n", b1.getFuel().get(1).getType(), b1.getFuel().get(1).getPrice());
		
		System.out.printf("\nBomba 2 opções de combustível:\n");
		System.out.printf("Código 0 - %s %.2f\n", b2.getFuel().get(0).getType(), b2.getFuel().get(0).getPrice());
		System.out.printf("Código 1 - %s %.2f\n", b2.getFuel().get(1).getType(), b2.getFuel().get(1).getPrice());
		
		System.out.printf("\nEscolha qual bomba deseja utilizar: \n");
		int e = input.nextInt();

		System.out.printf("Informe quantos litros e o código do combustível desejado: \n");
		int l = input.nextInt();
		int c = input.nextInt();
		
		switch (e) {
			case 1:
				System.out.printf("\n--> %d litros de %s = R$ %.2f", l, b1.getFuel().get(c).getType(), b1.getPriceLiter(c, l));
				break;
				
			case 2:
				System.out.printf("\n--> %d litros de %s = R$ %.2f", l, b2.getFuel().get(c).getType(), b2.getPriceLiter(c, l));
				break;
				
			default:
				break;
				
		}
		
		System.out.printf("\n\nEscolha qual bomba deseja utilizar: \n");
		e = input.nextInt();
		
		System.out.printf("Informe quantos reais e o código do combustível desejado: \n");
		int r = input.nextInt();
		c = input.nextInt();
		
		switch (e) {
		case 1:
			System.out.printf("\n--> R$ %d de %s = %.2f litros", r, b1.getFuel().get(c).getType(), b1.getLiterPrice(c, r));
			break;
			
		case 2:
			System.out.printf("\n--> R$ %d de %s = %.2f litros", r, b2.getFuel().get(c).getType(), b2.getLiterPrice(c, r));
			break;
			
		default:
			break;
			
	}
		
		input.close();
	}

}
