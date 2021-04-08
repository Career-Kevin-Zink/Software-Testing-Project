import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginIntegrationTest {
  Login loginTestObject = new Login();
  Main mainTestObject = new Main();

  @Test
  @DisplayName("valid Login XT")
  public void validLoginTest() {
    String[] stubInfo = validLoginInputStub();
    loginTestObject.txtuser.setText(stubInfo[0]);
    loginTestObject.txtpass.setText(stubInfo[1]);
    loginTestObject.setVisible(true);
    loginTestObject.jButton1.doClick();
    loginTestObject.hide();
    mainTestObject.setVisible(true);
    //uncomment me if you want to see the main window longer
    /*    try {
          Thread.sleep(1500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }*/
  }

  public String[] validLoginInputStub() {
    String[] userPass = {"john", "123"};
    return userPass;
  }


}
