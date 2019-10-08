package pl.coderslab.charity.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.CharityApplication;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CharityApplication.class)
//@EnableJpaRepositories(basePackages={"pl.coderslab.charity.repository"})
//@EntityScan(basePackages={"pl.coderslab.charity.entity"})
//@TestPropertySource("classpath:application.properties")
//@ContextConfiguration(classes = {UserRepository.class})
//@DataJpaTest
public class ResetPassowrdTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void checkIfMailExists() {
        //given
        String username= "adamKow@m.com";
        String notExistingUser = "no@.no.com";
        ResetPassowrd resetPassowrd = new ResetPassowrd();
        //when
        boolean result = resetPassowrd.checkIfMailExists(username) ;
        boolean falseResult = resetPassowrd.checkIfMailExists(notExistingUser);
        //then
        assertTrue(result);
        assertFalse(falseResult);

    }

    @Test
    public void resetPassword() {
    }
}