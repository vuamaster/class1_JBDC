package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/demo_jbdc";

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);

    }
}