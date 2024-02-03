package ru.praktikum.yandex.ui.pageobject;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.yandex.api.client.UserClient;
import ru.praktikum.yandex.api.step.ClientSteps;
import ru.praktikum.yandex.ui.pageobject.BasePage;

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


        // 1: Запуск браузера отдельно напрямую
//        System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver");// + "src/test/resources/yandexdriver_1");
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();


        // 2: Запуск браузера через switch
//        String browser = "yandex";
        switch (System.getProperty("browser", "yandex")) {
//        switch (browser) {
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
