package gui;

import app.Login;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/** The type Login gt. */
@TestMethodOrder(OrderAnnotation.class)
public class LoginGT {
  private FrameFixture window;

  /** Sets up. */
  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
    Login frame = GuiActionRunner.execute(Login::new);
    window = new FrameFixture(frame);
    window.show();
  }

  /** Tear down. */
  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
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
  @Order(1)
  @DisplayName("Are the components visible?")
  public void shouldBeVisible() {
    window.textBox("txtuser").requireVisible();
    window.textBox("txtpass").requireVisible();
    window.button(JButtonMatcher.withText("Login")).requireVisible();
    window.button(JButtonMatcher.withText("Cancel")).requireVisible();
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
  @DisplayName("Are the input components editable?")
  public void shouldBeUsable() {
    window.textBox("txtuser").requireEditable();
    window.textBox("txtpass").requireEditable();
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
  @DisplayName("Does Login button work with valid input?")
  public void shouldEnterText() {
    window.textBox("txtuser").enterText("john");
    window.textBox("txtpass").enterText("123");
    window.button(JButtonMatcher.withText("Login")).click();
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
  @DisplayName("Does the window close?")
  public void shouldClose() {
    window.button(JButtonMatcher.withText("Cancel")).click();
  }
}
