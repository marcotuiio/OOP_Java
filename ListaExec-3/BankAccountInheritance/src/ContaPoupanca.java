import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaPoupanca extends ContaBancaria {
	private int diaRendimento;
	
	public ContaPoupanca(int dia, String nome, String conta) {
		super(nome, conta);
		this.diaRendimento = dia;
	}
	
	public int getDiaRendimento() {
		return this.diaRendimento;
	}
	
	public void calcularRendimento(BigDecimal taxa) {
		BigDecimal rendimento = this.saldo.multiply(taxa).divide(BigDecimal.valueOf(100));
		this.saldo = saldo.add(rendimento);
	}
	
	static ContaPoupanca getAccount(ArrayList<ContaPoupanca> contas, String id) {
		
		for (ContaPoupanca required : contas) {
			if (required.getNumeroConta().equals(id)) {
				return required;
			}
		}
		System.out.println("Nenhuma conta com esse registro foi encontrada, encerrando procedimento\n");
		return null; // erro não encontrou a conta
	}
}
