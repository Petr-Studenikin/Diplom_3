package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriver driver;

    private final By mainPageLogin = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    private final By personAccount = By.xpath(".//*[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Личный Кабинет']");
    private final By placeOrder = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    private final By mainPageBun = By.xpath(".//*[@class='text text_type_main-default' and text()='Булки']");
    private final By mainPageSauce = By.xpath(".//*[@class='text text_type_main-default' and text()='Соусы']");
    private final By mainPageFilling = By.xpath(".//*[@class='text text_type_main-default' and text()='Начинки']");
    private final By mainPageIngredient = By.xpath(".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage clickMainPageLogin() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(mainPageLogin).click();
        return this;
    }
    public MainPage clickPersonAccount() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(personAccount).click();
        return this;
    }
    public boolean checkPlaceOrder() throws InterruptedException {
        Thread.sleep(700);
        return driver.findElement(placeOrder).isEnabled();
    }
    public String switchIngredient(String ingredient) throws InterruptedException {
        Thread.sleep(3000);
        switch (ingredient) {
            case "Булки":
                if (!(driver.findElement(mainPageBun).isEnabled())) {
                    driver.findElement(mainPageBun).click();}
                break;
            case "Соусы":
                driver.findElement(mainPageSauce).click();
                break;
            case "Начинки":
                driver.findElement(mainPageFilling).click();
                break;
        }
        return driver.findElement(mainPageIngredient).getText();
    }

}
