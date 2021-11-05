/**
 * ITSC 1212 Candle class for Project 3
 */
public class Candle {

  // FIELDS
  private String name; // This object's "name", i.e., "Taper", "Pillar", "Tea Light", etc.
  private int type; // This object's Type: 1, 2, or 3
  private double cost; // This object's cost
  private int burnTime; // This object's burn time in minutes

  // CONSTRUCTOR
  public Candle(String nam, int typ, double cst, int brn) {
    this.name = nam; // Set this Candle object's name field
    this.type = typ; // Set this Candle object's type field
    this.cost = cst; // Set this Candle object's cost field
    this.burnTime = brn; // Set this Candle object's burn time field
  }

  // GETTER FOR NAME
  public String getName() {
    return this.name; // Return the name of this type of Candle
  }

  // SETTER FOR NAME
  public void setName(String nam) {
    this.name = nam; // Set the name of the current Candle object
  }

  // GETTER FOR TYPE
  public int getType() {
    return this.type; // Return the type number of the current Candle object
  }

  // SETTER FOR TYPE
  public void setType(int typ) {
    this.type = typ; // Set the type of the current Candle object
  }

  // GETTER FOR COST
  public double getCost() {
    return this.cost; // Return the cost of the current Candle object
  }

  // SETTER FOR COST
  public void setCost(double amount) {
    this.cost = amount; // Set the cost of the current Candle object
  }

  // GETTER FOR BURN TIME
  public int getTime() {
    return this.burnTime; // Return the burn time of the current Candle object
  }

  // SETTER FOR BURN TIME
  public void setTime(int minutes) {
    this.burnTime = minutes; // Set the burn time of the current Candle object
  }

  // Returns a String object with all the data from the current Candle object
  public String toString() {
    return "Each " + this.name + ", a type " + this.type + " candle costs $" + this.cost + " and burns for "
        + this.burnTime + " minutes.";
  }

}
