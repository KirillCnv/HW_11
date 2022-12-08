package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ElementsHeaderPage {

    private SelenideElement
            elements =  $("._root_1416b_2");


    public ElementsHeaderPage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public ElementsHeaderPage elementsHeader(String value) {
       elements.shouldHave(Condition.text(value));

        return this;
    }
}
