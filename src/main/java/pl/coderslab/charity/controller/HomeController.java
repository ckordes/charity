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
    InstitutionRepository institutionRepository;
    @Autowired
    DonationRepository donationRepository;

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionRepository.findAll();
//        List<Institution> institutions = new ArrayList<>();
//        institutions.add(new Institution("test", "testdescription"));
//        institutions.add(new Institution("druga", "drugadescription"));
//        institutions.add(new Institution("trzecia", "drugadescription"));
//        institutions.add(new Institution("czwarta", "drugadescription"));
//        return institutions;
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


/*
Utwórz odpowiednią metodę w repozytorium.
Przekaż i wyświetl informacje.
>Wymagane do wyświetlanie danych w oznaczonym miejscu:
>https://drive.google.com/file/d/1USh8f4x0HQDUWcX5ZXLS8j32N7hPnpeC/view

Zastanów się w jaki sposób wyświetlić poprawnie wartość przy pomocy pętli **`c:foreach`**.

Zwróć uwagę na dwukolumnowy rozkład jaki został przygotowany przez grafika:

```
<li>
  <div class="col">
    <div class="title">Fundacja "Dla dzieci"</div>
    <div class="subtitle">Cel i misja: Pomoc osobom
            znajdującym się w trudnej sytuacji życiowej.</div>
  </div>
  <div class="col">
    <div class="title">Fundacja "Bez domu"</div>
    <div class="subtitle">Cel i misja: Pomoc dla osób
                 nieposiadających miejsca zamieszkania</div>
  </div>
</li>
```

Możesz wykorzystać zmienną pętli `varStatus`.


 */