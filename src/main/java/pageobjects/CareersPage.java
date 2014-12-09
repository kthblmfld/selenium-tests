package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {

    public static final String EXPECTED_HEADER_BUSINESS_INTELLIGENCE = "BUSINESS INTELLIGENCE";
    public static final String EXPECTED_SECTION_HEADER_GAME_PRODUCTION = "GAME PRODUCTION";

    private static final String URL_CAREERS = "http://www.doubledowninteractive.com/careers";
    private final WebDriver driver;

    private static final By BY_BODY_TAG = By.className("dd-page-careers");
    private static final By BY_OPEN_POSITIONS_BUTTON = By.cssSelector("#dd-careers-page-scroll-trigger");
    private static final By BY_BUSINESS_INTELLIGENCE = By.xpath("//*[@id=\"jvform\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[1]/td");
    private static final By BY_EXECUTIVE_MANAGEMENT = By.xpath("//*[@id=\"jvform\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[5]/td");
    private static final By BY_GAME_DEVELOPMENT = By.xpath("//*[@id=\"jvform\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[7]/td");
    private static final By BY_GAME_PRODUCTION = By.xpath("//*[@id=\"jvform\"]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[11]/td");


    public CareersPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Short-circuit navigation to page under test. If the url is directly addressable,
     * then we're wasting time walking to it from the home page.
     */
    public void navigateToCareers(){

        driver.get(URL_CAREERS);
        clickOpenPositions();

        driver.switchTo().frame(driver.findElement(By.id("jobviteframe")));
    }

    public boolean isCareersPage(){

        return driver.findElement(BY_BODY_TAG).isDisplayed();
    }

    public void clickOpenPositions(){

        driver.findElement(BY_OPEN_POSITIONS_BUTTON).click();
    }

    public String getBusinessIntelligenceHeaderText() {

        return driver.findElement(BY_BUSINESS_INTELLIGENCE).getText();
    }

    public String getExecutiveManagementHeaderText() {

        return driver.findElement(BY_EXECUTIVE_MANAGEMENT).getText();
    }

    public String getGameDevelopmentHeaderText() {

        return driver.findElement(BY_GAME_DEVELOPMENT).getText();
    }

    public String getGameProductionHeaderText() {
        return EXPECTED_SECTION_HEADER_GAME_PRODUCTION;
    }
}
