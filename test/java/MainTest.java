import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void initComponents() {

        assertDoesNotThrow(()->{Main main = new Main();

            long startTime = java.util.Calendar.getInstance().getTimeInMillis();
            main.initComponents();
            long endTime = java.util.Calendar.getInstance().getTimeInMillis();

            // Testing the GUI initialization time is less than 5 seconds.
            assertTrue(endTime - startTime <= 5000);});
    }

    @Test
    void JMenuItem1ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem1.doClick();
            assertNotNull(main.jDesktopPane1);
        });
    }

    @Test
    void JMenuItem2ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem2.doClick();
            assertNotNull(main.jDesktopPane1);
        });
    }

    @Test
    void JMenuItem3ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem3.doClick();
            assertNotNull(main.jDesktopPane1);
        });
    }

    @Test
    void JMenuItem4ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem4.doClick();
            assertNotNull(main.jDesktopPane1);
        });
    }

    @Test
    void JMenuItem5ActionPerformed() {

        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem5.doClick();
            assertNotNull(main.jDesktopPane1);
        });
    }

    @Test
    void JMenuItem6ActionPerformed() {
        assertDoesNotThrow(()->{
            Main main = new Main();
            main.jMenuItem6.doClick();
        });
    }

    @Test
    @DisplayName("Calling Main.main")
    void testMain(){
        Main.main(new String[]{"arg1", "arg2", "arg3"});
    }
}