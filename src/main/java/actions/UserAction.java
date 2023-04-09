package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.User;
import lombok.Getter;
import lombok.Setter;
import service.UserService;

import java.util.List;
import java.util.UUID;

public class UserAction extends ActionSupport {

    @Inject
    private UserService userService;

    @Getter
    @Setter
    private User user;

    @Getter
    private List<User> users;

    @Getter
    private UUID id;

    public String createUser() {
        userService.createUser(user);
        return SUCCESS;
    }

    public String getUser() {
        user = userService.getUser(id);
        if (user == null) {
            return ERROR;
        }
        return SUCCESS;
    }

    public String getAllUsers() {
       users = userService.getAllUsers();
       return SUCCESS;
    }

    public String updateUser() {
        user = userService.updateUser(user);
        return SUCCESS;
    }

    public String deleteUser() {
        userService.deleteUser(id);
        return SUCCESS;
    }
 }
