package potslotty.steps.bases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.*;

public class StepsResults {
    private CommonPage commonPage;
    private ResultsPage resultsPage;
    private UpcomingPage upcomingPage;

    public StepsResults() {
        commonPage = new CommonPage();
        upcomingPage = new UpcomingPage();
    }

    @Then("user can see all results")
    public void userCanSeeAllResults() {
        resultsPage.userCanSeeAllResultsLabel();
        resultsPage.userCanSeeEndingTournaments();
    }

    @When("user click on results page")
    public void userClickOnResultsPage() {
        resultsPage = commonPage.clickResults();
    }

    @Then("user can see each detail results tournament")
    public void userCanSeeEachDetailResultsTournament() {
        resultsPage.userCanSeeEachDetailTournament();
    }

    @Then("user can see detail first results")
    public void userCanSeeDetailFirstResults() {
        resultsPage.userCanSeeDetailFirstResults();
    }

    @And("user click first tournament")
    public void userClickFirstTournament() {
    }
}

