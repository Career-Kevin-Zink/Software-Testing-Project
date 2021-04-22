package integration;

import app.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class MainIT {

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
    void JMenuItem1ActionPerformed() {

        Main main = new Main();
        main.jMenuItem1.doClick();
        assertNotNull(main.jDesktopPane1);
        assertNotNull(conn);
    }

    @Test
    void JMenuItem2ActionPerformed() {

        Main main = new Main();
        main.jMenuItem2.doClick();
        assertNotNull(main.jDesktopPane1);
        assertNotNull(conn);
    }

    @Test
    void JMenuItem3ActionPerformed() {

        Main main = new Main();
        main.jMenuItem3.doClick();
        assertNotNull(main.jDesktopPane1);
        assertNotNull(conn);
    }

    @Test
    void JMenuItem4ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem4.doClick();
            assertNotNull(main.jDesktopPane1);
            assertNotNull(conn);
        });
    }

    @Test
    void JMenuItem5ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem5.doClick();
            assertNotNull(main.jDesktopPane1);
            assertNotNull(conn);
        });
    }

    @Test
    void JMenuItem6ActionPerformed() {
        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem6.doClick();
            assertNotNull(conn);
        });
    }

    @Test
    @DisplayName("Calling Main.main")
    void testMain(){
        Main.main(new String[]{"arg1", "arg2", "arg3"});
    }
}
