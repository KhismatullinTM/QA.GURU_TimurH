import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static testsData.TestData.*;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Успешное заполнение формы Регистрации студента")
    void shouldSuccessfullySubmitPracticeForm() {
        //Act
        practiceFormPage.
                openPracticeForm().
                setFirstName(USER_FIRST_NAME).
                setLastName(USER_LAST_NAME).
                setUserEmail(EMAIL).
                selectGender(GENDER).
                setUserNumber(PHONE_NUMBER).
                setDateOfBirth(DAY_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH).
                setSubject(SUBJECTS).
                setHobbies(HOBBY).
                fileUploader(FILE_PATH).
                setCurrentAddress(CURRENT_ADDRESS).
                setStateAndCity(USER_STATE, USER_CITY).
                submitButtonClick().
                checkModalTitleSubmittedForm();
                // Asserts
        practiceFormPage.
                checkTableRowByName("Student Name", FULL_USER_NAME).
                checkTableRowByName("Student Email", EMAIL).
                checkTableRowByName("Gender", GENDER).
                checkTableRowByName("Mobile", PHONE_NUMBER).
                checkTableRowByName("Date of Birth", DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH).
                checkTableRowByName("Subjects", SUBJECTS).
                checkTableRowByName("Hobbies", HOBBY).
                checkTableRowByName("Picture", FILE_PATH).
                checkTableRowByName("Address", CURRENT_ADDRESS).
                checkTableRowByName("State and City", USER_STATE + " " + USER_CITY);
    }

    @Test
    void testWithRequiredFields (){
        practiceFormPage.
                openPracticeForm().
                setFirstName(USER_FIRST_NAME).
                setLastName(USER_LAST_NAME).
                setUserEmail(EMAIL).
                selectGender(GENDER).
                setUserNumber(PHONE_NUMBER).
                submitButtonClick().
                checkModalTitleSubmittedForm();

        practiceFormPage.
                checkTableRowByName("Student Name", FULL_USER_NAME).
                checkTableRowByName("Student Email", EMAIL).
                checkTableRowByName("Gender", GENDER).
                checkTableRowByName("Mobile", PHONE_NUMBER);
    }

    @Test
    void testWithoutPhoneNumber () {
        practiceFormPage.
                openPracticeForm().
                setFirstName(USER_FIRST_NAME).
                setLastName(USER_LAST_NAME).
                setUserEmail(EMAIL).
                selectGender(GENDER).
                submitButtonClick();

        practiceFormPage.
                    checkModalTitleNotVisible();
    }

    @Test
    void testWithoutGender () {
        practiceFormPage.
                openPracticeForm().
                setFirstName(USER_FIRST_NAME).
                setLastName(USER_LAST_NAME).
                setUserEmail(EMAIL).
                setUserNumber(PHONE_NUMBER).
                submitButtonClick();

        practiceFormPage.
                checkModalTitleNotVisible();
    }

    @Test
    void testWithInvalidPhone (){
        practiceFormPage.
                openPracticeForm().
                setFirstName(USER_FIRST_NAME).
                setLastName(USER_LAST_NAME).
                setUserEmail(EMAIL).
                selectGender(GENDER).
                setUserNumber(INVALID_PHONE_NUMBER).
                submitButtonClick();

        practiceFormPage.
                checkModalTitleNotVisible();
    }
}