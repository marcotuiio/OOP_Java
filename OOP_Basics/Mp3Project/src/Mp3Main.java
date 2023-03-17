import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Mp3Main {

	public static void main(String[] args) {
		List<Mp3> l1 = new LinkedList<Mp3>();
		int out = 1;
		Scanner input = new Scanner(System.in);
		TituloComparator tComp = new TituloComparator();
		ArtistaComparator aComp = new ArtistaComparator();
		
		do {
			System.out.println("Cadastre nova musica: ");
			String titulo = input.next();
			System.out.println("Informe o artista: ");
			String artista = input.next();
			
			Mp3 newMusic = new Mp3(titulo, artista);
			l1.add(newMusic);
			
			out = 0;
			System.out.println("Digite 0 se deseja sair:");
			out = input.nextInt();
		} while (out != 0);
		
		Collections.sort(l1, tComp);
		System.out.println("\nOrdenação por titulo: ");
		for (Mp3 m : l1) {
			System.out.println(m.titulo + " - " + m.artista);
		}
		
		Collections.sort(l1, aComp);
		System.out.println("\nOrdenação por artista: ");   
		for (Mp3 m1 : l1) {
			System.out.println(m1.titulo + " - " + m1.artista);
		}
		
		System.out.println("\nInforme musica para buscar por titulo: ");
		String mus = input.next();
		Mp3 n1 = new Mp3();
		n1.setTitulo(mus);
		int index1 = Collections.binarySearch(l1, n1, tComp);
		System.out.println("Index busca por titulo " + index1);
		
		System.out.println("\nInforme artista para buscar por artista: ");
		String art = input.next();
		Mp3 n2 = new Mp3();
		n2.setArtista(art);
		int index2 = Collections.binarySearch(l1, n2, aComp);
		System.out.println("Index busca por artista " + index2);
		
		System.out.println("\nShuffle ");
		Collections.shuffle(l1);
		for (Mp3 m3 : l1) {
			System.out.println(m3.titulo + " - " + m3.artista);
		}

		input.close();
	}

}
