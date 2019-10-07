package pl.coderslab.charity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.coderslab.charity.repository.CategoryRepositoryTest;
import pl.coderslab.charity.repository.DonationRepositoryTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({CharityApplicationTests.class,CategoryRepositoryTest.class, DonationRepositoryTest.class})
public class AllTests {
}
