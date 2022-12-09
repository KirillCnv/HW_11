package ru.lamoda.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class PayWhenYouWantTest extends TestConfig {

    @DisplayName("Проверка страницы \"Платите когда хотите!\"")
    @Tag("Lamoda")
    @Test
    void checkPagePay() {
        step("Открыть главную страницу", () ->
                open("/")
        );
        step("Кликнуть на кнопку \"Платите когда хотите!\"", () ->
                payWhenYouWantPage.clickButtonPay()
        );
        step("Проверить, что открылось окно \"Платитекогда хотите!\"", () -> {
            payWhenYouWantPage.checkWindowPay("\"Оплата \n онлайн\"");
            payWhenYouWantPage.checkWindowPay("При получении заказа ");
            payWhenYouWantPage.checkWindowPay("Оплата частями");
        });
    }
}