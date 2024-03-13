package registration;

import api.User;
import api.Generator;
import driverSelection.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import object.Login;
import object.Registration;
import object.MainPage;

import static org.junit.Assert.assertTrue;

public class UserRegErrorTest {
    private static User user;
    private WebDriver driver;
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
        user = Generator.getFaker();
        user.setPassword("12");
    }

    @Test
    @DisplayName("Регистрация с ошибкой")
    public void userRegErrorTest() throws InterruptedException {
        MainPage stellarBurgers = new MainPage(driver);
        stellarBurgers.clickMainPageLogin();
        Login loginPage = new Login(driver);
        loginPage.clickRegistrationPath();
        Registration registerPage = new Registration(driver);
        assertTrue(registerPage.errorRegistrationClient(user));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
