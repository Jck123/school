//////////////////////////////////////////////////////////////////////////
// Filename: Utils.java		                                     		//
// Date: October 19, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program sets up the Utils class and the methods				//
//			roll and move												//
//////////////////////////////////////////////////////////////////////////

public class Utils {
	public static int roll() {					//Rolls a die between 1 and 6(inclusive)
		return (int)Math.round((Math.random() * 5 + 1));
	}
	
	public static int move(int currentPos, int moveAmount) {
		int newPos = currentPos + moveAmount;
		
		if (newPos > 100)						//Checks if player went over 100
			newPos -= 100;
		if (newPos % 5 == 0 && newPos != 100)	//Checks if player lands on multiple of 5(that isn't 100)
			newPos += 5;
		else if (newPos % 13 == 0)				//Checks if player lands on multiple of 13
			newPos -= moveAmount * 2;
		
		return newPos;
	}
}
