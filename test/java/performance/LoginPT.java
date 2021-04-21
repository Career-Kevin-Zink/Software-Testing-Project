package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginPT {
  long startTime = java.util.Calendar.getInstance().getTimeInMillis();
  long endTime = java.util.Calendar.getInstance().getTimeInMillis();

  @Test
  @DisplayName("Initialize Login UI in less than 5 seconds")
  public void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Login();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Query Username & Password in less than 5 seconds")
  public void search() {
    try {
      startTime = java.util.Calendar.getInstance().getTimeInMillis();

      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      PreparedStatement pst =
          con.prepareStatement("select * from user where username = ? and password = ?");
      pst.setString(1, "john");
      pst.setString(2, "123");

      ResultSet rs;
      rs = pst.executeQuery();
      if (rs.next()) {
        endTime = java.util.Calendar.getInstance().getTimeInMillis();
        assertTrue(endTime - startTime <= 5000);
      }

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Test
  @DisplayName("")
  @Disabled
  public void doTheWholeThing() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Login l = new Login();
    l.txtuser.setText("john");
    l.txtpass.setText("123");
    l.setVisible(true);
    l.jButton1.doClick();
    l.hide();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Calling Login.main")
  void testMainTime() {

    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    Login.main(new String[] {"arg1", "arg2", "arg3"});
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Query Username & Password 1000 times and time it")
  public void searchEndurance() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      PreparedStatement pst =
          con.prepareStatement("select * from user where username = ? and password = ?");
      pst.setString(1, "john");
      pst.setString(2, "123");

      ResultSet rs = null;
      startTime = java.util.Calendar.getInstance().getTimeInMillis();
      for (int i = 0; i < 100000; i++) {
        rs = pst.executeQuery();

        if (rs.next()) {
          System.out.println(rs);
        }
      }

    } catch (ClassNotFoundException | SQLException ex) {
      Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
}
