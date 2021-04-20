package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.userCreation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class userCreationPT {
  @Test
  @DisplayName("Initialize userCreation UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new userCreation();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

}
