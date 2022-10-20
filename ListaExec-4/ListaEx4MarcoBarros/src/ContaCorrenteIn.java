import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaCorrenteIn implements ContaBancariaIn {
	private String cliente;
	private String numConta;
	private BigDecimal saldo;
	private BigDecimal limite;
	
	public ContaCorrenteIn(String c, String numC, BigDecimal lim) {
		this.cliente = c;
		this.numConta = numC;
		this.saldo = BigDecimal.ZERO;
		this.limite = lim;
	}
	
	public ContaCorrenteIn() {
		// TODO Auto-generated constructor stub
	}

	public String getCliente() {
		return cliente;
	}

	public String getNumConta() {
		return numConta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	@Override
	public void sacar(BigDecimal value) {
		if (this.saldo.compareTo(value) >= 0) {
			this.saldo = this.saldo.subtract(value);
			System.out.println("Saque de R$" + value + " realizado com sucesso");
		} else {
			BigDecimal aux = this.saldo.add(this.limite);
			if (aux.compareTo(value) >= 0) {
				this.saldo = this.saldo.subtract(value);
				System.out.println("Saque de R$" + value + " utilizando limite de realizado com sucesso");
			} else {
				System.out.println("Saldo e Limite insuficientes para realizar saque");
			}
		}
	}

	@Override
	public void depositar(BigDecimal value) {
		this.saldo = this.saldo.add(value);
	}
	
	public ContaBancariaIn getAccount(ArrayList<ContaBancariaIn> contas, String id) {
		
		for (ContaBancariaIn required : contas) {
			if (required.getNumConta().equals(id)) {
				return required;
			}
		}
		System.out.println("Nenhuma conta com esse registro foi encontrada, encerrando procedimento\n");
		System.exit(0);
		return null; // erro não encontrou a conta
	}

}
