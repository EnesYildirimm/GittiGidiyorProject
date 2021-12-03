package Constants;

import org.openqa.selenium.By;

public class Constants {

    public static String HOME_PAGE_LINK = "https://www.gittigidiyor.com/";
    public static String LOGIN_PAGE_CHECK = "https://www.gittigidiyor.com/uye-girisi?s=1";
    public static String PAGE_TITLE = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    public static String SEARCH_PAGE_CHECK = "https://www.gittigidiyor.com/kolye?k=Kolye&qm=1";
    public static String SEARCH2_PAGE_CHECK = "https://www.gittigidiyor.com/arama/?k=%C3%87anta";
    public static String BASKET_PAGE_CHECK = "https://www.gittigidiyor.com/sepetim";
    public static String FAV_PAGE_CHECK = "https://www.gittigidiyor.com/hesabim/izlediklerim";
    public static final By POP_UP = By.xpath("(//div[@class = 'gekhq4-8 iHquZr'])[1]");
    public static String USERNAME = "testiniumn11test@hotmail.com";
    public static String PASSWORD = "Testinium123";
    public static String PRODUCT = "Kolye";
    public static String PRODUCT2 = "Çanta";
    public static final By HOMEPAGE_BUTTON = By.xpath("//div[@class = 'sc-1o6eogh-1 drryHP']");
    public static final By LOGIN = By.xpath("//a[@data-cy='header-login-button']");
    public static final By USERNAME_FIELD = By.id("L-UserNameField");
    public static final By PASSWORD_FIELD = By.id("L-PasswordField");
    public static final By LOGIN_BUTTON = By.id("gg-login-enter");
    public static final By SEARCH_BOX = By.xpath("//input[@data-cy='header-search-input']");
    public static final By SEARCH_BUTTON = By.xpath("//button[@data-cy='search-find-button']");
    public static final By PD_PICK = By.xpath("(//div[@class='sc-533kbx-0 sc-1v2q8t1-0 iCRwxx ixSZpI sc-1n49x8z-12 bhlHZl'])[7]");
    public static final By ADD_TO_BASKET = By.xpath("//button[@id='add-to-basket']");
    public static final By GO_TO_BASKET = By.xpath("//a[@class = 'gg-ui-btn-default padding-none']");
    public static final By QUANTITY_INCREASE_BUTTON = By.xpath("//div[@class='gg-input gg-input-select ']");
    public static final By QUANTITY_INCREASE_CLICK = By.xpath("//option[@value='2']");
    public static final By PAYMENT = By.xpath("//input[@type = 'submit']");
    public static final By SAVE_BUTTON = By.xpath("//button[@value = 'Kaydet']");
    public static final By EDIT_BASKET = By.xpath("//a[@title='Sepeti Düzenle']");
    //public static final By ADD_SECOND_PRODUCT = By.xpath("(//a[@class = 'gg-ui-btn-default btn-add-to-basket'])[1]");
    public static final By ADD_SP = By.xpath("//*[@id=\"save-for-later-slider\"]/div/div/div/div/div/div/ul/li[6]/div/a[2]/span");
    public static final By SELECT_FAV = By.xpath("(//span[@class = 'checkmark'])[4]");
    public static final By DELETE_FAV = By.xpath("//button[@type = 'submit']");
    public static final By LOG_OUT = By.xpath("//a[@title='Çıkış']");
    //public static final By ERROR_MESSAGE1 = By.xpath("(//div[@class='gg-input-error-text gg-d-24'])[1]");
    //public static final By CLOSE_COOKIES = By.xpath("//a[@class'tyj39b-5 lfsBU']");

}