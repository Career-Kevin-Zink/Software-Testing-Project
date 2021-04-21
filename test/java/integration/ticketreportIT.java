package integration;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;
import app.ticket;
import app.Main;
import app.ticketreport;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class ticketreportIT {
}
//  @Mock
//  private Connection conn;
//  @Mock
//  private ResultSet rs;
//  @Mock
//  private PreparedStatement pst;
//
//  @BeforeAll
//  private void setupMockDB(){
//
//    try{
//      when(conn.prepareStatement(any(String.class))).thenReturn(pst);
//      when(rs.first()).thenReturn(true);
//
//
//    }catch (SQLException se) {
//      se.printStackTrace();
//      System.out.println("SQL Exception in ticketreportIT: setUpMockDB");
//    }
//
//  }
//
//  @Test
//  @DisplayName("Verify JTable values not null")
//  public void checkJtable(){
//    ticketreport TR = new ticketreport();
//    TR.jButton1.doClick();
//    when(TR.jButton1.doClick()).thenReturn(true);
////assertTrue(when(conn == any(String.class))).thenReturn(true);

  //}
//}
