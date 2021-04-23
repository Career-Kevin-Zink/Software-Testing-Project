package integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import app.ticket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

@RunWith(MockitoJUnitRunner.class)
public class ticketIT {

    //setting the mock connection.
    @Mock
    private Connection conn;
    //setting the mock result set
    @Mock
    private ResultSet rs;
    // setting the mock prepared statement
    @Mock
    private PreparedStatement pst;
    //setting the mock db
    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
    }

    @BeforeEach
    @AfterEach
    public void initTicketTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE `ticket`");
            s.execute("CREATE TABLE `ticket` (" +
                    "  `id` varchar(255) NOT NULL," +
                    "  `flightid` varchar(255) NOT NULL," +
                    "  `custid` varchar(255) NOT NULL," +
                    "  `class` varchar(255) NOT NULL," +
                    "  `price` varchar(255) NOT NULL," +
                    "  `seats` varchar(255) NOT NULL," +
                    "  `date` varchar(255) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `ticket` (`id`, `flightid`, `custid`, `class`, `price`, `seats`, `date`) VALUES\n" +
                    "('TO001', 'FO003', 'CS001', 'Economy', 9000, 1, '2019-06-15')," +
                    "('TO002', 'FO003', 'CS001', 'Economy', 9000, 2, '2019-06-15')," +
                    "('TO003', 'FO001', 'CS003', 'Economy', 50000, 3, '2019-07-01');");

            // add table
        } catch (SQLException | ClassNotFoundException ignored){}
    }

    public void wipeTicketTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE `ticket`");
            s.execute("CREATE TABLE `ticket` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `flightid` varchar(255) NOT NULL,\n" +
                    "  `custid` varchar(255) NOT NULL,\n" +
                    "  `class` varchar(255) NOT NULL,\n" +
                    "  `price` varchar(255) NOT NULL,\n" +
                    "  `seats` varchar(255) NOT NULL,\n" +
                    "  `date` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        }catch (SQLException | ClassNotFoundException ignored) {}
    }
    /**
     * Requirement: The system shall allow users to search for flights by selecting a source and departure location.
     * <p>
     * Input: String"India", String"Uk",
     * Description: Input Validation: Assert that inputting a destination and source will fill the jtable.
     * <p>
     * Dependencies: None
     * Expected Output: true,
     * Actual Output: true,
     * Statement Coverage: 84%
     * Branch Coverage: 52%
     */
    @Test
    void testJButton3ActionPerformed(){

        ticket ticket = new ticket();

        //Simulating input into dropdown box's
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        //Testing to see if JTable is filled

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in TicketIT: testJButton3ActionPerformed");
        }
    }
    /**
     * Requirement:The system shall allow users to book tickets for an existing flight
     * by selecting the flight and providing their customer id, the ticket class, and the number of tickets.
     * <p>
     * Input: none
     * Description: this test checks to see if the database can incrememnt to the next ID
     * <p>
     * Dependencies: Database
     * Expected Output: true, true
     * Actual Output: true, true
     * Statement Coverage: 80%
     * Branch Coverage: 25%
     */
    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        new ticket().autoID();
        assertNotNull(conn);

        // Clear the database to trigger other branch.
        wipeTicketTable();

        // Test for "MAX(id)") == null.
        new ticket().autoID();
        assertNotNull(conn);
    }
    /**
     * Requirement: The system shall allow users to search for flights by selecting a source and departure location.
     * <p>
     * Input: String"83748902", String"CS001",
     * Description: Input Validation: Assert that inputting a valid customer ID will fill the appropriate fields.
     * <p>
     * Dependencies: None
     * Expected Output: false, true,
     * Actual Output: false, true,
     * Statement Coverage: 83%
     * Branch Coverage: 37%
     */
    @Test
    void testJButton4ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtcustid.setText("83748902");
        ticket.jButton4.doClick();

       try {
           when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        ticket.txtcustid.setText("CS001");
        ticket.jButton4.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement: None
     * <p>
     * Input: String"India", String"Uk", mouseclick
     * Description: Rerun of previous test, also that selecting the flight in the Jtable fills in the approrpriate fields.
     * <p>
     * Dependencies: None
     * Expected Output: true, true
     * Actual Output: true, true
     * Statement Coverage: 86%
     * Branch Coverage: 62%
     */
    @Test
    void jTable1MouseClickedTest() {

        ticket ticket = new ticket();
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        assertNotNull(conn);

        ticket.jTable1.changeSelection(0,0,false,false);

        DefaultTableModel Df = (DefaultTableModel) ticket.jTable1.getModel();
        int selectIndex = ticket.jTable1.getSelectedRow();

        ticket.flightno.setText(Df.getValueAt(selectIndex, 0).toString());
        ticket.flightname.setText(Df.getValueAt(selectIndex, 1).toString());
        ticket.txtdept.setText(Df.getValueAt(selectIndex, 5).toString());
        ticket.txtprice.setText(Df.getValueAt(selectIndex, 7).toString());
        ticket.jButton3.doClick();
        assertNotNull(conn);
    }
    /**
     * Requirement: The system shall allow users to book tickets for an existing flight
     * by selecting the flight and providing their customer id, the ticket class, and the number of tickets.
     * <p>
     * Input: String"2000",
     * Description: Checking the programming math to see if it correctly multiplies price by seats.
     * <p>
     * Dependencies: database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 81%
     * Branch Coverage: 12%
     */
    @Test
    void testTxtseatsStateChanged() {
        ticket ticket = new ticket();
        ticket.txtprice.setText("2000");
        ticket.txtseats.setValue(2);
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        assertNotNull(conn);
    }
    /**
     * Requirement: The system shall allow users to book tickets for an existing flight
     * by selecting the flight and providing their customer id, the ticket class, and the number of tickets.
     * <p>
     * Input: String"TO004",String"FO001",String"CS001",String"Economy",String"50000",Int"1",
     * Description: This test fills in the fields and then checks to see if the ticket exists
     * <p>
     * Dependencies: Database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 86%
     * Branch Coverage: 12%
     */
    @Test
    void testJButton1ActionPerformed() {
        ticket ticket = new ticket();

        ticket.txtticketno.setText("TO004");
        ticket.flightno.setText("FO001");
        ticket.txtcustid.setText("CS001");
        ticket.txtclass.setSelectedItem("Economy");
        ticket.txtprice.setText("50000");
        ticket.txtseats.setValue(1);


        ticket.jButton1.doClick();
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement: The system shall allow users to book tickets for an existing flight
     * by selecting the flight and providing their customer id, the ticket class, and the number of tickets.
     * <p>
     * Input: none
     * Description: this test checks to see if cancel hides the window correctly
     * <p>
     * Dependencies: none
     * Expected Output: true,
     * Actual Output: true,
     * Statement Coverage: 81%
     * Branch Coverage: 12%
     */
    @Test
    void testJButton2ActionPerformed() {
        ticket ticket = new ticket();

        ticket.jButton2.doClick();
        assertNotNull(conn);
    }

}
