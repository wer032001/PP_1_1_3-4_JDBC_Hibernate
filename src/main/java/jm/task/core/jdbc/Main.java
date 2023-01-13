package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        Util.getConnection();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        userDaoHibernate.createUsersTable();

        userDaoHibernate.saveUser("Елена", "Иванова", (byte) 20);
        userDaoHibernate.saveUser("Павел", "Захаров", (byte) 25);
        userDaoHibernate.saveUser("Мария", "Польских", (byte) 31);
        userDaoHibernate.saveUser("Дмитрий", "Васильев", (byte) 38);

        List<User> allUsers = userDaoHibernate.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }

        userDaoHibernate.cleanUsersTable();

        userDaoHibernate.dropUsersTable();
    }
}
