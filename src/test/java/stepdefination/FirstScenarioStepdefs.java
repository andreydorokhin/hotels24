package stepdefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.BasePage;
import pageObjects.GooglePage;
import pageObjects.ResultPage;

public class FirstScenarioStepdefs {

    private GooglePage googlePage;
    private ResultPage resultPage;
    private Boolean isLinkOnResultsPage;

    @Given("^User navigates to the google page$")
    public void userNavigatesToTheGooglePage() {
        googlePage = new GooglePage();
        googlePage.navigateTo(BasePage.settings.getBaseURL());
    }

    @When("^User submit searching word$")
    public void userSubmitSearchingWord() {
        googlePage.sendKeys();
    }

    @Then("^Result page should be shown$")
    public void resultPageShouldBeShown() {
        resultPage = googlePage.showResults();
    }

    @Given("^User is on result page$")
    public void userIsOnResultPage() {
        resultPage.waitPageLoaded();
    }
    @When("^User is searching specific link on results pages$")
    public void userIsSearchingSpecificLinkOnResultsPages() {
        isLinkOnResultsPage = resultPage.isExpectDomainOnSearchingResult(BasePage.settings.getDomain());
        Assert.assertTrue(isLinkOnResultsPage);
        System.out.println("isLinkOnResultsPage = " + isLinkOnResultsPage);
    }

    @And("^User is searching number of results$")
    public void userIsSearchingNumberOfResults() {
        System.out.println("User is searching number of results");
    }

    @And("^User is searching number of results on first page$")
    public void userIsSearchingNumberOfResultsOnFirstPage() {
        System.out.println("User is searching number of results on first page");
    }

    @Then("^detected result page$")
    public void detectedResultPage() {
        System.out.println("detected result page");
    }
}
