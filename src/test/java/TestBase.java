import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;
import pages.TextBoxPage;
import testsData.TestData;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TextBoxPage textBoxPage = new TextBoxPage();
    static TestData testData = new TestData();

    @BeforeEach
    void setUp (){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        //Configuration.timeout = 10000;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown (){
        closeWebDriver();
    }
}
