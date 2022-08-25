public class Ex2 {
	// Exercise 2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		String name = args[1];
		System.out.println();		
		for (int i = 1; i <= n; i += 1) {
			System.out.print(i);
			System.out.println(" " + name);
		}		
	}
}
