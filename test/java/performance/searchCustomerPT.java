package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.addCustomer;
import app.searchCustomer;
import java.awt.Component;
import java.sql.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class searchCustomerPT extends Component {


  @BeforeEach
  @AfterEach
  public void initUserTable() {
    // Set the database to the expected default state.
    byte[] smallphoto = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5, 8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87, 99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56, 38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();

      // Drop the table and recreate.
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

      // Add initial values.
      PreparedStatement pst = con.prepareStatement("insert into customer(id,firstname,lastname,nic,passport,address,dob,gender,contact,photo)values(?,?,?,?,?,?,?,?,?,?)");
      pst.setString(1, "CS001");
      pst.setString(2, "John");
      pst.setString(3, "Alex");
      pst.setString(4, "34232222");
      pst.setString(5, "3443");
      pst.setString(6, "Uk");
      pst.setString(7, "1996-06-01");
      pst.setString(8, "Male");
      pst.setString(9, "34324234");
      pst.setBytes(10, smallphoto);
      pst.executeUpdate();

      pst.setString(1, "CS002");
      pst.setString(2, "Jim");
      pst.setString(3, "Jones");
      pst.setString(4, "34324");
      pst.setString(5, "433");
      pst.setString(6, "Africa");
      pst.setString(7, "2019-06-14");
      pst.setString(8, "Male");
      pst.setString(9, "3432423");
      pst.setBytes(10, smallphoto);
      pst.executeUpdate();

      pst.setString(1, "CS003");
      pst.setString(2, "John");
      pst.setString(3, "Peter");
      pst.setString(4, "232423423V");
      pst.setString(5, "48733");
      pst.setString(6, "India");
      pst.setString(7, "2007-06-02");
      pst.setString(8, "Male");
      pst.setString(9, "324324324");
      pst.setBytes(10, smallphoto);
      pst.executeUpdate();

      pst.setString(1, "CS004");
      pst.setString(2, "Lily");
      pst.setString(3, "Tester");
      pst.setString(4, "232423423B");
      pst.setString(5, "48734");
      pst.setString(6, "USA");
      pst.setString(7, "2007-06-02");
      pst.setString(8, "Female");
      pst.setString(9, "324324328");
      pst.setBytes(10, smallphoto);
      pst.executeUpdate();


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
  @DisplayName("Initialize searchCustomer UI in less than 5 seconds")
  public void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new searchCustomer();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Update Customer in less than 5 seconds")
  public void update() {
    try {
      long startTime = java.util.Calendar.getInstance().getTimeInMillis();
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      PreparedStatement pst =
          con.prepareStatement(
              "update customer set firstname = ?,lastname = ?,nic = ?,passport = ?,address= ?,dob = ?,gender = ?,contact = ?,photo = ? where id = ?");

      pst.setString(1, "Joe");
      pst.setString(2, "Mana");
      pst.setString(3, "221");
      pst.setString(4, "P342342");
      pst.setString(5, "101 Te St.");
      pst.setString(6, new Date().toString());
      pst.setString(7, "Male");
      pst.setString(8, "239-443-0082");
      pst.setBytes(
          9,
          new byte[] {
            -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 5, 0, 0, 0, 5,
            8, 2, 0, 0, 0, 2, 13, -79, -78, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0, 0,
            0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 9, 112, 72, 89, 115, 0,
            0, 14, -61, 0, 0, 14, -61, 1, -57, 111, -88, 100, 0, 0, 0, 23, 73, 68, 65, 84, 24, 87,
            99, -8, -1, -1, 63, 3, 3, 18, 9, -60, -56, -128, 52, -7, -1, -1, 1, -33, -32, 56, -56,
            38, 25, 19, 55, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126
          });
      pst.setString(10, "CS001");
      pst.executeUpdate();
      long endTime = java.util.Calendar.getInstance().getTimeInMillis();
      assertTrue(endTime - startTime <= 5000);

      JOptionPane.showMessageDialog(null, "Registration Updated.........");
    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Test
  @DisplayName("Search customer in less than 5 seconds")
  public void search() {
    try {
      long startTime = java.util.Calendar.getInstance().getTimeInMillis();
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      PreparedStatement pst = con.prepareStatement("select * from customer where id = ?");
      pst.setString(1, "CS001");
      ResultSet rs = pst.executeQuery();

      if (!rs.next()) {
        long endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
      }

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(searchCustomer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
