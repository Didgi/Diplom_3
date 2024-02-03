# Diplom_3
<h3>Описание</h3>
1. В данном проекте реализовано ui тестирование сайта https://stellarburgers.nomoreparties.site/.

<h3>Технологии</h3>
1. Проект использует Java 11;

2. Используемые библиотеки для реализации ui тестов добавлены в pom.xml: Selenium, Webdrivermanager, JUnit 4, Rest-Assured, Gson, Lombok, JavaFaker, Allure, Maven;

3. Используются следующие версии браузеров: Chrome 120..., Yandex 120... и такие же версии web driver, которые совместимы между собой.

<h3>Запуск</h3>
1. Подготовка: в BaseTest в System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver") указан путь, откуда будет браться web driver для запуска в том или ином браузере; 

2. Чтобы запустить тесты в браузере по-умолчанию (yandex), необходимо выполнить команду, например: mvn clean test;

3. Чтобы запустить тесты в браузере yandex или chrome, необходимо выполнить команду: mvn clean test -Dbrowser=yandex, где в параметр Dbrowser можно передать chrome или yandex;

4. Чтобы просмотреть собранный allure report по выполненному прогону тестов, необходимо выполнить команду: mvn allure:serve.
