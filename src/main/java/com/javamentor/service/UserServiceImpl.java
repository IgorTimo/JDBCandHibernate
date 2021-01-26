package com.javamentor.service;

import com.javamentor.dao.UserDaoHibernateImpl;
import com.javamentor.dao.UserDaoJDBCImpl;
import com.javamentor.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl dao = new UserDaoJDBCImpl();
//    UserDaoHibernateImpl dao = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() {
        dao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        dao.saveUser(name, lastName, age);
        System.out.println("Log: User with name " + name + " added to table Users.");
    }

    @Override
    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        dao.cleanUsersTable();
    }
}
