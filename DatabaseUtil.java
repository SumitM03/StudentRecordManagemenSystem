import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final String DB_URL ="jdbc:mysql://localhost:3306/academic_db";
    private static final String USERNAME = "YOUR_DB_USERNAME";
    private static final String PASSWORD = "YOUR_DB_PASSWORD";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println("Unable to connect to database");
            e.printStackTrace();
        }
        return connection;
    }
}
