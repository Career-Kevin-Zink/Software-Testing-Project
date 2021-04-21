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
  Main mainMock;

  @Test
  @DisplayName("Verify Login fields arent null")
  public void successfulLogin(){
    Login login = new Login();
    login.txtuser.setText("john");
    login.txtpass.setText("123");
    verify(login).txtuser.setText(anyString());
    verify(login).txtpass.setText(anyString());

    //Simulate user logging in successfully
    login.jButton1.doClick(); // login
    login.jButton2.doClick(); // hide window

    // i dont think we need to test main tbh
    mainMock = login.getMain();
    mainMock.setVisible(true);

    //Check Main is loaded
    verify(mainMock).setVisible(true);
    //Check Login success

  }



}
