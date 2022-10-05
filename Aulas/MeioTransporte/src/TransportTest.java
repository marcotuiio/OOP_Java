
public class TransportTest {

	public static void main(String[] args) {
		Transport bus = new Transport();
		CarTransport car = new CarTransport();
		bus.turnOn();
//		car.turnOn();
		
		bus.setSpeed(90);
//		bus.setSpeed(-9);
		car.setSpeed(900);
		car.setSpeed(157);
		car.setMileage(201387);
//		car.setMileage(99999999);
		
		System.out.println("Velocidade de bus " + bus.getSpeed() + " km/h");
		System.out.println("Velocidade de car " + car.getSpeed() + " km/h");
		System.out.println("Kilometragem de car " + car.getMileage() + " km");

	}

}
