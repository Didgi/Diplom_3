package ru.praktikum.yandex.ui.pageobject;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.yandex.api.client.UserClient;
import ru.praktikum.yandex.api.step.ClientSteps;


public class SignUpPageTest extends BaseTest {
    private final Faker faker = new Faker();
    private final String name = faker.name().name();
    private final String email = faker.internet().emailAddress();
    private final String passwordLessSixSymbols = faker.internet().password(1, 5);
    private final String passwordMoreSixSymbols = faker.internet().password(6, 12);

//    @Before
//    public void setUp() {
//        clientSteps = new ClientSteps(new UserClient());
//        signUpPage = new SignUpPage(driver);
//        basePage = new BasePage(driver);
//    }

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    @Description("В этом тесте проверяется успешная регистрация пользователя, где проверяется, что происходит переход на следующую страницу и отображется кнопка войти")
    public void createUserPositiveShowsOk() {
        basePage.openSignUpPage();
        signUpPage.setName(name);
        signUpPage.setEmail(email);
        signUpPage.setPassword(passwordMoreSixSymbols);
        signUpPage.clickRegisterButton();
        Assert.assertTrue(signUpPage.checkSuccessfulRegistration());
        clientSteps.addClientsDataToClear(clientSteps.setAccessToken(clientSteps.loginClient(email, passwordMoreSixSymbols)));

    }

    @Test
    @DisplayName("Проверка запрета регистрации пользователя при вводе пароля меньше 6 символов")
    @Description("В этом тесте проверяется запрет регистрации пользователя при вводе пароля меньше 6 символов. Проверяется, что отображается текст с ошибкой")
    public void createUserNegativePasswordLessSixSymbolsShowsError() {
        basePage.openSignUpPage();
        signUpPage.setName(name);
        signUpPage.setEmail(email);
        signUpPage.setPassword(passwordLessSixSymbols);
        signUpPage.clickRegisterButton();
        Assert.assertTrue(signUpPage.checkLengthPassword());
    }

    @Test
    @DisplayName("Проверка запрета регистрации пользователя при вводе пустого пароля")
    @Description("В этом тесте проверяется запрет регистрации пользователя при вводе пустого пароля. Проверяется, что отображается текст с ошибкой")
    @Issue("BUG-1")
    //указал дефектом, т.к. ожидаю, что даже если пароль не указан, то при нажатии на кнопку
    //зарегистрироваться должна срабатывать валидация говорящая о минимальной длине пароля
    public void createUserNegativeEmptyPasswordShowsError() {
        basePage.openSignUpPage();
        signUpPage.setName(name);
        signUpPage.setEmail(email);
        signUpPage.setPassword("");
        signUpPage.clickRegisterButton();
        Assert.assertTrue(signUpPage.checkLengthPassword());
    }
}
