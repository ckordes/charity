package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class ValidationService {
    @Autowired
    UserRepository userRepository;

    public boolean validateEmail(String email){
        User user = userRepository.findByUsername(email);
        if (user!=null){
            return true;
        }
        return false;
    }

    public boolean validateUser(String email, String password){
        User user = userRepository.findByUsername(email);
        if (user!=null){
            if (user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
