package integration;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import app.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginIT {
  @Mock
  Login loginMock = mock(Login.class);

  @Test
  @DisplayName("Verify Login fields arent null")
  public void successfulLogin(){
    when(loginMock.login(anyString(),anyString())).thenReturn(anyString(), anyString());

    loginMock.login("user", "pass");

    verify(loginMock).login(notNull(),notNull());
  }

}
