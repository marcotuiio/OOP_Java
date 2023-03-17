import java.util.Comparator;

public class ArtistaComparator implements Comparator<Mp3> {
	@Override 
	public int compare(Mp3 m1, Mp3 m2) {
		String a1 = m1.artista;
		String a2 = m2.artista;
		
		return a1.compareTo(a2);	
	}
}
