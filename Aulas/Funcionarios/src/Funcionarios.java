
public class Funcionarios {
	private String name;
	private int income;
	
	private static int ticket = 0;
	
	public static void setTicket(int t) {
		ticket = t;
	}
	
	public Funcionarios(String n, int i) {
		this.name = n;
		this.income = i;
	}
	
	public static void adjustTicket(int p) {
		int a = ticket/100 * p;
		ticket = ticket + a;
	}
	
	public static int getTicket() {
		return ticket;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getIncome() {
		return this.income;
	}

}
