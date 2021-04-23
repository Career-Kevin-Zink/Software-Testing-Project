package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Main;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPT {

  long startTime;
  long endTime;
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main reacts to being called in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 67%
   * Branch Coverage: 100%
   */
  @Test
  @Order(1)
  @DisplayName("Calling Main.main")
  void testMainTime() {

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Main.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 52%
   * Branch Coverage: 46%
   */
  @Test
  @Order(2)
  @DisplayName("Initialize Main UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's add customer in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 89%
   * Branch Coverage: 17%
   */
  @Test
  @Order(3)
  @DisplayName("Time to open the add customer panel should be less than 5 seconds.")
  public void addCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main searchcustomer in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 67%
   * Branch Coverage: 14%
   */
  @Test
  @Order(4)
  @DisplayName("Time to open the search customer panel should be less than 5 seconds.")
  public void searchCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem2.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's bookticketin less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 70%
   * Branch Coverage: 19%
   */
  @Test
  @Order(5)
  @DisplayName("Time to open the book ticket panel should be less than 5 seconds.")
  public void bookTicket() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem3.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's bookticket in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 80%
   * Branch Coverage: 52%
   */
  @Test
  @Order(6)
  @DisplayName("Time to open the book ticket panel should be less than 5 seconds.")
  public void ticketReport() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem6.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's addflight in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 60%
   * Branch Coverage: 9%
   */
  @Test
  @Order(7)
  @DisplayName("Time to open the add flight panel should be less than 5 seconds.")
  public void addFlight() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem4.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main init's usercreation in less than 5 seconds
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 92%
   * Branch Coverage: 6%
   */
  @Test
  @Order(8)
  @DisplayName("Time to open the user creation panel should be less than 5 seconds.")
  public void createUser() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem5.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  // ENDURANCE TESTS -----------------------------------------------------------------------------
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 72%
   * Branch Coverage: 42%
   */
  @Test
  @Order(9)
  @DisplayName("Add Customer button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void addCustomerStress() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem1.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 57%
   * Branch Coverage: 43%
   */
  @Test
  @Order(10)
  @DisplayName("Search Customer button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void searchCustomerEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem2.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 50%
   * Branch Coverage: 41%
   */
  @Test
  @Order(11)
  @DisplayName("Add Ticket button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void addTicketEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem3.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if main can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 80%
   * Branch Coverage: 66%
   */
  @Test
  @Order(12)
  @DisplayName("Add Flight button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void addFlightEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem4.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if createuser can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 92%
   * Branch Coverage: 76%
   */
  @Test
  @Order(13)
  @DisplayName("Create User button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void createUserEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem5.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
  /**
   * Requirement:check if the main class initializes in less than 5 seconds
   * <p>
   * Input:none
   * Description:Checks to see if ticketReport can take 10 users
   * <p>
   * Dependencies: None
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 92%
   * Branch Coverage: 6%
   */
  @Test
  @Order(14)
  @DisplayName("Ticket Report button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void ticketReportEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem6.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
}
