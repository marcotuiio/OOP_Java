import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Mp3Main {

	public static void main(String[] args) {
		Set<Mp3> tSet = new TreeSet<Mp3>(new TitComparator());
		int out = 1;
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.println("Cadastre nova musica: ");
			String titulo = input.next();
			System.out.println("Informe o artista: ");
			String artista = input.next();
			
			Mp3 newMusic = new Mp3(titulo, artista);
			tSet.add(newMusic);
			
			out = 0;
			System.out.println("Digite 0 se deseja sair:");
			out = input.nextInt();
		} while (out != 0);
		
		System.out.println("\nOrdenação por titulo: ");
		
		Mp3.printSet(tSet);
		
		System.out.println("Informe uma musica para exibir todas as faixas anteriores: ");
		String ant = input.next();
		Mp3 aux1 = new Mp3();
		aux1.setTitulo(ant);
		
		System.out.println("\nAnteriores: ");
		Mp3.printSet(((TreeSet<Mp3>) tSet).headSet(aux1));
		
		
		System.out.println("Informe uma musica para exibir todas as faixas posteriores: ");
		String dps = input.next();
		Mp3 aux2 = new Mp3();
		aux2.setTitulo(dps);
		
		System.out.println("\nPosteriores: ");
		Mp3.printSet(((TreeSet<Mp3>) tSet).tailSet(aux2));
			
		input.close();
	}

}
