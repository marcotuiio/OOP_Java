import java.math.BigDecimal;
import java.util.ArrayList;

public interface ContaBancariaIn {
	public void sacar(BigDecimal value);
	public void depositar(BigDecimal value);
	public String getNumConta();
	public ContaBancariaIn getAccount(ArrayList<ContaBancariaIn> contas, String id);
}
