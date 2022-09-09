public class Minimum {
	
	// Encontrar o menor numero entre a e b analisando apenas a parte inteira
	public static void main(String[] args) {
		Minimum m = new Minimum();
		double a = 9.203;
		double b = 72.237492;
		
		System.out.println("min(a, b) = "+ m.min(a, b));
	}
	public int min(double a, double b) {
		return Math.min((int) a, (int) b);
	}

}
