import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class addCustomerTest {

    @BeforeEach
    @AfterEach
    public void initUserTable() {
        // Set the database to the expected default state.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
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
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    public void wipeCustomerTable() {
        // Wipe database to enter the null branch.
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE `customer`");
            s.execute("CREATE TABLE `customer` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `firstname` varchar(255) NOT NULL,\n" +
                    "  `lastname` varchar(255) NOT NULL,\n" +
                    "  `username` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
        } catch (SQLException | ClassNotFoundException ignored) {}
    }

    @Test
    void autoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> new addCustomer().autoID());

        wipeCustomerTable();

        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> new addCustomer().autoID());
    }


    @Test
    void initComponents() {
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();
        new addCustomer();
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();

        // Testing the GUI initialization time is less than 5 seconds.
        assertTrue(endTime - startTime <= 5000);
    }

    @Test
    void txtlastnameActionPerformed() {
        // Method does nothing.
    }

    @Test
    void txtpassportActionPerformed() {
        // Method does nothing.
    }

    @Test
    void jButton1ActionPerformed() {
        addCustomer addCustomer = new addCustomer();
        addCustomer.jButton1.doClick();
        System.out.println(Arrays.toString(addCustomer.userimage));
        assertNotNull(addCustomer.userimage);
    }

    @Test
    void jButton2ActionPerformed() {
        addCustomer addCustomer = new addCustomer();

        // Male customer
        addCustomer.txtid.setText("CS004");
        addCustomer.txtfirstname.setText("John");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JohnnyPassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.JANUARY, 1));
        addCustomer.r1.setSelected(true);
        addCustomer.r2.setSelected(false);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {0};

        addCustomer.jButton2.doClick();

        // Female customer
        addCustomer = new addCustomer();
        addCustomer.txtid.setText("CS005");
        addCustomer.txtfirstname.setText("Jane");
        addCustomer.txtlastname.setText("Doe");
        addCustomer.txtnic.setText("ABC123");
        addCustomer.txtpassport.setText("JanePassport");
        addCustomer.txtaddress.setText("123 Apple street");
        addCustomer.txtdate.setDate(new Date(2020, Calendar.SEPTEMBER, 2));
        addCustomer.r1.setSelected(false);
        addCustomer.r2.setSelected(true);
        addCustomer.txtcontact.setText("123456");
        addCustomer.userimage = new byte[] {0};

        addCustomer.jButton2.doClick();
    }

    @Test
    void jButton3ActionPerformed() {
        new addCustomer().jButton3.doClick();
    }
}