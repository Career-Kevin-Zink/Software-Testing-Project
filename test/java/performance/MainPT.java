package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPT {

  long startTime;
  long endTime;

  @Test
  @DisplayName("Calling Main.main")
  void testMainTime() {

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Main.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Initialize Main UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("")
  public void addCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenu1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("")
  public void searchCustomer() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenu2.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("")
  public void addTicket() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenu3.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("")
  public void addFlight() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenu4.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("")
  public void createUser() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem6.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Ticket Report button loaded in less than")
  public void ticketReport() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Main().jMenuItem6.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  // ENDURANCE TESTS -----------------------------------------------------------------------------

  @Test
  @DisplayName("Add Customer button clicked 10 times.")
  public void addCustomerEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem1.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Search Customer button clicked 10 times.")
  public void searchCustomerEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem2.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Add Ticket button clicked 10 times.")
  public void addTicketEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem3.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Add Flight button clicked 10 times.")
  public void addFlightEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem4.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Create User button clicked 10 times.")
  public void createUserEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem5.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Ticket Report button clicked 10 times.")
  public void ticketReportEndurance() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    for (int i = 0; i < 10; i++) {
      new Main().jMenuItem6.doClick();
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
    }
    assertTrue(endTime - startTime <= 5000);
  }
}
