
public enum TrafficLights {
	RED("RED", 22), 
	GREEN("GREEN", 24), 
	YELLOW("YELLOW", 4);
	
	private String status;
	private final int time;
	
	TrafficLights(String status, int time) {
		this.status = status;
		this.time = time;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getTime() {
		return this.time;
	}
}

