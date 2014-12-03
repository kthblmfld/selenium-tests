package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamPage {

    private final WebDriver driver;

    private static final By BY_BODY_TAG = By.className("dd-page-team");
    private static final By BY_CAREERS_BUTTON = By.xpath("/html/body/div[3]/div/div[2]/div/a");

    public TeamPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isTeamPage(){

        return driver.findElement(BY_BODY_TAG).isDisplayed();
    }

    public CareersPage clickCareersButton(){

        driver.findElement(BY_CAREERS_BUTTON).click();
        return new CareersPage(driver);
    }
}
