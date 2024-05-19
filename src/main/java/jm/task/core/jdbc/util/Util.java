package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    public Connection connectToDB(String dbName, String user, String password) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/" + dbName, user, password);
            if(connection != null) {
                System.out.println("Connection is established");
            } else {
                System.out.println("Connection is failed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
