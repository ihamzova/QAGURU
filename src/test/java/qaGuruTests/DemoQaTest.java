package qaGuruTests;

import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Selenide.$;

public class DemoQaTest extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void demoQaTest() {

        registrationFormPage.open().
                setFirstName(testData.firstName).
                setLastName(testData.lastName).
                setGender(testData.gender).
                setUserEmail(testData.email).
                setUserNumber(testData.phone).
                setDateOfBirth(testData.dayofBirth).
                setSubject(testData.subject).
                setHobby(testData.hobby).
                setCurrentAddress(testData.address).
                setState(testData.state).
                setCity(testData.city).
                submit().
                checkResult("Student Name", testData.firstName + " " + testData.lastName).
                checkResult("Student Email", testData.email).
                checkResult("Gender", "Male").
                checkResult("Mobile", testData.phone).
                checkResult("Date of Birth", testData.dayofBirth).
                checkResult("Subjects", testData.subject).
                checkResult("Hobbies", testData.hobby).
                checkResult("Address", testData.address).
                checkResult("State and City", testData.state + " " + testData.city);


    }
}

