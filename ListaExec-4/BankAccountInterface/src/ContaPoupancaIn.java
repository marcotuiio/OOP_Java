import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaPoupancaIn implements ContaBancariaIn {
	private String cliente;
	private String numConta;
	private BigDecimal saldo;
	private int diaRendimento;
	
	public ContaPoupancaIn(String c, String numC, int dR) {
		this.cliente = c;
		this.numConta = numC;
		this.saldo = BigDecimal.ZERO;
		this.diaRendimento = dR;
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

	public int getDiaRendimento() {
		return diaRendimento;
	}

	@Override
	public void sacar(BigDecimal value) {
		if (this.saldo.compareTo(value) >= 0) {
			this.saldo = this.saldo.subtract(value);
		} else {
			System.out.println("Saldo de R$" + this.saldo + " insuficiente para sacar R$" + value);
		}
	}

	@Override
	public void depositar(BigDecimal value) {
		this.saldo = this.saldo.add(value);
	}
	
	public void calcularNovoSaldo(BigDecimal taxa) {
		BigDecimal rendimento = this.saldo.multiply(taxa).divide(BigDecimal.valueOf(100));
		this.saldo = saldo.add(rendimento);
	}
	
	static ContaPoupancaIn getAccount(ArrayList<ContaPoupancaIn> contas, String id) {
		
		for (ContaPoupancaIn required : contas) {
			if (required.getNumConta().equals(id)) {
				return required;
			}
		}
		System.out.println("Nenhuma conta com esse registro foi encontrada, encerrando procedimento\n");
		return null; // erro não encontrou a conta
	}

}
