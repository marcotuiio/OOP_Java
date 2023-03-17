import java.util.HashSet;
import java.util.Set;

public class TestDupli {

	public static void main(String[] args) {
		String s1 = "It's me, hi, I'm the problem, it's me";
		Set<String> set = new HashSet<String>();
		String[] words = s1.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		
		for (String w : words) {
			set.add(w);
		}
		
		System.out.println("Existem " + (words.length - set.size()) + " palavras repetidas na sentença");

	}

}
