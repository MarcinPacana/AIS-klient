package pl.marcin.aisklient.comtrollers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.marcin.aisklient.model.User;
import pl.marcin.aisklient.services.CustomUserDetails;
import pl.marcin.aisklient.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/panel")
    public String showUserPanel(Model model) {
        userService.getCurrentLoggedInUsser(model);
        model.addAttribute("model", model);
        return "user-panel2";
    }

    @GetMapping("/user/list_users")
    public String getAllUsers() {
        return "user-list";
    }
}
