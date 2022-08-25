import java.util.Scanner;

public class Ex7 {
	// Exercise 7
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int lvl;
		int qntd;
		System.out.print("Informe quantas linhas deseja nos triangulos: ");
		lvl = input.nextInt();
		System.out.print("Informe a quantidade de trinagulos desejados: ");
		qntd = input.nextInt()
;		int repetidor = 0;
		while(repetidor < qntd) {
			int m = 1;
			int n = 1;
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
			repetidor += 1;
		}
		input.close();
	}

}
