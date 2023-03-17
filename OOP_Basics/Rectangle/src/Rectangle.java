
public class Rectangle {
	private float width = 1;
	private float height = 1;
	
	public void setWidth(float w) {
		if (w >0 && w < 20) {			
			this.width = w;
		} else {
			System.out.println("\nOnly numbers greater than 0 and smaller than 20");
		}
	}
	
	public float getWidth() {
		return this.width;
	}
	
	public void setHeight(float h) {
		if (h > 0 && h < 20) {			
			this.height = h;
		} else {
			System.out.println("\nOnly numbers greater than 0 and smaller than 20");
		}
	}
	
	public float getHeight() {
		return this.height;
	}
	
	public float getArea() {
		return (this.width * this.height);
	}
	
	public float getPermiter() {
		return (2*this.width + 2*this.height);
	}
}
