import java.util.Scanner;

public class PrincipalPizzaria {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Bem vindo ao Donattelos");
		System.out.println("Digite 0 para Pizza Quatro Queijos");
		System.out.println("Digite 1 para Pizza Calabresa");
		System.out.println(">> ");
		int escolha = input.nextInt();
		Pizzaria pizzaria = new Cardapio();
		
		Pizza p = pizzaria.createPizza(escolha);
		p.abrirMassa();
		p.addCobertura();
		p.addMolho();
		p.assar();
		p.cortar();
		
		input.close();
	}

}
