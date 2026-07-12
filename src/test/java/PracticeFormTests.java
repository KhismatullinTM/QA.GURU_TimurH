import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void validTest(){

        open("/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id='genterWrapper']").$(byText(gender)).click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=dateOfBirthInput]").click();
        $("[class=react-datepicker__year-select]").selectOption("2000");
        $("[class=react-datepicker__month-select]").selectOption("January");
        $(".react-datepicker__day.react-datepicker__day--001").click();
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue(subjects).pressEnter();
        $("[id='hobbiesWrapper']").$(byText(hobby)).click();
        $("[id=uploadPicture]").uploadFromClasspath("Dubai.jpg");
        $("[id=currentAddress]").scrollTo().setValue(currentAddress);
        $("#react-select-3-input").setValue(userState).pressEnter();
        $("#react-select-4-input").setValue(userCity).pressEnter();
        $("[id=submit]").click();
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);

        // Проверки
        $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text(userName), text(userLastName));
        $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text(email));
        $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text(gender));
        $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $("[class=table-responsive]").$(byText("Date of Birth")).parent().shouldHave(text("1 January,2000"));
        $("[class=table-responsive]").$(byText("Subjects")).parent().shouldHave(text(subjects));
        $("[class=table-responsive]").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $("[class=table-responsive]").$(byText("Picture")).parent().shouldHave(text("Dubai.jpg"));
        $("[class=table-responsive]").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $("[class=table-responsive]").$(byText("State and City")).parent().shouldHave(text(userState), text(userCity));

    }

    @Test
    void testWithRequiredFields (){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id='genterWrapper']").$(byText(gender)).click();
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=submit]").scrollTo().click(); // У меня небольшая диагональ экрана. Хотя Станислав говорил, что это стрем, но пока что я альтернатив не изучил)
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);

        $("[class=table-responsive]").$(byText("Student Name")).parent().shouldHave(text(userName), text(userLastName));
        $("[class=table-responsive]").$(byText("Student Email")).parent().shouldHave(text(email));
        $("[class=table-responsive]").$(byText("Gender")).parent().shouldHave(text(gender));
        $("[class=table-responsive]").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
    }

    @Test
    void testWithoutPhoneNumber () {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id='genterWrapper']").$(byText(gender)).click();
        $("[id=submit]").scrollTo().click();
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void testWithoutGender () {
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(phoneNumber);
        $("[id=submit]").scrollTo().click();
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

    @Test
    void testWithInvalidPhone (){
        open("/automation-practice-form");
        $("[id=firstName]").setValue(userName);
        $("[id=lastName]").setValue(userLastName);
        $("[id=userEmail]").setValue(email);
        $("[id='genterWrapper']").$(byText(gender)).click();
        $("[id=userNumber]").setValue(invalidPhoneNumber);
        $("[id=submit]").scrollTo().click();
        $("[id=example-modal-sizes-title-lg]").shouldNotBe(visible);
    }

}
