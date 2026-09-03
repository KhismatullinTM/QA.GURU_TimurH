package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeEach
    void setUp (){
        Configuration.baseUrl = System.getProperty("URL", "https://demoqa.com");
        Configuration.browser = System.getProperty("BROWSER", "chrome");
        Configuration.browserSize = System.getProperty("BROWSER_SIZE");
        //Configuration.browserVersion = System.getProperty("BROWSER_VERSION", "152");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("HEADLESS", "false"));
        Configuration.timeout = 10000;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(List.of("--disable-dev-shm-usage", "--no-sandbox"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;

        String selenoidUrl = System.getProperty("SELENOID_URL");
        if (selenoidUrl != null && !selenoidUrl.isEmpty()) {
            Configuration.remote = "https://user1:1234@" + selenoidUrl + "/wd/hub";
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown (){
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
