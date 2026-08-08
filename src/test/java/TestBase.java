import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

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
