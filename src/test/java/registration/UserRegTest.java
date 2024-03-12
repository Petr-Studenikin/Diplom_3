package registration;


import api.User;
import api.UserClient;
import api.UserDetails;
import api.Generator;
import driverSelection.WebDriverFactory;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import object.Login;
import object.Registration;
import object.MainPage;

import static org.junit.Assert.assertTrue;

public class UserRegTest {
    private UserClient userClient;
    private static User user;
    private String accessToken;
    private WebDriver driver;
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
        userClient = new UserClient();
        user = Generator.getFaker();
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void userRegTest() throws InterruptedException {
        MainPage stellarBurgers = new MainPage(driver);
        stellarBurgers.clickMainPageLogin();
        Login loginPage = new Login(driver);
        loginPage.clickRegistrationPath();
        Registration registerPage = new Registration(driver);
        assertTrue(registerPage.successRegistrationClient(user));
    }
    @After
    public void teardown() {
        ValidatableResponse loginResponse = userClient.login(UserDetails.from(user));
        accessToken = loginResponse.extract().path("accessToken");
        accessToken = accessToken.replace("Bearer ", "");
        userClient.delete(accessToken);
        driver.quit();
    }
}
