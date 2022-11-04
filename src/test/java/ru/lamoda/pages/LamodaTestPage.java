package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LamodaTestPage {

    // Elements

    private SelenideElement
            setValue = $("input[class*=\"_input_xf7ng_19 _inputShown_xf7ng_43\"]"),
            checkResult = $("h2[class=\"_titleText_5tc8h_15 ui-catalog-search-head-title\"]");


    // Actions
    public LamodaTestPage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public LamodaTestPage setValueSearch(String value) {
        setValue.setValue(value);

        return this;
    }

    public void searchButton() {
        $("#_025a50318d--container--sfUjh").click();
    }

    public LamodaTestPage checkResult(String value) {
        checkResult.shouldHave(Condition.text(value));
        return this;
    }
}
