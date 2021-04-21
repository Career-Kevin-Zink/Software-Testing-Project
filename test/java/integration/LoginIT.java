package integration;

import static org.mockito.Mockito.*;

import app.Login;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class LoginIT {

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



  @ParameterizedTest
  @DisplayName("Valid Username and Password input passed + jBtn #1 ActionPerformed")
  @CsvSource({",", "john,321", "%^@,123,", "john,123", ",123", "john, "})
  void loginTestSuccessful(String username, String password) {

    Login login = new Login();
    login.txtuser.setText(username);
    login.txtpass.setText(password);
    login.setVisible(true);
    login.jButton1.doClick();

    try {

        if (rs.next()) {
          doReturn(true).when(rs).next();
        }
      else if (rs != null){
        when(!rs.next()).thenReturn(false);
      }
    } catch (SQLException se) {
      se.printStackTrace();
      System.out.println("SQLException in LoginIT: loginTestSuccessful()");
    }
  }

  @Test
  @DisplayName("Calling Login.main")
  void testMain(){
    Login.main(new String[]{"arg1", "arg2", "arg3"});
  }
}
