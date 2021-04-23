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

  /** Sets . */
  @BeforeEach
  @DisplayName("Setting up test.")
  public void setup() {
    Main frame = GuiActionRunner.execute(Main::new);
    window = new FrameFixture(frame);
    window.show();

    // open searchCustomer panel.
    frame.jMenuItem6.doClick();
  }
  /** Tear down. */
  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  /**
   * Requirement:
   *
   * Input:None
   * Description:
   *
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   */
  @Test
  @Order(1)
  @DisplayName("Is the panel showing?")
  public void isPanelVisable() {
    window.scrollPane("ticketReportPane").requireVisible();
  }

  /**
   * Requirement:
   *
   * Input:None
   * Description:
   *
   * Dependencies:
   * Expected Output:
   * Actual Output:
   * Statement Coverage:
   * Branch Coverage:
   */
  @Test
  @Order(2)
  @DisplayName("Does the cancel button work?")
  public void checkCancelButton() {
    window.button("CancelButton").click();
  }
}
