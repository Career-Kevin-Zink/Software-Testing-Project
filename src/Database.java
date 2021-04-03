import java.sql.*;

public class Database {

    private static String dbFileLocation = "jdbc:mysql://localhost/airline";
    private static String username = "root";
    private static String password = "";
    public static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(dbFileLocation, username, password);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Could not find the Driver.");

            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return connection;
    }

    public static boolean isUsernameAvailable(String username) {
      boolean returnVal = false;

      try {
        Connection connection = getConnection();
        PreparedStatement pst = connection.prepareStatement("select * from user where username= ?");
        pst.setString(1, username);

        ResultSet rs = pst.executeQuery();

        if (!rs.next()) returnVal = true;

      } catch (SQLException e) {
        System.out.println("SQLException in isUsernameAvailable: " + e.getMessage());
      }

      return returnVal;
    }

    public static boolean doesCustomerExist(String customerId) {
        boolean returnVal = false;

        try {
            Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from customer where id= ?");
            pst.setString(1, customerId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException e) {
            System.out.println("SQLException in isUsernameAvailable: " + e.getMessage());
        }

        return returnVal;
    }

    public static boolean doesFlightExist(String flightId) {
        boolean returnVal = false;

        try {
            Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement("SELECT * FROM flight WHERE id = ?");
            pst.setString(1, flightId);


            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException e) {
            System.out.println("SQLException in doesFlightExist: " + e.getMessage());
            e.printStackTrace();
        }
        return returnVal;
    }
    
    public static boolean doesTicketExist(String ticketNo) {
        boolean returnVal = false;

        try {
            Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from ticket where id= ?");
            pst.setString(1, ticketNo);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) returnVal = true;

        } catch (SQLException e) {
            System.out.println("SQLException in doesTicketExist: " + e.getMessage());
        }

        return returnVal;
    }

}
