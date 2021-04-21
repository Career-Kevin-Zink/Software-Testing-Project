package performance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.ticket;
import org.junit.jupiter.api.*;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ticketPT {
  long startTime = java.util.Calendar.getInstance().getTimeInMillis();
  long endTime = java.util.Calendar.getInstance().getTimeInMillis();

  @BeforeEach
  @AfterEach
  public void initTicketTable() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `ticket`");
      s.execute("CREATE TABLE `ticket` (" +
              "  `id` varchar(255) NOT NULL," +
              "  `flightid` varchar(255) NOT NULL," +
              "  `custid` varchar(255) NOT NULL," +
              "  `class` varchar(255) NOT NULL," +
              "  `price` varchar(255) NOT NULL," +
              "  `seats` varchar(255) NOT NULL," +
              "  `date` varchar(255) NOT NULL" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
      s.execute("INSERT INTO `ticket` (`id`, `flightid`, `custid`, `class`, `price`, `seats`, `date`) VALUES\n" +
              "('TO001', 'FO003', 'CS001', 'Economy', 9000, 1, '2019-06-15')," +
              "('TO002', 'FO003', 'CS001', 'Economy', 9000, 2, '2019-06-15')," +
              "('TO003', 'FO001', 'CS003', 'Economy', 50000, 3, '2019-07-01');");

      // add table
    } catch (SQLException | ClassNotFoundException ignored){}
  }
  public void wipeTicketTable() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
      Statement s = con.createStatement();
      s.execute("DROP TABLE `ticket`");
      s.execute("CREATE TABLE `ticket` (\n" +
              "  `id` varchar(255) NOT NULL,\n" +
              "  `flightid` varchar(255) NOT NULL,\n" +
              "  `custid` varchar(255) NOT NULL,\n" +
              "  `class` varchar(255) NOT NULL,\n" +
              "  `price` varchar(255) NOT NULL,\n" +
              "  `seats` varchar(255) NOT NULL,\n" +
              "  `date` varchar(255) NOT NULL\n" +
              ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
    }catch (SQLException | ClassNotFoundException ignored) {}
  }


  @Test
  @DisplayName("Initialize ticket UI in less than 5 seconds")
  void initComponents() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    new ticket();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }

  @Test
  void testJButton3ActionPerformed() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();

    //Simulating input into dropdown box's
    ticket.txtsource.setSelectedItem("India");
    ticket.txtdepart.setSelectedItem("Uk");
    // Executing the method
    ticket.jButton3.doClick();
    //Testing to see if JTable is filled
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testJButton4ActionPerformed(){
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();

    ticket.txtcustid.setText("83748902");
    ticket.jButton4.doClick();
    ticket.txtcustid.setText("CS001");
    ticket.jButton4.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);

  }
  @Test
  void testJTable1MouseClicked() {
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();
    ticket.txtsource.setSelectedItem("India");
    ticket.txtdepart.setSelectedItem("Uk");
    // Executing the method
    ticket.jButton3.doClick();

    ticket.jTable1.changeSelection(0,0,false,false);

    DefaultTableModel Df = (DefaultTableModel) ticket.jTable1.getModel();
    int selectIndex = ticket.jTable1.getSelectedRow();

    ticket.flightno.setText(Df.getValueAt(selectIndex, 0).toString());
    ticket.flightname.setText(Df.getValueAt(selectIndex, 1).toString());
    ticket.txtdept.setText(Df.getValueAt(selectIndex, 5).toString());
    ticket.txtprice.setText(Df.getValueAt(selectIndex, 7).toString());
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testTxtseatsStateChanged(){
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();
    ticket.txtprice.setText("2000");
    ticket.txtseats.setValue(2);
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testJButton1ActionPerformed(){
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();

    ticket.txtticketno.setText("TO004");
    ticket.flightno.setText("FO001");
    ticket.txtcustid.setText("CS001");
    ticket.txtclass.setSelectedItem("Economy");
    ticket.txtprice.setText("50000");
    ticket.txtseats.setValue(1);

    ticket.jButton1.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testJButton2ActionPerformed(){
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    ticket ticket = new ticket();

    ticket.jButton2.doClick();
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
  @Test
  void testAutoID() {
    // Test for "MAX(id)") != null.
    startTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertDoesNotThrow(() -> {
      new ticket().autoID();
    });

    // Clear the database to trigger other branch.
    wipeTicketTable();
    // Test for "MAX(id)") == null.
    assertDoesNotThrow(() -> {
      new ticket().autoID();

    });
    endTime = java.util.Calendar.getInstance().getTimeInMillis();
    assertTrue(endTime - startTime <= 5000);
  }
}
