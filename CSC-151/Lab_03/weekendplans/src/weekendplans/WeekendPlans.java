//////////////////////////////////////////////////////////////////////////
// Filename: WeekendPlans.java                                          //
// Date: September 6, 2020                                              //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will take three inputs from the user, prompting		//
//			if their parents are visiting, if they have money			//
//			and what the weather's like. The program will then tell		//
//			the user what to do for the weekend.						//
//////////////////////////////////////////////////////////////////////////

package weekendplans;

import java.util.Scanner;

public class WeekendPlans {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What are you gonna do for the weekend? 1 for yes, 2 for no");
		System.out.print("Are your parents in town? ");
		int parents = input.nextInt();
		System.out.print("Is the weather good? ");
		int weather = input.nextInt();
		System.out.print("Are you rich? ");
		int money = input.nextInt();
		
		String action = "";
		
		if (parents == 1)
			if (weather == 2)
				action = "stay inside!";
			else
				action = "go to the cinema!";
		else
			if (money == 2)
				action = "stay inside!";
			else
				if (weather == 1)
					action = "go shopping!";
				else
					action = "go to the cinema!";
			
		System.out.println("Today, I will " + action);
	}
}
