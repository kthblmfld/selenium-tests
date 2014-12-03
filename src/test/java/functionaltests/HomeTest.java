package functionaltests;

import helpers.Scannable;
import helpers.WebDriverHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.TeamPage;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

@Scannable
public class HomeTest {

    private HomePage homePage;

    @AfterClass
    public static void tearDown(){
        WebDriverHelper.getInstance().removeTest(HomeTest.class);
    }

    @Before
    public void init() throws MalformedURLException {

        homePage = new HomePage(WebDriverHelper.getInstance().getWebDriver());
    }

    @Test
    public void homePageTitle(){

        assertThat(homePage.getLogoText()).isEqualTo(homePage.EXPECTED_TITLE);
    }

    @Test
        public void goToTeamPage(){

        TeamPage teamPage = homePage.clickTeamLink();
        assertThat(teamPage.isTeamPage()).isTrue();
    }
}
