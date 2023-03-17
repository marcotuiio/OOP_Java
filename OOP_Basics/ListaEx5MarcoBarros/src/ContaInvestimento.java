import java.math.BigDecimal;

public class ContaInvestimento extends ContaTributavel {
	
	public ContaInvestimento(String c, String nC) {
		super(c, nC);
	}
	
	public ContaInvestimento() {
		
	}
	
	@Override
	public void calcularTaxaAdministracao(BigDecimal taxa) {
		BigDecimal rendimento = this.saldo.multiply(taxa).divide(BigDecimal.valueOf(100));
		BigDecimal tAdmin = rendimento.multiply(BigDecimal.ONE).divide(BigDecimal.valueOf(100));
		System.out.println("Taxa de Administração R$" + tAdmin + " para " + taxa + "% e rendimento R$" + rendimento);
	}

	@Override
	public void calcularNovoSaldo(BigDecimal taxa) {
		BigDecimal rendimento = this.saldo.multiply(taxa).divide(BigDecimal.valueOf(100));
		System.out.println("Rendimento de R$" + rendimento);
		this.saldo = saldo.add(rendimento);
	}

}
