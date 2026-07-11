import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $("[id=subjectsContainer]").click();
        $("[id=subjectsInput]").setValue(subjects);
        $(byText(subjects)).click();
        $(byText(hobby)).click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/Dubai.jpg"));
        $("[id=submit]").scrollTo().click(); // У меня небольшая диагональ экрана. Хотя Станислав говорил, что это стрем, но пока что я альтернатив не изучил)
        $("[id=example-modal-sizes-title-lg]").shouldBe(visible);
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
