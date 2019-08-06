package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.*;
import pl.coderslab.charity.repository.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping ("/donation")
public class DonationController {
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DonationStatusRepository donationStatusRepository;

    @ModelAttribute("allCategories")
    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
    @ModelAttribute("allInstitutions")
    public List<Institution> allInstitutions(){
        return institutionRepository.findAll();
    }


    @GetMapping("/add")
    public String addDonation(Model model){
        Donation donation = new Donation();
        model.addAttribute("donation",donation);
        return "addDonation";
    }
    @PostMapping("/add")
    public String addDonation(@ModelAttribute Donation donation, Model model, HttpSession httpSession){
        DonationStatus donationStatus =  new DonationStatus();
        Optional<User> optionalUser = userRepository.findById((long)httpSession.getAttribute("loggedUserId"));
        User user = optionalUser.get();
        donationStatus.setUser(user);
        donationStatus.setPickedUp(false);
        donationStatusRepository.save(donationStatus);
        donationStatus = donationStatusRepository.findFirstByOrderByIdDesc();
        donation.setDonationStatus(donationStatus);
        donationRepository.save(donation);
        model.addAttribute("donation",donation);
        return "form-confirmation";
    }

    @RequestMapping("/")
    public String mainDonationPage(){
        return "donation";
    }

    @RequestMapping("/displayDonations")
    public String displayDonations(HttpSession httpSession, Model model){

        List<Donation> donationList = donationRepository.findAllMyDonations((long) httpSession.getAttribute("loggedUserId"));
        model.addAttribute("donationList",donationList);

        return "displayDonations";
    }

    @RequestMapping("/displayDonation/{id}")
    public String displayDonation(@PathVariable long id, Model model){
        Donation donation =donationRepository.findById(id);
        model.addAttribute("donation",donation);
        return "displayDonation";
    }


}
