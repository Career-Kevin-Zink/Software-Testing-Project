
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

    class addflightTest {

        @BeforeEach
        @AfterEach
        public void initFlightTable() {
            // Set the database to the expected default state.
            try {
                Database.getConnection();
                Statement s = Database.connection.createStatement();
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
                        + "('FO003', 'American Airlines', 'India', 'Srilanka', '2019-06-15', '9.00AM', '10.00AM', '9000');");
            } catch (SQLException ignored) {}
        }

        public void wipeFlightTable() {
            // Wipe database to enter the null branch.
            try {
                Database.getConnection();
                Statement s = Database.connection.createStatement();
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
            } catch (SQLException ignored) {}
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
        void testCreateCustomer() {
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
                Database.getConnection();
                PreparedStatement pst =
                        Database.connection.prepareStatement(
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

        @Test
        void jButton1ActionPerformed() {

            addflight addFlight = new addflight();

            addFlight.txtflightid.setText("FO107");
            addFlight.txtflightname.setText("Delta");
            addFlight.txtsource.getItemAt(0);
            addFlight.txtdepart.getItemAt(1);
            Date date = new Date();
            addFlight.txtdate.setDate(date);
            addFlight.txtdtime.setText("8.00AM");
            addFlight.txtarrtime.setText("8.00PM");
            addFlight.txtflightcharge.setText("700");

            assertFalse(Database.doesFlightExist("FO107"));

            addFlight.jButton1.doClick();

            assertTrue(Database.doesFlightExist("FO107"));

        }

        @Test
        void initComponents() {

            long startTime = java.util.Calendar.getInstance().getTimeInMillis();
            new addflight().initComponents();
            long endTime = java.util.Calendar.getInstance().getTimeInMillis();

            // Testing the GUI initialization time is less than 5 seconds.
            assertTrue(endTime - startTime <= 5000);
        }

        @Test
        void jButton2ActionPerformed() {

            addflight addFlight = new addflight();

            // Setup the GUI
            addFlight.initComponents();

            // Execute the method.
            addFlight.jButton2.doClick();
        }
    }
