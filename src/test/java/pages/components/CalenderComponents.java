package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalenderComponents {

    public void setDate(String dateBirthday) {
        String[] subStr;
        String delimeters = " ";
        subStr = dateBirthday.split(delimeters);
        $(".react-datepicker__month-select").selectOption(subStr[1]);
        $(".react-datepicker__year-select").selectOption(subStr[2]);
        $(".react-datepicker__day--0" + subStr[0] +
                ":not(.react-datepicker__day--outside-month)").click();
    }


}
