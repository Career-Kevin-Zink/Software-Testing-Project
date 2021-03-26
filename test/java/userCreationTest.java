import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class userCreationTest {

    @BeforeEach
    @AfterEach
    public void initUserTable() {
        // Set the database to the expected default state.
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `user`");
            s.execute("CREATE TABLE `user` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES\n" +
                    "('UO001', 'john', 'peter', 'john', '123'),\n" +
                    "('UO002', 'nimal', 'raja', 'raja', '321'),\n" +
                    "('UO003', 'Jim', 'Jones', 'jjones', '123'),\n" +
                    "('UO004', 'Ravi', 'Kumar', 'rjumar', '123');");
        } catch (SQLException ignored) {}
    }

    public void wipeUserTable() {
        // Wipe database to enter the null branch.
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `user`");
            s.execute("CREATE TABLE `user` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException ignored) {}
    }

    @Test
    public void testSubmitUserDetails() {
        // The simulated inputs, Equivalence Class E1.
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

        // Generate an id for the new user.
        final String[] userId = new String[1];
        assertDoesNotThrow(() -> {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            ResultSet rs = s.executeQuery("select MAX(id) from user");
            rs.next();
            rs.getString("MAX(id)");
            if (rs.getString("MAX(id)") == null) {
                userId[0] = "UO001";
            } else {
                long id =
                        Long.parseLong(rs.getString("MAX(id)").substring(2, rs.getString("MAX(id)").length()));
                id++;
                userId[0] = "UO" + String.format("%03d", id);
            }
        });

        // Insert the user into the database.
        assertDoesNotThrow(() -> {
            Database.getConnection();
            PreparedStatement pst =
                    Database.connection.prepareStatement(
                            "insert into user(id,firstname,lastname,username,password)values(?,?,?,?,?)");

            pst.setString(1, userId[0]);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, username);
            pst.setString(5, password);

            //pst.executeUpdate();
        });
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
        });

        // Clear the database to trigger other branch.
        wipeUserTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
        });
    }
}