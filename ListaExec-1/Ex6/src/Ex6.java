import java.util.Scanner;

public class Ex6 {
	// Exercise 6
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int lvl;
		System.out.print("Informe quantas linhas deseja nos triangulos: ");
		lvl = input.nextInt();
		int m = 0;
		int n = 0;
		while (m < lvl && n < lvl) {
			for (int i = 0; i < m; i += 1) {
				for (int j = 0; j < n; j += 1) {				
					System.out.print("*");
				}
				System.out.print("\n");
				n += 1;
			}
			m += 1;
		}
		input.close();
	}

}
