package Base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.time.Duration;
import java.util.*;

public class BasePage extends BaseTest{

    public static Logger logger = LogManager.getLogger(BasePage.class);

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void assertionPage(String text) {
        Assert.assertEquals(text, driver.getTitle());
        logger.info("--page has been checked--");
    }

    public void assertionUrl(String text) {
        Assert.assertEquals(text, driver.getCurrentUrl());
        logger.info("--url has been checked--");
    }

    public WebElement findElement(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void hoverElement(By by){
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public List<WebElement> findElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);
    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);
        logger.info(text + " has been written to the designated field.---");
    }

    public void switchTab(){
        String currentWindow = driver.getWindowHandle();
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String pencere : windowsHandles) {
            if (!currentWindow.equals(pencere)) {
                driver.switchTo().window(pencere);

            }
        }

    }


    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();

    }

    public void closeCookies(){
        driver.findElement(By.xpath("//a[@class='tyj39b-5 lfsBU']")).click();
    }


    public void scrollToElement(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", findElement(by));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(3200,4200)");
    }

    public void scrollToBag(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(0,500)");
    }
    public void getErrorText(){
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[1]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[2]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[3]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[4]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[5]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[6]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[7]")).getText());
        System.out.println(findElement(By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[8]")).getText());
    }

public BasePage randomItemClick(){
    List<WebElement> tumUrunler;
        try {
            tumUrunler  = driver.findElements(By.cssSelector("div[data-cy=\"product-favorite\"]"));
            JavascriptExecutor executor=(JavascriptExecutor)driver;
            Thread.sleep(1000);
            Random random = new Random();
            for(int i=0;i<4;i++){
                int rastgeleUrun  = random.nextInt(tumUrunler.size()-1);
                executor.executeScript("arguments[0].click();",tumUrunler.get(rastgeleUrun));
                tumUrunler.remove(rastgeleUrun);
            }

        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
return this;
    }
    public BasePage favouriteBasketAdd() throws InterruptedException {
        Thread.sleep(100);
        driver.findElement(By.xpath("//div[@class='']")).click();
        driver.findElement(By.xpath("//a[@title='Sepete Ekle']")).click();
        return this;
    }





}