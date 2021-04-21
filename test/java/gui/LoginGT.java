package gui;

import app.Login;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LoginGT {
  private FrameFixture window;

  @BeforeEach
  @DisplayName("Setting up test.")
  public void setUp() {
    Login frame = GuiActionRunner.execute(Login::new);
    window = new FrameFixture(frame);
    window.show();
  }

  @AfterEach
  @DisplayName("Cleaning up test.")
  public void tearDown() {
    window.cleanUp();
  }

  @Test
  @DisplayName("Are the components visible.")
  public void shouldBeVisible() {
    window.textBox("txtuser").requireVisible();
    window.textBox("txtpass").requireVisible();
    window.button(JButtonMatcher.withText("Login")).requireVisible();
    window.button(JButtonMatcher.withText("Cancel")).requireVisible();
  }

  @Test
  @DisplayName("Are the components editable and pressable.")
  public void shouldBeUsable() {
    window.textBox("txtuser").requireEditable();
    window.textBox("txtpass").requireEditable();
    window.button(JButtonMatcher.withText("Login")).requireEnabled();
    window.button(JButtonMatcher.withText("Cancel")).requireEnabled();
  }

  @Test
  @DisplayName("Does input work after clicking button.")
  public void shouldEnterText() {
    window.textBox("txtuser").enterText("john");
    window.textBox("txtpass").enterText("123");
    window.button(JButtonMatcher.withText("Login")).click();
  }

  @Test
  @DisplayName("Does the window close.")
  public void shouldClose() {
    window.button(JButtonMatcher.withText("Cancel")).click();
  }
}
