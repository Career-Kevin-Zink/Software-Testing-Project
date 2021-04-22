package gui;

import app.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class addFlightGT {
    private FrameFixture window;

    @BeforeEach
    @DisplayName("Setting up test.")
    public void setUp() {
        Main frame = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(frame);
        window.show();

        // Open the User Creation panel.
        frame.jMenuItem4.doClick();
    }

    @AfterEach
    @DisplayName("Cleaning up test.")
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    @Order(1)
    @DisplayName("Check that the Add Flight Panel opens.")
    public void isPanelOpen() {
        window.panel("addflightPanel").requireVisible();
    }

    @Test
    @Order(2)
    @DisplayName("Does an empty flight name display an error dialog?")
    public void emptyFlightName() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid flight name!");
    }

    @Test
    @Order(3)
    @DisplayName("Does an empty source display an error dialog?")
    public void emptySource() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").clearSelection();
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid flight source!");
    }

    @Test
    @Order(4)
    @DisplayName("Does an empty departure display an error dialog?")
    public void emptyDeparture() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").clearSelection();
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid flight destination!");
    }

    @Test
    @Order(5)
    @DisplayName("Does having the same source as departure display an error dialog?")
    public void sourceEqualsDeparture() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(1);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Flight source cannot be the same as the destination!");
    }

    @Test
    @Order(6)
    @DisplayName("Does an empty flight date display an error dialog?")
    public void emptyFlightDate() {
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        DateFormat da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid flight date!");
    }

    @Test
    @Order(7)
    @DisplayName("Does an empty departure time display an error dialog?")
    public void emptyDepartureTime() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid departure time!");
    }

    @Test
    @Order(8)
    @DisplayName("Does an empty arrival time display an error dialog?")
    public void emptyArrival() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid arrival time!");
    }

    @Test
    @Order(9)
    @DisplayName("Does an empty flight charge display an error dialog?")
    public void emptyFlightCharge() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Please enter a valid flight charge!");
    }

    @Test
    @DisplayName("Check that adding a flight works with valid data.")
    public void addValidFlight() {
        DateFormat da = new SimpleDateFormat("MMM d, y");
        window.textBox("txtFlightName").setText("Sri Lanka to Uk");
        window.comboBox("txtSource").selectItem(1);
        window.comboBox("txtDepart").selectItem(2);
        window.panel("txtDate").textBox().setText(da.format(new Date()));
        da = new SimpleDateFormat("HH:mm");
        window.textBox("txtDepTime").setText(da.format(new Date().getTime()));
        window.textBox("txtArrTime").setText(da.format(new Date().getTime()));
        window.textBox("txtFlightCharge").setText("5000");

        // Click the button.
        window.button("AddBtn").click();
        window.optionPane().requireMessage("Flight Created.........");
    }
}