package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
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
    @Step("Вводим имя: {value}")
    public PracticeFormPage setFirstName (String value){
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Вводим фамилию: {value}")
    public PracticeFormPage setLastName (String value){
        lastNameInput.setValue(value);
        return this;
    }
    @Step("Вводим e-mail: {value}")
    public PracticeFormPage setUserEmail (String value){
        userEmailInput.setValue(value);
        return this;
    }
    @Step("Вводим гендер: {value}")
    public PracticeFormPage selectGender (String value){
        genderCheckForm.$(byText(value)).click();
        return this;
    }
    @Step("Вводим номер телефона: {value}")
    public PracticeFormPage setUserNumber (String value){
        userNumberInput.setValue(value);
        return this;
    }
    @Step("Вводим дату рожения: {day}, {month}, {year}")
    public PracticeFormPage setDateOfBirth (String day, String month, String year){
        dateOfBirthInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.selectDateOfBirth(day, month, year);
        return this;
    }
    @Step("Вводим subject: {value}")
    public PracticeFormPage setSubject (String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }
    @Step("Вводим хобби: {value}")
    public PracticeFormPage setHobbies (String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    @Step("Добавляем файл: {fileName}")
    public PracticeFormPage fileUploader (String fileName){
        uploader.uploadFromClasspath(fileName);
        return this;
    }
    @Step("Вводим адрес: {value}")
    public PracticeFormPage setCurrentAddress (String value){
        currentAddressTextArea.scrollTo().setValue(value);
        return this;
    }
    @Step("Вводим штат: {value}")
    public PracticeFormPage setState (String value){
        selectState.setValue(value).pressEnter();
        return this;
    }
    @Step("Вводим город: {value}")
    public PracticeFormPage setCity (String value){
        selectCity.setValue(value).pressEnter();
        return this;
    }
    @Step("Вводим штат: {state} и город {city}")
    public PracticeFormPage setStateAndCity (String state, String city) {
        setState(state);
        setCity(city);
        return this;
    }

    public PracticeFormPage submitButtonClick (){
        submitButton.scrollTo().click();
        return this;
    }

    public PracticeFormPage checkModalTitleSubmittedForm (){
        modalTitleSubmittedForm.shouldBe(visible);
        return this;
    }

    public PracticeFormPage checkModalTitleNotVisible (){
        modalTitleSubmittedForm.shouldNotBe(visible);
        return this;
    }
    @Step("Проверка заполнения поля: \"{rowName}\" значением {resultRowTable}")
    public PracticeFormPage checkTableRowByName (String rowName, String resultRowTable){
        ResultTableComponent resultTable = new ResultTableComponent();
        resultTable.checkResultRowTable(rowName, resultRowTable);
        return this;
    };
}
