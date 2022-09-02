
public class Carro {
	private String marca;
	private String modelo;
	
	public void setMarca(String m) {
		this.marca = m;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setModelo(String m) {
		this.modelo = m;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int whichGear(int speed) {
		if (speed >= 0 && speed < 10) {
			return 1;
		} else if (speed >= 10 && speed < 20) {
			return 1;
		} else if (speed >= 20 && speed < 35) {
			return 3;
		} else if (speed >= 35 && speed < 50) {
			return 4;
		} else if (speed >= 50 && speed < 60) {
			return 5;
		} else {
			return 6;
		}
	}

}
