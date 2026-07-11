import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    String firstFullUserName = "Timur T";
    String firstEmail = "avito9196@yandex.ru";
    String firstCurrentAddress = "1 Kremlevskaya Embankment, Moscow, Russian Federation";

    String secondFullUserName = "Eva Nikonova";
    String secondEmail = "evanikonova@gmail.com";
    String invalidSecondEmail = "evanikonovagmail.com";
    String secondCurrentAddress = "2 Palace Square, Saint Petersburg, Russian Federation";

    @BeforeEach
    void setUp (){
        open("https://demoqa.com/text-box");
    }

    @AfterEach
    void tearDown (){
        closeWebDriver();
    }

    @Test
    void firstUserPositiveTest(){
        $("#userName").setValue(firstFullUserName);
        $("#userEmail").setValue(firstEmail);
        $("textarea#currentAddress").setValue(firstCurrentAddress);
        $("#submit").click();
        $("#name").shouldHave(text(firstFullUserName));
        $("#email").shouldHave(text(firstEmail));
        $("p#currentAddress").shouldHave(text(firstCurrentAddress));
    }

    @Test
    void secondUserPositiveTest(){
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
        $("#userName").setValue(firstFullUserName);
        $("#submit").click();
        $("#name").shouldHave(text(firstFullUserName));
    }

    @Test
    void secondUserNegativeTest(){
        $("#userName").setValue(secondFullUserName);
        $("#userEmail").setValue(invalidSecondEmail);
        $("textarea#currentAddress").setValue(secondCurrentAddress);
        $("#submit").click();
        $("#name").shouldNotBe(visible);
        $("#email").shouldNotBe(visible);
        $("p#currentAddress").shouldNotBe(visible);
    }
}
