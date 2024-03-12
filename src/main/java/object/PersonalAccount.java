package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccount {
    private final WebDriver driver;
    private final By stellarBurgerLogoPath = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private final By constructorButtonPath = By.xpath(".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']");
    private final By exitButtonPath = By.xpath(".//*[text()='Выход']");
    public PersonalAccount(WebDriver driver) {
        this.driver = driver;
    }
    public PersonalAccount clickStellarBurgerLogo() {
        driver.findElement(stellarBurgerLogoPath).click();
        return this;
    }
    public PersonalAccount clickConstructorButton() {
        driver.findElement(constructorButtonPath).click();
        return this;
    }
    public PersonalAccount clickExitButton() {
        driver.findElement(exitButtonPath).click();
        return this;
    }
    public boolean successEnterPersonalAccount() throws InterruptedException {
        Thread.sleep(700);
        return driver.findElement(exitButtonPath).isEnabled();
    }
}
