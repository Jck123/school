//////////////////////////////////////////////////////////////////////////
// Filename: CSVRow.java		                               			//
// Date: December 7, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Creates the CSVRow class.									//
//////////////////////////////////////////////////////////////////////////

package commaseperatedvalue;

public class CSVRow {
	private String name;
	private int score;
	private int weight;
	private String calc;
	
	public CSVRow() {
	}
	
	public CSVRow(String name, int score, int weight, String calc) {	//Constructor that takes all input
		this.name = name;
		this.score = score;
		this.weight = weight;
		this.calc = calc;
	}
	
	public String toString() {											//Wraps that input up with a bow and all
		return name + "," + score + "," + weight + "," + calc;
	}
}
