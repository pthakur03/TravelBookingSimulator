import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.io.PrintWriter;
/** Creates a Booking class which will read and write database.
 * @author Parth Thakur
 * @version 1
 */
public class Booking {
/** Creates a method outputBookings.
 * @param fileName Name of the file from which the data is to be read.
 * @return Returns an ArrayList of Transportation objects.
 * @throws FileNotFoundException Throws an exception when the file is null or nonexistent.
 * @throws InvalidBookingException Throws an exception when an invalid value is entered.
 */
    public static ArrayList<Transportation> outputBookings(String fileName) throws
        FileNotFoundException, InvalidBookingException {
        ArrayList<Transportation> transportationList = new ArrayList<Transportation>();

        if (fileName != null) {
            File other = new File(fileName);

            if (other.exists() && other.isFile()) {

                Scanner scan = new Scanner(other);
                scan.useDelimiter(",|\\n");


                while (scan.hasNext()) {
                    String type = new String();
                    String test = scan.next();
                    if (test.equals("Flight") || test.equals("Bus")) {
                        type = test;
                    } else {
                        throw new InvalidBookingException();
                    }
                    String company = scan.next();
                    int id = Integer.parseInt(scan.next());
                    String departDate = scan.next();
                    System.out.println("depart:" + departDate);
                    String departTime = scan.next();
                    String arrivalTime = scan.next();
                    System.out.println("arrivalTime:" + arrivalTime);
                    String testInt = scan.nextLine();
                    testInt = testInt.substring(1);
                    System.out.println("testInt" + testInt + "hi");
                    System.out.println("valueOf:" + Integer.valueOf(testInt));
                    int connectOrStop = Integer.valueOf(testInt);

                    if (type.equals("Flight")) {
                        Flight flight = new Flight(company, id, departDate, departTime, arrivalTime, connectOrStop);
                        transportationList.add(flight);
                    } else if (type.equals("Bus")) {
                        Bus bus = new Bus(company, id, departDate, departTime, arrivalTime, connectOrStop);
                        transportationList.add(bus);
                    } else {
                        throw new InvalidBookingException();
                    }
                }
            } else {

                throw new FileNotFoundException();

            }
        } else {

            throw new FileNotFoundException();

        }
        return transportationList;
    }
/** Creates a method writeBookings.
 * @param fileName Name of the file from which the data is to be read.
 * @param transportationList List of transportation objects to be accepted.
 * @return Returns a boolean value based on if the write is successful (true) or not (false).
 */
    public static boolean writeBookings(String fileName, ArrayList<Transportation> transportationList) {
        File other = new File(fileName);
        System.out.println(other.exists());
        System.out.println(other.isFile());
        try {
            if (other.exists() && other.isFile()) {
                System.out.println("1");
                ArrayList<Transportation> old = outputBookings(fileName);
                System.out.println("2");
                ArrayList<Transportation> temp = transportationList;
                System.out.println("3");
                temp.addAll(old);
                PrintWriter write = new PrintWriter(other);
                for (Transportation i: temp) {
                    write.println(i);
                }

                write.close();
                return true;
            } else {
                throw new FileNotFoundException();
            }

        } catch (FileNotFoundException fnf) {
            System.out.println(fnf);
            return false;
        } catch (InvalidBookingException ib) {
            System.out.println(ib);
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
/** Creates a method readBookings.
 * @param fileName Represents the name of the file from which the data is to be read.
 * @param t Represents the Transportation object t to be taken in.
 * @return Returns an ArrayList of Integer objects.
 * @throws InvalidBookingException Throws an exception when an invalid value is entered.
 * @throws FileNotFoundException Throws an exception if the file passed is null or non existent.
 */
    public static ArrayList<Integer> readBookings(String fileName, Transportation t)
        throws InvalidBookingException, FileNotFoundException {

        ArrayList<Transportation> transportationList = outputBookings(fileName);

        ArrayList<Integer> lineNums = new ArrayList<Integer>();

        for (int i = 0; 1 < transportationList.size(); i++) {

            if (transportationList.get(i).equals(t)) {
                lineNums.add(i);
            }
        }

        if (transportationList.size() == 0) {

            throw new InvalidBookingException();
        }
        return lineNums;
    }
/** Creates the main method which will implement and test our code.
 * @param args Represents the arguments taken in by the main method.
 * @throws InvalidBookingException Throws an exception if an invalid value is entered.
 * @throws FileNotFoundException Throws an exception if the file entered is not found.
 */
    public static void main(String[] args) throws InvalidBookingException, FileNotFoundException {
        Flight f1 = new Flight("Delta", 12345, "1-2-2021", "1200", "1200", 1);
        Flight f2 = new Flight("Southwest", 12345, "3-4-2021", "1200", "1200", 2);
        Bus b1 = new Bus("Greyhound", 12345, "5-6-2021", "1200", "1200", 3);
        Bus b2 = new Bus("School Bus", 12345, "7-8-2021", "1200", "1200", 4);
        ArrayList<Transportation> tList = new ArrayList<Transportation>();
        tList.add(f1);
        tList.add(f2);
        tList.add(b1);
        tList.add(b2);
        System.out.println("test1");
        System.out.println(writeBookings("testBooking.csv", tList));
        System.out.println("test2");
        ArrayList<Transportation> printList = outputBookings("testBooking.csv");
        for (Transportation i: printList) {
            System.out.println(i.toString());
        }

        Flight f3 = new Flight("Delta", 12345, "10-10-2021", "1200", "1200", 20);
        ArrayList<Transportation> tList2 = new ArrayList<Transportation>();
        tList2.add(f3);
        writeBookings("testBooking.csv", tList2);
    }
}