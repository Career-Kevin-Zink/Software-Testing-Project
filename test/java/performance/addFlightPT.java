package performance;

import app.addflight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class addFlightPT {
  @BeforeEach
  @AfterEach
  public void initFlightTable() {
    // Set the database to the expected default state.
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `flight`");
      s.execute("CREATE TABLE `flight` (\n" +
              "  `id` varchar(255) NOT NULL, \n" +
              "  `flightname` varchar(255) NOT NULL, \n" +
              "  `source` varchar(255) NOT NULL, \n" +
              "  `depart` varchar(255) NOT NULL, \n" +
              "  `date` varchar(255) NOT NULL, \n" +
              "  `deptime` text NOT NULL, \n" +
              "  `arrtime` varchar(255) NOT NULL, \n" +
              "  `flightcharge` varchar(255) NOT NULL\n" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
      s.execute("INSERT INTO `flight` (`id`, `flightname`, `source`, `depart`, `date`, `deptime`, `arrtime`, `flightcharge`) VALUES "
              + "('FO001', 'JetBlue', 'India', 'Uk', '2019-06-14', '8.00AM', '10.00Pm', '50000'),"
              + "('FO002', 'Delta', 'India', 'China', '2019-06-15', '8.00PM', '2.00AM0', '15000'),"
              + "('FO003', 'American Airlines', 'India', 'Sri Lanka', '2019-06-15', '9.00AM', '10.00AM', '9000');");
    } catch (SQLException | ClassNotFoundException ignored) {}
  }

  public void wipeFlightTable() {
    // Wipe database to enter the null branch.
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `flight`");
      s.execute("CREATE TABLE `flight` (\n" +
              "  `id` varchar(255) NOT NULL, \n" +
              "  `flightname` varchar(255) NOT NULL, \n" +
              "  `source` varchar(255) NOT NULL, \n" +
              "  `depart` varchar(255) NOT NULL, \n" +
              "  `date` varchar(255) NOT NULL, \n" +
              "  `deptime` varchar(255) NOT NULL, \n" +
              "  `arrtime` varchar(255) NOT NULL, \n" +
              "  `flightcharge` varchar(255) NOT NULL\n" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
    } catch (SQLException | ClassNotFoundException ignored) {}
  }


  @Test
  @DisplayName("Initialize addflight UI in less than 5 seconds")
  void initComponents() {

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new addflight();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  void testAutoID() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Test for "MAX(id)") != null.
    assertDoesNotThrow(() -> new addflight().autoID());
    wipeFlightTable();
    // Test for "MAX(id)") == null.
    assertDoesNotThrow(() -> new addflight().autoID());

    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testCreateFlight() {
    //testing to see if the program can create a flight and store it in less than 5 seconds
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    // Valid Flight information.
    String id = "FO005";
    String flightName = "Delta";
    String source = "USA";
    String depart = "China";
    String date = "2021-03-26";
    String depTime = "8.00AM";
    String arrTime = "8.00PM";
    String flightCharge = "700";

    try {

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      PreparedStatement pst =
              con.prepareStatement(
                      "insert into flight(id,flightname,source,depart,date,deptime,arrtime,flightcharge)values(?,?,?,?,?,?,?,?)");

      pst.setString(1, id);
      pst.setString(2, flightName);
      pst.setString(3, source);
      pst.setString(4, depart);
      pst.setString(5, date);
      pst.setString(6, depTime);
      pst.setString(7, arrTime);
      pst.setString(8, flightCharge);
      pst.executeUpdate();
    } catch (Exception ignored) {
    }
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Testing passing values for the creation of a new flight.
   */
  @Test   //testing to see if jButton1 passes values and finishes in less than 5 seconds
  void jButton1ActionPerformedPassValues() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    addflight addFlight = new addflight();

    addFlight.txtflightid.setText("FO107");
    addFlight.txtflightname.setText("Delta");
    addFlight.txtsource.getItemAt(0);
    addFlight.txtdepart.getItemAt(1);
    java.util.Date date = new Date();
    addFlight.txtdate.setDate(date);
    addFlight.txtdtime.setText("8.00AM");
    addFlight.txtarrtime.setText("8.00PM");
    addFlight.txtflightcharge.setText("700");
    addFlight.jButton1.doClick();

    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void jButton1ActionPerformedFailDate() {
    //testing to see if the wrong information error pops up in less than 5 seconds
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    addflight addFlight = new addflight();

    addFlight.txtflightid.setText("FO108");
    addFlight.txtflightname.setText("Delta");
    addFlight.txtsource.getItemAt(0);
    addFlight.txtdepart.getItemAt(1);
    Date date = new GregorianCalendar(2021, Calendar.JANUARY, 01).getTime();
    addFlight.txtdate.setDate(date);
    addFlight.txtdtime.setText("8.00AM");
    addFlight.txtarrtime.setText("8.00PM");
    addFlight.txtflightcharge.setText("700");


    addFlight.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test  //testing to see if the wrong information error pops up in less than 5 seconds
  void jButton1ActionPerformedFailDeptTime() {

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    addflight addFlight = new addflight();
    addFlight.txtflightid.setText("FO109");
    addFlight.txtflightname.setText("Delta");
    addFlight.txtsource.getItemAt(0);
    addFlight.txtdepart.getItemAt(1);
    Date date = new Date();
    addFlight.txtdate.setDate(date);
    addFlight.txtdtime.setText("-8.00AM");
    addFlight.txtarrtime.setText("8.00PM");
    addFlight.txtflightcharge.setText("700");
    addFlight.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void jButton1ActionPerformedFailArrivalTime() {
    //testing to see if the wrong information error pops up in less than 5 seconds
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    addflight addFlight = new addflight();
    addFlight.txtflightid.setText("FO110");
    addFlight.txtflightname.setText("Delta");
    addFlight.txtsource.getItemAt(0);
    addFlight.txtdepart.getItemAt(1);
    Date date = new Date();
    addFlight.txtdate.setDate(date);
    addFlight.txtdtime.setText("8.00AM");
    addFlight.txtarrtime.setText("-8.00PM");
    addFlight.txtflightcharge.setText("700");
    addFlight.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void jButton1ActionPerformedFailCharge() {

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();

    addflight addFlight = new addflight();
    addFlight.txtflightid.setText("FO111");
    addFlight.txtflightname.setText("Delta");
    addFlight.txtsource.getItemAt(0);
    addFlight.txtdepart.getItemAt(1);
    Date date = new Date();
    addFlight.txtdate.setDate(date);
    addFlight.txtdtime.setText("8.00AM");
    addFlight.txtarrtime.setText("8.00PM");
    addFlight.txtflightcharge.setText("-700");
    addFlight.jButton1.doClick();

    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void jButton2ActionPerformed() {
    //Testing to see if the button will close the window in less than 5 seconds
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();

    addflight addFlight = new addflight();
    // Setup the GUI
    addFlight.initComponents();
    assertTrue(true);
    // Execute the method.
    addFlight.jButton2.doClick();

    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
}
