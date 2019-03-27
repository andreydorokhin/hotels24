package pageObjects;

import config.DriverProvider;
import config.Settings;
import config.SettingsProvider;
import org.openqa.selenium.WebDriver;

public class BasePage {
    final WebDriver driver = DriverProvider.get().getWebDriver();
    public final static Settings settings = SettingsProvider.getInstance().getSettings();

    void navigateTo(String stringUrl) {
        driver.get(stringUrl);

    }
}
