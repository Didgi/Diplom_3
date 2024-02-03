package ru.praktikum.yandex.ui.pageobject;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignInTest extends BaseTest {
    private final Faker faker = new Faker();
    private final String name = faker.name().name();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password(6, 12);

    @Before
    public void setUp() {
        clientSteps.addClientsDataToClear(clientSteps.setAccessToken(clientSteps.createClient(email, password, name)));
    }

    @Test
    @DisplayName("Логин пользователем через кнопку \"Войти в аккаунт\"")
    @Description("В тесте проверяется логин пользователем через кнопку \"Войти в аккаунт\" расположенной на главной странице")
    public void signViaByAccountButtonMainPageShowsOk() {
        basePage.openMainPage();
        mainPage.enterByAccountEnterButtonMainPage();
        signInPage.setEmail(email);
        signInPage.setPassword(password);
        signInPage.clickEnterButton();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());

    }

    @Test
    @DisplayName("Логин пользователем через кнопку \"Войти в личный кабинет\"")
    @Description("В тесте проверяется логин пользователем через кнопку \"Войти в личный кабинет\" расположенной на главной странице")
    public void signInViaPersonalAccountButtonMainPageShowsOk() {
        basePage.openMainPage();
        mainPage.enterByPersonalAccountEnterButtonMainPage();
        signInPage.setEmail(email);
        signInPage.setPassword(password);
        signInPage.clickEnterButton();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());

    }

    @Test
    @DisplayName("Логин пользователем через кнопку \"Войти\" в форме регистрации")
    @Description("В тесте проверяется логин пользователем через кнопку \"Войти\" расположенной на странице регистрации")
    public void signInViaEnterButtonSignUpPageShowsOk() {
        basePage.openSignUpPage();
        signUpPage.enterButtonRestorePasswordOrSignUpPage();
        signInPage.setEmail(email);
        signInPage.setPassword(password);
        signInPage.clickEnterButton();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());

    }

    @Test
    @DisplayName("Логин пользователем через кнопку \"Войти\" в форме восстановления пароля")
    @Description("В тесте проверяется логин пользователем через кнопку \"Войти\" расположенной на странице восстановления пароля")
    public void signInViaEnterButtonRestorePasswordPageShowsOk() {
        basePage.openRecoveryPasswordPage();
        signUpPage.enterButtonRestorePasswordOrSignUpPage();
        signInPage.setEmail(email);
        signInPage.setPassword(password);
        signInPage.clickEnterButton();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());

    }
}
