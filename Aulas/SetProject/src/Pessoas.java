
public class Pessoas {
	public String nome;
	public String cpf;
	
	public Pessoas(String n, String c) {
		this.nome = n;
		this.cpf = c;
	}
	
	public boolean equals(Object o1) {
		Pessoas that = (Pessoas) o1;
		
		return (this.nome.compareTo(that.nome) == 0 
				&& this.cpf.compareTo(that.cpf) == 0); 
	}
}
