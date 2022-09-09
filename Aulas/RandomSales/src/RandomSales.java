import java.security.SecureRandom;

public class RandomSales {

	public static void main(String[] args) {
		int[] sales = new int[50];
		SecureRandom rand = new SecureRandom();
		
		int[] range = new int[6];
		
		for (int i = 0; i < 50; i++) {
			sales[i] = rand.nextInt(700); // randomizando os 50 valores das vendas
			
			// contando quantas ocorrencias de cada intervalo ocorreu
			if (sales[i] >= 0 && sales[i] <= 99) {
				range[0]++;
			
			} else if (sales[i] >= 100 && sales[i] <= 199) {
				range[1]++;
			
			} else if (sales[i] >= 200 && sales[i] <= 299) {
				range[2]++;
			
			} else if (sales[i] >= 300 && sales[i] <= 399) {
				range[3]++;	
			
			} else if (sales[i] >= 400 && sales[i] <= 499) {
				range[4]++;
			
			} else { // >= 500
				range[5]++;
			}
		}
		
		System.out.println("QNTD [0 - 99] = " + range[0]);
		System.out.println("QNTD [100 - 199] = " + range[1]);
		System.out.println("QNTD [200 - 299] = " + range[2]);
		System.out.println("QNTD [300 - 399] = " + range[3]);
		System.out.println("QNTD [400 - 499] = " + range[4]);
		System.out.println("QNTD [>= 500] = " + range[5]);
	}

}
