package ru.lamoda.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
@Feature("Проверка сайта https://www.lamoda.ru/")
@Story("Проверка сайта")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://www.lamoda.ru/")

public class ElementsHeaderTest extends TestConfig {

    @DisplayName("Проверка элементов Header")
    @Tag("Lamoda")
    @Test
    void checkElementsHeader() {
        step("Открыть главную страницу", () ->
                elementsHeaderPage.openPage()
        );
        step("Проверить, что все элементы отоброжаются", () -> {
            elementsHeaderPage.elementsHeader("Идеи");
            elementsHeaderPage.elementsHeader("Новинки");
            elementsHeaderPage.elementsHeader("Одежда");
            elementsHeaderPage.elementsHeader("Обувь");
            elementsHeaderPage.elementsHeader("Аксессуары");
        });
    }
}