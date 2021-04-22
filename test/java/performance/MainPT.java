package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Main;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPT {

  long startTime;
  long endTime;

  @Test
  @Order(1)
  @DisplayName("Calling Main.main")
  void testMainTime() {

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Main.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(2)
  @DisplayName("Initialize Main UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(3)
  @DisplayName("Time to open the add customer panel should be less than 5 seconds.")
  public void addCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(4)
  @DisplayName("Time to open the search customer panel should be less than 5 seconds.")
  public void searchCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem2.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(5)
  @DisplayName("Time to open the book ticket panel should be less than 5 seconds.")
  public void bookTicket() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem3.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(6)
  @DisplayName("Time to open the book ticket panel should be less than 5 seconds.")
  public void ticketReport() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem6.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @Order(7)
  @DisplayName("Time to open the add flight panel should be less than 5 seconds.")
  public void addFlight() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem4.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

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

  @Test
  @Order(9)
  @DisplayName("Add Customer button clicked 10 times.")
  @Disabled("Takes a Long time, dont run for demo")
  public void addCustomerEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem1.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

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
