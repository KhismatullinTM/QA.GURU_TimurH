/*
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    @Test
    void firstUserPositiveTest(){
        open("/text-box");
        $("#userName").setValue(fullUserName);
        $("#userEmail").setValue(email);
        $("textarea#currentAddress").setValue(currentAddress);
        $("#submit").click();
        $("#name").shouldHave(text(fullUserName));
        $("#email").shouldHave(text(email));
        $("p#currentAddress").shouldHave(text(currentAddress));
    }

    @Test
    void secondUserPositiveTest(){
        open("/text-box");
        $("#userName").setValue(secondFullUserName);
        $("#userEmail").setValue(secondEmail);
        $("textarea#currentAddress").setValue(secondCurrentAddress);
        $("#submit").click();
        $("#name").shouldHave(text(secondFullUserName));
        $("#email").shouldHave(text(secondEmail));
        $("p#currentAddress").shouldHave(text(secondCurrentAddress));
    }

    @Test
    void minimalFieldsPositiveTest(){
        open("/text-box");
        $("#userName").setValue(fullUserName);
        $("#submit").click();
        $("#name").shouldHave(text(fullUserName));
    }

    @Test
    void secondUserNegativeTest(){
        open("/text-box");
        $("#userName").setValue(secondFullUserName);
        $("#userEmail").setValue(invalidSecondEmail);
        $("textarea#currentAddress").setValue(secondCurrentAddress);
        $("#submit").click();
        $("#name").shouldNotBe(visible);
        $("#email").shouldNotBe(visible);
        $("p#currentAddress").shouldNotBe(visible);
    }
}
*/
