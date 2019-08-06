package pl.coderslab.charity.controller;

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

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @ModelAttribute("allInstitutions")
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }
    @ModelAttribute("usersNoAdmins")
    public List<User> noAdmins(){
        List<User> usersAdmins = userRepository.findAllAdmins();
        List<User> usersNoAdmins = userRepository.findAllUsers();
        usersNoAdmins.removeAll(usersAdmins);
        return usersNoAdmins;
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
    public String addAdmin() {
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

    @GetMapping("/editAdmin/{id}")
    public String editAdmin(Model model,@PathVariable long id){
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        model.addAttribute("user",user);
        return "editAdmin";
    }
    @PostMapping("/editAdmin/{id}")
    public String editAdmin(@ModelAttribute ("user") User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        Set<Role> roles = optionalUser.get().getRoles();
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:../manageAdmins";
    }

    @RequestMapping("/manageUsers")
    public String manageUsers (){
        return "manageUsers";
    }

    @RequestMapping("/removeUser/{id}")
    public String removeUser(@PathVariable long id){
        Optional<User> optionalUser = userRepository.findById(id);
        userRepository.delete(optionalUser.get());
        return "redirect:../manageUsers";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable long id, Model model){
        Optional<User> optionalUser = userRepository.findById(id);
        model.addAttribute("user",optionalUser.get());
        return "editUser";
    }

    @PostMapping("/editUser/{id}")
    public String editUser(@ModelAttribute User user){
        Optional<User> optionalUser = userRepository.findById(user.getId());
        Set<Role> roles = optionalUser.get().getRoles();
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:../manageUsers";
    }

}
