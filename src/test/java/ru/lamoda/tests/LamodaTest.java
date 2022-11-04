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
            $("._message_kn91o_11").click();
        });
        step("Проверить, что открылось окно \"Выберите регион или город\"", () -> {
            $("._rightCol_rq1gl_8").shouldHave(Condition.text("Где вы находитесь?"));
        });

    }


    @DisplayName("Проверка элементов Header")
    @Test
    void examinationHeader() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Проверить, что все элементы отоброжаются", () -> {
            $("._root_1416b_2").shouldHave(Condition.text("Идеи"));
            $("._root_1416b_2").shouldHave(Condition.text("Новинки"));
            $("._root_1416b_2").shouldHave(Condition.text("Одежда"));
            $("._root_1416b_2").shouldHave(Condition.text("Обувь"));
            $("._root_1416b_2").shouldHave(Condition.text("Аксессуары"));
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
            $("button[class*=\"_button_xf7ng_11\"]").click();
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
            $("img[src=\"//a.lmcdn.ru/bs2/8/97/24-px-usp-covid-19.svg\"]").click();
        });
        step("Проверить, что открылось окно \"Бесконтактная доставка  с примеркой\"", () -> {
            $("div[field=\"tn_text_1584497896110\"]").shouldHave(Condition.text("Воспользуйтесь бесконтактной доставкой "));
        });
    }

    @DisplayName("Проверка страницы \"Платите когда хотите!\"")
    @Test
    void examinationPay() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Кликнуть на кнопку \"Платите когда хотите!\"", () -> {
            $("img[src=\"//a.lmcdn.ru/bs2/7/81/24-px-usp-any-pay1.svg\"]").click();
        });
        step("Проверить, что открылось окно \"Платитекогда хотите!\"", () -> {
            $("div[field=\"tn_text_1587481758097\"]").shouldHave(Condition.text("Оплата \n онлайн"));
            $("div[field=\"tn_text_1587481758109\"]").shouldHave(Condition.text("При получении заказа "));
            $("div[field=\"tn_text_1587481758116\"]").shouldHave(Condition.text("Оплата частями "));
        });
    }


@DisplayName("Проверка страницы \"Платитекогда хотите!\"(FAIL)")
@Disabled
@Test
    void examinationPayFail() {
        step("Открыть главную страницу", () -> {
            lamodaTestPage.openPage();
        });
        step("Кликнуть на кнопку \"Платите когда хотите!\"", () -> {
            $("img[src=\"//a.lmcdn.ru/bs2/7/81/24-px-usp-any-pay1.svg\"]").click();
        });
        step("Проверить, что открылось окно \"Платитекогда хотите!\"", () -> {
            $("div[field=\"tn_text_1587481758097\"]").shouldHave(Condition.text("НЕ Оплата \n онлайн"));
            $("div[field=\"tn_text_1587481758109\"]").shouldHave(Condition.text("НЕ При получении заказа "));
            $("div[field=\"tn_text_1587481758116\"]").shouldHave(Condition.text("НЕ Оплата частями "));
        });
    }
}







