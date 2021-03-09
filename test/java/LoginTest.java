import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    @ParameterizedTest
    @ValueSource(userNames = {"Error", "john", "Error", "john"})
    public void loginTest(String username, String passwords) {

    }

}