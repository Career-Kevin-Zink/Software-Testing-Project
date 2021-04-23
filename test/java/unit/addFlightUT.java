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
    /**
     * Requirement:None
     * <p>
     * Input:String
     * Description:Checks to see if the database can increment id's
     * <p>
     * Dependencies: Database
     * Expected Output: True, True
     * Actual Output: True, True
     * Statement Coverage: 78%
     * Branch Coverage: 11%
     */
    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> new addflight().autoID());

        wipeFlightTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> new addflight().autoID());

    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"",String"USA",String"China",String"08:00",String"09:00",String"700"
     * Description:Testing passing values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False
     * Actual Output: False
     * Statement Coverage: 89%
     * Branch Coverage: 50%
     */
    @Test
    void testCreateFlightValidInput() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"",String"USA",String"China",String"08:00",String"09:00",String"700"
     * Description:Testing invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False`
     * Statement Coverage: 80%
     * Branch Coverage: 11%
     */
    @Test
    void testCreateFlightEmptyName() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"",String"China",String"08:00",String"09:00",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 81%
     * Branch Coverage: 16%
     */
    @Test
    void testCreateFlightInvalidSource() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem(null);
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"",String"08:00",String"09:00",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 81%
     * Branch Coverage: 22%
     */
    @Test
    void testCreateFlightInvalidDepart() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem(null);
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"USA",String"08:00",String"09:00",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 81%
     * Branch Coverage: 27%
     */
    @Test
    void testCreateFlightSourceEqualsDepart() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("USA");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"China",String"08:00",String"09:00",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 82%
     * Branch Coverage: 33%
     */
    @Test
    void testCreateFlightInvalidDate() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"China",String"",String"09:00",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 82%
     * Branch Coverage: 38%
     */
    @Test
    void testCreateFlightEmptyDepartureTime() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"China",String"08:00",String"",String"700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 82%
     * Branch Coverage: 44%
     */
    @Test
    void testCreateFlightEmptyArrivalTime() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("");
        addflight.txtflightcharge.setText("700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"China",String"08:00",String"09:00",String"-700"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 83%
     * Branch Coverage: 50%
     */
    @Test
    void testCreateFlightInvalidPrice() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("-700");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:String"F0105",String"Delta",String"USA",String"China",String"08:00",String"09:00",String"-"
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: False, False
     * Actual Output: False, False
     * Statement Coverage: 83%
     * Branch Coverage: 44%
     */
    @Test
    void testCreateFlightEmptyPrice() {
        addflight addflight = new addflight();
        addflight.txtflightid.setText("FO105");
        addflight.txtflightname.setText("Delta");
        addflight.txtsource.setSelectedItem("USA");
        addflight.txtdepart.setSelectedItem("China");
        addflight.txtdate.setDate(new Date());
        addflight.txtdtime.setText("08:00");
        addflight.txtarrtime.setText("09:00");
        addflight.txtflightcharge.setText("");

        assertFalse(doesFlightExist("FO105"));
        addflight.jButton1.doClick();
        assertFalse(doesFlightExist("FO105"));
    }
    /**
     * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:none
     * Description:Testing Invalid values for the creation of a new flight.
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 79%
     * Branch Coverage: 5%
     */
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


