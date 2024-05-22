package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection;

    public UserDaoJDBCImpl() {
        Util db = new Util();
        this.connection = db.connectToDB("postgres", "postgres", "xwnFSgG6");
    }

    public void createUsersTable() {
        Statement statement;
        try {
            String query = "CREATE TABLE IF NOT EXISTS Users (" +
                    "Id SERIAL PRIMARY KEY, " +
                    "FirstName CHARACTER VARYING(50), " +
                    "LastName CHARACTER VARYING(50), " +
                    "Age INTEGER);";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void dropUsersTable() {
        Statement statement;
        try {
            String query = "DROP TABLE Users";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Statement statement;
        try {
            String query =  String.format(
                    "INSERT INTO Users (FirstName, LastName, Age)" +
                            "VALUES ('%s', '%s', %d);", name, lastName, age);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("User added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeUserById(long id) {
        Statement statement;
        try {
            String query =  String.format(
                    "DELETE FROM Users " +
                            "WHERE Id = %d;", id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("User with id " + id + " deleted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<User> getAllUsers() {
        Statement statement;
        ResultSet users;
        List<User> usersList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Users";
            statement = connection.createStatement();
            users = statement.executeQuery(query);

            while(users.next()) {
                usersList.add(new User(users.getString("FirstName"),
                        users.getString("LastName"),
                        users.getByte("Age")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usersList;
    }

    public void cleanUsersTable() {
        Statement statement;

        try {
            String query =  "DELETE FROM Users";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table is cleared");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
