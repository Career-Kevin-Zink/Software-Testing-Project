package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.addCustomer;
import app.searchCustomer;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class searchCustomerPT extends Component {

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
