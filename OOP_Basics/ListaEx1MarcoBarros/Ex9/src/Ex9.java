import java.util.Scanner;
import java.util.Locale;

public class Ex9 {
	public static void main(String[] args) {
		System.out.print("\t\nCALCULADORA DE IMC\n");
		Locale.setDefault(new Locale("en", "US"));
		Scanner sc = new Scanner(System.in);
		System.out.print("Informe sua altura: ");
		float height = sc.nextFloat();
		System.out.print("Informe sua massa: ");
		float mass = sc.nextFloat();
		
		float imc = mass / (height * height);
		System.out.println("\n Seu IMC é: " + imc);
		sc.close();
	}
}
