package gui;

import app.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/** The type Ticketreport gt. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ticketreportGT {
  private FrameFixture window;

  /**
   * Requirement:The system shall allow users to view all existing tickets.
   *
   * Description: starts the robot up, vroom vroom
   *
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
    frame.jMenuItem6.doClick();
  }
  /**
   * Requirement:The system shall allow users to view all existing tickets.
   *
   * Description: gracefully ends the test
   *
   *
   * Dependencies: AssertJ
   */
  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  /**
   * Requirement:The system shall allow users to view all existing tickets.
   *
   * Description: tests to see if the panel comes up correctly
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(1)
  @DisplayName("Is the panel showing?")
  public void isPanelVisable() {
    window.scrollPane("ticketReportPane").requireVisible();
  }

  /**
   * Requirement:The system shall allow users to view all existing tickets.
   *
   * Description: tests to see if the cancel button closes the panel,
   * with a robut.
   *
   * Dependencies: AssertJ
   */
  @Test
  @Order(2)
  @DisplayName("Does the cancel button work?")
  public void checkCancelButton() {
    window.button("CancelButton").click();
  }
}
