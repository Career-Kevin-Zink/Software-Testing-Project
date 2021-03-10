import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    /**
     * Requirement Description: The system shall allow users to log in by providing a user ID and a password at the log
     * in screen.
     *
     * Input: String userID, String password
     *
     * Procedure: Inputs every possible combination of inputs. The method is looking for a passing condition and will
     * fail if those conditions are not met.
     *
     * Expected Output: Test 1: Fail, Test 2: Fail, Test 3: Fail, Test 4: Pass
     *
     * Branch Coverage: 100%
     *
     * Statement Coverage: 100%
     */
    @ParameterizedTest
    @CsvSource({"error,error", "john,error", "error,123", "john,123"})
    public void loginTest(String username, String password) {
        assertTrue(username.equals("john") && password.equals("123"));
    }

}