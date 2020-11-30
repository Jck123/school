public class Classroom extends Room{

   public Classroom() {
  
   }
  
   private int numberOfChairs;
  
  
   public int getnumberOfChairs() {
       return numberOfChairs;
   }
   public void setnumberOfChairs(int numberOfChairs) {
       this.numberOfChairs = numberOfChairs;
   }
   public Classroom(int area) {
       super(area);
   }
   public Classroom(int area,int numberOfChairs) {
       super(area);
       this.numberOfChairs=numberOfChairs;
   }
  
   @Override
   public int getCapacity(){
       return this.numberOfChairs;
   }
  
   @Override
   public String toString()
   {
       return "SquareFeet:"+super.getSquareFeet()+" Capacity: "+this.getCapacity();
   }
}