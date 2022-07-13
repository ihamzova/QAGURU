package qaGuru.Tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationFormPage;

public class DemoQaTest extends TestBase {
    String name = "Alex";
    String surname = "Smirnov";
    String email = "a.smirnov@ya.ru";
    String mobile = "3243423987";
    String address = "NY, Manhatten st.2/1";
    String gender = "Male";
    String subject = "E";
    String state = "Haryana";
    String city = "Karnal";
    String date = "21";
    String month = "April";
    String year = "1992";
    String hobby = "Reading";

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Tag("demoQaTest")
    @Owner("Irina")
    @DisplayName("Test with ValueSourse")
    @ValueSource(strings = {"Anna", "Света"})
    @ParameterizedTest(name = "Заполнения формы регистрации студента с именем {0}")
    void demoQaTest(String testData) {
        registrationFormPage.open().
                setFirstName(testData).
                setLastName(surname).
                setGender(gender).
                setUserEmail(email).
                setUserNumber(mobile).
                setDateOfBirth(month, year, date).
                setSubject(subject).
                setHobby(hobby).
                setCurrentAddress(address).
                setState(state).
                setCity(city).
                submit().
                checkResult("Student Name", testData + " " + surname).
                checkResult("Student Email", email).
                checkResult("Gender", "Male").
                checkResult("Mobile", mobile).
                checkResult("Date of Birth", date + " " + month + "," + year).
                checkResult("Subjects", subject).
                checkResult("Hobbies", hobby).
                checkResult("Address", address).
                checkResult("State and City", state + " " + city);
    }
}

