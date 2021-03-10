import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @ParameterizedTest
    @CsvSource({"error,error", "john,error", "error,123", "john,123"})
    public void loginTest(String username, String password) {
        assertTrue(username.equals("john") && password.equals("123"));
    }

}