package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class HomePage extends Common {

    //      Header Elements
    private SelenideElement headerText = $(".main__cont .heading-1"),
            loginButton = $(".header__dashboardBtn"),
            loginFormEmail = $("#login_form_email"),
            loginFormPassword = $("#login_form_password"),
            enter = $("#login_form_enter"),
            closeLoginPopUp = $("#dashboard_popup .closePopup"),

    //      first block elements
            firstTextBlock = $(".about__cont .heading-1"),
            moreInfo = $(".about__cont .heading-2"),
            newsTimeLine = $(".newsTimeline"),
            newsButton = $(".btnNews a"),
            newsMainHeading = $(".newsArchive__mainHeading"),

    //      second block elements
            secondTextBlock = $(".projects__leftWrap .heading-1"),
            creditPlusLink = $(".projects__asideRight span"),

    //      third block elements
            benefitsHeading = $(".common__cont.common__cont--benefit .heading-1"),

    //      fourth block elements
            mainPartner = $(".common__cont--partners .heading-1"),
            partnerLink = $(".common--partners span.gr_link"),

    //      fifth block elements
            forInvestors = $("section:nth-child(8) .common__cont .heading-1"),
            learnMore = $(".btnTransparent--investors"),

    //      seventh block elements
            contactUs = $(".contacts__cont .heading-1"),
            contact_field = $("#main_contact_form_name"),
            phoneNumber_field = $("#main_contact_form_phone"),
            email_field = $("#main_contact_form_email"),
            comment_field = $("#main_contact_form_msg"),

    //      footer elements
            footerHeading = $(".footer__heading"),
            rules = $(".footer__files--firstBlock p:nth-child(1)"),
            privacyPolicy = $(".footer__files--firstBlock p:nth-child(2)"),
            certificateChanges = $(".footer__about div:nth-child(4) p:nth-child(1)"),
            ecoFinCertificate = $(".footer__about div:nth-child(4) p:nth-child(2)");

    public void textValidation() {
        headerText.shouldBe(visible).shouldHave(text("Ecofinance — инновационная финансовая компания"));
        firstTextBlock.shouldHave(text("Компания с философией Fintech"));
        moreInfo.shouldHave(text("Мы развиваем и внедряем высокотехнологичные продукты онлайн-кредитования,\n" + "предоставляя дружественный сервис европейского уровня."));
        secondTextBlock.shouldHave(text("Наши проекты"));
        benefitsHeading.shouldHave(text("Залог нашего успеха —\n" + "опыт и знания"));
        mainPartner.shouldHave(text("Стратегический партнёр"));
        forInvestors.shouldHave(text("Информация инвесторам"));
    }

    public void linkValidation() {
        newsTimeLine.shouldBe(visible);
        newsButton.click();
        newsMainHeading.shouldBe(visible);
        back();
        creditPlusLink.click();
        pageValidationInNewTab("Онлайн займы, оформить срочно займ онлайн по всей России");
        partnerLink.click();
        pageValidationInNewTab("DYNINNO - Business Processes And IT Optimization | Outsourcing");
        learnMore.click();
        assertThat(Selenide.title()).isEqualTo("Инвестиции в МФО - МФК Экофинанс, сделать вложение денег в микрофинансовые организации");
        back();
        footerHeading.shouldBe(visible);
        rules.shouldBe(visible).click();
        pageValidationInNewTabByLink("/ppds-01082018.pdf");
        privacyPolicy.shouldBe(visible).click();
        pageValidationInNewTabByLink("/privacy-policy.pdf");
        certificateChanges.shouldBe(visible).click();
        pageValidationInNewTabByLink("/izmenenie_k_svidetelstvu_ecofinance.pdf");
        ecoFinCertificate.shouldBe(visible).click();
        pageValidationInNewTabByLink("/svidetelstvo_na_tz_ecofinance.pdf");
    }

    public void inputValidation() {
        contactUs.shouldBe(visible);
        contact_field.val(nameSurname);
        phoneNumber_field.val(phoneNumber);
        email_field.val(email);
        comment_field.val(message);
    }


    public void login() {
        loginButton.click();
        loginFormEmail.val(email);
        loginFormPassword.val(password);
        enter.click();
        closeLoginPopUp.click();
    }
}
