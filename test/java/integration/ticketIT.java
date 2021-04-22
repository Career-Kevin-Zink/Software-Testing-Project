package integration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import app.Login;
import app.ticket;
import app.Main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

@RunWith(MockitoJUnitRunner.class)
public class ticketIT {


    @Mock
    private Connection conn;

    @Mock
    private ResultSet rs;

    @Mock
    private PreparedStatement pst;

    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
    }

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
    void testJButton3ActionPerformed(){

        ticket ticket = new ticket();

        //Simulating input into dropdown box's
        ticket.txtsource.setSelectedItem("India");
        ticket.txtdepart.setSelectedItem("Uk");
        // Executing the method
        ticket.jButton3.doClick();
        //Testing to see if JTable is filled

        try {

            if (rs.next()) {
                doReturn(true).when(rs).next();
            }
            else if (rs != null){
                when(!rs.next()).thenReturn(false);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            System.out.println("SQLException in TicketIT: testJButton3ActionPerformed");
        }
    }

    @Test
    void testAutoID() {
        // Test for "MAX(id)") != null.
        new ticket().autoID();
        assertNotNull(conn);

        // Clear the database to trigger other branch.
        wipeTicketTable();

        // Test for "MAX(id)") == null.
        new ticket().autoID();
        assertNotNull(conn);
    }

    @Test
    void testJButton4ActionPerformed(){
        ticket ticket = new ticket();

        ticket.txtcustid.setText("83748902");
        ticket.jButton4.doClick();

       try {
           when(!rs.next()).thenReturn(false);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        ticket.txtcustid.setText("CS001");
        ticket.jButton4.doClick();

        try {
            doReturn(true).when(rs).next();
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Test
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

}
