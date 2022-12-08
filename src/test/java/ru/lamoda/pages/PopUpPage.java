package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PopUpPage {

    private SelenideElement
            buttonRegion = $("._message_kn91o_11"),
            windowRegion = $("._rightCol_rq1gl_8").shouldHave(Condition.text("Где вы находитесь?"));

    public PopUpPage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public void clickButtonRegion() {
        buttonRegion.click();
    }

    public void checkWindowRegion() {
       windowRegion.shouldHave(Condition.text("Где вы находитесь?"));
    }
}
