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
            investPromoCloseBtn = $(".closePopup--presentation");



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
}
