package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class UserService {

    public boolean checkIfAdmin(User user, HttpSession httpSession){
        long userId = user.getId();
        long adminId = (long) httpSession.getAttribute("loggedUserId");
        if (userId == adminId){
            return true;
        }
        return false;
    }
}
