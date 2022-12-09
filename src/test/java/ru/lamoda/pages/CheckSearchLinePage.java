package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckSearchLinePage {

    private SelenideElement
            setValue = $("input[class*=\"_input_xf7ng_19 _inputShown_xf7ng_43\"]"),
            checkResult = $("h2[class=\"_titleText_641wy_15 ui-catalog-search-head-title\"]"),
            searchButton = $("button[class*=\"_button_xf7ng_11\"]");

    public CheckSearchLinePage openPage() {
        open("/");
//        executeJavaScript("$('footer').remove()");
//        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public CheckSearchLinePage setValueSearch(String value) {
        setValue.setValue(value);

        return this;
    }

    public void searchClickButton() {
        searchButton.click();
    }

    public CheckSearchLinePage checkResult(String value) {
        checkResult.shouldHave(Condition.text(value));
        return this;
    }
}