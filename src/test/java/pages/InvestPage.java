package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class InvestPage extends Common {

//          Contact Us elements
    private SelenideElement investContact_field = $("#invest_contact_form_name"),
            investPhoneNumber_field = $("#invest_contact_form_phone"),
            investEmail_field = $("#invest_contact_form_email"),
            investComment_field = $("#invest_contact_form_msg"),

//          getPresentation popup elements
            popUpContact_field = $("#get_presentation_form_name"),
            popUpPhoneNumber_field = $("#get_presentation_form_phone"),
            popUpEmail_field = $("#get_presentation_form_email"),
            popupCheckBox = $("#get_presentation_form_agreeToTerms-styler"),
            investPromoBtn = $(".investPromo__button--popup"),
            investPromoCloseBtn = $(".closePopup--presentation"),

//          reportLinks elements
            audit_2017 = $(".investFaq__doc--active div:nth-child(2) a:nth-child(1)"),
            report_2017 = $(".investFaq__doc--active div:nth-child(2) a:nth-child(2)"),
            reportForSeptember_2017 = $(".investFaq__doc--active div:nth-child(2) a:nth-child(3)"),
            audit_2018 = $(".investFaq__doc--active div:nth-child(3) a:nth-child(1)"),
            report_1_2018 = $(".investFaq__doc--active div:nth-child(3) a:nth-child(2)"),
            report_2_2018 = $(".investFaq__doc--active div:nth-child(3) a:nth-child(3)"),
            report_3_2018 = $(".investFaq__doc--active div:nth-child(3) a:nth-child(4)"),
            report_2018 = $(".investFaq__doc--active div:nth-child(3) a:nth-child(5)");


    public void contactUsInputValidation() {
        open("/invest");
        investContact_field.val(nameSurname);
        investPhoneNumber_field.val(phoneNumber);
        investEmail_field.val(email);
        investComment_field.val(message);
//        ToDo select option by index or value for time picker
    }

    public void getPresentationInputValidation() {
        investPromoBtn.click();
        popUpContact_field.val(nameSurname);
        popUpPhoneNumber_field.val(phoneNumber);
        popUpEmail_field.val(email);
        popupCheckBox.shouldBe(visible).click();
        investPromoCloseBtn.shouldBe(visible).click();
    }

    public void reportLinksValidation() {
        open("/invest");
        audit_2017.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Auditorskoe-zaklyuchenie-za-2017-god.pdf");
        report_2017.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Buhgalterskaya-otchetnost-za-2017-god.pdf");
        reportForSeptember_2017.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Buhgalterskaya-otchetnost-za-9-mesyatsev-2017.pdf");
        audit_2018.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Auditorskoe-zaklyuchenie-za-2018-god.pdf");
        report_1_2018.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Buhgalterskaya-otchetnost-za-1-kvartal_2018.pdf");
        report_2_2018.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Promezhutochnaya-otchetnost-za-1-polugodie_2018.pdf");
        report_3_2018.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Buhgalterskaya-otchetnost-za-9-mesyatsev_2018.pdf");
        report_2018.shouldBe(visible).click();
        pageValidationInNewTabByLink("/Buhgalterskaya-otchetnost-za-2018_god-2.pdf");
    }
    }
