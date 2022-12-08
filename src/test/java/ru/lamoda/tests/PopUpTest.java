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

public class PopUpTest extends TestConfig {

    @DisplayName("Проверка Pop up выбора региона")
    @Tag("Lamoda")
    @Test
    void checkLocation() {
        step("Открыть главную страницу", () ->
                popUpPage.openPage()
        );

        step("Навести курсор на иконку региона", () ->
                popUpPage.clickButtonRegion()
        );
        step("Проверить, что открылось окно \"Выберите регион или город\"", () ->
                popUpPage.checkWindowRegion()
        );
    }
}