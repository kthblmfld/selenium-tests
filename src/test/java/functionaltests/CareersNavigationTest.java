package functionaltests;

import helpers.Scannable;
import helpers.WebDriverHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pageobjects.CareersPage;
import pageobjects.HomePage;
import pageobjects.TeamPage;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

@Scannable
public class CareersNavigationTest{

    private HomePage homePage;

    @AfterClass
    public static void tearDown(){
        WebDriverHelper.getInstance().removeTest(CareersNavigationTest.class);
    }

    @Before
    public void init() throws MalformedURLException {

        homePage = new HomePage(WebDriverHelper.getInstance().getWebDriver());
    }

    @Test
    public void navigateToCareersPage(){

        TeamPage teamPage = homePage.clickTeamLink();
        CareersPage careersPage = teamPage.clickCareersButton();
        assertThat(careersPage.isCareersPage()).isTrue();
    }
}
