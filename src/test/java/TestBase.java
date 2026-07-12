import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    protected static final String userName = "Timur";
    protected static final String userLastName = "T";
    protected static final String fullUserName = "Timur T";
    protected static final String email = "avito9196@yandex.ru";
    protected static final String phoneNumber = "9657895436";
    protected static final String gender = "Male";
    protected static final String invalidPhoneNumber = "965789543";
    protected static final String subjects = "Computer Science";
    protected static final String hobby = "Sports";
    protected static final String currentAddress = "1 Kremlevskaya Embankment, Moscow, Russian Federation";
    protected static final String userState = "Rajasthan";
    protected static final String userCity = "Jaipur";

    protected static final String secondFullUserName = "Eva Nikonova";
    protected static final String secondEmail = "evanikonova@gmail.com";
    protected static final String invalidSecondEmail = "evanikonovagmail.com";
    protected static final String secondCurrentAddress = "2 Palace Square, Saint Petersburg, Russian Federation";

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
