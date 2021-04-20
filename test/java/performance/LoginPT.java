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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

public class LoginPT {

  @Test
  @DisplayName("Initialize Login UI in less than 5 seconds")
  public void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new Login();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    // Testing the GUI initialization time is less than 5 seconds.
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  @DisplayName("Query Username & Password in less than 5 seconds")
  public void search(){
      try {
        long startTime = java.util.Calendar.getInstance().getTimeInMillis();

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
        PreparedStatement pst = con.prepareStatement("select * from user where username = ? and password = ?");
        pst.setString(1, "john");
        pst.setString(2, "123");

        ResultSet rs;
        rs = pst.executeQuery();
        if(rs.next()){
          long endTime = java.util.Calendar.getInstance().getTimeInMillis();
          assertTrue(endTime - startTime <= 5000);
        }

      }catch (ClassNotFoundException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
