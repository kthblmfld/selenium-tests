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
    public void hiringForSomethingElse(){

        assertThat(careersPage.getGameDevelopmentHeaderText()).isNotEmpty();
    }

    @Test
    public void hiringForGameProduction(){

        assertThat(careersPage.getGameProductionHeaderText()).isEqualTo(careersPage.EXPECTED_SECTION_HEADER_GAME_PRODUCTION);
    }
}
