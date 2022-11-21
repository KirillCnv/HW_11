package ru.lamoda.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.lamoda.helpers.Attach;


public class TestConfig extends Attach {

    @BeforeAll
    @Step("Browser configuration")
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        DriverProvider config = new DriverProvider();
        config.setConfiguration();
        Configuration.baseUrl = "https://www.lamoda.ru/";

        if (DriverProvider.isRemote.equals("true")) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
    }

    @BeforeEach
    @Step("Adding Allure Listener")
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }


    @AfterEach
    @Step("Adding Attachments to Allure report")
    void addAttachments() {
        Attach.screenshotAs("Screenshot");
        if ((Configuration.browser).equals("chrome")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        if (DriverProvider.isRemote.equals("true")) {
            Attach.addVideo();
        }
        WebDriverRunner.closeWebDriver();
    }

}