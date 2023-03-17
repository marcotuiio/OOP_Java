import java.math.BigDecimal;

public abstract class ContaTributavel extends ContaBancaria {
	
	public ContaTributavel(String c, String nC) {
		super(c, nC);
	}
	
	public ContaTributavel() {
		
	}
	
	public BigDecimal calcularTributo(BigDecimal taxaRendimento) {
		BigDecimal rendimento = this.saldo.multiply(taxaRendimento).divide(BigDecimal.valueOf(100));
		BigDecimal tTrib = rendimento.multiply(BigDecimal.valueOf(0.5)).divide(BigDecimal.valueOf(100));
		System.out.println("Valor Tributo R$" + tTrib + " para " + taxaRendimento + "% e rendimento R$" + rendimento);
		return tTrib;
	}
	
	public abstract void calcularTaxaAdministracao(BigDecimal taxa);
	
	public abstract void calcularNovoSaldo(BigDecimal taxa);
}
