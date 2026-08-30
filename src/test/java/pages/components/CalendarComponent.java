package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    //Elements
    SelenideElement yearOfBirth = $(".react-datepicker__year-select");
    SelenideElement monthOfBirth = $(".react-datepicker__month-select");

    //Actions
    public void selectDateOfBirth (String day, String month, String year) {
        yearOfBirth.selectOption(year);
        monthOfBirth.selectOption(month);
        String formattedDay = String.format("%03d", Integer.parseInt(day));
        $(".react-datepicker__day--" + formattedDay + ":not(.react-datepicker__day--outside-month)").click();
    }
}
