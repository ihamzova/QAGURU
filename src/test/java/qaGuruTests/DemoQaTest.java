package qaGuruTests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

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
                setDateOfBirth(testData.birthMonth,testData.birthYear, testData.birthDay).
                setSubject(testData.subject).
                setHobby(testData.hobby).
                setCurrentAddress(testData.address).
                setState(testData.state).
                setCity(testData.city).
                submit().
                checkResult("Student Name", testData.firstName + " " + testData.lastName).
                checkResult("Student Email", testData.email).
                checkResult("Gender", testData.gender).
                checkResult("Mobile", testData.phone).
                checkResult("Date of Birth", testData.birthDate).
                checkResult("Subjects", testData.subject).
                checkResult("Hobbies", testData.hobby).
                checkResult("Address", testData.address).
                checkResult("State and City", testData.state + " " + testData.city);


    }
}

