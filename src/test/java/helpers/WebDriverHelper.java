package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class WebDriverHelper {

    private static final Logger LOG = LoggerFactory.getLogger(WebDriverHelper.class);
    private static final String HUB_URL = "http://192.168.1.30:4444/wd/hub";

    private static WebDriverHelper instance;
    private static WebDriver driver;
    private static Set<Class<? extends Object>> testClasses;

    // defeat instantiation
    protected WebDriverHelper(){}

    public static WebDriverHelper getInstance(){

        if(instance == null){
            instance = new WebDriverHelper();
            collectTests();
        }

        return instance;
    }

    public static WebDriver getWebDriver() throws MalformedURLException {

        if(driver == null){
            LOG.info("Starting new WebDriver instance");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("firefox");
            driver = new RemoteWebDriver(new URL(HUB_URL), capabilities);
        }

        return driver;
    }

    public static void collectTests(){

        Reflections reflections = new Reflections(
                new ConfigurationBuilder()
                        .setUrls(ClasspathHelper.forJavaClassPath())
        );
        Set<Class<?>> types = reflections.getTypesAnnotatedWith(Scannable.class);

        for(Class testClass: types){
            LOG.info("Found a test class: {}", testClass);
        }

        testClasses = types;
    }

    public static void removeTest(Class testClass){

        LOG.info("Removing test class, {}", testClass);

        if(testClasses.contains(testClass)){
            testClasses.remove(testClass);
        }

        if(testClasses.isEmpty()){
            shutDownDriver();
        }
    }

    private static void shutDownDriver(){
        LOG.info("Shutting down WebDriver instance");
        driver.close();
    }
}
