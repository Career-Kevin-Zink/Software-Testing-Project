import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class addCustomerTest {

    @BeforeEach
    @AfterEach
    public void initUserTable() {
        // Set the database to the expected default state.
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `nic` varchar(255) NOT NULL,\n" +
                    "  `passport` varchar(255) NOT NULL,\n" +
                    "  `address` text NOT NULL,\n" +
                    "  `dob` varchar(255) NOT NULL,\n" +
                    "  `gender` varchar(255) NOT NULL,\n" +
                    "  `contact` int(11) NOT NULL,\n" +
                    "  `photo` longblob NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `customer` (`id`, `firstname`, `lastname`, `nic`, `passport`, `address`, `dob`, `gender`, `contact`, `photo`) VALUES "
                    + "('CS001', 'john', 'Alex', '34232222', '3443', 'Uk', '1996-06-01', 'Male', 34324234, 0),"
                    + "('CS002', 'Jim', 'Jones', '34324', '433', 'Africa', '2019-06-14', 'Male', 3432423, 0),"
                    + "('CS003', 'John', 'Peter', '232423423V', '48733', 'India\t', '2007-06-02', 'Male', 324324324, 0);");
        } catch (SQLException ignored) {}
    }

    public void wipeCustomerTable() {
        // Wipe database to enter the null branch.
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException ignored) {}
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> new addCustomer().autoID());

        wipeCustomerTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> new addCustomer().autoID());
    }

    @Test
    void testCreateCustomer() {
        // Valid Customer information.
        String id = "CS004";
        String firstName = "John";
        String lastName = "Doe";
        String nic = "12345678910";
        String passport = "1234";
        String address = "YOU ESS AYE";
        String dob = "1994-09-12";
        String gender = "Correct";
        String contact = "1234567";

        try {
            Database.getConnection();
            PreparedStatement pst =
                    Database.connection.prepareStatement(
                            "insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact)values(?,?,?,?,?,?,?,?,?)");

            pst.setString(1, id);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, nic);
            pst.setString(5, passport);
            pst.setString(6, address);
            pst.setString(7, dob);
            pst.setString(8, gender);
            pst.setString(9, contact);
            pst.executeUpdate();
        } catch (Exception ignored) {
        }
    }

}