package gui;

import app.Main;
import com.toedter.calendar.JDateChooser;
import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;
import java.io.File;

/** The type Add customer gt. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class addCustomerGT {
    private FrameFixture window;

  /** Sets up. */
  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
        Main frame = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(frame);
        window.show();

        // Open the User Creation panel.
        frame.jMenuItem1.doClick();
    }

  /** Tear down. */
  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
        window.cleanUp();
    }

  /**
   * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(1)
  @DisplayName("Check that the Picture Chooser successfully selects an image.")
  public void fileChooserSelectImage() {
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(2)
  @DisplayName("Does an empty first name open the error dialog?")
  public void checkEmptyFirstName() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(3)
  @DisplayName("Does an empty last name open the error dialog?")
  public void checkEmptyLastName() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(4)
  @DisplayName("Does an empty nic open the error dialog?")
  public void checkEmptyNic() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(5)
  @DisplayName("Does an empty passport open the error dialog?")
  public void checkEmptyPassport() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(6)
  @DisplayName("Does an empty address open the error dialog?")
  public void checkEmptyAddress() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(7)
  @DisplayName("Does an empty contact open the error dialog?")
  public void checkEmptyContact() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(8)
  @DisplayName("Does a non-numeric contact open the error dialog?")
  public void checkNonNumericContact() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("invalid");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Contact must be a number!");
    }

  /** * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(9)
  @DisplayName("Does an empty photo open the error dialog?")
  public void checkEmptyPhoto() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("All fields are required!");
    }

  /**
   * Requirement:
   * <p>
   * Input:None
   * Description:
   * <p>
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   * */
  @Test
  @Order(10)
  @DisplayName("Check that valid inputs result in adding a customer.")
  public void checkValidCustomer() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtNic").setText("LJen5");
        window.textBox("txtPassport").setText("LJen55");
        window.textBox("txtAddress").setText("123 Downs Street");
        window.textBox("txtContact").setText("12345");

        // Select a picture.
        window.button("BrowseBtn").click();
        window.fileChooser().selectFile(new File("test/res/Test-Dummy-Tux-icon.png"));
        window.fileChooser().cancel();

        // Try to add the user, checking if the error dialog opens.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Registration Created.........");
    }

}
