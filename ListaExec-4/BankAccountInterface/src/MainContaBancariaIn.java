import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MainContaBancariaIn {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int op = 1;
		int type;
		ContaCorrenteIn atualC = null;
		ContaPoupancaIn atualP = null;
		ContaInvestimentoIn atualI = null;
		ArrayList<ContaCorrenteIn> corrente = new ArrayList<ContaCorrenteIn>();
		ArrayList<ContaPoupancaIn> poupanca = new ArrayList<ContaPoupancaIn>();
		ArrayList<ContaInvestimentoIn> invest = new ArrayList<ContaInvestimentoIn>();
		// ArrayList<ContaBancariaIn> listaContas = new ArrayList<ContaBancariaIn>();
		// ContaBancariaIn generic = null
		
		System.out.println("--- Olá Cliente, bem vindo ao Banco de Westeros ---\n");
		
		while (op != 0 && op < 8) {
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
						corrente.add(novaC);
					} else if (type == 2) {
						System.out.println("Informe o dia de rendimento da conta");
						int dia = input.nextInt();
						ContaPoupancaIn novaP = new ContaPoupancaIn(name, conta, dia);
						poupanca.add(novaP);
					} else {
						ContaInvestimentoIn novaI = new ContaInvestimentoIn(name, conta);
						invest.add(novaI);
					}
					
					break;
				
				case 2:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe o valor do sacar: ");
					double vSaque = input.nextDouble();  
					System.out.println("Deseja sacar de conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						atualC = ContaCorrenteIn.getAccount(corrente, conta);
						atualC.sacar(BigDecimal.valueOf(vSaque));
					} else if (type == 2) {
						atualP = ContaPoupancaIn.getAccount(poupanca, conta);
						atualP.sacar(BigDecimal.valueOf(vSaque));
					} else {
						atualI = ContaInvestimentoIn.getAccount(invest, conta);
						atualI.sacar(BigDecimal.valueOf(vSaque));
					}
					
					break;
					
				case 3:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa = input.nextDouble();
					System.out.println("Deseja depositar em conta POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					if (type == 2) {
						atualP = ContaPoupancaIn.getAccount(poupanca, conta);
						((ContaPoupancaIn) atualP).calcularNovoSaldo(BigDecimal.valueOf(taxa));						
					} else {
						atualI = ContaInvestimentoIn.getAccount(invest, conta);
						((ContaInvestimentoIn) atualI).calcularNovoSaldo(BigDecimal.valueOf(taxa));
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
						atualC = ContaCorrenteIn.getAccount(corrente, conta);
						atualC.depositar(BigDecimal.valueOf(vDeposito));
					} else if (type == 2) {
						atualP = ContaPoupancaIn.getAccount(poupanca, conta);
						atualP.depositar(BigDecimal.valueOf(vDeposito));
					} else {
						atualI = ContaInvestimentoIn.getAccount(invest, conta);
						atualI.depositar(BigDecimal.valueOf(vDeposito));
					}
					break;
					
				case 5:
					System.out.println("Informe o NÚMERO DA CONTA: ");
					conta = input.next();
					System.out.println("Deseja exibir saldo em conta CORRENTE (1), POUPANÇA (2), INVESTIMENTO (3)");
					type = input.nextInt();
					
					if (type == 1) {
						atualC = ContaCorrenteIn.getAccount(corrente, conta);
						System.out.printf("=> Conta Corrente " + conta +  " Saldo " + ((ContaCorrenteIn) atualC).getSaldo() + " Limite " + 
											 ((ContaCorrenteIn) atualC).getLimite() + "\n");
					} else if (type == 2) {
						atualP = ContaPoupancaIn.getAccount(poupanca, conta);
						System.out.printf("=> Conta Poupança " + conta +  " Saldo " + ((ContaPoupancaIn) atualP).getSaldo() + "\n");
					} else {
						atualI = ContaInvestimentoIn.getAccount(invest, conta);
						System.out.println("=> Conta Investimento " + conta + " Saldo " + ((ContaInvestimentoIn) atualI).getSaldo() + "\n");
					}
					break;
					
				case 6:
					System.out.println("Informe o NÚMERO DA CONTA para calcular tributos");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa1 = input.nextDouble();
					atualI = ContaInvestimentoIn.getAccount(invest, conta);
					/*BigDecimal tributo = */((ContaInvestimentoIn) atualI).calcularTributo(BigDecimal.valueOf(taxa1));
					break;
					
				case 7:
					System.out.println("Informe o NÚMERO DA CONTA para calcular taxa de administração");
					conta = input.next();
					System.out.println("Informe a porcentagem da taxa de rendimento: "); // passar um numero entro 1 e 100
					double taxa2 = input.nextDouble();
					atualI = ContaInvestimentoIn.getAccount(invest, conta);
					((ContaInvestimentoIn) atualI).calcularTaxaAdministracao(BigDecimal.valueOf(taxa2));
					
				default:
					break;
			}
			
		}
		
		input.close();

	}

}