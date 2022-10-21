import java.util.Scanner;
		
public class HeartRatesMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("OLÁ PACIENTE, BEM VINDO AO PROGRAMA JAVA HEART-RATES\n");

		System.out.println("Informe seu nome: ");
		String name = input.next();
		
		System.out.println("Informe seu sobrenome: ");
		String lastName = input.next();
		
		System.out.println("Informe o dia de seu nascimento: ");
		int day = input.nextInt();
		
		System.out.println("Informe o mês de seu nascimento: ");
		int month = input.nextInt();
		
		System.out.println("Informe o ano de seu nascimento: ");
		int year = input.nextInt();
		
		HeartRates pacient = new HeartRates(name, lastName, day, month, year);
	
		System.out.println("\n--FICHA DO PACIENTE--\n");
		
		System.out.println("NOME: " + pacient.getName() + " " + pacient.getLastName());
		System.out.println("IDADE: " + pacient.getAge() + " anos");
		System.out.println("DATA DE NASCIMENTO: " + pacient.getDayBirth() + "/"
							+ pacient.getMonthBirth() + "/" + pacient.getYearBirth());
		System.out.println("FREQUÊNCIA CARDÍACA MÁXIMA: " + pacient.getMaximumRate() + " bpm");
		System.out.println("INTERVALO DE FREQUÊNCIA CARDÍACA: " + pacient.getRange(pacient.getMaximumRate())[0] 
							+ " <--> " + pacient.getRange(pacient.getMaximumRate())[1]);
		
		input.close();
	}

}
