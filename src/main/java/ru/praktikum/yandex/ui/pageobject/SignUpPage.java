package ru.praktikum.yandex.ui.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    //поле для ввода имени
    private final By nameField = By.xpath(".//*[text()='Имя']/following::input[@name='name']");
    //поле для ввода email
    private final By emailField = By.xpath(".//*[text()='Email']/following::input[@name='name']");
    //поле для ввода пароля
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following::input[@name='Пароль']");
    //кнопка зарегистрироваться
    private final By registrationButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Зарегистрироваться']");
    //кнопка войти
    private final By enterButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
    //ошибка некорректного пароля
    private final By lengthPasswordError = By.xpath(".//*[@class='input__error text_type_main-default']");
    //кнопка войти на странице восстановления пароля и на странице регистрации
    private final By enterButtonRestorePasswordOrSignUpPage = By.xpath(".//*[@class='Auth_link__1fOlj']");

    @Step("Ввод имени")
    public void setName(String name) {
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввод email")
    public void setEmail(String email) {
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Проверка, что отображается кнопка войти")
    public boolean checkSuccessfulRegistration() {
        WebElement enterButtonElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(enterButton));
        return enterButtonElement.isDisplayed();
    }
    @Step("Проверка, что отображается ошибка о коротком пароле")
    public boolean checkLengthPassword() {
        WebElement lengthPasswordErrorElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(lengthPasswordError));
        return lengthPasswordErrorElement.isDisplayed();
    }
    @Step("Нажатие по кнопке \"Войти\" на странице регистрации/восстановления пароля")
    public void enterButtonRestorePasswordOrSignUpPage(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(enterButtonRestorePasswordOrSignUpPage));
        driver.findElement(enterButtonRestorePasswordOrSignUpPage).click();
    }


}

