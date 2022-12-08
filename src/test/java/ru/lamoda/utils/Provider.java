package ru.lamoda.utils;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;

public class Provider {

    public Provider setConfiguration() {
        Config config = ConfigFactory.create(Config.class, System.getProperties());
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.remote = config.getRemoteUrl();

        return this;
    }
}