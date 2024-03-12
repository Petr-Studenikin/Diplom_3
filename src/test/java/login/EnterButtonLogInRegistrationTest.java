package login;

import api.User;
import api.UserClient;
import api.UserDetails;
import api.Generator;
import driverSelection.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import object.Login;
import object.Registration;
import object.MainPage;

import static org.junit.Assert.assertTrue;

public class EnterButtonLogInRegistrationTest {
    private UserClient userClient;
    private static User user;
    private String accessToken;
    private WebDriver driver;
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
        userClient = new UserClient();
        user = Generator.getFaker();
        ValidatableResponse createResponse = userClient.create(user);
        accessToken = createResponse.extract().path("accessToken");
        accessToken = accessToken.replace("Bearer ", "");
    }

    @Test
    @DisplayName("Входа по кнопке в форме регистрации")
    public void enterButtonLogInRegistrationTest() throws InterruptedException {
        MainPage stellarBurgers = new MainPage(driver);
        stellarBurgers.clickMainPageLogin();
        Login loginPage = new Login(driver);
        loginPage.clickRegistrationPath();
        Registration registerPage = new Registration(driver);
        registerPage.clickEnterButton();
        assertTrue(loginPage.positiveInput(UserDetails.from(user)));
    }
    @After
    public void teardown() {
        userClient.delete(accessToken);
        driver.quit();
    }
}
