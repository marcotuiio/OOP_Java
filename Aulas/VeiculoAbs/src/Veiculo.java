
public abstract class Veiculo {
	public String marca;
	public String modelo;
	public String placa;
	
	public void licenciamento() {
		System.out.println("Carro marca " + marca + " modelo " + " e de placa " 
							+ placa + "está licenciado!");
	}
	
	public abstract int getNumEixos();
}
