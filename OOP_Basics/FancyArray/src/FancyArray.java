public class FancyArray {

	public static void main(String[] args) {
		FancyArray c = new FancyArray();
		int a1 = 1, a2 = 2, a3 = 3, a4 = 4;
		int[] array = {9, 11, 13};
		
		System.out.println("T1: "+c.product(a1, a2));
	
		System.out.println("T2: "+c.product(a1, a2, a3));
		
		System.out.println("T3: "+c.product(a1, a2, a3, a4));
		
		System.out.println("T4: "+c.product(array));
		
	}
	
	public int product(int... values) {
		int result = 1;
		for (int i : values) {
			result *= i ;
		}
		return result;
	}

}
