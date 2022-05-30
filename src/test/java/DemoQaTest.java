import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.nio.channels.Selector.open;

public class DemoQaTest {
    String name = "Alex";
    String surname = "Smirnov";
    String email = "a.smirnov@ya.ru";
    String mobile = "3243423987";
    String address = "NY, Manhatten st.2/1";

    @BeforeEach
    void init() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void demoQaTest() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(mobile);
        $(byText("Male")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1992")).scrollIntoView(true).click();
        $(byText("21")).click();
        $("#subjectsInput").setValue("E");
        $(byText("English")).click();
        $(byText("Reading")).click();
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();

        $(".modal-body").shouldHave(
                text("Alex Smirnov"),
                text("a.smirnov@ya.ru"),
                text("Male"),
                text("3243423987"),
                text("21 April,1992"),
                text("English"),
                text("Reading"),
                text("NY, Manhatten st.2/1"),
                text("Haryana Karnal"));


    }

}

