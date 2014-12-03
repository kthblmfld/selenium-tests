package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage {

    private final WebDriver driver;

    private static final By BY_BODY_TAG = By.className("dd-page-careers");

    public CareersPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isCareersPage(){

        return driver.findElement(BY_BODY_TAG).isDisplayed();
    }
}
