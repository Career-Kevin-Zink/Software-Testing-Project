package unit;

import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;

import app.searchCustomer;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class searchCustomerUT {
  searchCustomer searchCustomerTestObject = new searchCustomer();
  ActionEvent e = new ActionEvent(ActionEvent.ACTION_PERFORMED, 0, "test");

  // The system shall allow users to SEARCH existing customers in the database.
  @Test
  @DisplayName("Customer ID  (valid/invalid)")
  void testCustomerID() {
    assertFalse(doesCustomerExist("001"));
    assertTrue(doesCustomerExist("CS001"));
    Assertions.assertNotEquals("", searchCustomerTestObject.txtcustid.getSelectedText());
  }

  // The system shall allow users to UPDATE existing customers in the database.
  @Test
  @DisplayName("Firstname (valid/invalid)")
  void testFirstName() {
    assertFalse("Starfox332".chars().allMatch(Character::isLetter));
    assertTrue("john".chars().allMatch(Character::isLetter));
    Assertions.assertNotEquals("", searchCustomerTestObject.txtfirstname.getSelectedText());
  }

  @Test
  @DisplayName("Lastname (valid/invalid)")
  void testLastName() {
    assertFalse("1inu5".chars().allMatch(Character::isLetter));
    assertTrue("Linus".chars().allMatch(Character::isLetter));

    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtlastnameActionPerformed(e);
    Assertions.assertNotEquals("", searchCustomerTestObject.txtlastname.getSelectedText());
  }

  @Test
  @DisplayName("Nic # (valid/invalid)")
  void testNicNum() {
    Assertions.assertNotEquals("", searchCustomerTestObject.txtnic.getSelectedText());
  }

  @Test
  @DisplayName("Passport ID (valid/invalid)")
  void testPassportID() {
    searchCustomerTestObject.txtpassportActionPerformed(e);
    Assertions.assertNotEquals("", searchCustomerTestObject.txtpassport.getSelectedText());
  }

  @Test
  @DisplayName("DOB (valid/invalid)")
  void testDOB() {
    searchCustomerTestObject.txtdate = new Date();
    Assertions.assertNotEquals("", searchCustomerTestObject.txtdate.toString());
  }

  @Test
  @DisplayName("Gender (valid/invalid)")
  void testGender() {

    //Male
    searchCustomerTestObject.r1.setSelected(true);
    Assertions.assertTrue(searchCustomerTestObject.r1.isSelected());
    //FeMale
    searchCustomerTestObject.r2.setSelected(true);
    Assertions.assertTrue(searchCustomerTestObject.r2.isSelected());
  }

  @Test
  @DisplayName("Contact (valid/invalid)")
  void testContact() {
    assertFalse("home".chars().allMatch(Character::isDigit));
    assertFalse("111a".chars().allMatch(Character::isDigit));
    assertTrue("123456".chars().allMatch(Character::isDigit));

    Assertions.assertNotEquals("", searchCustomerTestObject.txtcustid.getSelectedText());
  }

  @Test
  @DisplayName("Picture (valid/invalid)")
  void testPicture() {
    Assertions.assertNotEquals(null, searchCustomerTestObject.txtphoto);
  }

  @Test
  @DisplayName("jBtn #1 ActionPerformed")
  void jBtnONEActionPerformed() {
    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton1.doClick());
  }


  @Test
  @DisplayName("jBtn #2 ActionPerformed (UPDATE CUSTOMER) Male")
  void jBtnTwoActionPerformedMale() {
    Assertions.assertDoesNotThrow(
        () -> {
          // r1 selected sets 'Gender' to "Male", r2 sets to "Female"
          searchCustomerTestObject.r1.setSelected(true);
          searchCustomerTestObject.txtfirstname.setText("alex");
          searchCustomerTestObject.txtlastname.setText("jones");
          searchCustomerTestObject.txtnic.setText("34324");
          searchCustomerTestObject.txtpassport.setText("3443");
          searchCustomerTestObject.txtaddress.setText("TEXAS");
          searchCustomerTestObject.txtdate = new Date();
          searchCustomerTestObject.jButton2.doClick();
        });
  }

  @Test
  @DisplayName("jBtn #2 ActionPerformed (UPDATE CUSTOMER) Female")
  void jBtnTwoActionPerformedFemale() {
    Assertions.assertDoesNotThrow(
            () -> {
              // r1 selected sets 'Gender' to "Male", r2 sets to "Female"
              searchCustomerTestObject.r2.setSelected(true);
              searchCustomerTestObject.txtfirstname.setText("alex");
              searchCustomerTestObject.txtlastname.setText("jones");
              searchCustomerTestObject.txtnic.setText("34324");
              searchCustomerTestObject.txtpassport.setText("3443");
              searchCustomerTestObject.txtaddress.setText("TEXAS");
              searchCustomerTestObject.txtdate = new Date();
              searchCustomerTestObject.jButton2.doClick();
            });
  }

  @Test
  @DisplayName("jBtn #3 ActionPerformed")
  void jBtnTHREEActionPerformed() {
    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton3.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Passed Male")
  void jBtnFOURActionPerformedPassedMale() {
    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS001");
    searchCustomerTestObject.r1.setSelected(true);

    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton4.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Failed Male")
  void jBtnFOURActionPerformedFailedMale() {
    wipeCustomerTable();
    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS001");
    searchCustomerTestObject.r1.setSelected(true);

    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton4.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Passed Female")
  void jBtnFOURActionPerformedPassedFemale() {
    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS004");
    searchCustomerTestObject.r2.setSelected(true);

    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton4.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER) Failed Female")
  void jBtnFOURActionPerformedFailedFemale() {
    wipeCustomerTable();
    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS004");
    searchCustomerTestObject.r2.setSelected(true);

    Assertions.assertDoesNotThrow(() -> searchCustomerTestObject.jButton4.doClick());
  }


  public static boolean doesCustomerExist(String customerId) {
    boolean returnVal = false;

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      PreparedStatement pst = con.prepareStatement("select * from customer where id= ?");
      pst.setString(1, customerId);

      ResultSet rs = pst.executeQuery();

      if (rs.next()) returnVal = true;

    } catch (SQLException | ClassNotFoundException e) {
      System.out.println("SQLException in isUsernameAvailable: " + e.getMessage());
    }

    return returnVal;
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

}
