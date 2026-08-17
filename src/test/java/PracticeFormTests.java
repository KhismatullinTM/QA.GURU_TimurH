import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Успешное заполнение формы Регистрации студента")
    void shouldSuccessfullySubmitPracticeForm() {
        //Act
        practiceFormPage.
                openPracticeForm().
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
                // Asserts
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
    }

    @Test
    void testWithRequiredFields (){
        practiceFormPage.
                openPracticeForm().
                setFirstName(testData.USER_FIRST_NAME).
                setLastName(testData.USER_LAST_NAME).
                setUserEmail(testData.EMAIL).
                selectGender(testData.GENDER).
                setUserNumber(testData.PHONE_NUMBER).
                submitButtonClick().
                checkModalTitleSubmittedForm();

        practiceFormPage.
                checkTableRowByName("Student Name", testData.FULL_USER_NAME).
                checkTableRowByName("Student Email", testData.EMAIL).
                checkTableRowByName("Gender", testData.GENDER).
                checkTableRowByName("Mobile", testData.PHONE_NUMBER);
    }

    @Test
    void testWithoutPhoneNumber () {
        practiceFormPage.
                openPracticeForm().
                setFirstName(testData.USER_FIRST_NAME).
                setLastName(testData.USER_LAST_NAME).
                setUserEmail(testData.EMAIL).
                selectGender(testData.GENDER).
                submitButtonClick();

        practiceFormPage.
                    checkModalTitleNotVisible();
    }

    @Test
    void testWithoutGender () {
        practiceFormPage.
                openPracticeForm().
                setFirstName(testData.USER_FIRST_NAME).
                setLastName(testData.USER_LAST_NAME).
                setUserEmail(testData.EMAIL).
                setUserNumber(testData.PHONE_NUMBER).
                submitButtonClick();

        practiceFormPage.
                checkModalTitleNotVisible();
    }

    @Test
    void testWithInvalidPhone (){
        practiceFormPage.
                openPracticeForm().
                setFirstName(testData.USER_FIRST_NAME).
                setLastName(testData.USER_LAST_NAME).
                setUserEmail(testData.EMAIL).
                selectGender(testData.GENDER).
                setUserNumber(testData.INVALID_PHONE_NUMBER).
                submitButtonClick();

        practiceFormPage.
                checkModalTitleNotVisible();
    }
}