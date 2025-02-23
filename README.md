# Проект автоматизации тестирования [Trello](https://trello.com/).

## Содержание:

- Технологии и инструменты используемые для тестирования данного проекта.
- Реализованные проверки.
    - Тесты пользовательского интерфейса (WEB)
    - Тесты прикладного программного интерфейса (API)
- Способы запуска авто-тестов:
    - Локальный запуск
    - Удаленный запуск
    - Параметры для запуска тестов в Jenkins
- Визуализация.

## Технологии и инструменты используемые для тестирования данного проекта.

<p style="text-align: center;">
<a href="https://www.jetbrains.com/idea/"> <img src="media/images/logos/idea.svg" height="50" width="50" alt="IDEA logo."/></a>
<a href="https://www.java.com/"> <img src="media/images/logos/java.svg" height="50" width="50" alt="Java programming language logo."/></a>
<a href="https://gradle.org/"> <img src="media/images/logos/gradle.svg" height="50" width="50" alt="Gradle logo."/></a>
<a href="https://junit.org/junit5/"> <img src="media/images/logos/jUnit.svg" height="50" width="50" alt="jUnit5 logo."/></a>
<a href="https://selenide.org/"> <img src="media/images/logos/selenide.svg" height="50" width="50" alt="Selenide logo."/></a>
<a href="https://rest-assured.io/"> <img src="media/images/logos/restAssured.svg" width="50" height="50" alt="Rest-Assured logo."/></a>
<a href="https://github.com/"> <img src="media/images/logos/github.svg" height="50" width="50" alt="Github logo."/></a>
<a href="https://allurereport.org/"> <img src="media/images/logos/allure.svg" height="50" width="50" alt="Allure report logo."/></a>
<a href="https://qameta.io/"> <img src="media/images/logos/allureTestOps.svg" height="50" width="50" alt="Allure TestOps logo.">
<a href="https://www.jenkins.io/"> <img src="media/images/logos/jenkins.svg" height="50" width="50" alt="Jenkins logo."/></a>
<a href="https://aerokube.com/selenoid/"> <img src="media/images/logos/selenoid.svg" height="50" width="50" alt="Selenoid logo."></a>
</p>

Авто-тесты реализованы на языке программирования `Java`.
В качестве системы сборки и запуска тестов используется `Gradle`, а в качестве фреймворка для тестирования `JUnit5`.
Для автоматизации графического (пользовательского) интерфейса используется библиотека `Selenide`, а для проверки API —
`REST-assured`.
Для предоставления отчетности о выполнении тестов использован инструмент — `Allure-Report`.
Отчет состоит из следующих элементов:

- Шаги;
- Снимок экрана для последнего шага теста;
- Видео выполнения;
- Исходный код страницы;
- Логи консоли браузера.

Дополнительным инструментом уведомления о прохождении тестов выступает ```telegram bot``` отправляющий отчет в
специально созданный для этого канал.

Указанные выше элементы позволяют не только предоставить отчетность менеджерам, но и в случае проблем быстрее позволит
разобраться в причине падения конкретного теста.

Удаленный запуск осуществляется с помощью `Selenoid`, который представляет собой ферму браузеров, а системой CI/CD
выступает — `Jenkins`.

## Реализация тестов.

## Запуск авто-тестов.

Все команды необходимо выполнять в эмуляторе терминала (консоль).

#### Локальный запуск авто-тестов.

API:

```bash
gradle clean api_tests -Denv=local
```

UI:

```bash
gradle clean ui_tests -Denv=local
```

#### Удаленный запуск авто-тестов.

API:

```bash
gradle clean api_tests
```

UI:

```bash
gradle clean ui_tests
```

Для удаленного запуска необходимо выполнить:

#### Запуск тестов из Jenkins:

```bash
clean
${TASK}
--stacktrace
```

## Визуализация.

Пример Allure-отчета:
<p style="text-align: center;">
</p>

Пример отчета который отправляется в telegram:
<p style="text-align: center;">
</p>

Видео выполнения теста в Selenoid:
<p style="text-align: center;">
</p>