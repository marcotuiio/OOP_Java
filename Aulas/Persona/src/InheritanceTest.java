import java.math.BigDecimal;

public class InheritanceTest {

	public static void main(String[] args) {
		Person p1 = new Person("Mario", "Lopes");
		
		Employee p2 = new Employee("Lucas", "Mendes", "3bbr36", BigDecimal.valueOf(2000));

		Professor p3 = new Professor("Rafael", "Lira", "jkl909", BigDecimal.valueOf(5000));
		
		System.out.println("PESSOA 1 " + p1.getFullName());
		
		System.out.println("PESSOA 2 " + p2.getFullName() + " PARCELA 1 " + p2.getFirstPortionSalary() 
									+ " Parcela 2 " + p2.getSecondPortionSalary());
		
		System.out.println("PESSOA 3 " + p3.getFullName() + " PARCELA 1 " + p3.getFirstPortionSalary() 
									+ " Parcela 2 " + p3.getSecondPortionSalary());

	}

}
