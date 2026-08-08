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
                // Assert
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
}
/*
    }

    @Test
    void testWithRequiredFields (){
        open("/automation-practice-form");
        $("[#firstName]").setValue(USER_NAME);
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

}*/
