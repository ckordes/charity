package pl.coderslab.charity.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.jws.WebParam;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    InstitutionRepository institutionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @ModelAttribute("allInstitutions")
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }

    @RequestMapping("/")
    public String homeAdmin() {
        return "admin";
    }

    @RequestMapping("/manageInstitutions")
    public String manageInstitutions() {
        return "manageInstitutions";
    }

    @GetMapping("/edit/{id}")
    public String editInstitution(@PathVariable long id, Model model) {
        Institution institution = institutionRepository.findById(id);
        model.addAttribute("institution", institution);
        return "editInstitution";
    }

    @PostMapping("/edit/{id}")
    public String editInstitution(@PathVariable long id, @ModelAttribute("institution") Institution institution) {
        institutionRepository.save(institution);
        return "redirect:../manageInstitutions";
    }

    @RequestMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable long id) {
        institutionRepository.deleteById(id);
        return "redirect:../manageInstitutions";
    }

    @GetMapping("/add")
    public String addInstitution(Model model) {
        Institution institution = new Institution();
        model.addAttribute("institution", institution);
        return "addInstitution";
    }

    @PostMapping("/add")
    public String AddInstitution(@ModelAttribute("institution") Institution institution) {
        institutionRepository.save(institution);
        return "redirect:manageInstitutions";
    }

    @RequestMapping("/manageAdmins")
    public String manageAdmins() {
        return "manageAdmins";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Model model) {
        List<User> usersAdmins = userRepository.findAllAdmins();
        List<User> usersNoAdmins = userRepository.findAllUsers();
        usersNoAdmins.removeAll(usersAdmins);
        model.addAttribute("usersNoAdmins", usersNoAdmins);
        return "addAdmin";
    }

    @RequestMapping("/addAdmin/{id}")
    public String addAdmin(@PathVariable long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;
        user = optionalUser.get();
        Set<Role> userRoles = user.getRoles();
        Role role = roleRepository.findByName("ADMIN");
        userRoles.add(role);
        userRepository.save(user);
        return "redirect:../manageAdmins";
    }

    @RequestMapping("/removeAdmin")
    public String removeAdmin(Model model) {
        List<User> usersAdmins = userRepository.findAllAdmins();
        model.addAttribute("usersAdmins", usersAdmins);
        return "removeAdmin";
    }

    @RequestMapping("/removeAdmin/{id}")
    public String removeAdmin(@PathVariable long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        Set<Role> userRoles = user.getRoles();
        Role role = roleRepository.findByName("ADMIN");
        userRoles.remove(role);
        userRepository.save(user);
        return "redirect:../manageAdmins";
    }

}
