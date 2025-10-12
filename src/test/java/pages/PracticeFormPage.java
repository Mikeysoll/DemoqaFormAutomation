package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper").$(byText("Select State")),
            cityInput = $("#stateCity-wrapper").$(byText("Select City")),
            submitForm = $("#submit"),
            closeModal = $("#closeLargeModal");

    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects);
        subjectsInput.pressEnter();

        return this;
    }

    public PracticeFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public PracticeFormPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public PracticeFormPage setAddress(String value) {
            addressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();

        return this;
    }

    public PracticeFormPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();

        return this;
    }

    public PracticeFormPage submitForm() {
        submitForm.click();

        return this;
    }

    public PracticeFormPage checkResult(String key, String value)   {
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));

        return this;
    }

    public PracticeFormPage closeModal() {
        closeModal.click();

        return this;
    }


}