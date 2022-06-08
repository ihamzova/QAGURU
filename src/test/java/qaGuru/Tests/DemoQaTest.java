package qaGuru.Tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

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

    @Test
    void demoQaTest() {

        registrationFormPage.open().
                setFirstName(name).
                setLastName(surname).
                setGender().
                setUserEmail(email).
                setUserNumber(mobile).
                setDateOfBirth(month, year, date).
                setSubject(subject).
                setHobby(hobby).
                setCurrentAddress(address).
                setState(state).
                setCity(city).
                submit().
                checkResult("Student Name", name + " " + surname).
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

