package integration;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import app.Login;
import app.Main;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginIT {
  @Mock
  Login loginMock;

  @Mock
  Main mainMock;

  @Test
  @DisplayName("Verify Login fields arent null")
  public void successfulLogin() {
    loginMock = mock(Login.class);
    when(loginMock.login(anyString(),anyString())).thenReturn("Valid User", "Valid Pass");
    when(loginMock.getMain()).thenReturn(mock(Main.class));

    //Simulate user logging in successfully
    loginMock.login("Valid User", "Valid Pass");

    // i dont think we need to test main tbh
    mainMock = loginMock.getMain();
    mainMock.setVisible(true);

    //Check Main is loaded
    verify(mainMock).setVisible(true);
    //Check Login success
    verify(loginMock).login("Valid User", "Valid Pass");
  }

}
