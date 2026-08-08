package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    // Elements
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderCheckForm = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    SelenideElement uploader = $("#uploadPicture");
    SelenideElement currentAddressTextArea = $("#currentAddress");
    SelenideElement selectState = $("#react-select-3-input");
    SelenideElement selectCity = $("#react-select-4-input");
    SelenideElement submitButton = $("#submit");
    SelenideElement modalTitleSubmittedForm = $("#example-modal-sizes-title-lg");

    // Actions

    public PracticeFormPage openPracticeForm (){
      open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName (String value){
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setUserEmail (String value){
        userEmailInput.setValue(value);
        return this;
    }

    public PracticeFormPage selectGender (String value){
        genderCheckForm.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumber (String value){
        userNumberInput.setValue(value);
        return this;
    }

    public PracticeFormPage setDateOfBirth (String day, String month, String year){
        dateOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.selectDateOfBirth(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbies (String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage fileUploader (String fileName){
        uploader.uploadFromClasspath(fileName);
        return this;
    }

    public PracticeFormPage setCurrentAddress (String value){
        currentAddressTextArea.scrollTo().setValue(value);
        return this;
    }

    public PracticeFormPage setState (String value){
        selectState.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setCity (String value){
        selectCity.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setStateAndCity (String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public PracticeFormPage submitButtonClick (){
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkModalTitleSubmittedForm (){
        modalTitleSubmittedForm.shouldBe(visible);
        return this;
    }

    public PracticeFormPage checkTableRowByName (String rowName, String resultRowTable){
        ResultTableComponent resultTable = new ResultTableComponent();
        resultTable.checkResultRowTable(rowName, resultRowTable);
        return this;
    };
}
