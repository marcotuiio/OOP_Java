import java.util.Scanner;
import java.util.Locale;

public class Ex3 {
	// Exercise 3
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(new Locale("en", "US"));
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe quantas vezes deseja imprimir seu nome: ");
		int n = sc.nextInt();
		System.out.print("Digite seu nome: ");
		String c = sc.next();
		System.out.print("\n");
		for (short i = 1; i <= n; i += 1) {
			System.out.print(i);
			System.out.println(" " + c);
		}
		sc.close();
	}
}