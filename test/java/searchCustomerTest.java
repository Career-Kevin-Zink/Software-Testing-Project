import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class searchCustomerTest {

    /**
     * Requirement Description: The system shall allow users to search existing customers in the database.
     *
     * Input: String "CS010"
     *
     * Procedure: Check to see if the inputted string is located within the database. If it is not an exception will be
     * thrown.
     *
     * Expected Output: The test should fail.
     *
     * Branch Coverage: 100%
     *
     * Statement Coverage: 100%
     */
    @Test
    public void invalidCustomerID() throws Exception {
        if (Database.doesCustomerExist("CS010")) {
            System.out.println("Success");
        }
        else {
            throw new Exception("Customer ID does not exist.");
        }
    }
}