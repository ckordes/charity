package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.pojo.LoginMode;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.ValidationService;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ValidationService validationService;

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        String password2 ="";
        String error = "";
        model.addAttribute("user",user);
        model.addAttribute("password2",password2);
        model.addAttribute("error",error);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, @ModelAttribute ("password2") String password2, HttpSession httpSession){

        if (!user.getPassword().equals(password2)){
            return "register";
        }
        if (validationService.validateEmail(user.getUsername())){
            return "register";
        }
        String loggedUser = "USER";

        httpSession.setAttribute("loggedUser",loggedUser);
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        user.setEnabled(1);
        userRepository.save(user);
        return "redirect:/donation/";
    }

    @GetMapping("/login")
    public String login(Model model){
        LoginMode loginMode = new LoginMode();
        model.addAttribute("loginMode",loginMode);
        return "login";
    }

    @PostMapping ("/login")
    public String login(@ModelAttribute ("loginMode") LoginMode loginMode, HttpSession httpSession){
        if (validationService.validateUser(loginMode.getEmail(),loginMode.getPassword())){
            User user = userRepository.findByUsername(loginMode.getEmail());
            String loggedUser = "USER";
            for (Role role :user.getRoles()){
                if (role.getName().equals("ADMIN")) {
                    loggedUser = "ADMIN";
                    httpSession.setAttribute("loggedUser", loggedUser);
                    return "redirect:/admin/";
                }
            }

            httpSession.setAttribute("loggedUser", loggedUser);
            return "redirect:/donation/";
        }
        return "login";
    }


}
