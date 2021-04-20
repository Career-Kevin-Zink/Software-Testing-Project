package performance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPT {
  @Test
  @DisplayName("Initialize Main UI in less than 5 seconds")
  void initComponents() {
      long startTime = java.util.Calendar.getInstance().getTimeInMillis();
      new Main();
      long endTime = java.util.Calendar.getInstance().getTimeInMillis();

      // Testing the GUI initialization time is less than 5 seconds.
      assertTrue(endTime - startTime <= 5000);
  }
}
