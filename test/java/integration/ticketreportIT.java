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

    @Test
    void jButton1ActionPerformed() {
        ticketreport TR = new ticketreport();
        TR.jButton1.doClick();
        assertNotNull(conn);
    }

    @Test
    void loadData() {
        ticketreport TR = new ticketreport();
        TR.LoadData();
        assertNotNull(conn);
    }
}

