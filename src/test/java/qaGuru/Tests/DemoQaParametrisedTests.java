package qaGuru.Tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationFormPage;

public class DemoQaParametrisedTests extends TestBase {
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

    @DisplayName("Test with ValueSourse")
    @ValueSource(strings = {"Anna", "Света"})
    @ParameterizedTest(name = "Заполнения формы регистрации студента с именем {0}")
    void demoQaTestWithValueSourse(String testData) {
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


    @DisplayName("Test with CsvSource")
    @CsvSource(value = {
            "Anna, Smirnova,air@gmail.com",
            "Ирина,Смирнова,ihsf@yandex.ru",
    })
    @ParameterizedTest(name = "Заполнения формы регистрации студента с именем {0} отображается фамилия {1} и почта {2}")
    void demoQaTestWithCsv(String testData1, String testData2, String testData3) {
        registrationFormPage.open().
                setFirstName(testData1).
                setLastName(testData2).
                setGender(gender).
                setUserEmail(testData3).
                setUserNumber(mobile).
                setDateOfBirth(month, year, date).
                setSubject(subject).
                setHobby(hobby).
                setCurrentAddress(address).
                setState(state).
                setCity(city).
                submit().
                checkResult("Student Name", testData1 + " " + testData2).
                checkResult("Student Email", testData3).
                checkResult("Gender", gender).
                checkResult("Mobile", mobile).
                checkResult("Date of Birth", date + " " + month + "," + year).
                checkResult("Subjects", subject).
                checkResult("Hobbies", hobby).
                checkResult("Address", address).
                checkResult("State and City", state + " " + city);
    }
    @DisplayName("Test with Enum")
    @EnumSource(Sex.class)
    @ParameterizedTest(name = "Заполнения формы регистрации студента с именем {0}")
    void demoQaTestWithEnum(Sex sex) {
        registrationFormPage.open().
                setFirstName(name).
                setLastName(surname).
                setGender(sex.desc).
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
                checkResult("Gender", sex.desc).
                checkResult("Mobile", mobile).
                checkResult("Date of Birth", date + " " + month + "," + year).
                checkResult("Subjects", subject).
                checkResult("Hobbies", hobby).
                checkResult("Address", address).
                checkResult("State and City", state + " " + city);
    }
}
