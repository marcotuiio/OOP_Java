public class Incremental {
	
	private int count = 0;
	private static Incremental instance = null;
	
	private Incremental(){
		this.count = 0;	
	}
	
	public static Incremental getInstance() {
		if (instance == null) {
			instance = new Incremental();
		}
		return instance;
	}
	
	public String toString(){
		return "Incremental "+this.count;
	}
	
	public void incrementar(){
		this.count++;
	}

}
