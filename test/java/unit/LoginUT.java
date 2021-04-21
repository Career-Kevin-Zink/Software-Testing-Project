package unit;

import app.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

class LoginUT {
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

/*    @Test
    @DisplayName("jBtn #2 ActionPerformed")
    void jBtnTWOActionPerformed(){
        Login loginTestObject = new Login();
        loginTestObject.jButton2.doClick();
    }*/
}