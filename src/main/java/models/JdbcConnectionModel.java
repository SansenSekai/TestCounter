package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionModel {
    private final static String URL = "jdbc:postgresql://dev.gracelogic.com:37402/test";
    private final static String USER = "test";
    private final static String PASSWORD = "test";

    private Connection connection;

    private static JdbcConnectionModel instance = new JdbcConnectionModel();

    private JdbcConnectionModel(){
        connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Connection is successful");
            }
        } catch (SQLException e) {
            System.err.println("Connection failed");
        } catch (ClassNotFoundException e) {
            System.err.println("DriverName exception");
        }
    }

    public static JdbcConnectionModel getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
