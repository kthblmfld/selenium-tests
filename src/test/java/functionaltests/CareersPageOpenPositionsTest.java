package functionaltests;

import helpers.Scannable;
import helpers.WebDriverHelper;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import pageobjects.CareersPage;

import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

@Scannable
public class CareersPageOpenPositionsTest {

    private CareersPage careersPage;

    @AfterClass
    public static void tearDown(){
        WebDriverHelper.getInstance().removeTest(CareersPageOpenPositionsTest.class);
    }

    @Before
    public void init() throws MalformedURLException {

        careersPage = new CareersPage(WebDriverHelper.getInstance().getWebDriver());
        careersPage.navigateToCareers();
    }

    @Test
    public void hiringForBusinessIntelligence(){

        assertThat(careersPage.getBusinessIntelligenceHeaderText()).isEqualTo(careersPage.EXPECTED_HEADER_BUSINESS_INTELLIGENCE);
    }

    @Test
    public void hiringForExecutiveManagement(){

        assertThat(careersPage.getExecutiveManagementHeaderText()).isEqualTo(careersPage.EXPECTED_SECTION_HEADER_EXECUTIVE_MANAGEMENT);
    }

    @Test
    public void hiringForGameDevelopment(){

        assertThat(careersPage.getGameDevelopmentHeaderText()).isEqualTo(careersPage.EXPECTED_SECTION_HEADER_GAME_DEVELOPMENT);
    }

    @Test
    public void hiringForGameProduction(){

        assertThat(careersPage.getGameProductionHeaderText()).isEqualTo(careersPage.EXPECTED_SECTION_HEADER_GAME_PRODUCTION);
    }
}
