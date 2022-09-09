import java.util.Locale;
import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "US"));
		Scanner scan = new Scanner(System.in);
		
		int i, aux1, aux2;
		aux1 = 1;
		aux2 = 0; 
		System.out.print("Informe qual posição da sequência de Fibonacci deseja: ");
		int n = scan.nextInt();
		scan.close();
		if (n == 1) {
			System.out.print(">> " + aux2); 
		} else if (n == 2) {
			System.out.print(">> " + aux1); 
		} else {
			for(i = 1; i <= (n-2); i++) {
			      aux1 = aux1 + aux2;      
			      aux2 = aux1 - aux2;      
		    }
			System.out.print(">> s" + aux1);    
		}
		
	}

}
