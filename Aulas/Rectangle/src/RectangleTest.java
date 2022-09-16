
public class RectangleTest {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		
		System.out.println("\nInitial Width: " + r.getWidth());
		System.out.println("Initial Height: "+ r.getHeight());
		System.out.println("Initial Area: " + r.getArea());
		System.out.println("Initial Perimeter: " + r.getPermiter());
		
		r.setWidth(2);
		r.setHeight(13);
		System.out.println("\nNew Width: " + r.getWidth());
		System.out.println("New Height: "+ r.getHeight());
		System.out.println("New Area: " + r.getArea());
		System.out.println("New Perimeter: " + r.getPermiter());
		
		r.setWidth(0);
		r.setHeight(90);
		
		System.out.println("\nFinal Width: " + r.getWidth());
		System.out.println("Final Height: "+ r.getHeight());
		System.out.println("Final Area: " + r.getArea());
		System.out.println("Final Perimeter: " + r.getPermiter());
	}

}
