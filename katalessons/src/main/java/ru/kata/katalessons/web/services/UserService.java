package ru.kata.katalessons.web.services;


import ru.kata.katalessons.web.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public void saveUser(User user) throws SQLException;
    public List<User> listUsers();

    User getById(int id);

    void update(User user);

    void delete(int id);
}
