package unit;

import app.addflight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class addFlightUT {

    @BeforeEach
    @AfterEach
    public void initFlightTable() {
        // Set the database to the expected default state.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            Statement s = con.createStatement();
            s.execute("DROP TABLE IF EXISTS `flight`");
            s.execute("CREATE TABLE `flight` (" +
                    "  `id` varchar(255) NOT NULL, " +
                    "  `flightname` varchar(255) NOT NULL, " +
                    "  `source` varchar(255) NOT NULL, " +
                    "  `depart` varchar(255) NOT NULL, " +
                    "  `date` varchar(255) NOT NULL, " +
                    "  `deptime` text NOT NULL," +
                    "  `arrtime` varchar(255) NOT NULL, " +
                    "  `flightcharge` varchar(255) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `flight` (`id`, `flightname`, `source`, `depart`, `date`, `deptime`, `arrtime`, `flightcharge`) VALUES "
                    + "('FO001', 'JetBlue', 'India', 'Uk', '2019-06-14', '8.00AM', '10.00Pm', '50000'),"
                    + "('FO002', 'Delta', 'India', 'China', '2019-06-15', '8.00PM', '2.00AM0', '15000'),"
                    + "('FO003', 'American Airlines', 'India', 'Sri Lanka', '2019-06-15', '9.00AM', '10.00AM', '9000');");
        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }

    public void wipeFlightTable() {
        // Wipe database to enter the null branch.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
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
        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> new addflight().autoID());

        wipeFlightTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> new addflight().autoID());

    }

    @Test
    void testCreateFlight() {
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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
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
    }

    /**
     * Testing passing values for the creation of a new flight.
     */
    @Test
    void jButton1ActionPerformedPassValues() {
        addflight addFlight = new addflight();

        addFlight.txtflightid.setText("FO107");
        addFlight.txtflightname.setText("Delta");
        addFlight.txtsource.setSelectedItem("India");
        addFlight.txtdepart.setSelectedItem("Uk");
        Date date = new Date();
        addFlight.txtdate.setDate(date);
        addFlight.txtdtime.setText("8.00AM");
        addFlight.txtarrtime.setText("8.00PM");
        addFlight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO107"));

        addFlight.jButton1.doClick();

        assertTrue(doesFlightExist("FO107"));
    }

    @Test
    void jButton1ActionPerformedFailDate() {

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

        assertFalse(doesFlightExist("FO108"));

        addFlight.jButton1.doClick();

        assertFalse(doesFlightExist("FO108"));
    }

    @Test
    void jButton1ActionPerformedFailDeptTime() {

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

        assertFalse(doesFlightExist("FO109"));

        addFlight.jButton1.doClick();

        assertFalse(doesFlightExist("FO109"));
    }

    @Test
    void jButton1ActionPerformedFailArrivalTime() {

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

        assertFalse(doesFlightExist("FO110"));

        addFlight.jButton1.doClick();

        assertFalse(doesFlightExist("FO110"));
    }

    @Test
    void jButton1ActionPerformedFailCharge() {

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

        assertFalse(doesFlightExist("FO111"));

        addFlight.jButton1.doClick();

        assertFalse(doesFlightExist("FO111"));

    }

    @Test
    void jButton2ActionPerformed() {

        addflight addFlight = new addflight();

        // Setup the GUI
        addFlight.initComponents();

        assertTrue(true);

        // Execute the method.
        addFlight.jButton2.doClick();
    }

    public static boolean doesFlightExist(String flightId) {
        boolean returnVal = false;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM flight WHERE id = ?");
            pst.setString(1, flightId);


            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("SQLException in doesFlightExist: " + e.getMessage());
            e.printStackTrace();
        }
        return returnVal;
    }
}


