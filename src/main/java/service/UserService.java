package service;

import dao.UserDaoImpl;
import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {


    private UserDaoImpl userDaoImpl;

    public void setUserDao(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public void createUser(User user) {
       if (user == null || user.getId() == null) {
           throw new IllegalArgumentException("The user object is invalid for a creation");
       }
       userDaoImpl.createUser(user);
    }

    public User getUser(UUID id) {
        return userDaoImpl.getUser(id);
    }

    public List<User> getAllUsers() {
        List<User> users = userDaoImpl.getAllUsers();
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public User updateUser(User user) {
        if (user == null || user.getId() == null) {
            throw new IllegalArgumentException("Invalid user object for update");
        }
        User existUser = userDaoImpl.getUser(user.getId());
        if (existUser == null) {
            throw new IllegalArgumentException("User not found for update");
        }
        return userDaoImpl.updateUser(user);
    }

    public void deleteUser(UUID id) {
        userDaoImpl.deleteUser(id);
    }
}
