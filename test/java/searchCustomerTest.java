import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;
import javax.swing.JFileChooser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchCustomerTest {
  searchCustomer searchCustomerTestObject = new searchCustomer();
  ActionEvent e = new ActionEvent(ActionEvent.ACTION_PERFORMED, 0, "test");

  //Each page on the system shall populate with all relevant data in less than five seconds.
  @Test
  @DisplayName("Initialize UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new searchCustomer().initComponents();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  // The system shall allow users to SEARCH existing customers in the database.
  @Test
  @DisplayName("Customer ID  (valid/invalid)")
  void testCustomerID() {
    assertFalse(doesCustomerExist("001"));
    assertTrue(doesCustomerExist("CS001"));
    assertNotEquals("", searchCustomerTestObject.txtcustid.getSelectedText());
  }

  // The system shall allow users to UPDATE existing customers in the database.
  @Test
  @DisplayName("Firstname (valid/invalid)")
  void testFirstName() {
    assertFalse("Starfox332".chars().allMatch(Character::isLetter));
    assertTrue("john".chars().allMatch(Character::isLetter));
    assertNotEquals("", searchCustomerTestObject.txtfirstname.getSelectedText());
  }

  @Test
  @DisplayName("Lastname (valid/invalid)")
  void testLastName() {
    assertFalse("1inu5".chars().allMatch(Character::isLetter));
    assertTrue("Linus".chars().allMatch(Character::isLetter));

    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtlastnameActionPerformed(e);
    assertNotEquals("", searchCustomerTestObject.txtlastname.getSelectedText());
  }

  @Test
  @DisplayName("Nic # (valid/invalid)")
  void testNicNum() {
    assertNotEquals("", searchCustomerTestObject.txtnic.getSelectedText());
  }

  @Test
  @DisplayName("Passport ID (valid/invalid)")
  void testPassportID() {
    searchCustomerTestObject.txtpassportActionPerformed(e);
    assertNotEquals("", searchCustomerTestObject.txtpassport.getSelectedText());
  }

  @Test
  @DisplayName("DOB (valid/invalid)")
  void testDOB() {
    searchCustomerTestObject.txtdate = new Date();
    assertNotEquals("", searchCustomerTestObject.txtdate.toString());
  }

  @Test
  @DisplayName("Gender (valid/invalid)")
  void testGender() {
    //Male
    searchCustomerTestObject.r1.setSelected(true);
    assertTrue(searchCustomerTestObject.r1.isSelected());
    //FeMale
    searchCustomerTestObject.r2.setSelected(true);
    assertTrue(searchCustomerTestObject.r2.isSelected());
  }

  @Test
  @DisplayName("Contact (valid/invalid)")
  void testContact() {
    assertFalse("home".chars().allMatch(Character::isDigit));
    assertFalse("111a".chars().allMatch(Character::isDigit));
    assertTrue("123456".chars().allMatch(Character::isDigit));

    assertNotEquals("", searchCustomerTestObject.txtcustid.getSelectedText());
  }

  @Test
  @DisplayName("Picture (valid/invalid)")
  void testPicture() {
    assertNotEquals(null, searchCustomerTestObject.txtphoto);
  }

  @Test
  @DisplayName("jBtn #1 ActionPerformed")
  void jBtnONEActionPerformed() {
    assertDoesNotThrow(() -> searchCustomerTestObject.jButton1.doClick());
  }


  @Test
  @DisplayName("jBtn #2 ActionPerformed (UPDATE CUSTOMER)")
  void jBtnTWOActionPerformed() {
    assertDoesNotThrow(
        () -> {
          // r1 selected sets 'Gender' to "Male", r2 sets to "FeMale"
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
  @DisplayName("jBtn #3 ActionPerformed")
  void jBtnTHREEActionPerformed() {
    assertDoesNotThrow(() -> searchCustomerTestObject.jButton3.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed (QUERY CUSTOMER)")
  void jBtnFOURActionPerformed() {
    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS001");

    assertDoesNotThrow(() -> searchCustomerTestObject.jButton4.doClick());
  }

  @Test
  @DisplayName("JBtn #4 Action Performed Integration Test")
  void JButton4PerformedIT() {

    searchCustomerTestObject.pack();
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText(null);
    searchCustomerTestObject.jButton4.doClick();

    assertFalse(searchCustomerTestObject.customerFound);
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

}
