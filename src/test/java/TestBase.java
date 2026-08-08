import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeEach
    void setUp (){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterEach
    void tearDown (){
        closeWebDriver();
    }
}
