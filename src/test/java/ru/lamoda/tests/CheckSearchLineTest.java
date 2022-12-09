package ru.lamoda.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Проверка сайта https://www.lamoda.ru/")
@Story("Проверка сайта")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://www.lamoda.ru/")

public class CheckSearchLineTest extends TestConfig {

    @DisplayName("Проверка поисковой строки")
    @Tag("Lamoda")
    @ValueSource(strings = {"Футболка", "Джинсы", "Парка"})
    @ParameterizedTest(name = "Результаты поиска выдают \"{0}\"")
    public void checkSearchLamoda(String testData) {
        step("Открыть главную страницу", () ->
                open("/")
        );
        step("Ввести {0}", () -> {
            checkSearchLinePage.setValueSearch(testData);
            checkSearchLinePage.searchClickButton();
        });
        step("Проверить результаты поиска", () ->
                checkSearchLinePage.checkResult(testData)
        );
    }
}