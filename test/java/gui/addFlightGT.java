package gui;

import app.Main;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/** The type Add flight gt. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class addFlightGT {
  private FrameFixture window;

  /** Sets up. */
  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
    Main frame = GuiActionRunner.execute(Main::new);
    window = new FrameFixture(frame);
    window.show();

    // Open the User Creation panel.
    frame.jMenuItem4.doClick();
  }

  /** Tear down. */
  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Check that the Add Flight Panel opens.
     * <p>
     * Dependencies: addFlight
     * Expected Output: panel("addflightPanel").requireVisible()
     * Actual Output: True
     * */
  @Test
  @Order(1)
  @DisplayName("Check that the Add Flight Panel opens.")
  public void isPanelOpen() {
    window.panel("addflightPanel").requireVisible();
  }

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty flight name display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid flight name!")
     * Actual Output: True
     * */
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

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty source display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid flight source!")
     * Actual Output: True
     * */
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

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty departure display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid flight destination!")
     * Actual Output: True
     * */
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

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does having the same source as departure display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Flight source cannot be the same as the destination!")
     * Actual Output: True
     * */
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

  /** * Requirement:The system shall allow users to create new flights by providing a flight name,
   * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty flight date display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid flight date!")
     * Actual Output: True
     * */
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

    /** * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty departure time display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid departure time!")
     * Actual Output: True
     * */
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

    /** * Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty arrival time display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid arrival time!")
     * Actual Output: True
     * */
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

    /** Requirement:The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Does an empty flight charge display an error dialog?
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Please enter a valid flight charge!")
     * Actual Output: True
     * */
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

    /**
     * Requirement: The system shall allow users to create new flights by providing a flight name,
     * source, departure, date, departure time, arrival time, and flight charge.
     * <p>
     * Input:None
     * Description: Check that adding a flight works with valid data.
     * <p>
     * Dependencies: addFlight
     * Expected Output: requireMessage("Flight Created.........")
     * Actual Output: True
     * */
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
