import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria {
	private int diaRendimento;
	
	public ContaPoupanca(String c, String nC, int dR) {
		super(c, nC);
		this.diaRendimento = dR;
	}
	
	public ContaPoupanca() {
		
	}

	public int getDiaRendimento() {
		return diaRendimento;
	}
	
	public void calcularNovoSaldo(BigDecimal taxa) {
		BigDecimal rendimento = this.saldo.multiply(taxa).divide(BigDecimal.valueOf(100));
		System.out.println("Rendimento de R$" + rendimento);
		this.saldo = saldo.add(rendimento);
	}

}
