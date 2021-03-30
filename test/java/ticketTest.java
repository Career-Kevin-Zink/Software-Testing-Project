import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;

import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class ticketTest {

    @BeforeEach
    @AfterEach
    public void initBookFlightTable() {
        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `ticket`");
            s.execute("CREATE TABLE `ticket` (" +
                  "  `id` varchar(255) NOT NULL," +
                  "  `flightid` varchar(255) NOT NULL," +
                  "  `custid` varchar(255) NOT NULL," +
                  "  `class` varchar(255) NOT NULL," +
                  "  `price` varchar(255) NOT NULL" +
                  "  `seats` varchar(255) NOT NULL" +
                  "  `date` varchar(255) NOT NULL" +
                  ") ENGINE=InnoDB DEFAULT CHARSET=latin1;");
            s.execute("INSERT INTO `flights` (`ticketid`, `flightid`, `custid, `flightclass`, `price`, `seats` `dates`) VALUES" );
            // add table
        } catch (SQLException ignored){}
    }
    public void wipeBookFlightTable() {

        try {
            Database.getConnection();
            Statement s = Database.connection.createStatement();
            s.execute("DROP TABLE `ticket`");
            s.execute("CREATE TABLE `ticket` (\n" +
                    "  `id` varchar(255) NOT NULL,\n" +
                    "  `flightid` varchar(255) NOT NULL,\n" +
                    "  `custid` varchar(255) NOT NULL,\n" +
                    "  `class` varchar(255) NOT NULL,\n" +
                    "  `price` varchar(255) NOT NULL\n" +
                    "  `seats` varchar(255) NOT NULL\n" +
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
        wipeBookFlightTable();
        // Test for "MAX(id)") == null.
        assertDoesNotThrow(() -> {
            new ticket().autoID();
        });
    }
}
//    @Test
//    void TestBookFlightExceptions(){
//        String customerID2 = "CSO54321";
//
//        Assertions.assertThrows(SQLException.class);
//    }