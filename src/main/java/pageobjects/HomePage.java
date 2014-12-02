package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public static final String EXPECTED_TITLE = "Welcome";

    private final WebDriver driver;
    private static final By BY_TITLE = By.id("title");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){

        return driver.findElement(BY_TITLE).getText();
    }
}
