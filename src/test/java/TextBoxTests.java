import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static testsData.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    @DisplayName("Успешное заполнение формы Text Box")
    void shouldSuccessfullySubmitTextBoxForm(){
        textBoxPage.
                openTextBoxForm().
                setUserName(FULL_USER_NAME).
                setUserEmail(EMAIL).
                setUserCurrentAddress(CURRENT_ADDRESS).
                submitButtonClick().
                checkResultOutputVisible();

        textBoxPage.
                checkResultOutputField("name",FULL_USER_NAME).
                checkResultOutputField("email",EMAIL).
                checkResultOutputField("currentAddress",CURRENT_ADDRESS);
    }
}
/*
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
