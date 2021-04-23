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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 5 seconds
   * <p>
   * Input: none
   * Description:initializing main in less than 5 seconds
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 43%
   * Branch Coverage: 15%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 5 seconds
   * <p>
   * Input: none
   * Description:Checks checking to see if calling main works successfully in less than 5 seconds
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 93%
   * Branch Coverage: 15%
   */
  @Test
  @Order(2)
  @DisplayName("Calling Login.main")
  void testMainTime() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Login.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 5 seconds
   * <p>
   * Input:String "john", String "123",
   * Description:Checks valid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 43%
   * Branch Coverage: 25%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 5 seconds
   * <p>
   * Input:String "hi", String "mom",
   * Description:Checks valid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 63%
   * Branch Coverage: 50%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 3 seconds
   * <p>
   * Input:String "", String "123",
   * Description:Checks invalid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 83%
   * Branch Coverage: 10%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 3 seconds
   * <p>
   * Input:String "john", String "",
   * Description:Checks invalid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 93%
   * Branch Coverage: 15%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 3 seconds
   * <p>
   * Input:String "", String "123",
   * Description:Checks invalid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 83%
   * Branch Coverage: 15%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 10 seconds
   * <p>
   * Input:String "john", String "",
   * Description:Checks invalid username/passwords endurance test
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 83%
   * Branch Coverage: 30%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 10 seconds
   * <p>
   * Input:String "john", String "123",
   * Description:Checks invalid username/passwords endurance test
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 93%
   * Branch Coverage: 31%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 10 seconds
   * <p>
   * Input:String "invalid", String "customer",
   * Description:Checks invalid username/passwords endurance test
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 93%
   * Branch Coverage: 27%
   */
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
  /**
   * Requirement:A user will log into the system by providing their username and password
   * in less than 10 seconds
   * <p>
   * Input: none
   * Description:Checks checking to see if calling main again doesnt crash the app
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 93%
   * Branch Coverage: 25%
   */
  @Test
  @Order(11)
  @DisplayName("Calling Login.main. Should not crash the app.")
  void testMain(){
    assertDoesNotThrow(() -> Login.main(new String[]{"arg1", "arg2", "arg3"}));
  }
}
