package functionaltests;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalTest {

    private static final Logger LOG = LoggerFactory.getLogger(FunctionalTest.class);
    //private static final Config config = ConfigFactory.load();
    public static RemoteWebDriver driver;


    public FunctionalTest() {}

    @BeforeClass
    public static void createDriver() {
        LOG.debug("Instantiating new driver. ");
        driver = new ChromeDriver();
//        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void closeDriver() {
        LOG.debug("Closing driver.");
        driver.close();
    }
}
