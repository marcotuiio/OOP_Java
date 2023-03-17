
public class Transport {
	private boolean status = false;
	protected int speed = 0;
	
	public void turnOn() {
		this.status = true;
	}
	
	public void turnOff() {
		this.status = false;
		this.speed = 0;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setSpeed(int s) {
		if (this.getStatus()) {
			if (s > 0) {			
				this.speed = s;
			}	
		} else {
			System.out.println("Liga o veículo primeiro idiota\n");
		}
	}
	
	public int getSpeed() {
		return this.speed;
	}
}
