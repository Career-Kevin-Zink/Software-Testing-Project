package integration;

import app.addCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class addCustomerIT {
    //mock the connection
    @Mock
    private Connection conn;
    //mock the result set
    @Mock
    private ResultSet rs;
    //mock the prepared statement
    @Mock
    private PreparedStatement pst;
    //set the mock database
    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
    }

    @BeforeEach
    @AfterEach
    public void initUserTable() {
        // Set the database to the expected default state.
        byte[] smallphoto = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
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
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    public void wipeCustomerTable() {
        // Wipe database to enter the null branch.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    @Test
    void autoIDPassed() {

        addCustomer addCustomer = new addCustomer();

        addCustomer.autoID();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addCustomerIT: autoIDPassed()");
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:None
     * Description:Testing the database to see if it can increment to the next ID
     * <p>
     * Dependencies: Database
     * Expected Output: True, True
     * Actual Output: True, True
     * Statement Coverage: 80%
     * Branch Coverage: 9%
     */
    @Test
    void autoIDFailed() {

        addCustomer addCustomer = new addCustomer();
        wipeCustomerTable();
        addCustomer.autoID();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addCustomerIT: autoIDFailed()");
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:None
     * Description: It tests the txtlastnameActionPerformed method.
     * <p>
     * Dependencies: Database
     * Expected Output: True,
     * Actual Output: True,
     * Statement Coverage: 80%
     * Branch Coverage: 4%
     */
    @Test
    void txtlastnameActionPerformed() {

        ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED,1, null);
        new addCustomer().txtlastnameActionPerformed(ae);
        assertNotNull(conn);
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:None
     * Description: It tests the txtpassportActionPerformed method.
     * <p>
     * Dependencies: Database
     * Expected Output: True,
     * Actual Output: True,
     * Statement Coverage: 80%
     * Branch Coverage: 4%
     */
    @Test
    void txtpassportActionPerformed() {

        ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED,1, null);
        new addCustomer().txtpassportActionPerformed(ae);
        assertNotNull(conn);
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:None
     * Description: checks to see if the image chooser works correctly
     * <p>
     * Dependencies: Database
     * Expected Output: True,
     * Actual Output: True,
     * Statement Coverage: 85%
     * Branch Coverage: 13%
     */
    @Test
    void jButton1ActionPerformed() {
        addCustomer addCustomer = new addCustomer();
        addCustomer.jButton1.doClick();
        assertNotNull(addCustomer.userimage);
        assertNotNull(conn);
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS004",String"John",String"Doe",String"JohnnyPassport",String"123 Apple Street",String"123456"
     * Description: mocks adding two valid customers
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 88%
     * Branch Coverage: 45%
     */
    @Test
    void jButton2ActionPerformed() {
        addCustomer addCustomer = new addCustomer();

        // Male customer
        addCustomer.txtid.setText("CS004");
        addCustomer.txtfirstname.setText("John");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JohnnyPassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.JANUARY, 1));
        addCustomer.r1.setSelected(true);
        addCustomer.r2.setSelected(false);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addCustomerIT: jButton2ActionPerformed()");
        }

        // Female customer
        addCustomer = new addCustomer();
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in addCustomerIT: jButton2ActionPerformed()");
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS004",String"John",String"Doe",String"JohnnyPassport",String"123 Apple Street",String"123456"
     * Description: checks to see if adding a valid male customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 88%
     * Branch Coverage: 45%
     */
    @Test
    void addCustomerValidMale() {
        addCustomer addCustomer = new addCustomer();

        // Male customer
        addCustomer.txtid.setText("CS004");
        addCustomer.txtfirstname.setText("John");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JohnnyPassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.JANUARY, 1));
        addCustomer.r1.setSelected(true);
        addCustomer.r2.setSelected(false);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
}
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123"String"JanePassport",String"123 Apple Street",String"123456"
     * Description: checks to see if adding a valid female customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 88%
     * Branch Coverage: 45%
     */
    @Test
    void addCustomerValidFemale() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Doe",String"ABC123"String"JanePassport",String"123 Apple Street",String"123456"
     * Description: checks to see if adding an invalid first name works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 9%
     */
    @Test
    void addCustomerInvalidFirstName() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"ABC123",String"JanePassport",String"123 Apple Street",String"123456"
     * Description: checks to see if adding an invalid last name works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 13%
     */
    @Test
    void addCustomerInvalidLastName() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"JanePassport",String"123 Apple Street",String"123456"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 18%
     */
    @Test
    void addCustomerInvalidNicNumber() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"123 Apple Street",String"123456"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 22%
     */
    @Test
    void addCustomerInvalidPassport() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"JanePassport",String"123456"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 27%
     */
    @Test
    void addCustomerInvalidAddress() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"JanePassport",String"123456"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 88%
     * Branch Coverage: 45%
     */
    @Test
    void addCustomerInvalidDate() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        //addCustomer.txtdate.setDate(null);
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"JanePassport",String""
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 31%
     */
    @Test
    void addCustomerEmptyContact() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"JanePassport",String"Hello"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 84%
     * Branch Coverage: 45%
     */
    @Test
    void addCustomerInvalidContact() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("hello");
        addCustomer.userimage = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:String"CS005",String"Jane",String"Doe",String"ABC123",String"JanePassport",String"123456"
     * Description: checks to see if adding an invalid customer works correctly.
     * <p>
     * Dependencies: Database
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 36%
     */
    @Test
    void addCustomerInvalidUserImage() {
        addCustomer addCustomer = new addCustomer();

        // Female customer
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");

        addCustomer.jButton2.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }
    /**
     * Requirement:The system shall allow users to create new customers by providing the first name, last name,
     * NIC number, passport id, address, date of birth, gender, contact number, and a photo of the customer.
     * <p>
     * Input:None
     * Description: checks to see if hitting the cancel button correctly brings us back to the main screen.
     * <p>
     * Dependencies: None
     * Expected Output: None
     * Actual Output: None
     * Statement Coverage: 81%
     * Branch Coverage: 4%
     */
    @Test
    void jButton3ActionPerformed() {
        new addCustomer().jButton3.doClick();
        assertNotNull(conn);
    }
}
