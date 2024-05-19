package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.cleanUsersTable();
        userService.saveUser("Илья", "Зубков", (byte)21);
        userService.saveUser("Илья", "Логуненок", (byte)20);
        userService.saveUser("Илья", "Варламов", (byte)37);
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
//        userService.removeUserById(2);

    }
}

