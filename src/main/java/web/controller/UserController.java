package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.service.UserService;
import java.util.List;

@Controller
@Transactional
public class UserController {
    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public String getAll(Model model) {
        List<User> users = userServiceImpl.getAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/users-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/users-create")
    public String createUser(User user) {
        userServiceImpl.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String removeUser(@PathVariable("id") Integer id) {
        userServiceImpl.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String getUserById(@PathVariable("id") Integer id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userServiceImpl.updateUser(user);
        return "redirect:/users";
    }
}

