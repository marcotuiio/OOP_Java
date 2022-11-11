import java.util.Set;

public class Mp3 {
	public String titulo;
	public String artista;
	
	public Mp3(String t, String a) {
		this.titulo = t;
		this.artista = a;
	}
		
	public Mp3() {

	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	public static void printSet(Set<Mp3> s) {
		for (Mp3 m : s) {
			System.out.println(m.titulo + " - " + m.artista);
		}
	}
	
}
