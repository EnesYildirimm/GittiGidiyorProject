package Test;

import Base.BasePage;
import Pages.GittiGidiyorPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class GittiGidiyorPageTest extends BaseTest {

    GittiGidiyorPage GittiGidiyorPage;
   private static Logger logger = LogManager.getLogger(GittiGidiyorPageTest.class);

    @Before
    public void before(){
        logger.info("--Starting Driver.--");
        GittiGidiyorPage = new GittiGidiyorPage(getWebDriver());
        logger.info("Driver has been started");
    }

    @Test
    public void testLogin() throws InterruptedException{
        logger.info("--Starting Project.--");

        GittiGidiyorPage.start().login().search().randomClick().backToHomePage().searchBag().addToBasket().goToBasket().increaseQuantity().saveButton().addSecond().deleteFav().newTab().logOut();
        logger.info("--Project has been started.--");
    }

    @After
    public void after(){
        logger.info("--Shutting Driver--");
        tearDown();
    }
}