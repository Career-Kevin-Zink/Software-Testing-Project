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

  @Test
  @DisplayName("Initialize userCreation UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new userCreation();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

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
