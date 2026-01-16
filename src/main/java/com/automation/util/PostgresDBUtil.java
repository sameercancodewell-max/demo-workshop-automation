package com.automation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDBUtil {
    private static final String URL = "jdbc:postgresql://<HOST>:<PORT>/<DBNAME>";
    private static final String USER = "<USERNAME>";
    private static final String PASSWORD = "<PASSWORD>";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }   

    public static boolean validateUserExists(String email) {
        String query = "SELECT COUNT(*) FROM users WHERE email = '" + email + "'";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
