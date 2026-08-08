package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$$;

public class ResultTableComponent {
    // Elements
    SelenideElement setRowName (String value){
        return $$("tr").findBy(text(value));
    };

    // Actions
    public ResultTableComponent checkResultRowTable (String rowName, String rowValue){
        setRowName(rowName).shouldHave(text(rowValue));
        return this;
    }
}