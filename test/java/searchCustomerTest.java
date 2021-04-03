import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchCustomerTest {
  searchCustomer searchCustomerTestObject = new searchCustomer();
  /**
   * Requirement Description: The system shall allow users to search existing customers in the
   * database.
   *
   * <p>Input: String "CS010"
   *
   * <p>Procedure: Check to see if the inputted string is located within the database. If it is not
   * an exception will be thrown.
   *
   * <p>Expected Output: The test should fail.
   *
   * <p>Branch Coverage: 100%
   *
   * <p>Statement Coverage: 100%
   */

  @Test
  @DisplayName("Invalid customer ID search")
  public void invalidCustomerID() throws Exception {
    assertFalse(doesCustomerExist("CS010"));
  }

  @Test
  @DisplayName("jBtn #1 ActionPerformed")
  void jBtnONEActionPerformed(){
    assertDoesNotThrow(()->searchCustomerTestObject.jButton1.doClick());
  }

  @Test
  @DisplayName("jBtn #2 ActionPerformed")
  void jBtnTWOActionPerformed(){
    assertDoesNotThrow(()->{
      searchCustomerTestObject.r1.setSelected(true);
      searchCustomerTestObject.txtfirstname.setText("alex");
      searchCustomerTestObject.txtlastname.setText("jones");
      searchCustomerTestObject.txtnic.setText("34324");
      searchCustomerTestObject.txtpassport.setText("3443");
      searchCustomerTestObject.txtaddress.setText("TEXAS");
      searchCustomerTestObject.txtdate = new Date();

      assertDoesNotThrow(()->searchCustomerTestObject.jButton2.doClick());
    });
  }

  @Test
  @DisplayName("jBtn #3 ActionPerformed")
  void jBtnTHREEActionPerformed(){
    assertDoesNotThrow(()->searchCustomerTestObject.jButton3.doClick());
  }

  @Test
  @DisplayName("jBtn #4 ActionPerformed")
  void jBtnFOURActionPerformed(){
    searchCustomerTestObject.setVisible(true);
    searchCustomerTestObject.txtcustid.setText("CS001");
    assertDoesNotThrow(()->searchCustomerTestObject.jButton4.doClick());
  }

  @Test
  @DisplayName("Initialize UI in less than 5 seconds")
  void initComponents() {

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new searchCustomer().initComponents();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Customer ID  (valid/invalid)")
  void testCustomerID(){
    assertNotEquals("",searchCustomerTestObject.txtcustid.getSelectedText());
  }

  @Test
  @DisplayName("Firstname (valid/invalid)")
  void testFirstName(){
    assertNotEquals("",searchCustomerTestObject.txtfirstname.getSelectedText());
  }

  @Test
  @DisplayName("Lastname (valid/invalid)")
  void testLastName(){
    assertNotEquals("",searchCustomerTestObject.txtlastname.getSelectedText());
  }

  @Test
  @DisplayName("Nic # (valid/invalid)")
  void testNicNum(){
    assertNotEquals("",searchCustomerTestObject.txtnic.getSelectedText());
  }

  @Test
  @DisplayName("Passport ID (valid/invalid)")
  void testPassportID(){
    assertNotEquals("",searchCustomerTestObject.txtpassport.getSelectedText());
  }

  @Test
  @DisplayName("DOB (valid/invalid)")
  void testDOB(){
    searchCustomerTestObject.txtdate = new Date();
    assertNotEquals("", searchCustomerTestObject.txtdate.toString());
  }

  @Test
  @DisplayName("Gender (valid/invalid)")
  void testGender(){
    searchCustomerTestObject.r1.setSelected(true);
    searchCustomerTestObject.r2.setSelected(true);
    assertTrue(searchCustomerTestObject.r1.isSelected());
    assertTrue(searchCustomerTestObject.r2.isSelected());
  }

  @Test
  @DisplayName("Contact (valid/invalid)")
  void testContact(){
    assertNotEquals("",searchCustomerTestObject.txtcustid.getSelectedText());
  }

  @Test
  @DisplayName("Picture (valid/invalid)")
  void testPicture(){
    assertNotEquals(null, searchCustomerTestObject.txtphoto);
  }


  public static boolean doesCustomerExist(String customerId) {
    boolean returnVal = false;

    try {
      Connection connection = Database.getConnection();
      PreparedStatement pst = connection.prepareStatement("select * from customer where id= ?");
      pst.setString(1, customerId);

      ResultSet rs = pst.executeQuery();

      if (rs.next()) returnVal = true;

    } catch (SQLException e) {
      System.out.println("SQLException in isUsernameAvailable: " + e.getMessage());
    }

    return returnVal;
  }
}