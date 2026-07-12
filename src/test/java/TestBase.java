import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static final String userName = "Timur";
    public static final String userLastName = "T";
    public static final String fullUserName = "Timur T";
    public static final String email = "avito9196@yandex.ru";
    public static final String phoneNumber = "9657895436";
    public static final String gender = "Male";
    public static final String invalidPhoneNumber = "965789543";
    public static final String subjects = "Computer Science";
    public static final String hobby = "Sports";
    public static final String currentAddress = "1 Kremlevskaya Embankment, Moscow, Russian Federation";
    public static final String userState = "Rajasthan";
    public static final String userCity = "Jaipur";

    public static final String secondFullUserName = "Eva Nikonova";
    public static final String secondEmail = "evanikonova@gmail.com";
    public static final String invalidSecondEmail = "evanikonovagmail.com";
    public static final String secondCurrentAddress = "2 Palace Square, Saint Petersburg, Russian Federation";

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
