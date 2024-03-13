package object;

import api.UserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private final WebDriver driver;
    private final By registrationPath = By.xpath(".//*[@class='Auth_link__1fOlj' and @href='/register']");
    private final By emailPath = By.xpath(".//*[@class='text input__textfield text_type_main-default' and @name='name']");
    private final By passwordPath = By.xpath(".//*[@class='text input__textfield text_type_main-default' and @name='Пароль']");
    private final By enterPath = By.xpath(".//*[text()='Войти']");
    private final By placeOrderPath = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    private final By recoverPasswordEnterPath = By.xpath(".//*[@class='Auth_link__1fOlj' and text()='Войти']");
    private final By recoverPasswordPath = By.xpath(".//*[@class='Auth_link__1fOlj' and text()='Восстановить пароль']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }
    public Login setEmail(String email) {
        driver.findElement(emailPath).sendKeys(email);
        return this;
    }
    public Login setPassword(String password) {
        driver.findElement(passwordPath).sendKeys(password);
        return this;
    }
    public Login clickEnter() {
        driver.findElement(enterPath).click();
        return this;
    }
    public Login clickRecoverPassword() {
        driver.findElement(recoverPasswordPath).click();
        return this;
    }
    public Login clickRecoverPasswordEnter() {
        driver.findElement(recoverPasswordEnterPath).click();
        return this;
    }
    public Login clickRegistrationPath() throws InterruptedException {
        WebElement element = driver.findElement(registrationPath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);
        driver.findElement(registrationPath).click();
        return this;
    }
    public boolean positiveInput(UserDetails userCredentials) throws InterruptedException {
        setEmail(userCredentials.getEmail());
        setPassword(userCredentials.getPassword());
        clickEnter();
        Thread.sleep(1000);
        return driver.findElement(placeOrderPath).isEnabled();
    }
    public boolean loginPage() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(enterPath).isEnabled();
    }
}
