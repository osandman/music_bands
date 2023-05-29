package net.osandman.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbManager {
    private static Connection connection;
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASS_KEY = "db.pass";
    private static final String DRIVER_KEY = "db.driver";

    static {
        setDriver();
    }

    private static void setDriver() {
        try {
            Class.forName(PropertiesUtil.getValue(DRIVER_KEY));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        PropertiesUtil.getValue(URL_KEY),
                        PropertiesUtil.getValue(USER_KEY),
                        PropertiesUtil.getValue(PASS_KEY));
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
