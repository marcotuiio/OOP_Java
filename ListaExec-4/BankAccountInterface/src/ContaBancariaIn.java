import java.math.BigDecimal;

public interface ContaBancariaIn {
	public void sacar(BigDecimal value);
	public void depositar(BigDecimal value);
}
