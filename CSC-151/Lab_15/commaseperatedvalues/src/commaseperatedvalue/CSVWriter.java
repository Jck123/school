//////////////////////////////////////////////////////////////////////////
// Filename: CSVWriter.java		                               			//
// Date: December 7, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Takes user input and turns it into a .csv file.				//
//////////////////////////////////////////////////////////////////////////

package commaseperatedvalue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {

	public static void main(String[] args)throws IOException {
		Scanner input = new Scanner(System.in);										//Console input
		
		System.out.print("What was your average grade on Lab assingments: ");		//User input taken here
		CSVRow row1 = new CSVRow("Labs", input.nextInt(), 20, "=B1*C1/100");		//User input is turned into CSVRow objects
		System.out.print("What was your average grade on Reading Quizzes: ");
		CSVRow row2 = new CSVRow("Reading Quizzes", input.nextInt(), 10, "=B2*C2/100");
		System.out.print("What was your average grade on Group Work assingments: ");
		CSVRow row3 = new CSVRow("Group Work", input.nextInt(), 10, "=B3*C3/100");
		System.out.print("What was your average grade on the Midterm: ");
		CSVRow row4 = new CSVRow("Midterm", input.nextInt(), 20, "=B4*C4/100");
		System.out.print("What was your average grade on the Project: ");
		CSVRow row5 = new CSVRow("Project", input.nextInt(), 15, "=B5*C5/100");
		System.out.print("What was your average grade on the Final: ");
		CSVRow row6 = new CSVRow("Final", input.nextInt(), 20, "=B6*C6/100");
		System.out.print("What was your average grade on Instructor Discretion: ");
		CSVRow row7 = new CSVRow("Instructor Discretion", input.nextInt(), 5, "=B7*C7/100");
		
		FileWriter writer = new FileWriter("./MyGrades.csv");						//Writer object
		
		writer.write(row1.toString() + "\n");										//Writes each object into the file created
		writer.write(row2.toString() + "\n");
		writer.write(row3.toString() + "\n");
		writer.write(row4.toString() + "\n");
		writer.write(row5.toString() + "\n");
		writer.write(row6.toString() + "\n");
		writer.write(row7.toString() + "\n");
		writer.write("average,=(D1+D2+D3+D4+D5+D6+D7)");							//Writes average to file created
		writer.flush();																//Cleans up everything
		writer.close();
		System.out.print("File Created! You can find a spreadsheet with your scores in MyGrades.csv");	//Lets user know what to find
	}

}
