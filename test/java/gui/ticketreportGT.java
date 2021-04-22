package gui;
import app.Main;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JInternalFrameFixture;
import org.assertj.swing.fixture.JPanelFixture;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import javax.swing.*;
import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ticketreportGT {
    private FrameFixture window;


    @BeforeEach
    @DisplayName("Setting up test.")
    public void setup() {
        Main frame = GuiActionRunner.execute(Main::new);
        window = new FrameFixture(frame);
        window.show();

        //open searchCustomer panel.
        frame.jMenuItem6.doClick();
    }
    @AfterEach
    @DisplayName("Cleaning up test.")
    public void tearDown() {window.cleanUp();}

    @Test
    @Order(1)
    @DisplayName("Is the panel showing?")
    public void isPanelVisable() {
        window.scrollPane("ticketReportPane").requireVisible();
    }
    @Test
    @Order(2)
    @DisplayName("Does the cancel button work?")
    public void checkCancelButton(){
        window.button("CancelButton").click();

    }
}
