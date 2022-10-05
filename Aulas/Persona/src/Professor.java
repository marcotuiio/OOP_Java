import java.math.BigDecimal;

public class Professor extends Employee {
	
	public Professor(String n, String ln, String r, BigDecimal s) {
		super(n, ln, r, s);
	}
	
	@Override
	public BigDecimal getFirstPortionSalary() {
		return this.salary;
	}
	
	public BigDecimal getSecondPortionSalary() {
		return BigDecimal.ZERO;
	}
}
