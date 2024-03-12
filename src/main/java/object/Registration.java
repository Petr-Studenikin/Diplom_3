package object;

import api.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Registration {
    private final WebDriver driver;
    private final By userNameReg = By.xpath(".//*[@class='text input__textfield text_type_main-default' and @name='name']");
    private final By userEmailReg = By.xpath("(.//*[@class='text input__textfield text_type_main-default'])[2]");
    private final By userPasswordReg = By.xpath(".//*[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By EnterText = By.xpath(".//*[text()='Вход']");
    private final By RegisterButton = By.xpath(".//*[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//*[@class='Auth_link__1fOlj' and text()='Войти']");
    private final By invalidPasswordText = By.xpath(".//*[@class='input__error text_type_main-default' and text()='Некорректный пароль']");

    public Registration(WebDriver driver) {
        this.driver = driver;
    }
    public Registration setUserNameReg(String name) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(userNameReg).sendKeys(name);
        return this;
    }
    public Registration setUserEmailReg(String email) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(userEmailReg).sendKeys(email);
        return this;
    }
    public Registration setUserPasswordReg(String password) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(userPasswordReg).sendKeys(password);
        return this;
    }
    public Registration clickRegisterButton() {
        driver.findElement(RegisterButton).click();
        return this;
    }
    public Registration clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }
    public boolean successRegistrationClient(User user) throws InterruptedException {
        setUserNameReg(user.getName());
        setUserEmailReg(user.getEmail());
        setUserPasswordReg(user.getPassword());
        WebElement element = driver.findElement(RegisterButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(700);
        clickRegisterButton();
        return driver.findElement(EnterText).isEnabled();
    }
    public boolean errorRegistrationClient(User user) throws InterruptedException {
        setUserNameReg(user.getName());
        setUserEmailReg(user.getEmail());
        setUserPasswordReg(user.getPassword());
        WebElement element = driver.findElement(RegisterButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(700);
        clickRegisterButton();
        return driver.findElement(invalidPasswordText).isEnabled();
    }
}
