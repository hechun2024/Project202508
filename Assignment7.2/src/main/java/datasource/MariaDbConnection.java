package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/currencydb"; // 故意写错可测试
    private static final String USER = "appuser";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("❌ Database connection failed: " + e.getMessage());
            throw e; // 交给上层处理
        }
    }
}
