package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getConnection();
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("Елена", "Иванова", (byte) 20);
        userDao.saveUser("Павел", "Захаров", (byte) 25);
        userDao.saveUser("Мария", "Польских", (byte) 31);
        userDao.saveUser("Дмитрий", "Васильев", (byte) 38);

        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
