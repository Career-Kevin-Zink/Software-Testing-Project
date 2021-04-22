package integration;

import app.addflight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class addFlightIT {

    @Mock
    private Connection conn;

    @Mock
    private ResultSet rs;

    @Mock
    private PreparedStatement pst;

    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
    }

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
    void autoIDPassed() {

        addflight addFlight = new addflight();

        addFlight.autoID();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlight: autoIDPassed()");
        }
    }

    @Test
    void autoIDFailed() {

        addflight addFlight = new addflight();
        wipeFlightTable();
        addFlight.autoID();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in AddFlightIT: autoIDFailed()");
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
        addFlight.txtsource.getItemAt(0);
        addFlight.txtdepart.getItemAt(1);
        java.util.Date date = new Date();
        addFlight.txtdate.setDate(date);
        addFlight.txtdtime.setText("8.00AM");
        addFlight.txtarrtime.setText("8.00PM");
        addFlight.txtflightcharge.setText("700");

        try {
            when(!rs.next()).thenReturn(false);
            addFlight.jButton1.doClick();
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlightIT: jButton1ActionPerformedPassValues()");
        }
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

        try {
            when(!rs.next()).thenReturn(false);
            addFlight.jButton1.doClick();
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlightIT: jButton1ActionPerformedFailDate()");
        }
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

        try {
            when(!rs.next()).thenReturn(false);
            addFlight.jButton1.doClick();
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlightIT: jButton1ActionPerformedFailDeptTime()");
        }
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

        try {
            when(!rs.next()).thenReturn(false);
            addFlight.jButton1.doClick();
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlightIT: jButton1ActionPerformedArrivalTime()");
        }
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

        try {
            when(!rs.next()).thenReturn(false);
            addFlight.jButton1.doClick();
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addFlightIT: jButton1ActionPerformedFailCharge()");
        }
    }

    @Test
    void jButton2ActionPerformed() {
        addflight addFlight = new addflight();
        // Execute the method.
        addFlight.jButton2.doClick();
        assertNotNull(conn);
    }
}
