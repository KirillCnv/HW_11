package ru.lamoda.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.lamoda.helpers.Attach;
import ru.lamoda.pages.*;
import ru.lamoda.utils.Provider;


public class TestConfig {

    Attach attach = new Attach();
    PopUpPage popUpPage = new PopUpPage();
    LamodaTestPage lamodaTestPage = new LamodaTestPage();
    ElementsHeaderPage elementsHeaderPage = new ElementsHeaderPage();
    CheckSearchLinePage checkSearchLinePage = new CheckSearchLinePage();
    СontactlessDeliveryPage сontactlessDeliveryPage = new СontactlessDeliveryPage();
    PayWhenYouWantPage payWhenYouWantPage = new PayWhenYouWantPage();

    @BeforeAll
    @Step("Browser configuration")
    static void configure() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Provider config = new Provider();
        config.setConfiguration();
        Configuration.baseUrl = "https://www.lamoda.ru/";

//        if (Provider.isRemote.equals("true")) {
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//        }
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
        if (Provider.isRemote.equals("true")) {
            Attach.addVideo();
        }
        WebDriverRunner.closeWebDriver();
    }
}