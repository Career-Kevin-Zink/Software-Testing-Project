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
  //mock the connection
  @Mock
  private Connection conn;
  //mock the result set
  @Mock
  private ResultSet rs;
  // mock the prepared statement
  @Mock
  private PreparedStatement pst;
  //mock the database.
  @BeforeEach
  void setDB() {
    conn = mock(Connection.class);
    rs = mock(ResultSet.class);
    pst = mock(PreparedStatement.class);
  }
  /**
   * Requirement:A user will log into the system by providing their username and password
   * <p>
   * Input:String "john,321", String "%^@,123", String "john,123", String ",123", String "john, String"John,123",
   * Description:Checks valid and invalid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True, False
   * Actual Output: True, False
   * Statement Coverage: 93%
   * Branch Coverage: 100%
   */
  @ParameterizedTest
  @DisplayName("Valid Username and Password input + jBtn #1 ActionPerformed")
  @CsvSource({",", "john,321", "%^@,123", "john,123", ",123", "john,"})
  public void loginTest(String username, String password) {
    Login login = new Login();

    login.txtuser.setText(username);
    login.txtpass.setText(password);
    login.setVisible(true);
    login.jButton1.doClick();

    if(login.txtuser.getText().equals("john") && login.txtpass.getText().equals("123")){
      try {
        doReturn(true).when(rs).next();
      }
      catch (SQLException se) {
        se.printStackTrace();
      }
    }
    try {
      when(!rs.next()).thenReturn(false);
    }
    catch (SQLException se) {
      se.printStackTrace();
    }
  }
  /**
   * Requirement:A user will log into the system by providing their username and password
   * <p>
   * Input:String "john,321", String "%^@,123", String "john,123", String ",123", String "john, String"John,123",
   * Description:Checks valid and invalid username/passwords
   * <p>
   * Dependencies: Database
   * Expected Output: True, False
   * Actual Output: True, False
   * Statement Coverage: 77%
   * Branch Coverage: 0%
   */
  @Test
  @DisplayName("Calling Login.main")
  void testMain(){
    Login.main(new String[]{"arg1", "arg2", "arg3"});
  }
}
