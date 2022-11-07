package ru.lamoda.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LamodaTestPage {

    // Elements

    private SelenideElement
            setValue = $("input[class*=\"_input_xf7ng_19 _inputShown_xf7ng_43\"]"),
            checkResult = $("h2[class=\"_titleText_641wy_15 ui-catalog-search-head-title\"]");


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

    public LamodaTestPage checkResult(String value) {
        checkResult.shouldHave(Condition.text(value));
        return this;
    }

    public void parameterizedClickButton() {
        $("button[class*=\"_button_xf7ng_11\"]").click();
    }

    public void buttonRegion() {
        $("._message_kn91o_11").click();
    }

    public void examinationWindowRegion() {
        $("._rightCol_rq1gl_8").shouldHave(Condition.text("Где вы находитесь?"));
    }

    public LamodaTestPage elementsHeader(String value) {
        $("._root_1416b_2").shouldHave(Condition.text(value));

        return this;
    }

    public void buttonDelivery() {
        $("img[src=\"//a.lmcdn.ru/bs2/8/97/24-px-usp-covid-19.svg\"]").click();
    }

    public void windowDelivery() {
        $("div[field=\"tn_text_1584497896110\"]").shouldHave(Condition.text("Воспользуйтесь бесконтактной доставкой "));
    }

    public void buttonPay() {
        $("img[src=\"//a.lmcdn.ru/bs2/7/81/24-px-usp-any-pay1.svg\"]").click();
    }

    public LamodaTestPage windowPay(String value) {
        $("div[field=\"tn_text_1587481758097\"]").shouldHave(Condition.text(value));

        return this;
    }




}
