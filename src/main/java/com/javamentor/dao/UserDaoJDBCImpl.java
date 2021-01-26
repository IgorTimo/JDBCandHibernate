package com.javamentor.dao;

import com.javamentor.model.User;
import com.javamentor.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao{

    public UserDaoJDBCImpl() {
    }

    @Override
    public void createUsersTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        String createTableSQL;
        try {
            createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45) NOT NULL, last_name VARCHAR(45) NOT NULL, age INT NOT NULL, PRIMARY KEY (id));";
            connection = Util.getConnection();
            statement = connection.prepareStatement(createTableSQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void dropUsersTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        String dropTableSQL;
        try {
            dropTableSQL = "DROP TABLE IF EXISTS users";
            connection = Util.getConnection();
            statement = connection.prepareStatement(dropTableSQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        PreparedStatement statement = null;
        String saveUserSQL;
        try {
            saveUserSQL = "INSERT INTO users (name, last_name, age) VALUES (?, ?, ?)";
            connection = Util.getConnection();
            statement = connection.prepareStatement(saveUserSQL);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String removeUserSQL;
        try {
            removeUserSQL = "DELETE FROM users WHERE id = ?;";
            connection = Util.getConnection();
            statement = connection.prepareStatement(removeUserSQL);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            String getAllUsersSQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(getAllUsersSQL);
            while (resultSet.next()) {
                long id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                byte age = (byte) resultSet.getInt("age");
                list.add(new User(name, lastName, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Connection connection = null;
        PreparedStatement statement = null;
        String cleanTableSQL;
        try {
            cleanTableSQL = "TRUNCATE TABLE users;";
            connection = Util.getConnection();
            statement = connection.prepareStatement(cleanTableSQL);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
