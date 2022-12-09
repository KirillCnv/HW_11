# Проект по автоматизации тестирования "LAMODA"

## Содержание

> ➠ [Покрытый функционал](#earth_africa-покрытый-функционал)
>
> ➠ [Технологический стек](#classical_building-технологический-стек)
>
> ➠ [Запуск тестов из терминала](#запуск-тестов-из-терминала)
>
> ➠ [Отчет о результатах тестирования в Allure Report](#skier-главная-страница-allure-отчета)
>
> ➠ [Уведомления в Telegram с использованием бота](#-уведомления-в-telegram-с-использованием-бота)
>
> ➠ [Интеграция с AllureTestOps](#Интеграция-с-[AllureTestOps])
> 
> ➠ [Пример запуска теста в Selenoid](#-пример-запуска-теста-в-selenoid)

## :tshirt: Покрытый функционал

> Разработаны автотесты на <code>UI</code>.

### UI

- [x] Проверка элементов Header
- [x] Проверка страницы "Платите когда хотите!"
- [x] Проверка страницы "Бесконтактная доставка с примеркой"
- [x] Проверка поисковой строки
- [x] Проверка Pop up выбора региона

## :abacus: Технологический стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

В данном проекте автотесты написаны на <code>Java</code> с использованием <code>Selenide</code> для UI-тестов.

> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> Для автоматизированной сборки проекта используется <code>Gradle</code>.
>
> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.
>
> <code>Jenkins</code> выполняет запуск тестов.
> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.

## Запуск тестов из терминала

### :desktop_computer: Локальный запуск тестов

```
gradle clean test
```

### :desktop_computer: Удаленный запуск тестов [Jenkins](https://jenkins.autotests.cloud/job/HW_11_jenkins/)

```
clean
test
-Dselenoid=true
-Dos=remote
-Dbrowser_name=${BROWSER_NAME}
-Dbrowser_version=${BROWSER_VERSION}
-Dbrowser_size=${BROWSER_SIZE}
-Dremote_selenide=${remote_selenide}
```

<p align="center">
<img title="Jenkins Overview" src="images/screens/jobJenkins.png">
</p>

### :desktop_computer: Параметры сборки

> <code>REMOTE_URL</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
> <code>BROWSER</code> – браузер, в котором будут выполняться тесты (_по умолчанию - <code>chrome</code>_).
>
> <code>BROWSER*VERSION</code> – версия браузера, в которой будут выполняться тесты (*по умолчанию - <code>100</code>\_).
>
> <code>BROWSER*SIZE</code> – размер окна браузера, в котором будут выполняться тесты (*по умолчанию - <code>1920x1080</code>).


### :scroll: Главная страница Allure-отчета

<p align="center">
<img title="Allure Overview" src="images/screens/allureMainPage.png">
</p>

### :scroll: Группировка тестов по проверяемому функционалу

<p align="center">
<img title="Allure Behaviors" src="images/screens/allureSuites.png">
</p>


### :scroll: Основной дашборд

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/allureGraphs.png">
</p>


## <img width="4%" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

> После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне.

<p align="center">
<img title="Telegram Notifications" src="images/screens/Tele.png">
</p>

## Интеграция с [AllureTestOps](https://allure.autotests.cloud/project/1707/dashboards)

### Тест-кейсы
<p align="center">
<img title="testCase" src="images/screens/testCase.png">
</p>

### Дашборд

<p align="center">
<img title="dashboard" src="images/screens/dashboard.png">
</p>

## <img width="4%" title="Selenoid" src="images/logo/Selenoid.svg"> Пример запуска теста в Selenoid

> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Selenoid Video" src="images/gif/selenoid.gif">
</p>

