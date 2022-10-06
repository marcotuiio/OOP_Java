import java.math.BigDecimal;
// import java.util.Objects;

public class ContaBancaria {
	private String cliente;
	private String numeroConta;
	protected BigDecimal saldo;
	
	public ContaBancaria(String nome, String nConta) {
		this.cliente = nome;
		this.numeroConta = nConta;
		this.saldo = BigDecimal.ZERO;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	
	public void deposito(BigDecimal deposit) {
		this.saldo = saldo.add(deposit);
	}
	
	public void saque(BigDecimal withdraw) {
		if (saldo.compareTo(withdraw) >= 0) {			
			this.saldo = saldo.subtract(withdraw);
		} else {
			System.out.println("Saldo da conta menor inferior ao saque, tente novamente");
		}
	}

}
