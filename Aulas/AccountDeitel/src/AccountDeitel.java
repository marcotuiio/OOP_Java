import java.math.BigDecimal;

public class AccountDeitel {
   private String name; // instance variable 
   private BigDecimal balance; // instance variable 

   // Account constructor that receives two parameters  
   public AccountDeitel(String name, BigDecimal balance) {
      this.name = name; // assign name to instance variable name

      // validate that the balance is greater than 0.0; if it's not,
      // instance variable balance keeps its default initial value of 0.0
     this.balance = balance; // assign it to instance variable balance   
   }

   // method that deposits (adds) only a valid amount to the balance
   public void deposit(BigDecimal depositAmount) {  
	   if (depositAmount.compareTo(BigDecimal.ZERO) > 0) {		   
		   balance = balance.add(depositAmount); // add it to the balance     
	   }
   }

   // method returns the account balance
   public BigDecimal getBalance() {
      return balance; 
   } 

   // method that sets the name
   public void setName(String name) {
      this.name = name; 
   } 

   // method that returns the name
   public String getName() {
      return name; 
   } 
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/