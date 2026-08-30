import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {

    static Stream<Arguments> shouldSuccessfullySubmitTextBoxFormWithAnyUsers() {
        return Stream.of(
                Arguments.of(testData.FULL_USER_NAME, testData.EMAIL, testData.CURRENT_ADDRESS),
                Arguments.of(testData.SECOND_FULL_USER_NAME, testData.SECOND_EMAIL, testData.SECOND_CURRENT_ADDRESS)
        );
    }
    @ParameterizedTest(name = "Польователь {0}, его email {1} и город {2}")
    @MethodSource
    @DisplayName("Заполнение формы \"Text Box\" валидными данными.")
    void shouldSuccessfullySubmitTextBoxFormWithAnyUsers(String userName, String email, String currentAddress){
        step("Открытие страницы \"Text Box\"", () -> {
            textBoxPage.openTextBoxForm();
        });
        step("Заполнение полей данными пользователя", () -> {
            textBoxPage.
                    setUserName(userName).
                    setUserEmail(email).
                    setUserCurrentAddress(currentAddress).
                    submitButtonClick().
                    checkResultOutputVisible();
        });
        step("Проверка заполнения полей", () -> {
            textBoxPage.
                    checkResultOutputField("name",userName).
                    checkResultOutputField("email",email).
                    checkResultOutputField("currentAddress",currentAddress);
        });
    }

    @Test
    @DisplayName("Заполнение формы \"Text Box\" только обязательными параметрами")
    void shouldSubmitFormWithOnlyRequiredFields(){
        step("Открытие страницы \"Text Box\"", () -> {
            textBoxPage.openTextBoxForm();
        });
        step("Заполнение полей данными пользователя", () -> {
            textBoxPage.
                    setUserName(testData.USER_FIRST_NAME).
                    submitButtonClick();
        });
        step("Проверка заполнения полей", () -> {
            textBoxPage.
                    checkResultOutputVisible().
                    checkResultOutputField("name", testData.USER_FIRST_NAME);
        });
    }

    @Test
    @DisplayName("Заполнение формы \"Text Box\" с неверным e-mail")
    void shouldNotSubmitFormWithInvalidEmail(){
        step("Открытие страницы \"Text Box\"", () -> {
            textBoxPage.openTextBoxForm();
        });
        step("Заполнение полей данными пользователя", () -> {
            textBoxPage.
                    setUserName(testData.USER_FIRST_NAME).
                    setUserEmail(testData.INVALID_SECOND_EMAIL).
                    setUserCurrentAddress(testData.CURRENT_ADDRESS).
                    submitButtonClick();
        });
        step("Проверка отсутствия результатирующего поля", () -> {
            textBoxPage.
                    checkResultOutputNotVisible();
        });
    }
}