import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MainContaBancaria {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = 1;
		int type;
		ContaCorrente atualC = null;
		ContaPoupanca atualP = null;
		ArrayList<ContaCorrente> corrente = new ArrayList<ContaCorrente>();
		ArrayList<ContaPoupanca> poupanca = new ArrayList<ContaPoupanca>();
		
		System.out.println("--- Olá Cliente, bem vindo ao Banco de Westeros ---\n");
		
		while (op != 0 && op < 6) {
			System.out.println("\nInforme qual operação deseja realizar: ");
			System.out.println("1 - Cadastrar conta (poupança ou corrente) ");
			System.out.println("2 - Sacar um valor da sua conta (poupança ou corrente)");
			System.out.println("3 - Atualizar conta poupança com um dado rendimento");
			System.out.println("4 - Depositar um valor na conta (poupança ou corrente)");
			System.out.println("5 - Exibir saldo da conta (poupança ou corrente)");
			System.out.println("0 - SAIR");
			System.out.printf(">> ");
			op = input.nextInt();
			
			switch (op) {
				case 1:
					System.out.println("Informe o Nome do Cliente");
					String name = input.next();
					System.out.println("Informe o Número da Conta");
					String conta = input.next();
					System.out.println("Deseja criar conta CORRENTE (1) ou POUPANÇA (2)");
					type = input.nextInt();
					
					if (type == 1) {
						System.out.println("Informe o limite inicial da conta");
						double lim = input.nextDouble();
						ContaCorrente novaC = new ContaCorrente(BigDecimal.valueOf(lim), name, conta);
						corrente.add(novaC);
					} else {
						System.out.println("Informe o dia de rendimento da conta");
						int dia = input.nextInt();
						ContaPoupanca novaP = new ContaPoupanca(dia, name, conta);
						poupanca.add(novaP);
					}
					
					break;
				
				case 2:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe o valor do saque: ");
					double vSaque = input.nextDouble();  
					System.out.println("Deseja sacar de conta CORRENTE (1) ou POUPANÇA (2)");
					type = input.nextInt();
					
					if (type == 1) {
						atualC = ContaCorrente.getAccount(corrente, conta);
						atualC.saque(BigDecimal.valueOf(vSaque));
					} else {
						atualP = ContaPoupanca.getAccount(poupanca, conta);
						atualP.saque(BigDecimal.valueOf(vSaque));
					}
					
					break;
					
				case 3:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa = input.nextDouble();
					atualP = ContaPoupanca.getAccount(poupanca, conta);
					atualP.calcularRendimento(BigDecimal.valueOf(taxa));
					break;	
				
				case 4:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe o valor do depósito: ");
					double vDeposito = input.nextDouble();  
					System.out.println("Deseja depositar em conta CORRENTE (1) ou POUPANÇA (2)");
					type = input.nextInt();
					
					if (type == 1) {
						atualC = ContaCorrente.getAccount(corrente, conta);
						atualC.deposito(BigDecimal.valueOf(vDeposito));
					} else {
						atualP = ContaPoupanca.getAccount(poupanca, conta);
						atualP.deposito(BigDecimal.valueOf(vDeposito));
					}
					break;
					
				case 5:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Deseja exibir saldo em conta CORRENTE (1) ou POUPANÇA (2)");
					type = input.nextInt();
					
					if (type == 1) {
						atualC = ContaCorrente.getAccount(corrente, conta);
						System.out.printf("=> Conta Corrente " + conta +  " Saldo " + atualC.getSaldo() + " Limite " + 
											 atualC.getLimite() + "\n");
					} else {
						atualP = ContaPoupanca.getAccount(poupanca, conta);
						System.out.printf("=> Conta Poupança " + conta +  " Saldo " + atualP.getSaldo() + "\n");}
					break;
					
				default:
					break;
			}
			
		}
		
		input.close();

	}

}
