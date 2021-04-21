package gui;

import app.Main;
import org.assertj.core.api.Assertions;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class userCreationGT {
    private FrameFixture window;
    private JPanelFixture userCreationPanel;

    @BeforeEach
    @DisplayName("Setting up test.")
    public void setUp() {
        Main frame = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(frame);
        window.show();

        // Open the User Creation panel.
        frame.jMenuItem5.doClick();
        userCreationPanel = window.panel("UserCreationPanel");
    }

    @AfterEach
    @DisplayName("Cleaning up test.")
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    @Order(1)
    @DisplayName("Is the panel showing?")
    public void isPanelVisible() {
        userCreationPanel.requireVisible();
    }

    @Test
    @Order(2)
    @DisplayName("Does an empty FirstName open the error dialog?")
    public void checkEmptyFirstName() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtUserName").setText("Jenkins8802");
        window.textBox("txtPassword").setText("8802");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddUserButton").click();
        window.dialog().requireVisible();
    }

    @Test
    @Order(3)
    @DisplayName("Does an empty LastName open the error dialog?")
    public void checkEmptyLastName() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtUserName").setText("Jenkins8802");
        window.textBox("txtPassword").setText("8802");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddUserButton").click();
        window.dialog().requireVisible();
    }

    @Test
    @Order(4)
    @DisplayName("Does an empty User Name open the error dialog?")
    public void checkEmptyUserName() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtPassword").setText("8802");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddUserButton").click();
        window.dialog().requireVisible();
    }

    @Test
    @Order(5)
    @DisplayName("Does an empty Password open the error dialog?")
    public void checkEmptyPassword() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtUserName").setText("Jenkins8802");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddUserButton").click();
        window.dialog().requireVisible();
    }

    @Test
    @Order(6)
    public void addValidUser() {
        // Fill in the other fields so we know the first name text entry caused the dialog.
        window.textBox("txtFirstName").setText("Leeroy");
        window.textBox("txtLastName").setText("Jenkins");
        window.textBox("txtUserName").setText("Jenkins8802");
        window.textBox("txtPassword").setText("8802");

        // Try to add the user, checking if the error dialog opens.
        window.button("AddUserButton").click();
    }

    @Test
    @Order(7)
    @DisplayName("Does the cancel button close the panel?")
    public void hitCancelButton() {
        window.button("CancelButton").click();
    }
}