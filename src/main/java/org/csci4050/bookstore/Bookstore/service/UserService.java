package org.csci4050.bookstore.Bookstore.service;

import org.csci4050.bookstore.Bookstore.dao.UserDao;
import org.csci4050.bookstore.Bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(final UserDao userDao) {
        this.userDao = userDao;
    }

    public User registerUser(final User user) throws Exception {
        userDao.createUser(user);
        final Optional<User> retrieveUser = userDao.getUser(user.getUsername());
        if (retrieveUser.isPresent() && retrieveUser.get().equals(user)) {
            return retrieveUser.get();
        } else {
            throw new Exception();
        }
    }

    public Optional<User> getUser(final String username) {
        return userDao.getUser(username);
    }

}
