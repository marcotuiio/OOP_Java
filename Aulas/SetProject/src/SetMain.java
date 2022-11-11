import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

	public static void main(String[] args) {
		ArrayList<Pessoas> list = new ArrayList<Pessoas>();

		Pessoas p1 = new Pessoas("vini", "8e2e27824");
		Pessoas p2 = new Pessoas("lais", "43855-227");
		Pessoas p3 = new Pessoas("marco", "0987654");
		Pessoas p4 = new Pessoas("ana", "34567894");
		Pessoas p5 = new Pessoas("bruno", "456783366");
		Pessoas p6 = new Pessoas("ana", "34567894");
		Pessoas p7 = new Pessoas("marco", "0987654");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		
		for (Pessoas p : list) {
			System.out.println(p.nome + " - " + p.cpf);
		}
		
		Set<Pessoas> set = new HashSet<Pessoas>();
		set.addAll(list);
		
		System.out.println("\nNão duplicados: ");
		for (Pessoas pp : set) {
			System.out.println(pp.nome);
		}
		
	}

}


