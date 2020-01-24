import org.junit.Test;
import pages.HomePage;

public class EcofinanceTests {
    private HomePage homePage = new HomePage();

    @Test
    public void mainPageTests() {
        homePage.headerCheck();
        homePage.firstBlockCheck();
        homePage.secondBlockCheck();
        homePage.thirdBlockCheck();
        homePage.fourthBlockCheck();
        homePage.fifthBlockCheck();
        homePage.setInvestor();
        homePage.sixthAndSeventhBlockCheck();
        homePage.footerLinks();
        homePage.login();
    }
}
