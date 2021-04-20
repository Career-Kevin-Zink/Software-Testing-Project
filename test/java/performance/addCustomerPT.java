package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.addCustomer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class addCustomerPT {
  @Test
  @DisplayName("Initialize addCustomer UI in less than 5 seconds")
  void initComponents() {

    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new addCustomer();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

}
