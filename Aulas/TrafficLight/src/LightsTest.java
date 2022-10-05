
public class LightsTest {

	public static void main(String[] args) {
		System.out.print("\nTRAFFIC LIGHTS\n");
		for (TrafficLights lights : TrafficLights.values()) {
			System.out.printf("Color %s - Duration %d seconds\n", lights.getStatus(), lights.getTime());
		}
	}

}
