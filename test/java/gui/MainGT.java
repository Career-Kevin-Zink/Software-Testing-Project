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
public class MainGT {
  private FrameFixture window;

  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
    Main frame = GuiActionRunner.execute(Main::new);
    window = new FrameFixture(frame);
    window.show();
  }

  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  @Test
  @Order(1)
  @DisplayName("Is the Add Customer component visible and clickable?")
  public void addCustomerShouldBeVisible() {
    window.menuItem("Add Customer").click();
    window.menuItem("Add Customer").requireVisible();
  }

  @Test
  @Order(2)
  @DisplayName("Is the Search Customer component visible and clickable?")
  public void searchCustomerShouldBeVisible() {
    window.menuItem("Search Customer").click();
    window.menuItem("Search Customer").requireVisible();
  }

  @Test
  @Order(4)
  @DisplayName("Is the Add Ticket component visible and clickable?")
  public void addTicketShouldBeVisible() {
    window.menuItem("Add Ticket").click();
    window.menuItem("Add Ticket").requireVisible();
  }

  @Test
  @Order(6)
  @DisplayName("Is the Ticket Report component visible and clickable?")
  public void ticketReportShouldBeVisible() {
    window.menuItem("Ticket Report").click();
    window.menuItem("Ticket Report").requireVisible();
  }

  @Test
  @Order(5)
  @DisplayName("Is the Add Flight component visible and clickable?")
  public void addFlightShouldBeVisible() {
    window.menuItem("Add Flight").click();
    window.menuItem("Add Flight").requireVisible();
  }

  @Test
  @Order(3)
  @DisplayName("Is the User Creation component visible and clickable?")
  public void userCreationShouldBeVisible() {
    window.menuItem("User Creation").click();
    window.menuItem("User Creation").requireVisible();
  }
}
