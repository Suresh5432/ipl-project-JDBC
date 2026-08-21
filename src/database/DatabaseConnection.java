package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static final String URL="jdbc:postgresql://localhost:5432/ipl_data_jdbc";
    static final String USER="suresh";
    static final String PASSWORD="Sunny@1432";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
