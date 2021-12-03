package Base;

import Constants.Constants;
import Constants.Constants.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        chromeOptions.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(chromeOptions));
        driver.get("https://www.gittigidiyor.com/");
        //getWebDriver().navigate().to(Constants.HOME_PAGE_LINK);
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static WebDriver getWebDriver() {

        return driver;
    }

    public static void setWebDriver(WebDriver driver) {
        BaseTest.driver = driver;
    }

    public void tearDown(){

       getWebDriver().quit();
    }

}