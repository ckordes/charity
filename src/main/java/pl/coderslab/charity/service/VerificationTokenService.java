package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.emailService.EmailServiceImpl;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.VerificationToken;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.VerificationTokenRepository;

import java.util.UUID;

@Service
public class VerificationTokenService {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    @Autowired
    EmailServiceImpl emailServiceImpl;
    @Autowired
    UserRepository userRepository;

    public void generateTokenForConfirmation(User user){
        //verificationtoken generation
        String token= UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken(token,user);
        verificationTokenRepository.save(verificationToken);
        //email sending
        String verificationiEmail ="http://localhost:8080/confirmRegistration?token="+token;
        String message = "Zarejestrowales sie w naszym serwisie. Aby potwierdzic rejestracje, kliknij w ponizszy link: \n";
        emailServiceImpl.sendSimpleMessage(user.getUsername(),"Link aktywacyjny potwierdzajacy rejestracje!",message+verificationiEmail);
    }

    public boolean verifyUserToken(String token){
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if (verificationToken == null){
            return false;
        }
        User user = verificationToken.getUser();
        user.setEnabled(1);
        userRepository.save(user);
        return true;
    }


}
