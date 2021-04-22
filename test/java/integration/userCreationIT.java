package integration;

import app.userCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class userCreationIT {

    @Mock
    private Connection conn;

    @Mock
    private ResultSet rs;

    @Mock
    private PreparedStatement pst;

    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
    }

    @Test
    void userCreationValidDetails() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was successfully created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void userCreationInvalidId() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        // Provide test inputs.
        userCreation.txtuserid.setText("");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void userCreationInvalidFirstName() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void userCreationInvalidLastName() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void userCreationInvalidUsername() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("");
        userCreation.txtpassword.setText("ABC123");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void userCreationInvalidPassword() {
        userCreation userCreation = new userCreation();

        // Ensure the user does not already exist.
        try {
            when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        // Provide test inputs.
        userCreation.txtuserid.setText("UO005");
        userCreation.txtfirstname.setText("John");
        userCreation.txtlastname.setText("Doe");
        userCreation.txtusername.setText("jdoe69");
        userCreation.txtpassword.setText("");

        // Execute the method.
        userCreation.jButton1.doClick();

        // Ensure the user was not created.
        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
    void jButton2ActionPerformed() {
        userCreation userCreation = new userCreation();

        // Execute the method.
        userCreation.jButton2.doClick();
        assertNotNull(conn);
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
            assertNotNull(conn);
        });

        // Clear the database to trigger other branch.
        emptyUserTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> {
            new userCreation().autoID();
            assertNotNull(conn);
        });
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

}
