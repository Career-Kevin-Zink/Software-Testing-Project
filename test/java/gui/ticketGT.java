package gui;

import app.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class ticketGT {
  private FrameFixture window;

  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
    Main frame = GuiActionRunner.execute(Main::new);
    window = new FrameFixture(frame);
    window.show();
    window.menuItem("Add Ticket").click();
  }

  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  @Test
  @Order(1)
  @DisplayName("Is the first panel visible?")
  public void firstPanelShouldBeVisible() {
    window.panel("first panel").requireVisible();
  }

  @Test
  @Order(2)
  @DisplayName("Is the second panel visible?")
  public void secondPanelShouldBeVisible() {
    window.panel("second panel").requireVisible();
  }

  @Test
  @Order(3)
  @DisplayName("Is the third panel visible?")
  public void thirdPanelShouldBeVisible() {
    window.panel("third panel").requireVisible();
  }

  @Test
  @Order(4)
  @DisplayName("Is the scroll pane visible?")
  public void scrollPaneShouldBeVisible() {
    window.scrollPane("Scroll Pane").requireVisible();
  }

  @Test
  @Order(5)
  @DisplayName("Is the table visible?")
  public void tableShouldBeVisible() {
    window.table("first table").requireVisible();
  }

  @Test
  @Order(6)
  @DisplayName("Are the labels visible and displaying text?")
  public void labelsShouldBeVisible() {
    window.label("Source Label").requireVisible().requireText("Source");
    window.label("Departure Label").requireVisible().requireText("Departure");
    window.label("Ticket Number Label").requireVisible().requireText("Ticket No");
    window.label("Customer ID Label").requireVisible().requireText("Customer ID");
    window.label("First Name Label").requireVisible().requireText("FirstName");
    window.label("Last Name Label").requireVisible().requireText("LastName");
    window.label("Passport Number Label").requireVisible().requireText("Passportno");
    window.label("Seats Label").requireVisible().requireText("Seats");
    window.label("Price Label").requireVisible().requireText("Price");
    window.label("Class Label").requireVisible().requireText("Class");
    window.label("Depart Time Label").requireVisible().requireText("Depart Time");
    window.label("Flight Name Label").requireVisible().requireText("Flight Name");
    window.label("Flight Number Label").requireVisible().requireText("Flight no");
    window.label("Flight Name").requireVisible().requireText("jLabel19");
    window.label("Flight Number").requireVisible().requireText("jLabel18");
  }

  @Test
  @Order(7)
  @DisplayName("Are the buttons visible and enabled?")
  public void buttonsShouldBeVisible() {
    window.button("Book Flight Button").requireVisible().requireEnabled();
    window.button("Hide Button").requireVisible().requireEnabled();
    window.button("Search Flight Button").requireVisible().requireEnabled();
    window.button("Search Customer Button").requireVisible().requireEnabled();
  }

  @Test
  @Order(8)
  @DisplayName("Does searching customer by ID populate the correct components?")
  public void searchingCustomerByIdPopulation() {
    window.textBox("txtcustid").setText("CS001");
    window.button("Search Customer Button").click();
    window.label("txtfirstname").requireText("john");
    window.label("txtlastname").requireText("Alex");
    window.label("txtpassport").requireText("3443");
  }

  @Test
  @Order(9)
  @DisplayName("Does searching by Source/Departure populate the correct components?")
  public void a() {
    window.panel("first panel").comboBox("txtsource").requireVisible().selectItem(0);
    window.panel("first panel").comboBox("txtdepart").requireVisible().selectItem(5);
    window.panel("first panel").button("Search Flight Button").click();
    window.table("first table").selectRows(0).click();
    window.label("Flight Name").requireVisible().requireText("Delta");
    window.label("Flight Number").requireVisible().requireText("FO002");
    window.label("txtdept").requireVisible().requireText("8.00PM");
    window.textBox("txtprice").requireVisible().requireText("15000");
    window.comboBox("txtclass").requireSelection("Economy");
    window.spinner("txtseats").requireValue(0);
    window.button("Book Flight Button").click();
  }
}
