package ru.lamoda.utils;

@org.aeonbits.owner.Config.Sources({
        "classpath:properties/prop.properties"
})
public interface Properties extends org.aeonbits.owner.Config {


    @Key("Browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browserVersion")
    @DefaultValue("99.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://www.lamoda.ru/")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getResolution();

    @Key("remote")
    @DefaultValue("false")
    boolean getRemote();

    @Key("selenoidLogin")
    String getSelenoidLogin();

    @Key("selenoidPassword")
    String getSelenoidPassword();

}