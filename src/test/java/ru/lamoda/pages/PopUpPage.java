package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PopUpPage {

    private SelenideElement buttonRegion = $("._message_kn91o_11"),
            windowRegion = $("._rightCol_rq1gl_8");

    public PopUpPage openPage() {
        open("/");
        return this;
    }

    public PopUpPage clickButtonRegion() {
        buttonRegion.click();

        return this;
    }
    public PopUpPage checkWindowRegion() {
        windowRegion.shouldHave(Condition.text("Где вы находитесь?"));

        return this;
    }
}