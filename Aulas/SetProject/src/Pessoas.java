
public class Pessoas {
	public String nome;
	public String cpf;
	
	public Pessoas(String n, String c) {
		this.nome = n;
		this.cpf = c;
	}
	
	public boolean equals(Object o1) {
		Pessoas that = (Pessoas) o1;
		
		return (this.cpf.equals(that.cpf) 
				&& this.nome.equals(that.nome)); 
	}
	
	public int hashCode() {
		return this.cpf.hashCode() + this.nome.hashCode();
	}
}
