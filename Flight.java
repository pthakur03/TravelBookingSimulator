/** Creates a Flight class, which is a concrete implementation of Transportation.
 * @author Parth Thakur
 * @version 1
 */
public class Flight extends Transportation {
    private int connectors;
/** Creates a constructor that initiates Flight.
 * @param company Represents the name of the Transportation company.
 * @param id Represents the transportation vehicle number identifier.
 * @param departDate Represents the departure date.
 * @param departTime Represents the departure time.
 * @param arrivalTime Represents the arrival time.
 * @param connectors Represents the number of connecting flights.
 * @throws IllegalArgumentException Throws an exception when an invalid input is found.
 */
    public Flight(String company, int id, String departDate, String departTime, String arrivalTime, int connectors)
        throws IllegalArgumentException {
        super(company, id, departDate, departTime, arrivalTime);
        if (connectors < 0) {
            throw new IllegalArgumentException();
        } else {
            this.connectors = connectors;
        }
    }

/**Creates a toString() method that properly overrides Transportation’s toString() method.
 * @return Returns the String output.
 */

    public String toString() {
        return ("Flight," + company + "," + id + "," + departDate
            + "," + departTime + "," + arrivalTime + "," + connectors);
    }
/**Creates an equals() method that properly overrides Transportation’s equals() method.
 * @param other Represents the other String value to be compared.
 * @return Returns true if the objects are equal and returns false otherwise.
  */
    public boolean equals(Object other) {
        boolean condition1 = super.equals(other);
        boolean condition2 = false;
        if (other instanceof Flight) {
            condition2 = this.connectors == ((Flight) other).connectors;
        }
        return (condition1 && condition2);
    }
}
