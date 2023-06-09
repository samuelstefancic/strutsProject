package actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import entity.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.Action;
import service.UserService;

import java.util.List;
import java.util.UUID;
@Action
 @Getter
 @Setter
public class UserAction extends ActionSupport {

    private UserService userService;


    private User user;

    private List<User> users;

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
