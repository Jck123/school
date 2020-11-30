
public class Room { 

	public Room() {

	   }
	   private int area;
	  
	   public int getSquareFeet() {
	       return area;
	   }
	  
	   public int getCapacity() {
	       return area/9;
	   }
	   public Room(int area) {
	       this.area=area;
	   }
	  
	   @Override
	   public String toString()
	   {
	       return "SquareFeet:"+this.area+" Capacity: "+this.getCapacity();
	   }


}

