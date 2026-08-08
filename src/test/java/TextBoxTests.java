import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static testsData.TestData.*;

public class TextBoxTests extends TestBase {

    static Stream<Arguments> shouldSuccessfullySubmitTextBoxFormWithAnyUsers() {
        return Stream.of(
                Arguments.of(FULL_USER_NAME, EMAIL, CURRENT_ADDRESS),
                Arguments.of(SECOND_FULL_USER_NAME, SECOND_EMAIL, SECOND_CURRENT_ADDRESS)
        );
    }
    @ParameterizedTest(name = "Заполнение страницы text-box польователем {0}, его email {1} и город {2}")
    @MethodSource
    void shouldSuccessfullySubmitTextBoxFormWithAnyUsers(String userName, String email, String currentAddress){
        textBoxPage.
                openTextBoxForm().
                setUserName(userName).
                setUserEmail(email).
                setUserCurrentAddress(currentAddress).
                submitButtonClick().
                checkResultOutputVisible();

        textBoxPage.
                checkResultOutputField("name",userName).
                checkResultOutputField("email",email).
                checkResultOutputField("currentAddress",currentAddress);
    }

    @Test
    void shouldSubmitFormWithOnlyRequiredFields(){
        textBoxPage.
                openTextBoxForm().
                setUserName(USER_FIRST_NAME).
                submitButtonClick();

        textBoxPage.
                checkResultOutputVisible().
                checkResultOutputField("name", USER_FIRST_NAME);
    }

    @Test
    void shouldNotSubmitFormWithInvalidEmail(){
        textBoxPage.
                openTextBoxForm().
                setUserName(USER_FIRST_NAME).
                setUserEmail(INVALID_SECOND_EMAIL).
                setUserCurrentAddress(CURRENT_ADDRESS).
                submitButtonClick();

        textBoxPage.
                checkResultOutputNotVisible();
    }
}