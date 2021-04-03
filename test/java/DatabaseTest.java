import org.junit.jupiter.api.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void getValidConnection() {

        assertDoesNotThrow(Database::getConnection);
    }

    //@Test
    void getInvalidConnection() {

        String dbFileLocation = "jdbc:mysql://localhost/air";
        String username = "root";
        String password = "";

        Database database = new Database();

        try {
            database.connection = DriverManager.getConnection(dbFileLocation, username, password);
        } catch (SQLException se) {
            se.printStackTrace();
        }

        assertThrows(ClassNotFoundException.class, ()-> {
            database.getConnection();
        });
    }
}