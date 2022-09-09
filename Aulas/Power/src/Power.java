public class Power {
	
	// Elevar a para a potência de b (a^b)
	public static void main(String[] args) {
		Power p = new Power();
		int a = 2;
		int b = 10;
		
		System.out.println("a ^ b = "+p.power(a, b));
	}
	
	public double power(int a, int b) {
		return Math.pow(a, b);
	}
	
}
