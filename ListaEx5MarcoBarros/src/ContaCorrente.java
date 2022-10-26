import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {
	private BigDecimal limite;
	
	public ContaCorrente(String c, String nC, BigDecimal l) {
		super(c, nC);
		this.limite = l;
	}
	
	public ContaCorrente() {
		
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
	
	public BigDecimal getLimite() {
		return this.limite;
	}

}
