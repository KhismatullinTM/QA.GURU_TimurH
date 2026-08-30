package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ResultComponent;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    SelenideElement userNameInput = $("#userName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement currentAddressTextArea = $("#currentAddress-wrapper textarea");
    SelenideElement submitButton = $("#submit");
    SelenideElement resultOutput = $("#output");


    public TextBoxPage openTextBoxForm (){
        open("/text-box");
        return this;
    }
    @Step("Вводим имя: {userName}")
    public TextBoxPage setUserName (String userName){
        userNameInput.setValue(userName);
        return this;
    }
    @Step("Вводим e-mail: {userEmail}")
    public TextBoxPage setUserEmail (String userEmail){
        userEmailInput.setValue(userEmail);
        return this;
    }
    @Step("Вводим адрес: {currentAddress}")
    public TextBoxPage setUserCurrentAddress (String currentAddress){
        currentAddressTextArea.setValue(currentAddress);
        return this;
    }
    @Step("Кликаем на кнопку \"Submit\"")
    public TextBoxPage submitButtonClick (){
        submitButton.click();
        return this;
    }
    @Step("Проверка отображения поля с результами")
    public TextBoxPage checkResultOutputVisible (){
        resultOutput.shouldBe(visible);
        return this;
    }

    public TextBoxPage checkResultOutputNotVisible (){
        resultOutput.shouldNotBe(visible);
        return this;
    }
    @Step("Проверка заполнения поля: \"{fieldId}\" значением {resultValue}")
    public TextBoxPage checkResultOutputField (String fieldId, String resultValue){
        ResultComponent resultComponent = new ResultComponent();
        resultComponent.checkField(fieldId, resultValue);
        return this;
    }
}
