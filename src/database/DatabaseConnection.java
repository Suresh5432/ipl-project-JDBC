package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String URL="jdbc:postgresql://localhost:5432/ipl_data_jdbc";
    static final String USER="suresh";
    static final String PASSWORD=requireEnvironmentVariable("IPL_DB_PASSWORD");
    private DatabaseConnection(){}
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    private static String requireEnvironmentVariable(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Required environment variable is missing: " + name
            );
        }
        return value;
    }
}
