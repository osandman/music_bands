package net.osandman.util;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class DbManager {
    private static final String URL_KEY = "db.url";
    private static final String USER_KEY = "db.user";
    private static final String PASS_KEY = "db.pass";
    private static final String DRIVER_KEY = "db.driver";
    private static final String CONN_POOL_SIZE_KEY = "db.pool.size";
    private static final int DEFAULT_POOL_SIZE = 5;
    private static BlockingQueue<Connection> connectionPool;
    private static Set<Connection> sourceConnections;

    static {
        setDriver();
        initConnectionPool();
    }

    private static void initConnectionPool() {
        var poolSize = PropertiesUtil.getValue(CONN_POOL_SIZE_KEY);
        int currentPoolSize = poolSize == null ? DEFAULT_POOL_SIZE : Integer.parseInt(poolSize);
        connectionPool = new ArrayBlockingQueue<>(currentPoolSize);
        sourceConnections = new HashSet<>(currentPoolSize);
        for (int i = 0; i < currentPoolSize; i++) {
            Connection connection = openConnection();
            connectionPool.add(getProxyConnection(connection));
            sourceConnections.add(connection);
        }
    }

    private static Connection getProxyConnection(Connection connection) {
        return (Connection) Proxy.newProxyInstance(DbManager.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> method.getName().equals("close")
                        ? connectionPool.add((Connection) proxy)
                        : method.invoke(connection, args));
    }

    public static Connection getConnection() {
        try {
            return connectionPool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closePool() {
        try {
            for (Connection sourceConnection : sourceConnections) {
                sourceConnection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection openConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getValue(URL_KEY),
                    PropertiesUtil.getValue(USER_KEY),
                    PropertiesUtil.getValue(PASS_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void setDriver() {
        try {
            Class.forName(PropertiesUtil.getValue(DRIVER_KEY));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
