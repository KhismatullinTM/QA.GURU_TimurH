import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    String userName = "Timur";
    String userLastName = "T";
    String email = "avito9196@yandex.ru";
    String phoneNumber = "9657895436";
    String invalidPhoneNumber = "965789543";
    String subjects = "Computer Science";
    String hobby = "Sports";
    String currentAddress = "1 Kremlevskaya Embankment, Moscow, Russian Federation";
    String userState = "Rajasthan";
    String userCity = "Jaipur";

    @BeforeEach
    void setUp (){
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void tearDown (){
        closeWebDriver();
    }

    @Test
    void validTest(){

        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=gender-radio-1][value=Male]").click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption("2000");
        $("[class=react-datepicker__month-select]").selectOption("January");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue(subjects);
        $(byText(subjects)).click();
        $(byText(hobby)).click();
        $("[id=uploadPicture]").uploadFromClasspath("Dubai.jpg");
        $("[id=currentAddress]").scrollTo().setValue(currentAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();
        $("[id=submit]").click();
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);

        // Проверки
        $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text(userName), text(userLastName));
        $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text(email));
        $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text("Male"));
        $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $("[class=table-responsive]").$(byText("Date of Birth")).parent().shouldHave(text("1 January,2000"));
        $("[class=table-responsive]").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $("[class=table-responsive]").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $("[class=table-responsive]").$(byText("Picture")).parent().shouldHave(text("Dubai.jpg"));
        $("[class=table-responsive]").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $("[class=table-responsive]").$(byText("State and City")).parent().shouldHave(text(userState), text(userCity));

    }

    @Test
    void TestWithRequiredFields (){
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=gender-radio-1][value=Male]").click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=submit]").scrollTo().click(); // У меня небольшая диагональ экрана. Хотя Станислав говорил, что это стрем, но пока что я альтернатив не изучил)
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);
    }

    @Test
    void TestWithoutPhoneNumber () {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=gender-radio-1][value=Male]").click();
        $("[id=submit]").scrollTo().click();
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void TestWithoutGender () {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=submit]").scrollTo().click();
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void TestWithInvalidPhone (){
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=gender-radio-1][value=Male]").click();
        $("[id=userNumber]").setValue(invalidPhoneNumber);
        $("[id=submit]").scrollTo().click(); // У меня небольшая диагональ экрана. Хотя Станислав говорил, что это стрем, но пока что я альтернатив не изучил)
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

}
