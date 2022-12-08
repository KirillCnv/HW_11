package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PayWhenYouWantPage {

    private SelenideElement
            buttonPay = $("img[src=\"//a.lmcdn.ru/bs2/7/81/24-px-usp-any-pay1.svg\"]"),
            windowPay = $("div[field=\"tn_text_1587481758097\"]");

    public PayWhenYouWantPage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public void clickButtonPay() {
        buttonPay.click();
    }

    public PayWhenYouWantPage checkWindowPay(String value) {
        windowPay.shouldHave(Condition.text(value));

        return this;
    }
}