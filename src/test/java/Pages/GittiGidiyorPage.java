package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static Constants.Constants.*;

public class GittiGidiyorPage extends BasePage {


    public GittiGidiyorPage(WebDriver driver) {
        super(driver);
    }

    private static Logger logger = LogManager.getLogger(BasePage.class);

    public GittiGidiyorPage start() throws InterruptedException {   // Web sitesinin sayfa başlığı(PAGE_TITLE) kontrol edilir.
        logger.info("--Preparing starting conditions.--");
        closeCookies();
        Thread.sleep(3000);
        assertionPage(PAGE_TITLE);
        hoverElement(POP_UP);
        logger.info("--Starting conditions have been checked properly.--");
        return this;
    }

    public GittiGidiyorPage login() throws InterruptedException {    /* Üye girişi sayfasında olunduğu kontrol edilir.
    Üye girişi(USERNAME,PASSWORD) yapılır. */
        logger.info("--Signing in.--");
        Thread.sleep(3000);
        click(LOGIN);
        Thread.sleep(2000);
        assertionUrl(LOGIN_PAGE_CHECK);
        Thread.sleep(2000);
        findElement(USERNAME_FIELD);
        findElement(PASSWORD_FIELD);
        findElement(USERNAME_FIELD).clear();
        findElement(PASSWORD_FIELD).clear();
        sendKeys(USERNAME_FIELD,USERNAME);
        sendKeys(PASSWORD_FIELD,PASSWORD);
        click(LOGIN_BUTTON);
        Thread.sleep(3000);    // Statik bekleme süresi ekliyoruz ve işlemci 3 saniyeliğine boşa çıkartılır.
        logger.info("--Signed in successfully.--");
        return this;
    }

    public GittiGidiyorPage search() throws InterruptedException {  /* Arama kutusuna(SEARCH_BOX) Kolye kelimesi yazılır
         ve arama butonuna(SEARCH_BUTTON) tıklanır. Arama yapıldığı kontrol edilir. */
        logger.info(PRODUCT + "--the word 'Kolye' has been written in search box.--");
        findElement(SEARCH_BOX);
        sendKeys(SEARCH_BOX,PRODUCT);
        click(SEARCH_BUTTON);
        assertionUrl(SEARCH_PAGE_CHECK);
        Thread.sleep(3000);
        logger.info(PRODUCT + "--has been found.--");
        return this;
    }

    public GittiGidiyorPage searchBag() throws InterruptedException {    /* Arama kutusuna(SEARCH_BOX) ikinci arama olarak
    Çanta kelimesi yazılır ve arama butonuna(SEARCH_BUTTON) tıklanır. Arama yapıldığı kontrol edilir. */
        logger.info(PRODUCT2 + "--the word 'Çanta' has been written in search box.--");
        findElement(SEARCH_BOX);
        sendKeys(SEARCH_BOX,PRODUCT2);
        click(SEARCH_BUTTON);
        assertionUrl(SEARCH2_PAGE_CHECK);
        Thread.sleep(3000);
        logger.info(PRODUCT2 + "--has been found.--");
        return this;
    }


    public GittiGidiyorPage backToHomePage() throws InterruptedException {  /* Ana sayfaya geçmek için ana sayfa butonu(HOMEPAGE_BUTTON)
    bulunup tıklanır.
      Ana sayfaya ulaşıldığı (PAGE_TITLE) kullanılarak kontrol edilir. */
        logger.info("--Clicking to the home page button.--");
        findElement(HOMEPAGE_BUTTON);
        click(HOMEPAGE_BUTTON);
        assertionPage(PAGE_TITLE);
        Thread.sleep(3000);
        logger.info("--Moved into the home page successfully.--");
        return this;
    }


    public GittiGidiyorPage randomClick() throws InterruptedException {   // Ürün listesi içerisinden rastgele tıklama işlemi yapılır.
        logger.info("--Picking a product randomly.--");
        //scrollToElement();
        randomItemClick();
        Thread.sleep(5000);
        scrollToElement();
        logger.info("--Product has been picked randomly.--");
        return this;
    }

    public GittiGidiyorPage addToBasket() throws InterruptedException { /* 7. sıradaki çanta ürünü sepete eklenir.   */
        logger.info("--Adding seventh of bag products to the basket.--");
        click(PD_PICK);
        scrollToBag();
        findElement(ADD_TO_BASKET);
        click(ADD_TO_BASKET);
        Thread.sleep(5000);
        logger.info("--Product has been added to the basket.--");
        return this;
    }

    public GittiGidiyorPage goToBasket() throws InterruptedException { /* Sepete gidilir.
     Sepete gidildiği kontrol edilir. */
        logger.info("--Moving into the basket.--");
        click(GO_TO_BASKET);
        assertionUrl(BASKET_PAGE_CHECK);
        Thread.sleep(2000);
        logger.info("--Moved into the basket.--");
        return this;
    }

    public GittiGidiyorPage increaseQuantity() throws InterruptedException {  /* Adet arttırma butonuna(QUANTITY_INCREASE_BUTTON) tıklama işlemi yapılarak
        ürün adedi artırılır. */
        logger.info("--Increasing quantity.--");
        click(QUANTITY_INCREASE_BUTTON);
        Thread.sleep(2000);
        findElement(QUANTITY_INCREASE_CLICK);
        click(QUANTITY_INCREASE_CLICK);
        Thread.sleep(2000);
        click(PAYMENT);
        Thread.sleep(2000);
        logger.info("--Quantity has been increased.--");
        return this;
    }

    public GittiGidiyorPage saveButton() throws InterruptedException { // Kaydet butonuna tıklanır
        logger.info("--Clicking to save button and printing errors.--");
        Thread.sleep(3000);
        click(SAVE_BUTTON);
        Thread.sleep(3000);
        scrollToElement();
        getErrorText();
        click(EDIT_BASKET);
        Thread.sleep(3000);
        logger.info("--Save button has been clicked and errors has been printed.--");
        return this;
    }

    public GittiGidiyorPage addSecond() throws InterruptedException { /* Favorilerimden bir ürün seçilerek
     sepete eklenir. Ardından favorilerim sayfasına geçiş yapılır ve sayfaya gidildiği kontrol edilir. */
        logger.info("--Adding second product and moving to my favourite products list page.--");
        Thread.sleep(3000);
        click(ADD_SP);
        Thread.sleep(3000);
        getWebDriver().get("https://www.gittigidiyor.com/hesabim/izlediklerim");
        assertionUrl(FAV_PAGE_CHECK);
        Thread.sleep(3000);
        logger.info("--Second product has been added to bag and moved to my favourite products list page.--");
        return this;
    }


    public GittiGidiyorPage deleteFav() throws InterruptedException { /* Favoriler listesindeki 3. ürün silinir. */
        logger.info("--Clicking to third item in my favourite products list page.--");
        click(SELECT_FAV);
        Thread.sleep(3000);
        click(DELETE_FAV);
        Thread.sleep(3000);
        logger.info("--Third item in my favourite products list has been clicked and delete button has been clicked.--");
        return this;
    }

    public GittiGidiyorPage newTab() throws InterruptedException { // Yeni sekmede gittigidiyor anasayfası açılır.
        logger.info("--Opening gittigidiyor homepage in new tab.--");
        sendKeys(By.xpath("//a[@class='header-gg-logo robot-header-logoContainer-logo']"), Keys.chord(Keys.CONTROL,Keys.RETURN));
        Thread.sleep(3000);
        switchTab();
        Thread.sleep(3000);
        logger.info("--Gittigidiyor homepage has been opened in the new tab.--");
        return this;
    }

    public GittiGidiyorPage logOut() throws InterruptedException { /* Gittigidiyor sitesinden çıkış işlemi gerçekleştirilir.
     Ardından açılan yeni sekme kapatılır. */
        logger.info("--Clicking logout button.--");
        hoverElement(POP_UP);
        Thread.sleep(3000);
        findElement(LOG_OUT);
        click(LOG_OUT);
        Thread.sleep(3000);
        getWebDriver().close();
        Thread.sleep(3000);
        logger.info("--Logout button has been clicked.--");
        return this;
    }

}