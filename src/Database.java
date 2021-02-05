import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

}
