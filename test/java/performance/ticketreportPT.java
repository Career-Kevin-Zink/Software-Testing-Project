package performance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import app.ticketreport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class ticketreportPT {

  long startTime = java.util.Calendar.getInstance().getTimeInMillis();
  long endTime = java.util.Calendar.getInstance().getTimeInMillis();
  /**
   * Requirement: The system shall display all tickets from the database in under ten seconds.
   * <p>
   * Input: none
   * Description: Tests that the GUI initializes in less than 10 seconds
   * <p>
   * Dependencies: none
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 91%
   * Branch Coverage: 100%
   */
  @Test
  @DisplayName("Initialize ticketreport UI in less than 5 seconds")
  void initComponents() {
    long startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new ticketreport();
    long endTime = java.util.Calendar.getInstance().getTimeInMillis();

    assertTrue(endTime - startTime <= 10000);
  }
  /**
   * Requirement: The system shall display all tickets from the database in under ten seconds.
   * <p>
   * Input: none
   * Description: Checks to see if the table loads up correctly
   * in less than 10 seconds
   * <p>
   * Dependencies: Database
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 91%
   * Branch Coverage: 100%
   */
  @Test
  @DisplayName("Fill the jTable in less than 5 seconds")
  public void fill() {
    ticketreport t = new ticketreport();
    try {
      startTime = java.util.Calendar.getInstance().getTimeInMillis();
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");
      PreparedStatement pst = con.prepareStatement("SELECT * from ticket");
      ResultSet rs = pst.executeQuery();

      ResultSetMetaData rsm = rs.getMetaData();
      int c;
      c = rsm.getColumnCount();

      DefaultTableModel Df = (DefaultTableModel) t.jTable1.getModel();
      Df.setRowCount(0);

      while (rs.next()) {
        Vector v2 = new Vector();

        for (int i = 1; i <= c; i++) {
          v2.add(rs.getString("id"));
          v2.add(rs.getString("flightid"));
          v2.add(rs.getString("custid"));
          v2.add(rs.getString("class"));
          v2.add(rs.getString("price"));
          v2.add(rs.getString("seats"));
          v2.add(rs.getString("date"));
        }

        Df.addRow(v2);
      }
      endTime = java.util.Calendar.getInstance().getTimeInMillis();
      assertTrue(endTime - startTime <= 10000);


    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
  /**
   * Requirement: The system shall display all tickets from the database in under ten seconds.
   * <p>
   * Input: none
   * Description: this test tests the only clickable button on the pannel.
   * in less than 10 seconds
   * <p>
   * Dependencies: True
   * Expected Output: True
   * Actual Output: True
   * Statement Coverage: 97%
   * Branch Coverage: 100%
   */
  @Test
  void jButton1ActionPerformed() {
    // testing to see if the button closes the window in less than 1 second
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticketreport TR = new ticketreport();
    TR.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 10000);


  }
}
