package pl.coderslab.charity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.CharityApplication;
import pl.coderslab.charity.entity.User;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CharityApplication.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUsername() {
        //given
        String username= "adamKow@m.com";
        String notExistinUser = "no@.no.com";
        //when
        User user = userRepository.findByUsername(username);
        User nullUser = userRepository.findByUsername(notExistinUser);
        //then
        assertNotNull(user);
        assertNull(nullUser);
    }

    @Test
    public void findAllAdmins() {
    }

    @Test
    public void findAllUsers() {
    }
}