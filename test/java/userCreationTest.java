import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userCreationTest {

    @Test
    public void testSubmitUserDetails() {
        // The simulated inputs
        String firstName = "John";
        String lastName = "Doe";
        String username = "jdoe09";
        String password = "12345678";

        // Test if the first name is valid.
        assertTrue(!firstName.isEmpty());

        // Test if the last name is valid.
        assertTrue(!lastName.isEmpty());

        // Test if the username is available and valid.
        assertTrue(username.length() > 3 && Database.isUsernameAvailable(username));

        // Test if the password is valid
        assertTrue(password.length() >= 8);
    }

}