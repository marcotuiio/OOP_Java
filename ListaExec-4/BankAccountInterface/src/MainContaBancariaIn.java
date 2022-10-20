import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MainContaBancariaIn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = 1;
		int type;
		ContaCorrenteIn cc = new ContaCorrenteIn();
		ContaPoupancaIn cp = new ContaPoupancaIn();
		ContaInvestimentoIn ci = new ContaInvestimentoIn();
		ContaBancariaIn generic = null;
		ArrayList<ContaBancariaIn> listaContas = new ArrayList<ContaBancariaIn>();
		
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
						ContaCorrenteIn novaC = new ContaCorrenteIn(name, conta, BigDecimal.valueOf(lim));
						listaContas.add(novaC);
					} else if (type == 2) {
						System.out.println("Informe o dia de rendimento da conta");
						int dia = input.nextInt();
						ContaPoupancaIn novaP = new ContaPoupancaIn(name, conta, dia);
						listaContas.add(novaP);
					} else {
						ContaInvestimentoIn novaI = new ContaInvestimentoIn(name, conta);
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
						generic = cc.getAccount(listaContas, conta);
						generic.sacar(BigDecimal.valueOf(vSaque));
					} else if (type == 2) {
						generic = cp.getAccount(listaContas, conta);
						generic.sacar(BigDecimal.valueOf(vSaque));
					} else {
						generic = ci.getAccount(listaContas, conta);
						generic.sacar(BigDecimal.valueOf(vSaque));
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
						generic = cp.getAccount(listaContas, conta);
						((ContaPoupancaIn) generic).calcularNovoSaldo(BigDecimal.valueOf(taxa));						
					} else {
						generic = ci.getAccount(listaContas, conta);
						((ContaInvestimentoIn) generic).calcularNovoSaldo(BigDecimal.valueOf(taxa));
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
						generic = cc.getAccount(listaContas, conta);
						generic.depositar(BigDecimal.valueOf(vDeposito));
					} else if (type == 2) {
						generic = cp.getAccount(listaContas, conta);
						generic.depositar(BigDecimal.valueOf(vDeposito));
					} else {
						generic = ci.getAccount(listaContas, conta);
						generic.depositar(BigDecimal.valueOf(vDeposito));
					}
					break;
					
				case 5:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Deseja exibir saldo em conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						generic = cc.getAccount(listaContas, conta);
						System.out.printf("=> Conta Corrente " + conta +  " Saldo " + ((ContaCorrenteIn) generic).getSaldo() + " Limite " + 
											 ((ContaCorrenteIn) generic).getLimite() + "\n");
					} else if (type == 2) {
						generic = cp.getAccount(listaContas, conta);
						System.out.printf("=> Conta Poupança " + conta +  " Saldo " + ((ContaPoupancaIn) generic).getSaldo() + "\n");
					} else {
						generic = ci.getAccount(listaContas, conta);
						System.out.println("=> Conta Investimento " + conta + " Saldo " + ((ContaInvestimentoIn) generic).getSaldo() + "\n");
					}
					break;
					
				case 6:
					System.out.println("Informe o NÚMERO DA CONTA para calcular tributos");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa1 = input.nextDouble();
					generic = ci.getAccount(listaContas, conta);
					/*BigDecimal tributo = */((ContaInvestimentoIn) generic).calcularTributo(BigDecimal.valueOf(taxa1));
					break;
					
				case 7:
					System.out.println("Informe o NÚMERO DA CONTA para calcular taxa de administração");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa2 = input.nextDouble();
					generic = ci.getAccount(listaContas, conta);
					((ContaInvestimentoIn) generic).calcularTaxaAdministracao(BigDecimal.valueOf(taxa2));
					
				default:
					break;
			}
			
		} while (op != 0 && op < 8);
		
		input.close();

	}

}