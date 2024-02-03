package ru.praktikum.yandex.ui.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends BasePage{
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    //кнопка войти
    private final By enterButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //поле для ввода email
    private final By emailField = By.xpath(".//*[text()='Email']/following::input[@name='name']");
    //поле для ввода пароля
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following::input[@name='Пароль']");

    @Step("Ввод email")
    public void setEmail(String email) {
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("Ввод пароля")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("Клик по кнопке войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

}
