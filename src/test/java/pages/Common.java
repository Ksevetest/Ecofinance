package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Common {

    String nameSurname = "Ozoliņš Janis";
    String phoneNumber = "+793512345678";
    String email = "fakemail@gmail.com";
    String message = "random text";
    String password = "fakepassword";

    public void openPage () {
        open("/");
    }

    public void pageValidationInNewTab(String title) {
        switchTo().window(1);
        assertThat(Selenide.title()).isEqualTo(title);
        closeWindow();
        switchTo().window(0);
    }

    public void pageValidationInNewTabByLink(String link) {
        switchTo().window(1);
        assertThat(getWebDriver().getCurrentUrl()).contains(link);
        closeWindow();
        switchTo().window(0);
    }
}