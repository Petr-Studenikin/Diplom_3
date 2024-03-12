package driverSelection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import static api.BaseUrl.URL;
import static api.WebDriverConfig.SECONDS_TIMEOUT;

public class WebDriverFactory {
    public static WebDriver get() {
        WebDriver driver;

        Properties prop = new Properties();try {
            prop.load(new FileInputStream("src/test/browser.properties"));} catch (IOException e) {
            throw new RuntimeException(e);}
        String browserName = prop.getProperty("browser");

        if (browserName == null) {browserName = "yandex";}

        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/yandexdriver.exe");
                ChromeOptions optionsYa = new ChromeOptions();
                optionsYa.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(optionsYa);
                driver.manage().window().maximize();
                break;
            default: throw new RuntimeException("Browser " + browserName + " not exist");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(SECONDS_TIMEOUT));
        driver.navigate().to(URL);
        return driver;
    }
}
