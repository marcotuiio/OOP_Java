import java.math.BigDecimal;

public class Employee extends Person {
	private String registration;
	protected BigDecimal salary;
	
	public Employee(String n, String ln, String r, BigDecimal s) {
		super(n, ln);
		this.registration = r;
		this.salary = s;
	}
	
	public String getRegistration() {
		return registration;
	}
	
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setSalary(BigDecimal salary) {
		if (salary.compareTo(BigDecimal.ZERO) > 0)
		this.salary = salary;
	}
	
	public BigDecimal getFirstPortionSalary() {
		return this.salary.multiply(BigDecimal.valueOf(60)).divide(BigDecimal.valueOf(100));
	}
	
	public BigDecimal getSecondPortionSalary() {
		return this.salary.multiply(BigDecimal.valueOf(40)).divide(BigDecimal.valueOf(100));
	}
}
