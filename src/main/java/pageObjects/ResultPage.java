package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends BasePage {
    private final By nextPageResultButton = By.id("pnnext");

    public void waitPageLoaded () {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(nextPageResultButton));
    }

    public boolean isExpectDomainOnSearchingResult(String expectedDomain) {
        boolean isExpectDomain = false;

        if (driver.getPageSource().contains(expectedDomain))
            isExpectDomain = true;

        if (isExpectDomain){
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is On Result");
        }else {
            Allure.addAttachment("ResultPage is Expect Domain On Searching Result", "Expect Domain is NOT On Result");
        }

        return isExpectDomain;
    }
}

