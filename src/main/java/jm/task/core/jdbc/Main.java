package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.cleanUsersTable();
        userService.saveUser("Кирилл", "Юртанов", (byte)21);
        userService.saveUser("Илья", "Зубков", (byte)22);
        userService.saveUser("Алексей", "Капущак", (byte)23);
        users = userService.getAllUsers();
        userService.dropUsersTable();

    }
}

