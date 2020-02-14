import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;
import pages.HomePage;
import pages.InvestPage;

import static com.codeborne.selenide.Selenide.*;

public class EcofinanceTests {

    private HomePage homePage = new HomePage();
    private InvestPage investPage = new InvestPage();

    @Before
    public void setup() {
        Configuration.baseUrl = "https://ecofinance.ru";
//        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
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

    @Test
    public void investPageInputValidation(){
        investPage.contactUsInputValidation();
        investPage.getPresentationInputValidation();
    }

    @Test
    public void investPageLinkValidation(){
        investPage.reportLinksValidation();
    }
}
