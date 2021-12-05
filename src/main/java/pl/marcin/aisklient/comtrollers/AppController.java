package pl.marcin.aisklient.comtrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.marcin.aisklient.model.User;
import pl.marcin.aisklient.services.TrackService;
import pl.marcin.aisklient.services.UserService;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private TrackService trackService;


    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("tracks", trackService.getTracks());
        return "index";
    }

    @PostMapping("/indicated-place")
    public String getTestowy(@RequestParam String name, Model model) {
        model.addAttribute("tracks", trackService.getTracks(name));
        return "index";
    }



    @GetMapping("/register")
    public String showSingUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up-form";
    }

    @PostMapping("/register_process")
    public String showSingInForm(User user) {
        userService.addUser(user);
        return "sign-up-succes";
    }

    @GetMapping("/login")
    public String showLogInForm() {
        return "sign-in-form";
    }
}
