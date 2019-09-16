package pl.coderslab.charity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private DonationRepository donationRepository;

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepository.findAll();
    }

    @ModelAttribute("donationsCount")
    public long donationsCount() {
        return donationRepository.donationCount();
    }

    @ModelAttribute("quaintityCount")
    public long quantityCount() {
        return donationRepository.quantityCount();
    }

    @ModelAttribute("institutionsCount")
    public long institutionsCount() {
        List<Institution> institutions = donationRepository.sumSupportedInstitutions();
        long institutionsCount = institutions.size();
        return institutionsCount;
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }


}