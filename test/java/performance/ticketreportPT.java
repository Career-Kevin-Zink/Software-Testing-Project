package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.ticketreport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ticketreportPT {
  @Test
  @DisplayName("Initialize ticketreport UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new ticketreport();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

}
