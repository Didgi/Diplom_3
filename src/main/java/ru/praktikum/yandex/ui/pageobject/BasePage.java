package ru.praktikum.yandex.ui.pageobject;

import io.qameta.allure.Step;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import ru.praktikum.yandex.ui.config.Configs;

@Data
public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы регистрации")
    public void openSignUpPage() {
        driver.get(Configs.BASE_URI + Configs.REGISTER);
    }
    @Step("Открытие основной страницы")
    public void openMainPage() {
        driver.get(Configs.BASE_URI);
    }
    @Step("Открытие страницы восстановления пароля")
    public void openRecoveryPasswordPage() {
        driver.get(Configs.BASE_URI + Configs.RECOVERY_PASSWORD);
    }


}
