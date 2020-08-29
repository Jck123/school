//////////////////////////////////////////////////////////////////////////
// Filename: MyGrade.java	                                            //
// Date: August 28, 2020                                                //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Program will take the averages of each grade type and		//
//			calculate the average grade of the student given the		//
//			weight of each grade type. This program also allows			//
//			easy changing of the grade weight.							//
//////////////////////////////////////////////////////////////////////////

package mygrade;

import java.util.Scanner;

public class MyGrade {
	public static void main(String[] args) {
		final double LABS_WEIGHT 					= 0.20;
		final double READING_WEIGHT 				= 0.10;
		final double VIDEO_WEIGHT 					= 0.10;
		final double MIDTERM_WEIGHT 				= 0.20;
		final double PROJECT_WEIGHT 				= 0.15;
		final double FINAL_WEIGHT 					= 0.20;
		final double INSTRUCTOR_DISCRETION_WEIGHT 	= 0.05;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the MyGrade program!");
		System.out.print("Enter Labs average in percent: ");
		int labs = input.nextInt();
		System.out.print("Enter Reading average in percent: ");
		int reading = input.nextInt();
		System.out.print("Enter Video average in percent: ");
		int video = input.nextInt();
		System.out.print("Enter Midterm average in percent: ");
		int midterm = input.nextInt();
		System.out.print("Enter Project average in percent: ");
		int project = input.nextInt();
		System.out.print("Enter Final average in percent: ");
		int finalExam = input.nextInt();
		System.out.print("Enter Instructor Discretion average in percent: ");
		int instructorDiscretion = input.nextInt();
		System.out.println("Your average is " + (labs * LABS_WEIGHT + reading * READING_WEIGHT + video * VIDEO_WEIGHT
				+ midterm * MIDTERM_WEIGHT + project * PROJECT_WEIGHT + finalExam * FINAL_WEIGHT
				+ instructorDiscretion * INSTRUCTOR_DISCRETION_WEIGHT) + "%");
	}
}
