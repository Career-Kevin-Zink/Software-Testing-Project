package gui;

import app.Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/** The type Search customer gt. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class searchCustomerGT {
  private FrameFixture window;
  /** Init user table. */
  @BeforeEach
  @AfterEach
  public void initUserTable() {
    // Set the database to the expected default state.
    byte[] smallphoto =
        new byte[] {
          -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8,
          2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0,
          4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0,
          14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99,
          -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25,
          19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126
        };

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      Statement s = con.createStatement();

      // Drop the table and recreate.
      s.execute("DROP TABLE `customer`");
      s.execute(
          "CREATE TABLE `customer` (\n"
              + "  `id` varchar(255) NOT NULL,\n"
              + "  `firstname` varchar(255) NOT NULL,\n"
              + "  `lastname` varchar(255) NOT NULL,\n"
              + "  `nic` varchar(255) NOT NULL,\n"
              + "  `passport` varchar(255) NOT NULL,\n"
              + "  `address` text NOT NULL,\n"
              + "  `dob` varchar(255) NOT NULL,\n"
              + "  `gender` varchar(255) NOT NULL,\n"
              + "  `contact` int(11) NOT NULL,\n"
              + "  `photo` longblob NOT NULL\n"
              + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");

      // Add initial values.
      PreparedStatement pst =
          con.prepareStatement(
              "insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
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

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: gracefully starts up the robot.
   *
   * Dependencies: AssertJ
   */
  @BeforeEach
  @DisplayName("Setting up test.")
  public void setup() {
    Main frame = GuiActionRunner.execute(Main::new);
    window = new FrameFixture(frame);
    window.show();

    // open searchCustomer panel.
    frame.jMenuItem2.doClick();
  }

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: gracefully tears down the robot.
   *
   * Dependencies: AssertJ
   */  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if the SearchCustomer panel is showing,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(1)
  @DisplayName("Is the panel showing?")
  public void isPanelVisable() {
    window.panel("searchCustomerPanel").requireVisible();
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if an empty custid field pulls up the error dialog,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(2)
  @DisplayName("Does an empty CustID pull up the error dialog.")
  public void checkEmptyCustID() {
    window.button("FindButton").click();
    window.optionPane().requireVisible();
  }

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if hitting the find button with the custid filled in fills
   * apropriate fields, with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(3)
  @DisplayName("Does hitting the -Find- button fill in all the fields. ")
  public void checkValidCustID() {
    // fill in the custID text box
    window.textBox("custID").setText("CS001");
    // check if hitting the button fills in the appropriate fields.
    window.button("FindButton").click();
    window.textBox("FirstName").requireText("John");
    window.textBox("LastName").requireText("Alex");
    window.textBox("NicNumber").requireText("34232222");
    window.textBox("PassPortNumber").requireText("3443");
    window.textBox("Address").requireText("Uk");
    window.textBox("Contact").requireText("34324234");
  }

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if the update button updates the database with the current info,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(4)
  @DisplayName("Does hitting -Update- update the database.")
  public void checkRegistration() {
    // fill in the custID text box
    window.textBox("custID").setText("CS001");
    window.button("FindButton").click();
    // change a field and see if it correctly registers
    window.textBox("FirstName").setText("Johnny");
    // hit update
    window.button("UpdateButton").click();
    window.optionPane().requireVisible();
  }
  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if the browse button pulls up the file browser,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(5)
  @DisplayName("Does hitting browse bring up the filebrowser")
  public void fileChooser() {
    window.button("BrowseButton").click();
    window.fileChooser().requireVisible();
  }

  /**
   * Requirement:The system shall allow users to UPDATE existing customers in the database.
   *
   * Description: Checks to see if the cancel button brings the user back to the main menu,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(6)
  @DisplayName("Does hitting cancel hide the window as it should.")
  public void cancelButton() {
    window.button("CancelButton").click();
  }
}
