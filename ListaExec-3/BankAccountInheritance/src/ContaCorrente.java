import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaCorrente extends ContaBancaria {
	private BigDecimal limite;
	
	public ContaCorrente(BigDecimal limite, String nome, String conta) {
		super(nome, conta);
		this.limite = limite;
	}
	
	public BigDecimal getLimite() {
		return this.limite; 
	}
	
	@Override
	public void saque(BigDecimal withdraw) {
		if (this.saldo.compareTo(withdraw) >= 0) {			
			this.saldo = saldo.subtract(withdraw);
		} else {
			BigDecimal aux = saldo.subtract(withdraw).abs();
			if (this.limite.compareTo(aux) >= 0) {
				BigDecimal remains = withdraw.subtract(this.saldo);
				this.saldo = BigDecimal.ZERO;
				this.limite = limite.subtract(remains);
			} else {				
				System.out.println("Limite insuficiente para saque\n");
			}
		} 
	}
	
	static ContaCorrente getAccount(ArrayList<ContaCorrente> contas, String id) {
		
		for (ContaCorrente required : contas) {
			if (required.getNumeroConta().equals(id)) {
				return required;
			}
		}
		System.out.println("Nenhuma conta com esse registro foi encontrada, encerrando procedimento\n");
		return null; // erro não encontrou a conta
	}
}
