package performance;

import app.userCreation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class userCreationPT {
  @BeforeEach
  @AfterEach
  public void defaultUserTable() {
    // Set the database to the expected default state.
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `user`");
      s.execute("CREATE TABLE `user` (" +
              "  `id` varchar(255) NOT NULL," +
              "  `firstname` varchar(255) NOT NULL," +
              "  `lastname` varchar(255) NOT NULL," +
              "  `username` varchar(255) NOT NULL," +
              "  `password` varchar(255) NOT NULL" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
      s.execute("INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES" +
              "('UO001', 'john', 'peter', 'john', '123')," +
              "('UO002', 'nimal', 'raja', 'raja', '321')," +
              "('UO003', 'Jim', 'Jones', 'jjones', '123')," +
              "('UO004', 'Ravi', 'Kumar', 'rjumar', '123');");
    } catch (SQLException | ClassNotFoundException ignored) {}
  }

  public void emptyUserTable() {
    // Wipe database to enter the null branch.
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `user`");
      s.execute("CREATE TABLE `user` (\n" +
              "  `id` varchar(255) NOT NULL,\n" +
              "  `firstname` varchar(255) NOT NULL,\n" +
              "  `lastname` varchar(255) NOT NULL,\n" +
              "  `username` varchar(255) NOT NULL,\n" +
              "  `password` varchar(255) NOT NULL\n" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
    } catch (SQLException | ClassNotFoundException ignored) {}
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   *
   * Input: None
   *
   * Description: Initialize the userCreation GUI in less than 5 seconds
   *
   * Dependencies: None
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 84%
   * Branch Coverage: 8%
   */
  @Test
  @DisplayName("Initialize userCreation UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new userCreation();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"UO005", String"John", String"Doe", String "jdoe69", String"ABC123"
   * Description: Assert that creating a user will create the user in the database.
   * in less than 5 seconds
   *
   * Dependencies: None
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 95%
   * Branch Coverage: 50%
   */
  @Test
  void userCreationValidDetails() {
    userCreation userCreation = new userCreation();
    // Provide test inputs.
    userCreation.txtuserid.setText("UO005");
    userCreation.txtfirstname.setText("John");
    userCreation.txtlastname.setText("Doe");
    userCreation.txtusername.setText("jdoe69");
    userCreation.txtpassword.setText("ABC123");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"", String"John", String"Doe", String "jdoe69", String"ABC123"
   * Description: checking to see if a false entry correctly stops the entry from going to the database.
   * in less than 5 seconds
   *
   * Dependencies: database
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 89%
   * Branch Coverage: 16%
   */
  @Test
  void userCreationInvalidId() {
    userCreation userCreation = new userCreation();
    // Provide test inputs.
    userCreation.txtuserid.setText("");
    userCreation.txtfirstname.setText("John");
    userCreation.txtlastname.setText("Doe");
    userCreation.txtusername.setText("jdoe69");
    userCreation.txtpassword.setText("ABC123");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"UO005", String"", String"Doe", String "jdoe69", String"ABC123"
   * Description:  checking to see if a false entry correctly stops the entry from going to the database.
   * in less than 5 seconds
   *
   * Dependencies: database
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 89%
   * Branch Coverage: 33%
   */
  @Test
  void userCreationInvalidFirstName() {
    userCreation userCreation = new userCreation();

    // Provide test inputs.
    userCreation.txtuserid.setText("UO005");
    userCreation.txtfirstname.setText("");
    userCreation.txtlastname.setText("Doe");
    userCreation.txtusername.setText("jdoe69");
    userCreation.txtpassword.setText("ABC123");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"UO005", String"John", String"", String "jdoe69", String"ABC123"
   * Description:  checking to see if a false entry correctly stops the entry from going to the database.
   * in less than 5 seconds
   *
   * Dependencies: database
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 89%
   * Branch Coverage: 33%
   */
  @Test
  void userCreationInvalidLastName() {
    userCreation userCreation = new userCreation();

    // Provide test inputs.
    userCreation.txtuserid.setText("UO005");
    userCreation.txtfirstname.setText("John");
    userCreation.txtlastname.setText("");
    userCreation.txtusername.setText("jdoe69");
    userCreation.txtpassword.setText("ABC123");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"UO005", String"John", String"Doe", String "", String"ABC123"
   * Description:  checking to see if a false entry correctly stops the entry from going to the database.
   * in less than 5 seconds
   *
   * Dependencies: database
   * Expected Output: true
   * Actual Output: true
   * Statement Coverage: 89%
   * Branch Coverage: 41%
   */
  @Test
  void userCreationInvalidUsername() {
    userCreation userCreation = new userCreation();

    // Provide test inputs.
    userCreation.txtuserid.setText("UO005");
    userCreation.txtfirstname.setText("John");
    userCreation.txtlastname.setText("Doe");
    userCreation.txtusername.setText("");
    userCreation.txtpassword.setText("ABC123");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement: The system shall add a new user to the database in under five seconds
   *
   * Input: String"UO005", String"John", String"Doe", String "jdoe69", String""
   * Description:  checking to see if a false entry correctly stops the entry from going to the database.
   *in less than 5 seconds
   *
   * Dependencies: database
   * Expected Output: true,
   * Actual Output: true,
   * Statement Coverage: 89%
   * Branch Coverage: 50%
   */
  @Test
  void userCreationInvalidPassword() {
    userCreation userCreation = new userCreation();
    // Provide test inputs.
    userCreation.txtuserid.setText("UO005");
    userCreation.txtfirstname.setText("John");
    userCreation.txtlastname.setText("Doe");
    userCreation.txtusername.setText("jdoe69");
    userCreation.txtpassword.setText("");

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation.jButton1.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:The system shall add a new user to the database in under five seconds
   *
   * Input: none
   * Description: Assert that creating a user will create the user in the database.
   *in less than 5 seconds
   *
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 85%
   * Branch Coverage: 8%
   */
  @Test
  void jButton2ActionPerformed() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    userCreation userCreation = new userCreation();

    // Setup the GUI
    userCreation.initComponents();

    // Execute the method.
    userCreation.jButton2.doClick();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:The system shall add a new user to the database in under five seconds.
   *
   * Input: none
   * Description: Makes sure that they can pull the next ID from the database
   * in less than 5 seconds
   *
   * Dependencies: Database
   * Expected Output: true, true, True
   * Actual Output: true, true, True
   * Statement Coverage: 85%
   * Branch Coverage: 16%
   */
  @Test
  void testAutoID() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Test for "MAX(id)") != null.
    assertDoesNotThrow(() -> {
      new userCreation().autoID();

    });

    // Clear the database to trigger other branch.
    emptyUserTable();

    // Test for "MAX(id)") == null.
    assertDoesNotThrow(() -> {
      new userCreation().autoID();
    });
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
}
