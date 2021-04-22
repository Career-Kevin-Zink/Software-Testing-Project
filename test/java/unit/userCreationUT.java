package unit;

import app.userCreation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class userCreationUT {


    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"UO005", String"John", String"Doe", String "jdoe69", String"ABC123"
     * Description: Assert that creating a user will create the user in the database.
     *
     * Dependencies: None
     * Expected Output: true, false
     * Actual Output: true, false
     * Statement Coverage: 95%
     * Branch Coverage: 50%
     */
    //@Test
    void userCreationValidDetails() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was successfully created.
        assertFalse(isUsernameAvailable("jdoe69"));
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"", String"John", String"Doe", String "jdoe69", String"ABC123"
     * Description: checking to see if a false entry correctly stops the entry from going to the database.
     *
     * Dependencies: database
     * Expected Output: true, True
     * Actual Output: true, True
     * Statement Coverage: 89%
     * Branch Coverage: 16%
     */
    //@Test
    void userCreationInvalidId() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        assertTrue(isUsernameAvailable("jdoe69"));
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"UO005", String"", String"Doe", String "jdoe69", String"ABC123"
     * Description:  checking to see if a false entry correctly stops the entry from going to the database.
     *
     * Dependencies: database
     * Expected Output: true, True
     * Actual Output: true, True
     * Statement Coverage: 89%
     * Branch Coverage: 33%
     */
    //@Test
    void userCreationInvalidFirstName() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        assertTrue(isUsernameAvailable("jdoe69"));
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"UO005", String"John", String"", String "jdoe69", String"ABC123"
     * Description:  checking to see if a false entry correctly stops the entry from going to the database.
     *
     * Dependencies: database
     * Expected Output: true, True
     * Actual Output: true, True
     * Statement Coverage: 89%
     * Branch Coverage: 33%
     */
    //@Test
    void userCreationInvalidLastName() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        assertTrue(isUsernameAvailable("jdoe69"));
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"UO005", String"John", String"Doe", String "", String"ABC123"
     * Description:  checking to see if a false entry correctly stops the entry from going to the database.
     *
     * Dependencies: database
     * Expected Output: true, True
     * Actual Output: true, True
     * Statement Coverage: 89%
     * Branch Coverage: 41%
     */
    //@Test
    void userCreationInvalidUsername() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        assertTrue(isUsernameAvailable("jdoe69"));
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: String"UO005", String"John", String"Doe", String "jdoe69", String""
     * Description:  checking to see if a false entry correctly stops the entry from going to the database.
     *
     * Dependencies: database
     * Expected Output: true, True
     * Actual Output: true, True
     * Statement Coverage: 89%
     * Branch Coverage: 50%
     */
    @Test
    void userCreationInvalidPassword() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        assertTrue(isUsernameAvailable("jdoe69"));

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        assertTrue(isUsernameAvailable("jdoe69"));
    }

    /**
     * Requirement:The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: none
     * Description: Assert that creating a user will create the user in the database.
     *
     * Dependencies: Database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 85%
     * Branch Coverage: 8%
     */
    //@Test
    void jButton2ActionPerformed() {
        userCreation userCreation = new userCreation();

        // Execute the method.
        userCreation.jButton2.doClick();
    }
    /**
     * Requirement: The system shall allow users to create new users by providing the first name,
     * last name, username and password for the new user.
     *
     * Input: none
     * Description: Makes sure that they can pull the next ID from the database
     *
     * Dependencies: Database
     * Expected Output: true, true
     * Actual Output: true, true
     * Statement Coverage: 85%
     * Branch Coverage: 16%
     */
    //@Test
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE IF EXISTS `user`");
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
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    public void emptyUserTable() {
        // Wipe database to enter the null branch.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE IF EXISTS `user`");
            s.execute("CREATE TABLE `user` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    // simple function to check and see if the username is already in the database or not.
    public static boolean isUsernameAvailable(String username) {
        boolean returnVal = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            PreparedStatement pst = con.prepareStatement("select * from user where username= ?");
            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if (!rs.next()) returnVal = true;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("SQLException in isUsernameAvailable: " + e.getMessage());
        }

        return returnVal;
    }
}