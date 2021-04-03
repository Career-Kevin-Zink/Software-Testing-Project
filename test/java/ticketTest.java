import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class ticketTest {
    public static boolean doesFlightExist(String flightid) {
        boolean returnVal = false;

        try {
            Connection connection = Database.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from flight where id= ?");
            pst.setString(1, flightid);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException e) {
            System.out.println("SQLException in isFlightAvailable: " + e.getMessage());
        }

        return returnVal;
    }
    @BeforeEach
    @AfterEach
    public void initTicketTable() {
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
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
            s.execute("INSERT INTO `flights` (`id`, `flightid`, `custid, `flightclass`, `price`, `seats`, `dates`) VALUES" );
            // add table
        } catch (SQLException ignored){}
    }
    public void wipeTicketTable() {
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
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
        }catch (SQLException ignored) {}
    }

    @Test
    public void TestBookFlightDetails() {
            String id = "TK001";
            String flightid = "FL001";
            String custid = "CS001";
            String Fclass = "Economy";
            String price = "100";
            String seats = "5";
            String date = "2012/09/07";

            assertTrue(!id.isEmpty());

            assertTrue(!flightid.isEmpty());

            assertTrue(!custid.isEmpty());

            assertTrue(!Fclass.isEmpty());

            assertTrue(!price.isEmpty());

            assertTrue(!seats.isEmpty());

            assertTrue(!date.isEmpty());
    }

    @Test
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
    @Test
    void initComponents(){
        new ticket();
    }

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

    @Test
    void testJButton4ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtcustid.setText("CS001");
        ticket.jButton4.doClick();
        assertTrue(ticket.txtfirstname.getText().equals("john"));
    }

    @Test
    void testJTable1MouseClicked(){
        ticket ticket = new ticket();
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        assertTrue(ticket.jTable1.getRowCount() >= 1);
        ticket.jTable1.setRowSelectionInterval(0,0);
        assertTrue(ticket.flightname.getText().equals("JetBlue"));
    }
    @Test
    void testTxtseatsStateChanged(){
        ticket ticket = new ticket();

        
    }
    @Test
    void testJButton1ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtticketno.setText("TO001");
        ticket.flightno.setText("FO001");
        ticket.txtcustid.setText("CS001");
        ticket.txtclass.setSelectedItem("Economy");
        ticket.txtprice.setText("50000");
        ticket.txtseats.setValue(1);
//        Date date = new Date();
//        ticket.txtdate.setDate(date);


        ticket.jButton1.doClick();
        assertTrue(Database.doesTicketExist("TO001"));
    }
    @Test
    void testJButton2ActionPerformed(){
        ticket ticket = new ticket();

        ticket.jButton2.doClick();

    }
}
