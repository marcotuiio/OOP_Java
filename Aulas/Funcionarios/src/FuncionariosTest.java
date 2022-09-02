import java.util.Scanner;

public class FuncionariosTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	
		Funcionarios f1 = new Funcionarios("Joao", 2040);
		Funcionarios f2 = new Funcionarios("Pedro", 9800);
		Funcionarios f3 = new Funcionarios("Marta", 12300);
		Funcionarios f4 = new Funcionarios("Kleber", 1500);
		
		Funcionarios.setTicket(125);
		System.out.printf("%n Vale refeição inicial %d %n", Funcionarios.getTicket());
		
		Funcionarios.adjustTicket(12);
		
		System.out.printf("Funcionário %s Renda %d Vale %d %n", f1.getName(), f1.getIncome(), Funcionarios.getTicket());
		System.out.printf("Funcionário %s Renda %d Vale %d %n", f2.getName(), f2.getIncome(), Funcionarios.getTicket());
		System.out.printf("Funcionário %s Renda %d Vale %d %n", f3.getName(), f3.getIncome(), Funcionarios.getTicket());
		System.out.printf("Funcionário %s Renda %d Vale %d %n", f4.getName(), f4.getIncome(), Funcionarios.getTicket());
	
		input.close();
	}

}
