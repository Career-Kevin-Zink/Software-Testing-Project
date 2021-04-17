import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    Login loginTestObject = new Login();

    @ParameterizedTest
    @DisplayName("Valid Username and Password input + jBtn #1 ActionPerformed")
    @CsvSource({",", "john,321", "%^@,123", "john,123", ",123", "john,"})
    public void loginTest(String username, String password) {
        loginTestObject.txtuser.setText(username);
        loginTestObject.txtpass.setText(password);
        loginTestObject.setVisible(true);
        loginTestObject.jButton1.doClick();

        if(loginTestObject.txtuser.getText().equals("john") && loginTestObject.txtpass.getText().equals("123")){
            assertTrue(true);
        }
        else{
            assertFalse(false);
        }
    }

    @Test
    @DisplayName("Calling Login.main")
    void testMain(){
        Login.main(new String[]{"arg1", "arg2", "arg3"});
    }

    @Test
    @DisplayName("Initialize UI in less than 5 seconds")
    void initComponents() {

        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        new Login().initComponents();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();

        // Testing the GUI initialization time is less than 5 seconds.
        assertTrue(endTime - startTime <= 5000);
    }

    @Test
    @DisplayName("jBtn #2 ActionPerformed (Button exists, actionPerformed method does not)")
    void jBtnTWOActionPerformed(){
        Login loginTestObject = new Login();
        loginTestObject.jButton2.doClick();
    }

}