package com.javamentor;

import com.javamentor.dao.UserDaoHibernateImpl;
import com.javamentor.service.UserServiceImpl;
import com.javamentor.util.Util;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("lida", "bukina", (byte) 44);
        userService.saveUser("ivan", "lobutin", (byte) 56);
        userService.saveUser("petr", "tirchin", (byte) 23);
        userService.saveUser("bork", "genin", (byte) 79);
        System.out.println("After adding: \n" + userService.getAllUsers());
        userService.removeUserById(1);
        System.out.println("After removing id=1: \n" + userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println("After clearing table: \n" + userService.getAllUsers());
        userService.dropUsersTable();
    }
}
