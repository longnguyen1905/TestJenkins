package potslotty.steps.bases;

import constants.ConstantGlobal;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.*;

import static keywords.Keyword.*;

public class StepsHeader {
    private CommonPage commonPage;
    private TournamentPage tournamentPage;
    private ResultsPage resultsPage;
    private UpcomingPage upcomingPage;
    private EarnPage earnPage;
    private HomePage homePage;
    private ProfilePage profilePage;
    private TermAndConPage termAndConPage;
    private DepositPage depositPage;
    private SearchPage searchPage;

    public StepsHeader(){
        commonPage = new CommonPage();
        tournamentPage = new TournamentPage();
        homePage = new HomePage();
        upcomingPage = new UpcomingPage();
        profilePage = new ProfilePage();
        termAndConPage = new TermAndConPage();
        depositPage = new DepositPage();
        searchPage = new SearchPage();
    }


    @Given("user stayed at homepage")
    public void userStayedAtHomepage() {
        waitForPageLoaded();
//        verifyURL(ConstantGlobal.URL);
    }

    @When("user click on tournaments")
    public void userClickOnTournaments() {
        tournamentPage = commonPage.clickTournaments();
    }

    @Then("user will be redirected to tournament page")
    public void userWillBeRedirectedToTournamentPage() {

    }

    @And("user can see the running tournaments")
    public void userCanSeeTheRunningTournaments() {
        tournamentPage.userCanSeeTheTournamentsList();
    }

    @When("user click on results")
    public void userClickOnResults() {
        resultsPage = commonPage.clickResults();
    }
    @Then("user will be redirected to results page")
    public void userWillBeRedirectedToResultsPage() {
        resultsPage.userCanSeeAllResultsLabel();
    }

    @And("user can see the ending tournaments")
    public void userCanSeeTheEndingTournaments() {
        resultsPage.userCanSeeEndingTournaments();
    }

    @When("user click on upcoming")
    public void userClickOnUpcoming() {
        upcomingPage = commonPage.clickUpcoming();
    }

    @Then("user will be redirected to upcoming page")
    public void userWillBeRedirectedToUpcomingPage() {
    }

    @And("user can see the upcoming tournaments")
    public void userCanSeeTheUpcomingTournaments() {
        upcomingPage.userCanSeeUpcomingTitle();
    }

    @When("user click on earn")
    public void userClickOnEarn() {
        earnPage = commonPage.clickEarn();
    }

    @Then("user will be redirected to earn page")
    public void userWillBeRedirectedToEarnPage() {
    }

    @And("user can see the referral section")
    public void userCanSeeTheReferralSection() {
        earnPage.userCanSeeEarnTitle();
    }

    @Then("user can see footer")
    public void userCanSeeFooter() {
        verifyContainText(commonPage.reserved,"All rights Reserved");
        verifyContainText(commonPage.termAndCon,"Terms and Conditions");
        verifyContainText(commonPage.support,"Support");
    }

    @Then("user will be redirected to term and condition page")
    public void userWillBeRedirectedToTermAndConditionPage() {
        termAndConPage.userWillBeRedirectedToTermAndConditionPage();
    }

    @When("user click on term and condition")
    public void userClickOnTermAndCondition() {
        termAndConPage = commonPage.clickOnTermAndCondition();
    }

    @Then("user will be redirected to deposit page")
    public void userWillBeRedirectedToDepositPage() {
    }

    @And("user can see the deposit section")
    public void userCanSeeTheDepositSection() {
        depositPage.userCanSeeDepositSection();
    }

    @Then("user will be redirected to search page")
    public void userWillBeRedirectedToSearchPage() {
    }

    @And("user can see the search section")
    public void userCanSeeTheSearchSection() {
        searchPage.userCanSeeSearchInput();
    }

    @Then("user will be redirected to profile page")
    public void userWillBeRedirectedToProfilePage() {
    }

    @And("user can see the profile player")
    public void userCanSeeTheProfilePlayer() {
        profilePage.verifyProfilePlayer();
    }

    @When("user click on deposit")
    public void userClickOnDeposit() {
        depositPage = commonPage.clickOnDeposit();
    }

    @When("user click on profile")
    public void userClickOnProfile() {
        profilePage = commonPage.clickOnProfile();
    }

    @When("user click on search header")
    public void userClickOnSearchHeader() { searchPage = commonPage.clickOnSearchIcon();
    }
}

