package functionaltests;

import org.junit.Before;
import org.junit.Test;
import pageobjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeTests extends FunctionalTest{

    private HomePage homePage;

    @Before
    public void setUp(){

        driver.get("192.168.1.55:49158");
        homePage = new HomePage(driver);
    }

    @Test
    public void homePageTitle(){

        assertThat(homePage.getTitle()).isEqualTo(homePage.EXPECTED_TITLE);
    }
}
