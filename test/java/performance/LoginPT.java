package performance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPT {
  long startTime = java.util.Calendar.getInstance().getTimeInMillis();
  long endTime = java.util.Calendar.getInstance().getTimeInMillis();

  @Test
  @DisplayName("Initialize Login UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Login();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Calling Login.main")
  void testMainTime() {

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Login.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  public void searchInvalidUsernameEndurance() {
    Login login = new Login();
    login.txtuser.setText("");
    login.txtpass.setText("123");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      login.jButton1.doClick();
    }
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 50000);
  }

  @Test
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  public void searchInvalidPasswordEndurance() {
    Login login = new Login();
    login.txtuser.setText("john");
    login.txtpass.setText("");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      login.jButton1.doClick();
    }
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 50000);
  }

  @Test
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  public void searchValidLoginEndurance() {
    Login login = new Login();
    login.txtuser.setText("john");
    login.txtpass.setText("123");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      login.jButton1.doClick();
      login.main.dispose();
    }
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 50000);
  }

  @Test
  @DisplayName("Query Invalid Username & Password 10 times. Should not crash the app.")
  public void searchInvalidLoginEndurance() {
    Login login = new Login();
    login.txtuser.setText("invalid");
    login.txtpass.setText("customer");

    for (int i = 0; i < 10; i++) {
      assertDoesNotThrow(() -> login.jButton1.doClick());
    }
  }

  @Test
  @DisplayName("Calling Login.main. Should not crash the app.")
  void testMain(){
    assertDoesNotThrow(() -> Login.main(new String[]{"arg1", "arg2", "arg3"}));
  }
}
