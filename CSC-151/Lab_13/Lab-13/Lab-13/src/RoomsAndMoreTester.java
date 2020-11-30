//////////////////////////////////////////////////////////////////////////
// Filename: RoomsAndMoreTester.java                   					//
// Date: November 22, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Tests the Classroom, Room, and Elevator classes and			//
//			displays results											//
//////////////////////////////////////////////////////////////////////////

public class RoomsAndMoreTester {

	public static void main(String[] args) {
		Room rm1 = new Room();					//Creates objects using each of the different constructors avalible
		Room rm2 = new Room(16);
		Classroom crm1 = new Classroom();
		Classroom crm2 = new Classroom(16);
		Classroom crm3 = new Classroom(16, 6);
		Elevator e1 = new Elevator(16);
		
		System.out.println("Room 1: " + rm1.toString());
		System.out.println("Room 2: " + rm2.toString());	//Displays details of each room
		System.out.println("Classroom 1: " + crm1.toString());
		System.out.println("Classroom 2: " + crm2.toString());
		System.out.println("Classroom 3: " + crm3.toString());
		crm3.setnumberOfChairs(45);							//Mutates the objects a bit and shows results
		System.out.println("Classroom 3 number of chairs after renovation: " + crm3.getnumberOfChairs());
		System.out.println("Elevator: " + e1.toString());
		e1.up(5);											//More object manipulation
		System.out.println("Elevator after going up 5 floors: " + e1.toString());
		e1.down(3);
		System.out.println("Elevator after going down 3 floors: " + e1.toString());
	}

}
