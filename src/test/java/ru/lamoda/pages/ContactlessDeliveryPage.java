package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ContactlessDeliveryPage {

    private SelenideElement
                buttonDelivery = $("img[src=\"//a.lmcdn.ru/bs2/8/97/24-px-usp-covid-19.svg\"]"),
                windowDelivery = $("div[field=\"tn_text_1584497896110\"]");

    public ContactlessDeliveryPage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public void clickButtonDelivery() {
        buttonDelivery.click();
    }

    public void checkWindowDelivery() {
        windowDelivery.shouldHave(Condition.text("Воспользуйтесь бесконтактной доставкой "));
    }
}
