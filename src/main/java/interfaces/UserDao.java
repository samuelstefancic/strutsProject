package interfaces;

import entity.User;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    void createUser(User user);
    User getUser(UUID id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(UUID id);
}
