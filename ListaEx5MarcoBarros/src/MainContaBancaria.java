import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MainContaBancaria {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = 1;
		int type;
		ArrayList<ContaBancaria> listaContas = new ArrayList<ContaBancaria>();
		ContaBancaria cc = new ContaCorrente();
		ContaBancaria cp = new ContaPoupanca();
		ContaBancaria ci = new ContaInvestimento();
		
		System.out.println("--- Olá Cliente, bem vindo ao Banco de Westeros ---\n");
		
		do {
			System.out.println("\nInforme qual operação deseja realizar: ");
			System.out.println("1 - Cadastrar conta (poupança, corrente ou investimento) ");
			System.out.println("2 - Sacar um valor da sua conta (poupança, corrente ou investimento)");
			System.out.println("3 - Atualizar conta poupança com um dado rendimento");
			System.out.println("4 - Depositar um valor na conta (poupança, corrente ou investimento)");
			System.out.println("5 - Exibir saldo da conta (poupança, corrente ou investimento)");
			System.out.println("6 - Calcular tributos de uma conta de investimento");
			System.out.println("7 - Calcular taxa de administração de uma conta de investimento");
			System.out.println("0 - SAIR");
			System.out.printf(">> ");
			op = input.nextInt();
			System.out.println();
			
			switch (op) {
				case 1:
					System.out.println("Informe o Nome do Cliente");
					String name = input.next();
					System.out.println("Informe o Número da Conta");
					String conta = input.next();
					System.out.println("Deseja criar conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						System.out.println("Informe o limite inicial da conta");
						double lim = input.nextDouble();
						ContaBancaria novaC = new ContaCorrente(name, conta, BigDecimal.valueOf(lim));
						listaContas.add(novaC);
					} else if (type == 2) {
						System.out.println("Informe o dia de rendimento da conta");
						int dia = input.nextInt();
						ContaBancaria novaP = new ContaPoupanca(name, conta, dia);
						listaContas.add(novaP);
					} else {
						ContaBancaria novaI = new ContaInvestimento(name, conta);
						listaContas.add(novaI);
					}
					
					break;
				
				case 2:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe o valor do saque: ");
					double vSaque = input.nextDouble();  
					System.out.println("Deseja sacar de conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						cc = cc.getAccount(listaContas, conta);
						cc.sacar(BigDecimal.valueOf(vSaque));
					} else if (type == 2) {
						cp = cp.getAccount(listaContas, conta);
						cp.sacar(BigDecimal.valueOf(vSaque));
					} else {
						ci = ci.getAccount(listaContas, conta);
						ci.sacar(BigDecimal.valueOf(vSaque));
					}
					break;
					
				case 3:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento(porcentagem entre 0 e 100): "); // passar um numero entro 1 e 100
					double taxa = input.nextDouble();
					System.out.println("Deseja calcular rendimento em conta POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					if (type == 2) {
						cp = cp.getAccount(listaContas, conta);
						((ContaPoupanca) cp).calcularNovoSaldo(BigDecimal.valueOf(taxa));						
					} else {
						ci = ci.getAccount(listaContas, conta);
						((ContaInvestimento) ci).calcularNovoSaldo(BigDecimal.valueOf(taxa));
					}
					break;	
				
				case 4:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe o valor do depósito: ");
					double vDeposito = input.nextDouble();  
					System.out.println("Deseja depositar em conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						cc = cc.getAccount(listaContas, conta);
						cc.depositar(BigDecimal.valueOf(vDeposito));
					} else if (type == 2) {
						cp = cp.getAccount(listaContas, conta);
						cp.depositar(BigDecimal.valueOf(vDeposito));
					} else {
						ci = ci.getAccount(listaContas, conta);
						ci.depositar(BigDecimal.valueOf(vDeposito));
					}
					break;
					
				case 5:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Deseja exibir saldo em conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						cc = cc.getAccount(listaContas, conta);
						System.out.printf("=> Conta Corrente " + conta +  " Saldo " + ((ContaCorrente) cc).getSaldo() + " Limite " + 
											 ((ContaCorrente) cc).getLimite() + "\n");
					} else if (type == 2) {
						cp = cp.getAccount(listaContas, conta);
						System.out.printf("=> Conta Poupança " + conta +  " Saldo " + ((ContaPoupanca) cp).getSaldo() + "\n");
					} else {
						ci = ci.getAccount(listaContas, conta);
						System.out.println("=> Conta Investimento " + conta + " Saldo " + ((ContaInvestimento) ci).getSaldo() + "\n");
					}
					break;
					
				case 6:
					System.out.println("Informe o NÚMERO DA CONTA para calcular tributos");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa1 = input.nextDouble();
					ci = ci.getAccount(listaContas, conta);
					/*BigDecimal tributo = */((ContaInvestimento) ci).calcularTributo(BigDecimal.valueOf(taxa1));
					break;
					
				case 7:
					System.out.println("Informe o NÚMERO DA CONTA para calcular taxa de administração");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa2 = input.nextDouble();
					ci = ci.getAccount(listaContas, conta);
					((ContaInvestimento) ci).calcularTaxaAdministracao(BigDecimal.valueOf(taxa2));
					
				default:
					break;
			}
			
		} while (op != 0 && op < 8);
		
		input.close();

	}

}