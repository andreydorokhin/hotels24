package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class GooglePage extends BasePage{
    private final By textbox = By.name("q");

    public void sendKeys() {
        driver.findElement(textbox).sendKeys(settings.getDetectedText());

    }

    public ResultPage showResults() {
        driver.findElement(textbox).submit();

        System.out.println("word '"+settings.getDetectedText()+"' Entered in Textbox and Submited");
        Allure.addAttachment("MainPage "+settings.getBaseURL()+"", "word "+ settings.getDetectedText() + " Entered in Textbox and Submited");

        return new ResultPage();
    }

    public void navigateTo(String stringUrl) {
        super.navigateTo(stringUrl);

    }
}
