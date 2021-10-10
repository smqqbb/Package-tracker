package smqb.packagetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import smqb.packagetracker.entity.UserEntity;
import smqb.packagetracker.repository.UserRepository;

@Controller
public class AppController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/sign_in")
    public String viewSignInPage() {
        return "sign_in";
    }

    @GetMapping("/sign_up")
    public String viewSignUpPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "sign_up";
    }

    @PostMapping("/process_sign_up")
    public String viewSignUpPage(UserEntity user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "success";
    }
}
