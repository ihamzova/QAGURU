package pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponents;
import pages.components.ResultsComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            gender = $(byText("Male")),
            dateOfBirth = $("#dateOfBirthInput"),
            subject = $(byText("English")),
            subjectInput = $("#subjectsInput"),
            hobby = $(byText("Reading")),
            currentAddress = $("#currentAddress"),
            currentState = $("#state"),
            currentStateInput = $(byText("Haryana")),
            city = $("#city"),
            cityInput = $(byText("Karnal")),
            submit = $("#submit");


    CalenderComponents calenderComponents = new CalenderComponents();
    ResultsComponent resultsComponent = new ResultsComponent();

    public RegistrationFormPage open() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender() {
        gender.click();
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year, String day) {
        dateOfBirth.click();
        calenderComponents.setDate(month, year, day);
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value);
        subject.click();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        hobby.click();
        return this;
    }


    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        currentState.click();
        currentStateInput.click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        city.click();
        cityInput.click();
        return this;
    }

    public RegistrationFormPage submit() {
        submit.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsComponent.checkResult(key, value);

        return this;
    }
}

