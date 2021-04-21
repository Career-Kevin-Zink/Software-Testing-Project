package integration;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import app.ticket;
import app.Main;
import app.ticketreport;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ticketreportIT {
  @Mock
  Main mainMock;
  @Mock
  ticketreport ticketreportMock;

  @Test
  @DisplayName("Verify JTable values not null")
  public void checkJtable(){
    ticketreportMock = mock(ticketreport.class);



  }
}
