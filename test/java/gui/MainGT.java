package gui;

import app.Main;
import org.assertj.swing.driver.JMenuItemMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
  @DisplayName("")
  public void tism1(){
    window.menuItem("Add Customer").requireVisible();
  }

  @Test
  @DisplayName("")
  public void tism2(){}

  @Test
  @DisplayName("")
  public void tism3(){}

  @Test
  @DisplayName("")
  public void tism4(){}

  @Test
  @DisplayName("")
  public void tism5(){}

  @Test
  @DisplayName("")
  public void tism6(){}

}

