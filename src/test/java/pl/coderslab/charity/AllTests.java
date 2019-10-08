package pl.coderslab.charity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.coderslab.charity.repository.CategoryRepositoryTest;
import pl.coderslab.charity.repository.DonationRepositoryTest;
import pl.coderslab.charity.repository.UserRepositoryTest;
import pl.coderslab.charity.service.ResetPassowrdTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CharityApplicationTests.class,CategoryRepositoryTest.class, DonationRepositoryTest.class,
         UserRepositoryTest.class,ResetPassowrdTest.class})
public class AllTests {
}
