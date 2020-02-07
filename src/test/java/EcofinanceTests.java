import com.codeborne.selenide.Configuration;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class EcofinanceTests {

    private HomePage homePage = new HomePage();

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://ecofinance.ru";
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        open("/");
    }

    @Test
    public void mainPageTextValidation() {
        homePage.textValidation();
    }

    @Test
    public void mainPageLinkValidation() {
        homePage.linkValidation();
    }

    @Test
    public void mainPageInputValidation() {
        homePage.inputValidation();
        homePage.login();
    }

}
