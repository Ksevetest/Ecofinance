package pages;


import models.Investor;


import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Common {

    protected Investor investor = new Investor();

    public void moveToNextBlock(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validationByTitle(String title) {
        if (getWebDriver().getTitle().contains(title))
            //Pass
            System.out.println("# Page title contain expected text");
        else
            //Fail
            System.out.println("# Page title doesn't contain expected text");
    }

    public void pageValidationInNewTab(String title) {
        switchTo().window(1);
        if (getWebDriver().getTitle().contains(title))
            //Pass
            System.out.println("# Page title contain expected text");
        else
            //Fail
            System.out.println("# Page title doesn't contain expected text");
        closeWindow();
        switchTo().window(0);
    }

    public void pageValidationInNewTabByLink(String link) {
        switchTo().window(1);
        if (getWebDriver().getCurrentUrl().contains(link))
            //Pass
            System.out.println("# Page Link is correct");
        else
            //Fail
            System.out.println("# Page Link isn't correct");
        closeWindow();
        switchTo().window(0);
    }
}