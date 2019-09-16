package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class ResetPassowrd {
    @Autowired
    UserRepository userRepository;

    public boolean checkIfMailExists(String username){
        if( userRepository.findByUsername(username).equals(null)){
            return false;
        }
        return true;
    }

    public void ResetPassword(String username, String password){
        User user = userRepository.findByUsername(username);
        user.setPassword(password);
    }


}
