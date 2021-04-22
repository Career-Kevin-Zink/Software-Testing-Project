package unit;

import app.ticket;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class ticketUT {

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

    /**
     * Requirement: None
     *
     * Input: String"India", String"Uk",
     * Description: Assert that inputting a destination and source will fill the jtable.
     *
     * Dependencies: None
     * Expected Output: true,
     * Actual Output: true,
     * Statement Coverage: 84$s%
     * Branch Coverage: 52%
     */
    @Test
    void testJButton3ActionPerformed(){

        ticket ticket = new ticket();

        //Simulating input into dropdown box's
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        //Testing to see if JTable is filled
        assertTrue(ticket.jTable1.getRowCount() >= 1);

    }

   // @Test
    void testJButton4ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtcustid.setText("83748902");
        ticket.jButton4.doClick();
        Assertions.assertFalse(ticket.txtfirstname.getText().equalsIgnoreCase("john"));
        ticket.txtcustid.setText("CS001");
        ticket.jButton4.doClick();
        Assertions.assertTrue(ticket.txtfirstname.getText().equalsIgnoreCase("john"));

    }

   // @Test
    void testJTable1MouseClicked() {
        ticket ticket = new ticket();
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        assertTrue(ticket.jTable1.getRowCount() >= 1);

        ticket.jTable1.changeSelection(0,0,false,false);

        DefaultTableModel Df = (DefaultTableModel) ticket.jTable1.getModel();
        int selectIndex = ticket.jTable1.getSelectedRow();

        ticket.flightno.setText(Df.getValueAt(selectIndex, 0).toString());
        ticket.flightname.setText(Df.getValueAt(selectIndex, 1).toString());
        ticket.txtdept.setText(Df.getValueAt(selectIndex, 5).toString());
        ticket.txtprice.setText(Df.getValueAt(selectIndex, 7).toString());
        Assertions.assertTrue(ticket.flightname.getText().equals("JetBlue"));
    }
  //  @Test
    void testTxtseatsStateChanged(){
        ticket ticket = new ticket();
        ticket.txtprice.setText("2000");
        ticket.txtseats.setValue(2);
        Assertions.assertTrue(ticket.txttotal.getText().equals("4000"));

    }
  //  @Test
    void testJButton1ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtticketno.setText("TO004");
        ticket.flightno.setText("FO001");
        ticket.txtcustid.setText("CS001");
        ticket.txtclass.setSelectedItem("Economy");
        ticket.txtprice.setText("50000");
        ticket.txtseats.setValue(1);


        ticket.jButton1.doClick();
        assertTrue(doesTicketExist("TO004"));
    }
  //  @Test
    void testJButton2ActionPerformed(){
        ticket ticket = new ticket();

        ticket.jButton2.doClick();

    }
   // @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        assertDoesNotThrow(() -> {
            new ticket().autoID();
        });

        // Clear the database to trigger other branch.
        wipeTicketTable();
        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> {
            new ticket().autoID();
        });
    }

    public static boolean doesTicketExist(String ticketNo) {
        boolean returnVal = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            PreparedStatement pst = con.prepareStatement("select * from ticket where id= ?");
            pst.setString(1, ticketNo);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("SQLException in doesTicketExist: " + e.getMessage());
        }

        return returnVal;
    }

}

