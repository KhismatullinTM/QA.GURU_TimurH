package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    SelenideElement getFieldById (String fieldId) {
        return $("p#"+ fieldId);
    }

    public ResultComponent checkField (String fieldId, String fieldValue){
        getFieldById(fieldId).shouldHave(text(fieldValue));
        return this;
    }
}
