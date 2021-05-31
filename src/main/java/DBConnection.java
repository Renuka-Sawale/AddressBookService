import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBConnection {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/?user=root";
        String userName = "root";
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in classpath", e);
        }
        listDrivers();
        try {
            System.out.println("Connecting to database:"+jdbcURL);
            conn = DriverManager.getConnection(jdbcURL, userName, "Renuka@1994");
            System.out.println("Connection is successful" +conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listDrivers() {
        Enumeration<Driver> driverlist = DriverManager.getDrivers();
        while (driverlist.hasMoreElements()) {
            Driver driverClass = (Driver) driverlist.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}
