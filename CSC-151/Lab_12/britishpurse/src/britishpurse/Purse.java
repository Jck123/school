//////////////////////////////////////////////////////////////////////////
// Filename: Purse.java                               					//
// Date: November 15, 2020	                                            //
// Programmer: James Kelly												//
// Class Section: CSC-151-0001											//
// Instructor: Professor McGregor										//
//                                                                      //
// Description:                                                         //
//          Keeps track of money for multiple different users,			//
//			primarily keeps track of shillings and pence				//
//////////////////////////////////////////////////////////////////////////

package britishpurse;

public class Purse {
	private int shillingCount;
	private int penceCount;
	
	public Purse() {								//Purse starts with NO money
		shillingCount = 0;
		penceCount = 0;
	}
	
	public Purse(int pence, int shillings) {		//Purse starts with some money
		penceCount = pence;
		shillingCount = shillings;
	}
	
	public void giveShilling(int shil) {			//shillings added
		shillingCount += shil;
	}
	
	public void givePence(int pence) {				//pence added
		penceCount += pence;
	}
	
	public String getCoins() {
		return "The purse has " + penceCount +  " pence, " + shillingCount + " shillings";	//Coins are counted
	}
}