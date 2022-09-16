import java.util.Scanner;
import java.util.ArrayList;

public class BankQueue {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> queue = new ArrayList<String>();
		int op = 0;
		String name;
		
		System.out.println("-- Olá funcionário. O que deseja fazer? ");
		while (op < 6) {			
			System.out.println("\n1 - Cadastrar cliente na fila");
			System.out.println("2 - Consultar posição de cliente na fila");
			System.out.println("3 - Exibir todos os clientes na fila");
			System.out.println("4 - Atender cliente");
			System.out.println("5 - Remover cliente da fila");
			System.out.println("6 - Desligar sistema");
			System.out.printf(">> ");
			op = input.nextInt();
			
			switch (op) {
				case 1:
					System.out.println("\nInforme o nome do novo cliente: ");
					System.out.printf(">> ");
					name = input.next();
					queue.add(name);
					break;
				
				case 2: 
					System.out.println("\nInforme o nome do cliente que deseja consultar a posição: ");
					System.out.printf(">> ");
					name = input.next();
					System.out.printf("\nCliente %s está na posição %d da fila.\n", name, queue.indexOf(name)+1);
					break;
					
				case 3:
					System.out.println("\nTODOS OS CLIENTES: ");
					for (String client : queue) {
						System.out.printf(" %s ", client);
					}
					System.out.println();
					break;
					
				case 4: 
					System.out.println("\nAtendendo cliente " + queue.get(0));
					queue.remove(0);
					break;
					
				case 5: 
					System.out.println("\nInforme o nome do cliente desistente: ");
					System.out.printf(">> ");
					name = input.next();
					boolean r = queue.remove(name);
					if (r == true) {
						System.out.println("REMOVIDO");
					} else {
						System.out.println("NÃO EXISTENTE");
					} 
					break;
					
				default:
					break;
			}
		}
		System.out.println("\nDESLIGANDO SISTEMA");
		input.close();
	}

}
