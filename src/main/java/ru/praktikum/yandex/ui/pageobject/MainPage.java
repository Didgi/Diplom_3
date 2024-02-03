package ru.praktikum.yandex.ui.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    //кнопка Войти в аккаунт на основной странице
    private final By accountEnterButtonMainPage = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    //кнопка  личный кабинет на основной странице
    private final By personalAccountEnterButtonMainPage = By.xpath(".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    //кнопка оформить заказ
    private final By makeOrderButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    //кнопка выход в личном кабинете
    private final By exitButton = By.xpath(".//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");
    //кнопка конструктора
    private final By constructorButton = By.xpath(".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    //основное лого
    private final By logo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']//*//*");
    //раздел "булки"
    private final By bunsChapter = By.xpath(".//*[@class='text text_type_main-default' and text()='Булки']");
    //раздел "соусы"
    private final By saucesChapter = By.xpath(".//*[@class='text text_type_main-default' and text()='Соусы']");
    //раздел "начинки"
    private final By fillingsChapter = By.xpath(".//*[@class='text text_type_main-default' and text()='Начинки']");
    //локатор класса "булки" для проверки скролла
    private final By currentChapterBuns = By.xpath(".//*[@class='text text_type_main-default' and text()='Булки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    //локатор класса "соусы" для проверки скролла
    private final By currentChapterSauces = By.xpath(".//*[@class='text text_type_main-default' and text()='Соусы']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    //локатор класса "начинки" для проверки скролла
    private final By currentChapterFillings = By.xpath(".//*[@class='text text_type_main-default' and text()='Начинки']/parent::div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");


    @Step("Нажатие по кнопке \"Войти в аккаунт\"")
    public void enterByAccountEnterButtonMainPage(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(accountEnterButtonMainPage));
        driver.findElement(accountEnterButtonMainPage).click();
    }
    @Step("Нажатие по кнопке \"Войти в аккаунт\"")
    public void enterByPersonalAccountEnterButtonMainPage(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(personalAccountEnterButtonMainPage));
        driver.findElement(personalAccountEnterButtonMainPage).click();
    }
    @Step("Нажатие по кнопке \"Конструктор\"")
    public void clickConstructorButtonMainPage(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }
    @Step("Нажатие по лого")
    public void clickLogoButtonMainPage(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(logo));
        driver.findElement(logo).click();
    }
    @Step("Нажатие по кнопке \"выход\" в личном кабинете")
    public void clickExitButtonInAccountSettings(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }
    @Step("Переход в раздел \"булки\"")
    public void clickBunsChapter(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(bunsChapter));
        driver.findElement(bunsChapter).click();
    }
    @Step("Переход в раздел \"соусы\"")
    public void clickSaucesChapter(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(saucesChapter));
        driver.findElement(saucesChapter).click();
    }
    @Step("Переход в раздел \"начинки\"")
    public void clickFillingChapter(){
        new WebDriverWait(driver,3).until(ExpectedConditions.elementToBeClickable(fillingsChapter));
        driver.findElement(fillingsChapter).click();
    }
    @Step("Проверка, что отображается кнопка \"оформить заказ\"")
    public boolean checkOrderButtonMainPage() {
        WebElement orderButtonElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(makeOrderButton));
        return orderButtonElement.isDisplayed();
    }
    @Step("Проверка, что отображается кнопка \"выход из аккаунта\"")
    public boolean checkExitButtonInAccountSettings() {
        WebElement exitButtonElement = new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(exitButton));
        return exitButtonElement.isDisplayed();
    }
    @Step("Проверка, что активен раздел \"Булки\"")
    public boolean checkActiveBunsChapter() {
        return driver.findElement(currentChapterBuns).isDisplayed();
    }
    @Step("Проверка, что активен раздел \"Cоусы\"")
    public boolean checkActiveSauceChapter() {
        return driver.findElement(currentChapterSauces).isDisplayed();
    }
    @Step("Проверка, что активен раздел \"Начинки\"")
    public boolean checkActiveFillingsChapter() {
        return driver.findElement(currentChapterFillings).isDisplayed();
    }

}
