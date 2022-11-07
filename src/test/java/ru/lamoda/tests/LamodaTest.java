package ru.lamoda.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.lamoda.pages.LamodaTestPage;
import ru.lamoda.utils.TestConfig;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Проверка сайта https://www.lamoda.ru/")
@Story("Проверка сайта")
@Owner("KirillCnv")
@Severity(SeverityLevel.CRITICAL)
@Link(value = "Testing", url = "https://www.lamoda.ru/")
@Tag("all")
@DisplayName("Проверка сайта https://www.lamoda.ru/ (Jenkins)")


public class LamodaTest extends TestConfig {

    LamodaTestPage lamodaTestPage = new LamodaTestPage();


    @DisplayName("Проверка Pop up выбора региона")
    @Test
    void examinationLocation() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });

        step("Навести курсор на иконку региона", () -> {
            lamodaTestPage.buttonRegion();
        });
        step("Проверить, что открылось окно \"Выберите регион или город\"", () -> {
            lamodaTestPage.examinationWindowRegion();
        });

    }


    @DisplayName("Проверка элементов Header")
    @Test
    void examinationHeader() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Проверить, что все элементы отоброжаются", () -> {
            lamodaTestPage.elementsHeader("Идеи");
            lamodaTestPage.elementsHeader("Новинки");
            lamodaTestPage.elementsHeader("Одежда");
            lamodaTestPage.elementsHeader("Обувь");
            lamodaTestPage.elementsHeader("Аксессуары");
        });
    }


    @DisplayName("Проверка поисковой строки")
    @ValueSource(strings = {"Футболка", "Джинсы", "Парка"})
    @ParameterizedTest(name = "Результаты поиска выдают квартиры рядом с \"{0}\"")
    public void searchLamoda(String testData) {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Ввести {0}", () -> {
            lamodaTestPage.setValueSearch(testData);
            lamodaTestPage.parameterizedClickButton();
        });
        step("Проверить результаты поиска", () -> {
            lamodaTestPage.checkResult(testData);
        });

    }


    @DisplayName("Проверка страницы \"Бесконтактная доставка  с примеркой\"")
    @Test
    void examinationDelivery() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Кликнуть на кнопку \"Бесконтактная доставка  с примеркой\"", () -> {
            lamodaTestPage.buttonDelivery();
        });
        step("Проверить, что открылось окно \"Бесконтактная доставка  с примеркой\"", () -> {
            lamodaTestPage.windowDelivery();
        });
    }

    @DisplayName("Проверка страницы \"Платите когда хотите!\"")
    @Test
    void examinationPay() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Кликнуть на кнопку \"Платите когда хотите!\"", () -> {
            lamodaTestPage.buttonPay();
        });
        step("Проверить, что открылось окно \"Платитекогда хотите!\"", () -> {
            lamodaTestPage.windowPay("\"Оплата \n онлайн\"");
            lamodaTestPage.windowPay("При получении заказа ");
            lamodaTestPage.windowPay("Оплата частями");
        });
    }

    @DisplayName("Проверка страницы \"Платите когда хотите!\" FAIL ")
    @Test
    void examinationPayFail() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Кликнуть на кнопку \"Платите когда хотите!\"", () -> {
            lamodaTestPage.buttonPay();
        });
        step("Проверить, что открылось окно \"Платитекогда хотите!\"", () -> {
            lamodaTestPage.windowPay("Не Оплата \n онлайн");
            lamodaTestPage.windowPay("Не получении заказа ");
            lamodaTestPage.windowPay("Не Оплата частями");
        });
    }
}









