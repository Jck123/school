//////////////////////////////////////////////////////////////////////////
// Filename: PurseTester.java                               			//
// Date: November 15, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the Purse class and allows user to play around		//
//			with the Purse class										//
//////////////////////////////////////////////////////////////////////////

package britishpurse;

import java.util.Scanner;

public class PurseTester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lastInput = 1;
		Purse sophie = new Purse();													//Sophie starts with no coins
		Purse sally = new Purse(3, 5);												//Sally starts with 3 pence and 5 shillings
		
		System.out.println("Welcome to Purse Simulator!");
		System.out.print("Enter 1 for Sophie, 2 for Sally, or 0 to exit: ");		//Initial question
		lastInput = input.nextInt();
		while (lastInput != 0) {													//Allows user to keep going through program until they decide to stop
			if (lastInput == 1) {													//Sophie is chosen
				System.out.print("Enter 1 to give pence, 2 to give shillings, 3 to query her purse: ");	//After purse is chosen, action is chosen next
				lastInput = input.nextInt();
				if (lastInput == 1) {												//User adds pence to purse
					System.out.print("Enter pence to give: ");
					sophie.givePence(input.nextInt());
				} else if (lastInput == 2) {
					System.out.print("Enter shillings to give: ");					//User adds shillings to purse
					sophie.giveShilling(input.nextInt());
				} else if (lastInput == 3)
					System.out.println(sophie.getCoins());							//User requests coin count
				else
					System.out.println("Invalid input!");							//Invalid input
			} else if (lastInput == 2) {											//Sally is chosen
				System.out.print("Enter 1 to give pence, 2 to give shillings, 3 to query her purse: ");
				lastInput = input.nextInt();
				if (lastInput == 1) {
					System.out.print("Enter pence to give: ");						//Same code as above, but with Sally
					sally.givePence(input.nextInt());
				} else if (lastInput == 2) {
					System.out.print("Enter shillings to give: ");
					sally.giveShilling(input.nextInt());
				} else if (lastInput == 3)
					System.out.println(sally.getCoins());
				else
					System.out.println("Invalid input!");
			}
			
			System.out.print("\nEnter 1 for Sophie, 2 for Sally, or 0 to exit: ");		//Gets user ready for next iteration
			lastInput = input.nextInt();
		}
	}

}
