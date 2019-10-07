package pl.coderslab.charity.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.charity.CharityApplication;
import pl.coderslab.charity.entity.Category;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CharityApplication.class)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    public void shouldGetCategories() {
        //given
        int expectedCategoriesCount = 3;
        //when
        List<Category> categoryList = categoryRepository.findAll();
        //then
        assertEquals(expectedCategoriesCount, categoryList.size());
    }

    @Test
    public void shouldGetCategoryById(){
        //given
        int givenId = 1;
        String givenName = "zabawki";
        //when
        Category category = categoryRepository.findById(1);
        //then
        assertEquals(givenName, category.getName());
    }

}
