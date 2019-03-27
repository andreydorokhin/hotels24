package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class DriverProvider {
    private static DriverProvider INSTANCE = null;
    private WebDriver driver = null;

    private DriverProvider() {
        Settings settings = SettingsProvider.getInstance().getSettings();
        if (settings.getBrowser().equalsIgnoreCase("mozilla")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (settings.getBrowser().equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
        }
    }

    public static DriverProvider get() {
        if(INSTANCE == null){
            INSTANCE = new DriverProvider();
        }
        return INSTANCE;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

}