import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;

public class EcofinanceTests {
    private HomePage homePage = new HomePage();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://ecofinance.ru";
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }

    @Test
    public void mainPageTests() {
        homePage.headerCheck();
        homePage.firstBlockCheck();
        homePage.secondBlockCheck();
        homePage.thirdBlockCheck();
        homePage.fourthBlockCheck();
        homePage.fifthBlockCheck();
        homePage.sixthAndSeventhBlockCheck();
        homePage.footerLinks();
        homePage.login();
    }
}
