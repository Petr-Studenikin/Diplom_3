package constructor;

import driverSelection.WebDriverFactory;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import object.MainPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SelectionIngredientTest {
    private WebDriver driver;
    @Parameterized.Parameter
    public String ingredient;

    @Parameterized.Parameters(name = "{index}: данные")
    public static Object[] ingredientData() {
        return new Object[] {"Булки", "Соусы", "Начинки"};
    }
    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    @Test
    @DisplayName("Переходы к разделам Булки, Соусы, Начинки")
    public void selectionIngredientTest() throws InterruptedException {
        MainPage stellarBurgers = new MainPage(driver);
        assertEquals(ingredient, stellarBurgers.switchIngredient(ingredient));
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
