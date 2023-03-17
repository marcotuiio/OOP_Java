import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account myAccount = new Account();
		
		System.out.printf("Initial name is: %s%n%n", myAccount.getName());
		
		System.out.println("Please enter name: ");
		String newName = input.nextLine();
		myAccount.setName(newName);
		System.out.println();
		
		System.out.printf("Name in object myAccount: %s%n%n", myAccount.getName());
		
		input.close();
	}

}
