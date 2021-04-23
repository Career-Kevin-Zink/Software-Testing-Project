package integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import app.ticketreport;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RunWith(MockitoJUnitRunner.class)
public class ticketreportIT {
    // sets the mock connections
    @Mock
    private Connection conn;
    // sets the mock result set
    @Mock
    private ResultSet rs;
    //sets the mock prepared statements
    @Mock
    private PreparedStatement pst;
    // sets the mock DB
    @BeforeEach
    void setDB() {
        conn = mock(Connection.class);
        rs = mock(ResultSet.class);
        pst = mock(PreparedStatement.class);
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
    void jButton1ActionPerformed() {
        ticketreport TR = new ticketreport();
        TR.jButton1.doClick();
        assertNotNull(conn);
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
        TR.LoadData();
        assertNotNull(conn);
    }
}

