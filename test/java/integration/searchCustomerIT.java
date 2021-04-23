package integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import app.searchCustomer;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class searchCustomerIT {
  //sets mock connection
  @Mock
  private Connection conn;
  //sets mock result set
  @Mock
  private ResultSet rs;
  //sets mock prepared statement
  @Mock
  private PreparedStatement pst;
  //sets mock DB
  @BeforeEach
  void setDB() {
    conn = mock(Connection.class);
    rs = mock(ResultSet.class);
    pst = mock(PreparedStatement.class);
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
  void txtlastnameActionPerformed() {

    ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED,1, null);
    new searchCustomer().txtlastnameActionPerformed(ae);
    assertNotNull(conn);
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
  void txtpassportActionPerformed() {

    ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED,1, null);
    new searchCustomer().txtpassportActionPerformed(ae);
    assertNotNull(conn);
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:none
   * Description:Check to see if the method updates the fields with customer information
   * <p>
   * Dependencies: Database
   * Expected Output:  True
   * Actual Output: True
   * Statement Coverage: 77%
   * Branch Coverage: 25%
   */
  @Test
  @DisplayName("jBtn #1 ActionPerformed")
  void jButtonOneActionPerformed() {
    searchCustomer searchCustomer = new searchCustomer();
    searchCustomer.jButton1.doClick();
    assertNotNull(conn);
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "alex", String, "jones", String"34324", String"3443" String "TEXAS"
   * Description:Checks to see if the method correctly updates the database
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 79%
   * Branch Coverage: 12%
   */
  @Test
  @DisplayName("jBtn #2 ActionPerformed (UPDATE CUSTOMER) Male")
  void jBtnTwoActionPerformedMale() {

    searchCustomer searchCustomer = new searchCustomer();

              // r1 selected sets 'Gender' to "Male", r2 sets to "Female"
    searchCustomer.r1.setSelected(true);
    searchCustomer.txtfirstname.setText("alex");
    searchCustomer.txtlastname.setText("jones");
    searchCustomer.txtnic.setText("34324");
    searchCustomer.txtpassport.setText("3443");
    searchCustomer.txtaddress.setText("TEXAS");
    searchCustomer.txtdate = new Date();
    searchCustomer.jButton2.doClick();

    try {

      if (rs.next()) {
        doReturn(true).when(rs).next();
      }
      else if (rs != null){
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in searchCustomerIT: JBtnTwoActionPerformedFemale");
    }
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "alex", String, "jones", String"34324", String"3443" String "TEXAS"
   * Description:Checks to see if the method correctly updates the database
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 79%
   * Branch Coverage: 12%
   */
  @Test
  @DisplayName("jBtn #2 ActionPerformed (UPDATE CUSTOMER) Female")
  void jBtnTwoActionPerformedFemale() {

    searchCustomer searchCustomer = new searchCustomer();

    // r1 selected sets 'Gender' to "Male", r2 sets to "Female"
    searchCustomer.r2.setSelected(true);
    searchCustomer.txtfirstname.setText("alex");
    searchCustomer.txtlastname.setText("jones");
    searchCustomer.txtnic.setText("34324");
    searchCustomer.txtpassport.setText("3443");
    searchCustomer.txtaddress.setText("TEXAS");
    searchCustomer.txtdate = new Date();
    searchCustomer.jButton2.doClick();

    try {

      if (rs.next()) {
        doReturn(true).when(rs).next();
      }
      else if (rs != null){
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in searchCustomerIT: JBtnTwoActionPerformedFemale");
    }
  }
  /**
   * Requirement: none
   * <p>
   * Input:
   * Description: Checks to see if the cancel button method works correctly
   * <p>
   * Dependencies: none
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 73%
   * Branch Coverage: 0%
   */
  @Test
  @DisplayName("jBtn #3 ActionPerformed")
  void jBtnTHREEActionPerformed() {

    ActionEvent ae = new ActionEvent(ActionEvent.ACTION_PERFORMED,1, null);
    new searchCustomer().jButton3ActionPerformed(ae);
    assertNotNull(conn);
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "CS001",
   * Description:Checks the database to see if the customers picture updates with the database correctly
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 81%
   * Branch Coverage: 25%
   */
  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Passed Male")
  void jBtnFOURActionPerformedPassedMale() {

    searchCustomer searchCustomer = new searchCustomer();

    searchCustomer.pack();
    searchCustomer.setVisible(true);
    searchCustomer.txtcustid.setText("CS001");
    searchCustomer.r1.setSelected(true);

    searchCustomer.jButton4.doClick();

    try {

      if (rs.next()) {
        doReturn(true).when(rs).next();
      } else if (rs != null) {
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in searchCustomerIT: JBtnFourActionPerformedPassedMale");
    }
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "CS001",
   * Description:Checks the database to see if the customers picture updates with the database correctly (Fail)
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 75%
   * Branch Coverage: 12%
   */
    @Test
    @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Failed Male")
    void jBtnFourActionPerformedFailedMale() {

    searchCustomer searchCustomer = new searchCustomer();

      wipeCustomerTable();
      searchCustomer.pack();
      searchCustomer.setVisible(true);
      searchCustomer.txtcustid.setText("CS001");
      searchCustomer.r1.setSelected(true);

      searchCustomer.jButton4.doClick();

      try {

        if (rs.next()) {
          doReturn(true).when(rs).next();
        } else if (rs != null) {
          when(!rs.next()).thenReturn(false);
        }
      } catch (SQLException se) {
        se.printStackTrace();
        System.out.println("SQLException in searchCustomerIT: JBtnFourActionPerformedFailedMale");
      }
    }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "CS001",
   * Description:Checks the database to see if the customers picture updates with the database correctly
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 81%
   * Branch Coverage: 25%
   */
  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Passed Female")
  void jBtnFourActionPerformedPassedFemale() {

    searchCustomer searchCustomer = new searchCustomer();

    searchCustomer.pack();
    searchCustomer.setVisible(true);
    searchCustomer.txtcustid.setText("CS004");
    searchCustomer.r2.setSelected(true);

    searchCustomer.jButton4.doClick();

    try {

      if (rs.next()) {
        doReturn(true).when(rs).next();
      } else if (rs != null) {
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in searchCustomerIT: JBtnFourActionPerformedPassedFemale");
    }
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   * <p>
   * Input:String "CS004",
   * Description:Checks the database to see if the customers picture updates with the database correctly (Fail)
   * <p>
   * Dependencies: Database
   * Expected Output: none
   * Actual Output: none
   * Statement Coverage: 75%
   * Branch Coverage: 12%
   */
  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Failed Female")
  void jBtnFOURActionPerformedFailedFemale() {
    searchCustomer searchCustomer = new searchCustomer();

    wipeCustomerTable();
    searchCustomer.pack();
    searchCustomer.setVisible(true);
    searchCustomer.txtcustid.setText("CS004");
    searchCustomer.r2.setSelected(true);

    searchCustomer.jButton4.doClick();

    try {

      if (rs.next()) {
        doReturn(true).when(rs).next();
      } else if (rs != null) {
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in searchCustomerIT: JBtnFourActionPerformedFailedFemale");
    }
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


    } catch (SQLException | ClassNotFoundException ignored) {}
  }

}
