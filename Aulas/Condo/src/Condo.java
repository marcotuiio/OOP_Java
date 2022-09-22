
public class Condo {

	public static void main(String[] args) {
		Morador m1 = new Morador("Joao", 202);
		Morador m2 = new Morador("Robert", 809);
		
		Car c11 = new Car("la ferrari", "ferrari", 42069, "yellow");
		Car c12 = new Car("kicks", "nissan", 27930, "white");
		Car c21 = new Car("911", "porshe", 1001, "red");
		Car c22 = new Car("camaro", "gm", 13022, "black");
		
		m1.setCar(c11);
		m1.setCar(c12);
		
		m2.setCar(c21);
		m2.setCar(c22);
		
		System.out.printf("Morador %s, carro %s %s\n", m1.getName(), m1.getCar(0).getBrand(), m1.getCar(0).getModel());
		System.out.printf("Morador %s, carro %s %s\n", m1.getName(), m1.getCar(1).getBrand(), m1.getCar(1).getModel());

		System.out.printf("\nMorador %s, carro %s %s\n", m2.getName(), m2.getCar(0).getBrand(), m2.getCar(0).getModel());
		System.out.printf("Morador %s, carro %s %s\n", m2.getName(), m2.getCar(1).getBrand(), m2.getCar(1).getModel());
	}

}
