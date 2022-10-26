import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class ContaBancaria {
	protected String cliente;
	protected String numConta;
	protected BigDecimal saldo;
	
	public ContaBancaria(String c, String nC) {
		this.cliente = c;
		this.numConta = nC;
		this.saldo = BigDecimal.ZERO;
	}
	
	public ContaBancaria() {
		
	}
	
	public void sacar(BigDecimal value) {
		if (this.saldo.compareTo(value) >= 0) {
			this.saldo = this.saldo.subtract(value);
			System.out.println("Saque de R$" + value + " realizado com sucesso\n");
		} else {
			System.out.println("Saldo de R$" + this.saldo + " insuficiente para sacar R$" + value);
		}
	}
	
	public BigDecimal getSaldo() {
		return this.saldo;
	}
	
	public void depositar(BigDecimal value) {
		this.saldo = this.saldo.add(value);
	}
	
	public String getCliente() {
		return this.cliente;
	}
	
	public String getNumConta() {
		return this.numConta;
	}
	
	public ContaBancaria getAccount(ArrayList<ContaBancaria> contas, String id) {
		for (ContaBancaria required : contas) {
			if (required.getNumConta().equals(id)) {
				return required;
			}
		}
		System.out.println("Nenhuma conta com esse registro foi encontrada, encerrando procedimento\n");
		System.exit(0);
		return null; // erro não encontrou a conta
	}

}
