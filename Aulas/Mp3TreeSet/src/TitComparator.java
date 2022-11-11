import java.util.Comparator;

public class TitComparator implements Comparator<Mp3> {
	@Override 
	public int compare(Mp3 m1, Mp3 m2) {
		String t1 = m1.titulo;
		String t2 = m2.titulo;
		
		return t1.compareTo(t2);	
	}
}
