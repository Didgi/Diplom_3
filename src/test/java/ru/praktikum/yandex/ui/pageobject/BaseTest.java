package ru.praktikum.yandex.ui.pageobject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.yandex.api.client.UserClient;
import ru.praktikum.yandex.api.step.ClientSteps;

public class BaseTest {
    protected WebDriver driver;
    protected ClientSteps clientSteps;
    protected SignUpPage signUpPage;
    protected SignInPage signInPage;
    protected MainPage mainPage;
    protected BasePage basePage;

    public BaseTest() {
    }

    @Before
    public void setUpAll() {

        switch (System.getProperty("browser", "yandex")) {
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
        basePage = new BasePage(driver);
        mainPage = new MainPage(driver);
        clientSteps = new ClientSteps(new UserClient());
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);

    }
    @After
    public void tearDown() {
        driver.quit();
        clientSteps.clearTestClientsData();
    }

}
