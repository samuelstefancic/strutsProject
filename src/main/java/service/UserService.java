package service;

import com.opensymphony.xwork2.inject.Inject;
import dao.UserDao;
import entity.User;

import java.util.List;
import java.util.UUID;

public class UserService {

    @Inject
    private UserDao userDao;

    public void createUser(User user) {
       if (user == null || user.getId() == null) {
           throw new IllegalArgumentException("The user object is invalid for a creation");
       }
       userDao.createUser(user);
    }

    public User getUser(UUID id) {
        return userDao.getUser(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User updateUser(User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("Invalid user object for update");
        }
        User existUser = userDao.getUser(user.getId());
        if (existUser == null) {
            throw new IllegalArgumentException("User not foudn for update");
        }
        return userDao.updateUser(user);
    }

    public void deleteUser(UUID id) {
        userDao.deleteUser(id);
    }
}
