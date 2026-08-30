import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Story("Тесты формы регистрации \"Practice Form\"")
@Feature("Тесты формы регистрации \"Practice Form\"")
public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Успешное заполнение формы \"Регистрации студента\"")
    void shouldSuccessfullySubmitPracticeForm() {
        //Act
        step("Открытие страницы \"Practice Form\"", () -> {
                    practiceFormPage.openPracticeForm();
                });
        step("Заполнение полей данными студента", () -> {
            practiceFormPage.
                    setFirstName(testData.USER_FIRST_NAME).
                    setLastName(testData.USER_LAST_NAME).
                    setUserEmail(testData.EMAIL).
                    selectGender(testData.GENDER).
                    setUserNumber(testData.PHONE_NUMBER).
                    setDateOfBirth(testData.DAY_OF_BIRTH, testData.MONTH_OF_BIRTH, testData.YEAR_OF_BIRTH).
                    setSubject(testData.SUBJECTS).
                    setHobbies(testData.HOBBY).
                    fileUploader(testData.FILE_PATH).
                    setCurrentAddress(testData.CURRENT_ADDRESS).
                    setStateAndCity(testData.USER_STATE, testData.USER_CITY).
                    submitButtonClick().
                    checkModalTitleSubmittedForm();
        });
                // Asserts
        step("Проверка заполнения полей", () -> {
            practiceFormPage.
                    checkTableRowByName("Student Name", testData.FULL_USER_NAME).
                    checkTableRowByName("Student Email", testData.EMAIL).
                    checkTableRowByName("Gender", testData.GENDER).
                    checkTableRowByName("Mobile", testData.PHONE_NUMBER).
                    checkTableRowByName("Date of Birth", testData.DAY_OF_BIRTH + " " + testData.MONTH_OF_BIRTH + "," + testData.YEAR_OF_BIRTH).
                    checkTableRowByName("Subjects", testData.SUBJECTS).
                    checkTableRowByName("Hobbies", testData.HOBBY).
                    checkTableRowByName("Picture", testData.FILE_PATH).
                    checkTableRowByName("Address", testData.CURRENT_ADDRESS).
                    checkTableRowByName("State and City", testData.USER_STATE + " " + testData.USER_CITY);
        });
    }

    @Test
    @DisplayName("Регистрация студента только обязательными параметрами")
    void testWithRequiredFields (){
        step("Открытие страницы \"Practice Form\"", () -> {
            practiceFormPage.openPracticeForm();
        });
        step("Заполнение полей данными студента", () -> {
            practiceFormPage.
                    setFirstName(testData.USER_FIRST_NAME).
                    setLastName(testData.USER_LAST_NAME).
                    setUserEmail(testData.EMAIL).
                    selectGender(testData.GENDER).
                    setUserNumber(testData.PHONE_NUMBER).
                    submitButtonClick().
                    checkModalTitleSubmittedForm();
        });
        step("Проверка заполнения полей", () -> {
            practiceFormPage.
                    checkTableRowByName("Student Name", testData.FULL_USER_NAME).
                    checkTableRowByName("Student Email", testData.EMAIL).
                    checkTableRowByName("Gender", testData.GENDER).
                    checkTableRowByName("Mobile", testData.PHONE_NUMBER);
        });
    }

    @Test
    @DisplayName("Заполнение формы \"Регистрации студента\" без заполнения номера телефона")
    void testWithoutPhoneNumber () {
        step("Открытие страницы \"Practice Form\"", () -> {
            practiceFormPage.openPracticeForm();
        });
        step("Заполнение полей данными студента без номера телефона", () -> {
            practiceFormPage.
                    setFirstName(testData.USER_FIRST_NAME).
                    setLastName(testData.USER_LAST_NAME).
                    setUserEmail(testData.EMAIL).
                    selectGender(testData.GENDER).
                    submitButtonClick();
        });
        step("Проверка отсутствия модального окна", () -> {
            practiceFormPage.
                    checkModalTitleNotVisible();
        });
    }

    @Test
    @DisplayName("Заполнение формы \"Регистрации студента\" без указания гендера")
    void testWithoutGender () {
        step("Открытие страницы \"Practice Form\"", () -> {
            practiceFormPage.openPracticeForm();
        });
        step("Заполнение полей данными студента без гендера", () -> {
            practiceFormPage.
                    setFirstName(testData.USER_FIRST_NAME).
                    setLastName(testData.USER_LAST_NAME).
                    setUserEmail(testData.EMAIL).
                    setUserNumber(testData.PHONE_NUMBER).
                    submitButtonClick();
        });
        step("Проверка отсутствия модального окна", () -> {
            practiceFormPage.
                    checkModalTitleNotVisible();
        });
    }

    @Test
    @DisplayName("Заполнение формы \"Регистрации студента\" с некорректным номером телефона")
    void testWithInvalidPhone (){
        step("Открытие страницы \"Practice Form\"", () -> {
            practiceFormPage.openPracticeForm();
        });
        step("Заполнение полей данными студента с некорректным номером телефона", () -> {
            practiceFormPage.
                    setFirstName(testData.USER_FIRST_NAME).
                    setLastName(testData.USER_LAST_NAME).
                    setUserEmail(testData.EMAIL).
                    selectGender(testData.GENDER).
                    setUserNumber(testData.INVALID_PHONE_NUMBER).
                    submitButtonClick();
        });
        step("Проверка отсутствия модального окна", () -> {
            practiceFormPage.
                    checkModalTitleNotVisible();
        });
    }
}