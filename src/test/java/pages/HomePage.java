package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;


public class HomePage extends Common {

    //    Header Elements
    private By headerText = By.cssSelector(".main__cont .heading-1");
    private By moreButton = By.cssSelector(".landingArrow");
    private By loginButton = By.cssSelector(".header__dashboardBtn");
    private By loginFormEmail = By.cssSelector("#login_form_email");
    private By loginFormPassword = By.cssSelector("#login_form_password");
    private By enter = By.cssSelector("#login_form_enter");

    //    first block elements
    private By firstTextBlock = By.cssSelector(".about.animate .heading-1");
    private By moreInfo = By.cssSelector(".about__cont .heading-2");
    private String moreInfoString = "Мы развиваем и внедряем высокотехнологичные продукты онлайн-кредитования,\n" + "предоставляя дружественный сервис европейского уровня.";
    private By newsTimeLine = By.cssSelector(".newsTimeline");
    private By newsButton = By.cssSelector(".btnNews a");
    private By newsMainHeading = By.cssSelector(".newsArchive__mainHeading");

    //    second block elements
    private By secondTextBlock = By.cssSelector(".projects__leftWrap .heading-1");
    private By creditPlusLink = By.cssSelector(".projects__asideRight span");

    //    third block elements
    private By benefits = By.cssSelector(".common__cont--benefit");
    private By benefitsHeading = By.cssSelector(".common__cont.common__cont--benefit .heading-1");

    //    fourth block elements
    private By mainPartner = By.cssSelector(".common__cont--partners .heading-1");
    private By partnerLink = By.cssSelector(".common--partners span.gr_link");

    //    fifth block elements
    private By forInvestors = By.cssSelector("section:nth-child(8) .common__cont .heading-1");
    private By learnMore = By.cssSelector(".btnTransparent--investors");

    //    sixth block elements
    private By teamExperience = By.cssSelector(".team div:nth-child(1) > div.heading-1");

    //    seventh block elements
    private By contactUs = By.cssSelector(".contacts__cont .heading-1");
    private By contact = By.cssSelector("#main_contact_form_name");
    private By phoneNumber = By.cssSelector("#main_contact_form_phone");
    private By email = By.cssSelector("#main_contact_form_email");
    private By comment = By.cssSelector("#main_contact_form_msg");

    //    footer elements
    private By footerHeading = By.cssSelector(".footer__heading");
    private By rules = By.cssSelector(".footer__files--firstBlock p:nth-child(1)");
    private By privacyPolicy = By.cssSelector(".footer__files--firstBlock p:nth-child(2)");
    private By certificateChanges = By.cssSelector(".footer__about div:nth-child(4) p:nth-child(1)");
    private By ecoFinCertificate = By.cssSelector(".footer__about div:nth-child(4) p:nth-child(2)");

    public void headerCheck() {
        baseUrl = "https://ecofinance.ru";
        startMaximized = true;
        /* choose one: e.g. chrome firefox ie */
        browser = "chrome";
        open("/");
        $(headerText).shouldBe(visible);
        $(headerText).shouldHave(text("Ecofinance — инновационная финансовая компания"));
        $(moreButton).click();
        moveToNextBlock(2000);
    }

    public void firstBlockCheck() {
        $(firstTextBlock).waitUntil(visible, 2000);
        $(firstTextBlock).shouldHave(text("Компания с философией Fintech"));
        $(moreInfo).shouldHave(text(moreInfoString));
        $(newsTimeLine).shouldBe(visible);
        $(newsButton).click();
        $(newsMainHeading).shouldBe(visible);
        back();
    }

    public void secondBlockCheck() {
        $(secondTextBlock).waitUntil(visible, 2000);
        $(secondTextBlock).shouldHave(text("Наши проекты"));
        $(creditPlusLink).click();
        pageValidationInNewTab("Онлайн займы, оформить срочно займ онлайн по всей России");
        $(secondTextBlock).waitUntil(visible, 2000);
    }

    public void thirdBlockCheck() {
        $(benefits).waitUntil(visible, 2000);
        $(benefitsHeading).shouldHave(text("Залог нашего успеха —\n" + "опыт и знания"));
    }

    public void fourthBlockCheck() {
        $(mainPartner).shouldHave(text("Стратегический партнёр"));
        $(partnerLink).click();
        pageValidationInNewTab("DYNINNO - Business Processes And IT Optimization | Outsourcing");
    }

    public void fifthBlockCheck() {
        $(forInvestors).shouldHave(text("Информация инвесторам"));
        $(learnMore).click();
        validationByTitle("Инвестиции в МФО - МФК Экофинанс, сделать вложение денег в микрофинансовые организации");
        back();
    }

    public void setInvestor() {
        investor.setNameSurname("Ozoliņš Janis");
        investor.setEmail("fakemail@gmail.com");
        investor.setPhoneNumber("+793512345678");
        investor.setMessage("random text");
        investor.setPassword("fakepassword");
    }

    public void sixthAndSeventhBlockCheck() {
        $(teamExperience).shouldHave(text("Синергия разностороннего опыта"));
        $(contactUs).waitUntil(visible, 2000);
        $(contact).sendKeys(investor.getNameSurname());
        $(phoneNumber).sendKeys(investor.getPhoneNumber());
        $(email).sendKeys(investor.getEmail());
        $(comment).sendKeys(investor.getMessage());
    }

    public void footerLinks() {
        $(footerHeading).isDisplayed();
        $(rules).waitUntil(visible, 2000).click();
        pageValidationInNewTabByLink("/ppds-01082018.pdf");
        $(privacyPolicy).waitUntil(visible, 2000).click();
        pageValidationInNewTabByLink("/privacy-policy.pdf");
        $(certificateChanges).waitUntil(visible, 2000).click();
        pageValidationInNewTabByLink("/izmenenie_k_svidetelstvu_ecofinance.pdf");
        $(ecoFinCertificate).waitUntil(visible, 2000).click();
        pageValidationInNewTabByLink("/svidetelstvo_na_tz_ecofinance.pdf");
    }

    public void login() {
        $(loginButton).click();
        $(loginFormEmail).sendKeys(investor.getEmail());
        $(loginFormPassword).sendKeys(investor.getEmail());
        $(enter).click();
    }
}
