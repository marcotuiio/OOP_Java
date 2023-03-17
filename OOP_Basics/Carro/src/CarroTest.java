import java.util.Scanner;

public class CarroTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe a marca do carro: ");
		String marca = input.nextLine();
		
		System.out.println("Informe o modelo do carro: ");
		String modelo = input.nextLine();
		
		Carro myCar = new Carro();
		myCar.setMarca(marca);
		myCar.setModelo(modelo);
		
		System.out.printf("%nA marca do carro é %s%n", myCar.getMarca());
		System.out.printf("O modelo do carro é %s%n", myCar.getModelo());
		
		System.out.println("Informe a velocidade atual para saber a marcha correspondente: ");
		int vel = input.nextInt();
		
		int gear = myCar.whichGear(vel);
		
		System.out.printf("%n A marcha adequada para %d km/h é %dª marcha %n", vel, gear);
		
		input.close();
	}

}
