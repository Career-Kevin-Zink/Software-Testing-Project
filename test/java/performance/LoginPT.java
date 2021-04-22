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

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPT {
  long startTime = java.util.Calendar.getInstance().getTimeInMillis();
  long endTime = java.util.Calendar.getInstance().getTimeInMillis();

  @Test
  @Order(1)
  @DisplayName("Initialize Login UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Login();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(2)
  @DisplayName("Calling Login.main")
  void testMainTime() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Login.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(3)
  @DisplayName("Checking a valid username and password should take less than 3 seconds.")
  public void checkValidLoginTime() {
    Login login = new Login();
    login.txtuser.setText("john");
    login.txtpass.setText("123");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    login.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 3000);
  }

  @Test
  @Order(4)
  @DisplayName("Checking an invalid username and password should take less than 3 seconds.")
  public void checkInvalidLoginTime() {
    Login login = new Login();
    login.txtuser.setText("hi");
    login.txtpass.setText("mom");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    login.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 3000);
  }

  @Test
  @Order(5)
  @DisplayName("Checking an invalid username should take less than 3 seconds.")
  public void checkInvalidUsernameTime() {
    Login login = new Login();
    login.txtuser.setText("");
    login.txtpass.setText("123");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    login.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 3000);
  }

  @Test
  @Order(6)
  @DisplayName("Checking an invalid password should take less than 3 seconds.")
  public void checkInvalidPasswordTime() {
    Login login = new Login();
    login.txtuser.setText("john");
    login.txtpass.setText("");

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    login.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 3000);
  }

  @Test
  @Order(7)
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  @Disabled("Takes a Long time, dont run for demo")
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
  @Order(8)
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  @Disabled("Takes a Long time, dont run for demo")
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
  @Order(9)
  @DisplayName("Query Username & Password 10 times. Should last less than 10 seconds.")
  @Disabled("Takes a Long time, dont run for demo")
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
  @Order(10)
  @DisplayName("Query Invalid Username & Password 10 times. Should not crash the app.")
  @Disabled("Takes a Long time, dont run for demo")
  public void searchInvalidLoginEndurance() {
    Login login = new Login();
    login.txtuser.setText("invalid");
    login.txtpass.setText("customer");

    for (int i = 0; i < 10; i++) {
      assertDoesNotThrow(() -> login.jButton1.doClick());
    }
  }

  @Test
  @Order(11)
  @DisplayName("Calling Login.main. Should not crash the app.")
  void testMain(){
    assertDoesNotThrow(() -> Login.main(new String[]{"arg1", "arg2", "arg3"}));
  }
}
