package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.UserConfig;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
    static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    String email = userConfig.getEmail();
    String password = userConfig.getPassword();
    String wrongPassword = userConfig.getWrongPassword();

    static LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }

    @BeforeEach
    void declineCookies() {
        open("");
        $("button[id='onetrust-accept-btn-handler']").click();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (config.isRemote()) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}
