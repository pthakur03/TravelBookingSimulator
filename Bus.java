/** Creates a Bus class, which is a concrete implementation of Transportation.
 * @author Parth Thakur
 * @version 1
 */
public class Bus extends Transportation {
    private int stops;
/** Creates a constructor that iniates Bus.
 * @param company Represents the name of the Transportation company.
 * @param id Represents the transportation vehicle number identifier.
 * @param departDate Represents the departure date.
 * @param departTime Represents the departure time.
 * @param arrivalTime Represents the arrival time.
 * @param stops Represents the number of stops the bus trip has.
 * @throws IllegalArgumentException Throws an exception when an invalid input is found.
 */
    public Bus(String company, int id, String departDate, String departTime, String arrivalTime, int stops)
        throws IllegalArgumentException {
        super(company, id, departDate, departTime, arrivalTime);
        if (stops < 0) {
            throw new IllegalArgumentException();
        } else {
            this.stops = stops;
        }
    }

/**Creates a toString() method that properly overrides Transportation’s toString() method.
 * @return Returns the String output.
 */
    public String toString() {
        return ("Bus," + company + "," + id + "," + departDate + "," + departTime + "," + arrivalTime + "," + stops);
    }
/**Creates an equals() method that properly overrides Transportation’s equals() method.
 * @param other Represents the other String value to be compared.
 * @return Returns true if the objects are equal and returns false otherwise.
  */
    public boolean equals(Object other) {
        boolean condition1 = super.equals(other);
        boolean condition2 = false;
        if (other instanceof Bus) {
            condition2 = this.stops == ((Bus) other).stops;
        }
        return (condition1 && condition2);
    }
}