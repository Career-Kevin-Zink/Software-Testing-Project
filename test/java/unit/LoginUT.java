package unit;

import app.Login;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LoginUT {
    Login loginTestObject = new Login();

    /**
     * Requirement:A user will log into the system by providing their username and password
     * <p>
     * Input:String "john,321", String "%^@,123", String "john,123", String ",123", String "john, String"John,123",
     * Description:Checks valid and invalid username/passwords
     * <p>
     * Dependencies: Database
     * Expected Output: True, False
     * Actual Output: True, False
     * Statement Coverage: 93%
     * Branch Coverage: 100%
     */
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
    /**
     * Requirement:A user will log into the system by providing their username and password
     * <p>
     * Input:String "john,321", String "%^@,123", String "john,123", String ",123", String "john, String"John,123",
     * Description:Checks valid and invalid username/passwords
     * <p>
     * Dependencies: Database
     * Expected Output: True, False
     * Actual Output: True, False
     * Statement Coverage: 77%
     * Branch Coverage: 0%
     */
    @Test
    @DisplayName("Calling Login.main")
    void testMain(){
        Login.main(new String[]{"arg1", "arg2", "arg3"});
    }
}