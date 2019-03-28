package pageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ResultPage extends BasePage {
    private final By numberOfSearchingResultLocator = By.id("resultStats");
    private final By numberOfResultElementsLocator = By.xpath("//div[@class='rc']");

    public final int numberToCompare = 100000000;
    public final int numberOfElementsToCompare = 9;


    public void waitPageLoaded () {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(numberOfSearchingResultLocator));
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

    public int numberOfSearchingResult(){
        String numberOfSearchingResultText = driver.findElement(numberOfSearchingResultLocator).getText();
        String tempText = numberOfSearchingResultText.replaceAll("\\D+","");
        int numberOfSearchingResult = Integer.parseInt(tempText.substring(0,tempText.length()-3));

        if (numberOfSearchingResult > numberToCompare){
            Allure.addAttachment("Number of Searching Result", "MORE then " + numberToCompare);
        }else {
            Allure.addAttachment("Number of Searching Result", "LESS then " + numberToCompare);
        }

        return numberOfSearchingResult;
    }

    public int numberOfElementsOnPage (){
        int numberOfElementsOnPage = driver.findElements(numberOfResultElementsLocator).size();

        if (numberOfElementsOnPage > numberOfElementsToCompare){
            Allure.addAttachment("Number of Elements Result on Page", "MATCH " + numberOfElementsToCompare);
        }else {
            Allure.addAttachment("Number of Elements Result on Page", "NOT match " + numberOfElementsToCompare);
        }

        return numberOfElementsOnPage;
    }
}

