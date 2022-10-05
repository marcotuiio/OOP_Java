
public class CarTransport extends Transport {
	private int mileage;
	
	public int getMileage() {
		return this.mileage;
	}
	
	public void setMileage(int m) {
		if (m > 0 && m <= 999999) {			
			this.mileage = m;
		} else {
			System.out.println("Ta querendo desmontar esse furgão veio ??\n");
		}
	}
	
	@Override 
	public void setSpeed(int s) {
		if (this.getStatus()) {			
			if (s > 0 && s <= 200) {			
				this.speed = s;
			} else {
				System.out.println("Essa carroça não chega a " + s + " km/h nem ferrando\n");
			}
		} else {
			System.out.println("Liga o carro primeiro idiota\n");
		}
	}
}
