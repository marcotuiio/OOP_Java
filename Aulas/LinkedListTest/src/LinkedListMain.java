import java.util.List;
import java.util.ListIterator;
import java.util.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<Integer>();
		List<Integer> l2 = new LinkedList<Integer>();
		
		for (int k = 0; k < 10; k++) {
			l1.add(k);
		}
		
		ListIterator<Integer> iterator = l1.listIterator(l1.size());
		while (iterator.hasPrevious()) {
			l2.add(iterator.previous());
		}
		
		System.out.println("l1: ");
		for (int i : l1) {
			System.out.printf(" %d", i);
		}
		System.out.println("\nl2: ");
		for (int j : l2) {
			System.out.printf(" %d", j);
		}
	}

}
