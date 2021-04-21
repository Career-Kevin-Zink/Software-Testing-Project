package integration;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import app.searchCustomer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class searchCustomerIT {

  @Mock
  searchCustomer searchCustomerMock;

  @Test
  @DisplayName("Verify successful search of customer")
  public void successfulSearch(){
    searchCustomerMock = mock(searchCustomer.class);
    //when().thenReturn();

  }

}
