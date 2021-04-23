package performance;

import app.searchCustomer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class searchCustomerPT extends Component {


    @BeforeEach
    @AfterEach
    public void initUserTable() {
        // Set the database to the expected default state.
        byte[] smallphoto = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            Statement s = con.createStatement();

            // Drop the table and recreate.
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `nic` varchar(255) NOT NULL,\n" +
                    "  `passport` varchar(255) NOT NULL,\n" +
                    "  `address` text NOT NULL,\n" +
                    "  `dob` varchar(255) NOT NULL,\n" +
                    "  `gender` varchar(255) NOT NULL,\n" +
                    "  `contact` int(11) NOT NULL,\n" +
                    "  `photo` longblob NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

            // Add initial values.
            PreparedStatement pst = con.prepareStatement("insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, "CS001");
            pst.setString(2, "John");
            pst.setString(3, "Alex");
            pst.setString(4, "34232222");
            pst.setString(5, "3443");
            pst.setString(6, "Uk");
            pst.setString(7, "1996-06-01");
            pst.setString(8, "Male");
            pst.setString(9, "34324234");
            pst.setBytes(10, smallphoto);
            pst.executeUpdate();

            pst.setString(1, "CS002");
            pst.setString(2, "Jim");
            pst.setString(3, "Jones");
            pst.setString(4, "34324");
            pst.setString(5, "433");
            pst.setString(6, "Africa");
            pst.setString(7, "2019-06-14");
            pst.setString(8, "Male");
            pst.setString(9, "3432423");
            pst.setBytes(10, smallphoto);
            pst.executeUpdate();

            pst.setString(1, "CS003");
            pst.setString(2, "John");
            pst.setString(3, "Peter");
            pst.setString(4, "232423423V");
            pst.setString(5, "48733");
            pst.setString(6, "India");
            pst.setString(7, "2007-06-02");
            pst.setString(8, "Male");
            pst.setString(9, "324324324");
            pst.setBytes(10, smallphoto);
            pst.executeUpdate();

            pst.setString(1, "CS004");
            pst.setString(2, "Lily");
            pst.setString(3, "Tester");
            pst.setString(4, "232423423B");
            pst.setString(5, "48734");
            pst.setString(6, "USA");
            pst.setString(7, "2007-06-02");
            pst.setString(8, "Female");
            pst.setString(9, "324324328");
            pst.setBytes(10, smallphoto);
            pst.executeUpdate();


        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }

    public void wipeCustomerTable() {
        // Wipe database to enter the null branch.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
            Statement s = con.createStatement();
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException | ClassNotFoundException ignored) {
        }
    }
    /**
     * Requirement:The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:none
     * Description:Check for a valid or invalid picture
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 72%
     * Branch Coverage: 0%
     */
    @Test
    @DisplayName("Initialize searchCustomer UI in less than 5 seconds")
    public void initComponents() {
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        new searchCustomer();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();

        assertTrue(endTime - startTime <= 5000);
    }

    @Test
    @DisplayName("Ensure the picture chooser opens and closes correctly.")
    public void picChooser() {
        searchCustomer sc = new searchCustomer();
        sc.jButton1.doClick();
        assertNotNull(sc.userimage);
    }
    /**
     * Requirement:The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:String "joe", String, "Mana", String"NICJOE123", String"JOEPASSPORT1" String "JOEADDRESS123"String"5558802"
     * Description:Checks to see if the method correctly updates the database
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 79%
     * Branch Coverage: 12%
     */
    @Test
    @DisplayName("Update Customer in less than 5 seconds")
    public void updateMale() {
        searchCustomer sc = new searchCustomer();

        sc.txtcustid.setText("CS001");
        sc.txtfirstname.setText("Joe");
        sc.txtlastname.setText("Mana");
        sc.txtnic.setText("NICJOE123");
        sc.txtpassport.setText("JOEPASSPORT1");
        sc.txtaddress.setText("JOEADDRESS123");
        sc.txtdate = new Date();
        sc.r1.setSelected(true);
        sc.txtcontact.setText("5558802");
        sc.userimage = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton2.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
    }
    /**
     * Requirement:The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:String "alex", String, "jones", String"34324", String"3443" String "TEXAS"
     * Description:Checks to see if the method correctly updates the database in less than 5 seconds
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 79%
     * Branch Coverage: 12%
     */
    @Test
    @DisplayName("Update Customer in less than 5 seconds")
    public void updateFemaleTest() {
        searchCustomer sc = new searchCustomer();

        sc.txtcustid.setText("CS001");
        sc.txtfirstname.setText("Jane");
        sc.txtlastname.setText("Mana");
        sc.txtnic.setText("NICJANE123");
        sc.txtpassport.setText("JANEPASSPORT1");
        sc.txtaddress.setText("JANEADDRESS123");
        sc.txtdate = new Date();
        sc.r1.setSelected(false);
        sc.r2.setSelected(true);
        sc.txtcontact.setText("5558801");
        sc.userimage = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton2.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
    }
    /**
     * Requirement: The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:
     * Description: checks to see if the program can fill in the appropriate fields given a valid custid
     * in less than 5 seconds
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 80%
     * Branch Coverage: 32%
     */
    @Test
    @DisplayName("Search customer in less than 5 seconds")
    public void searchTestValidMaleCustomer() {
        searchCustomer sc = new searchCustomer();
        sc.txtcustid.setText("CS001");
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton4.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
    }
    /**
     * Requirement: The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:
     * Description: checks to see if the program can fill in the appropriate fields given a valid custid
     * in less than 5 seconds
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 83%
     * Branch Coverage: 29%
     */
    @Test
    @DisplayName("Search customer in less than 5 seconds")
    public void searchTestValidFemaleCustomer() {
        searchCustomer sc = new searchCustomer();
        sc.txtcustid.setText("CS004");
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton4.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
    }
    /**
     * Requirement: The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:
     * Description: Checks to make sure that an invalid CustID responds with the popup window in less than 5 seconds
     * <p>
     * Dependencies: Database
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 81%
     * Branch Coverage: 25%
     */
    @Test
    @DisplayName("Search customer in less than 5 seconds")
    public void searchTestInvalidCustomer() {
        searchCustomer sc = new searchCustomer();
        sc.txtcustid.setText("howdy");
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton4.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
    }
    /**
     * Requirement: The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:
     * Description: Checks to see if the cancel button method works correctly in less than 1 second
     * <p>
     * Dependencies: none
     * Expected Output: True
     * Actual Output: True
     * Statement Coverage: 73%
     * Branch Coverage: 0%
     */
    @Test
    @DisplayName("Hide the window in less than 1 second.")
    void hideTest() {
        searchCustomer sc = new searchCustomer();
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        sc.jButton3.doClick();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 1000);
    }
    /**
     * Requirement:The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:String none,
     * Description: txtlastname action performed test
     * <p>
     * Dependencies: Database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 75%
     * Branch Coverage: 12%
     */
    @Test
    @DisplayName("Test txtlastnameActionPerformed")
    void txtlastnameActionPerformed() {
        ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED, 1, null);
        assertDoesNotThrow(() -> new searchCustomer().txtlastnameActionPerformed(ae));
    }
    /**
     * Requirement:The system shall fetch customer details from the database in under five seconds.
     * <p>
     * Input:String none,
     * Description: txtpassport action performed test
     * <p>
     * Dependencies: Database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 75%
     * Branch Coverage: 12%
     */
    @Test
    @DisplayName("Test txtpassportActionPerformed")
    void txtpassportActionPerformed() {
        ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED, 1, null);
        assertDoesNotThrow(() -> new searchCustomer().txtpassportActionPerformed(ae));
    }
}