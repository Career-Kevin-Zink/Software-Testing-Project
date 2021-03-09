import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userCreationTest {

    @Test
    public void testSubmitUserDetails() {
        String firstName = "John";
        String lastName = "John";
        String username = "jdoe09";
        String password = "12345678";

        assertTrue(!firstName.isEmpty()
                            && !lastName.isEmpty()
                            && username.length() > 3
                            && Database.isUsernameAvailable(username)
                            && password.length() >= 8);
    }

}