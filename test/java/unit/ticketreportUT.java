package unit;

import app.ticketreport;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ticketreportUT {

    @BeforeEach
    @AfterEach
    public void initTicketTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
            Statement s = con.createStatement();
            s.execute("DROP TABLE IF EXISTS `ticket`");
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
    /**
     * Requirement: The system shall allow users to view all existing tickets.
     * <p>
     * Input: none
     * Description: this test tests the only clickable button on the pannel.
     * <p>
     * Dependencies: none
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 97%
     * Branch Coverage: 100%
     */
    @Test
    @Disabled
    void jButton1ActionPerformed() {
    ticketreport TR = new ticketreport();
    TR.jButton1.doClick();
    }
    /**
     * Requirement: The system shall allow users to view all existing tickets.
     * <p>
     * Input: none
     * Description: Checks to see if the table loads up correctly
     * <p>
     * Dependencies: Database
     * Expected Output: none
     * Actual Output: none
     * Statement Coverage: 97%
     * Branch Coverage: 100%
     */
    @Test
    void loadData() {
        ticketreport TR = new ticketreport();

        assertTrue(TR.jTable1.getRowCount() == 3);

    }

}