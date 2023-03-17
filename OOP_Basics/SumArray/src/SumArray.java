
public class SumArray {

	public static void main(String[] args) {
		int total = 0;
		for (String value : args) {
			total +=  Integer.parseInt(value);
			System.out.println(Integer.parseInt(value));
		}
		System.out.println("\nSOMA: "+total);
	}
}
