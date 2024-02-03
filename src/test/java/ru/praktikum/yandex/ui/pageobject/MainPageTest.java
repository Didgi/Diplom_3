package ru.praktikum.yandex.ui.pageobject;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.yandex.api.client.UserClient;
import ru.praktikum.yandex.api.step.ClientSteps;

public class MainPageTest extends BaseTest {
    private final Faker faker = new Faker();
    private final String name = faker.name().name();
    private final String email = faker.internet().emailAddress();
    private final String password = faker.internet().password(6, 12);
//    private ClientSteps clientSteps;
//    private SignUpPage signUpPage;
//    private SignInPage signInPage;
//    private MainPage mainPage;
//    private BasePage basePage;
//    protected ClientSteps clientSteps;// = new ClientSteps(new UserClient());;
//    protected SignUpPage signUpPage;
//    protected SignInPage signInPage;
//    protected MainPage mainPage;
//    protected BasePage basePage;

    @Before
    public void setUp(){
        clientSteps.addClientsDataToClear(clientSteps.setAccessToken(clientSteps.createClient(email, password, name)));
        basePage.openMainPage();
        mainPage.enterByAccountEnterButtonMainPage();
        signInPage.setEmail(email);
        signInPage.setPassword(password);
        signInPage.clickEnterButton();

    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    @Description("В тесте проверяется переход в личный кабинет через кнопку \"Личный кабинет\" расположенной на главной странице")
    public void enterPersonalAccountSettingsShowsOk(){
        mainPage.enterByPersonalAccountEnterButtonMainPage();
        Assert.assertTrue(mainPage.checkExitButtonInAccountSettings());

    }
    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор кликом по кнопке конструктора")
    @Description("В тесте проверяется переход из личного кабинета в конструктор расположенный на главной странице")
    public void transitionFromPersonalAccountSettingsToConstructorViaClickConstructorShowsOk(){
        mainPage.enterByPersonalAccountEnterButtonMainPage();
        mainPage.clickConstructorButtonMainPage();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());

    }
    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор кликом по лого")
    @Description("В тесте проверяется переход из личного кабинета в конструктор расположенный на главной странице")
    public void transitionFromPersonalAccountSettingsToConstructorViaClickLogoShowsOk(){
        mainPage.enterByPersonalAccountEnterButtonMainPage();
        mainPage.clickLogoButtonMainPage();
        Assert.assertTrue(mainPage.checkOrderButtonMainPage());
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта через личный кабинет")
    @Description("В тесте проверяется выход из аккаунта через личный кабинет")
    public void logOutFromPersonalAccountSettingsShowsOk(){
        mainPage.enterByPersonalAccountEnterButtonMainPage();
        mainPage.clickExitButtonInAccountSettings();
        Assert.assertTrue(signUpPage.checkSuccessfulRegistration());
    }
    @Test
    @DisplayName("Проверка перехода в раздел Соусы в конструкторе")
    @Description("В тесте проверяется переход в раздел Соусы в конструкторе на главной странице")
    public void transitionToSaucesChapterInConstructorShowsOk(){
        mainPage.clickSaucesChapter();
        Assert.assertTrue(mainPage.checkActiveSauceChapter());
    }
    @Test
    @DisplayName("Проверка перехода в раздел Булки в конструкторе")
    @Description("В тесте проверяется переход в раздел Булки в конструкторе на главной странице")
    public void transitionToBunsChapterInConstructorShowsOk(){
        mainPage.clickSaucesChapter();
        mainPage.clickBunsChapter();
        Assert.assertTrue(mainPage.checkActiveBunsChapter());
    }
    @Test
    @DisplayName("Проверка перехода в раздел Начинки в конструкторе")
    @Description("В тесте проверяется переход в раздел Начинки в конструкторе на главной странице")
    public void transitionToFillingsChapterInConstructorShowsOk(){
        mainPage.clickFillingChapter();
        Assert.assertTrue(mainPage.checkActiveFillingsChapter());
    }
//    @After
//    public void cleanData() {
//        clientSteps.clearTestClientsData();
//    }

}
