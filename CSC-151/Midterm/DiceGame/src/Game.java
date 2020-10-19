//////////////////////////////////////////////////////////////////////////
// Filename: Game.java                                     				//
// Date: October 19, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program runs a single player game where the user can		//
//			either roll two dice or move forward one space. Some		//
//			spaces have special properties, good and bad. The user		//
//			wins when they get to space 100(but not over 100)			//
//////////////////////////////////////////////////////////////////////////

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int playerPos = 0;				//Placeholder for player position
		int in;							//Placeholder for player int input
		int roll;						//Placeholder for 2 die roll
		
		while(playerPos != 100) {		//Runs as long as the player is not on position 100
			System.out.println("You are now at position " + playerPos);
			System.out.println("What would you like to do?\n0 to exit\n1 to move 1 space\n2 to roll");
			in = input.nextInt();
			if (in == 1) 				//Player moves 1 space forward
				playerPos = Utils.move(playerPos, 1);
			else if (in == 2) {			//Player rolls
				roll = Utils.roll() + Utils.roll();
				System.out.println("You rolled " + roll + " and moved " + (Utils.move(playerPos, roll) - playerPos) + " spaces");
				playerPos = Utils.move(playerPos, roll);
			}
			else if (in == 0)			//If player enters 0, forces the loop to end
				break;
		}
		if (playerPos == 100)			//Checks if player actually won
			System.out.println("You won");
		System.out.println("Bye");		//Bye :)
	}

}
