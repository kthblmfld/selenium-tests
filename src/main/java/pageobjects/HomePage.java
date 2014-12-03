package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static final String EXPECTED_TITLE = "DOUBLEDOWN INTERACTIVE";

    private final WebDriver driver;

    private static final String BASE_URL = "http://www.doubledowninteractive.com";

    private static final By BY_HEADER_LOGO = By.className("dd-header-logo");
    private static final By BY_PLAY_NOW_LINK = By.xpath("//*[@id=\"dd-header-nav\"]/li[6]/a");
    private static final By BY_TEAM_LINK = By.xpath("//*[@id=\"dd-header-nav\"]/li[2]/a");

    public HomePage(WebDriver driver){

        this.driver = driver;
        driver.get(BASE_URL);
    }

    public String getLogoText(){

        return driver.findElement(BY_HEADER_LOGO).getText();
    }

    public TeamPage clickTeamLink(){
        driver.findElement(BY_TEAM_LINK).click();
        return new TeamPage(driver);
    }

    /**
     * This opens the DoubleDownCasino site in a new tab
     * @return DoubleDownCasino home page
     */
    public HomePage clickGamesLink(){

        driver.findElement(BY_PLAY_NOW_LINK).click();
        return new HomePage(driver);
    }
}
