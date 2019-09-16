package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.emailService.EmailServiceImpl;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.pojo.LoginMode;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.service.ValidationService;
import pl.coderslab.charity.service.VerificationTokenService;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ValidationService validationService;
    @Autowired
    private EmailServiceImpl emailServiceImpl;
    @Autowired
    private VerificationTokenService verificationTokenService;

    @GetMapping("/register")
    public String register(Model model) {
        User user = new User();
        String password2 = "";
        String error = "";
        model.addAttribute("user", user);
        model.addAttribute("password2", password2);
        model.addAttribute("error", error);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user, @ModelAttribute("password2") String password2, HttpSession httpSession) {

        if (!user.getPassword().equals(password2)) {
            return "register";
        }
        if (validationService.validateEmail(user.getUsername())) {
            return "register";
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        user.setEnabled(0);
        userRepository.save(user);
        verificationTokenService.generateTokenForConfirmation(user);
        return "redirect:/donation/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginMode loginMode = new LoginMode();
        model.addAttribute("loginMode", loginMode);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginMode") LoginMode loginMode, HttpSession httpSession) {
        if (validationService.validateUser(loginMode.getEmail(), loginMode.getPassword())) {
            User user = userRepository.findByUsername(loginMode.getEmail());
            if (user.getEnabled() == 1) {
                httpSession.setAttribute("loggedUserId", user.getId());
                String loggedUser = "USER";
                for (Role role : user.getRoles()) {
                    if (role.getName().equals("ADMIN")) {
                        loggedUser = "ADMIN";
                        httpSession.setAttribute("loggedUser", loggedUser);
                        return "redirect:/admin/";
                    }
                }
                httpSession.setAttribute("loggedUser", loggedUser);
                return "redirect:/donation/";
            } else {
                return "userNotActive";
            }
        }
        return "login";
    }

    @GetMapping("/editUser")
    public String editUser(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedUserId") != null) {
            Optional<User> optionalUser = userRepository.findById((long) httpSession.getAttribute("loggedUserId"));
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "editUser";
        }
        return "redirect:login";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        Set<Role> roles = optionalUser.get().getRoles();
        user.setRoles(roles);
        return "redirect:/donation/";
    }

    @RequestMapping("/displayUser")
    public String displayUser(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("loggedUserId") != null) {
            Optional<User> optionalUser = userRepository.findById((long) httpSession.getAttribute("loggedUserId"));
            model.addAttribute("user", optionalUser.get());
            return "displayUser";
        }
        return "redirect:login";
    }

    @RequestMapping("/confirmRegistration")
    public String confirmRegistration(@RequestParam(name = "token") String token) {
        if (verificationTokenService.verifyUserToken(token)) {
            return "redirect:/login";
        }
        return "incorrectToken";
    }

    @RequestMapping("/loggedOut")
    public String loggedOut(HttpSession httpSession) {
        httpSession.removeAttribute("loggedUserId");
        httpSession.removeAttribute("loggedUser");
        return "redirect:/";
    }

    @GetMapping("/resetPasswordSendEmail")
    public String resetPasswordSendEmail(Model model) {
        String email = "";
        model.addAttribute("email", email);
        return "resetPasswordSendEmail";
    }

    @PostMapping("/resetPasswordSendEmail")
    public String resetPasswordSendEmail(@ModelAttribute("email") String email) {
        if (validationService.validateEmail(email)) {
            User user = userRepository.findByUsername(email);
            verificationTokenService.generateTokenForResetPassword(user);
            return "redirect:/";
        }
        return "wrongEmail";
    }

    @GetMapping("/resetPassword")
    public String resetPassword(Model model, HttpSession httpSession,@RequestParam (name="token") String token) {
        String email = verificationTokenService.verifyUserTokenReset(token);
        if (email.equals("")){
            return "incorrectToken";
        }
        httpSession.setAttribute("email",email);
        String password = "";
        String password2 = "";
        model.addAttribute("password",password);
        model.addAttribute("password2",password);
        return "resetPassword";
    }
    @PostMapping("/resetPassword")
    public String resetPassword(@ModelAttribute ("password") String password,
                                @ModelAttribute ("password2")String password2,
                                HttpSession httpSession) {
        if (!password.equals(password2)){
            return "resetPassword";
        }
        User user = userRepository.findByUsername((String) httpSession.getAttribute("email"));
        user.setPassword(password);
        userRepository.save(user);
        User testUser = userRepository.findByUsername((String) httpSession.getAttribute("email"));
        return "redirect:login";
    }
}

/*
(@RequestParam(name = "token") String token) {
        if (verificationTokenService.verifyUserToken(token)) {
            return "redirect:/login";
        }
        return "incorrectToken";
    }
 */