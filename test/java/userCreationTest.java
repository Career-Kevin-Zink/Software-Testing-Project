import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class userCreationTest {

    @Test
    void initComponents() {
        new userCreation().initComponents();
    }

    @Test
    void jButton1ActionPerformed() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(Database.isUsernameAvailable("jdoe69"));

        // Setup the GUI
        userCreation.initComponents();

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was successfully created.
        assertFalse(Database.isUsernameAvailable("jdoe69"));
    }

    @Test
    void jButton2ActionPerformed() {
        userCreation userCreation = new userCreation();

        // Setup the GUI
        userCreation.initComponents();

        // Execute the method.
        userCreation.jButton2.doClick();
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
        });

        // Clear the database to trigger other branch.
        emptyUserTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
        });
    }

    // Test Helper Methods

    @BeforeEach
    @AfterEach
    public void defaultUserTable() {
        // Set the database to the expected default state.
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `user`");
            s.execute("CREATE TABLE `user` (" +
                    "  `id` varchar(255) NOT NULL," +
                    "  `firstname` varchar(255) NOT NULL," +
                    "  `lastname` varchar(255) NOT NULL," +
                    "  `username` varchar(255) NOT NULL," +
                    "  `password` varchar(255) NOT NULL" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `user` (`id`, `firstname`, `lastname`, `username`, `password`) VALUES" +
                    "('UO001', 'john', 'peter', 'john', '123')," +
                    "('UO002', 'nimal', 'raja', 'raja', '321')," +
                    "('UO003', 'Jim', 'Jones', 'jjones', '123')," +
                    "('UO004', 'Ravi', 'Kumar', 'rjumar', '123');");
        } catch (SQLException ignored) {}
    }

    public void emptyUserTable() {
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
}