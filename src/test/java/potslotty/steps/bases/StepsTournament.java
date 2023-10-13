package potslotty.steps.bases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.TournamentPage;

public class StepsTournament {
    private CommonPage commonPage;
    private TournamentPage tournamentPage;

    public StepsTournament(){
        commonPage = new CommonPage();
        tournamentPage = new TournamentPage();
    }

    @Given("user navigate tournament page")
    public void userNavigateTournamentPage() {
        tournamentPage = commonPage.clickTournaments();
    }

    @When("user select TON")
    public void userSelectTON() {
        commonPage.switchToTonWallet();
    }

    @Then("user must not see any currencies except TON")
    public void userMustNotSeeAnyCurrenciesExceptTON() {
        tournamentPage.userMustNotSeeAnyCurrenciesExceptTON();

    }

    @Then("user must not see any currencies except MYR")
    public void userMustNotSeeAnyCurrenciesExceptMYR() {
        tournamentPage.userMustNotSeeAnyCurrenciesExceptMYR();
    }

    @When("user select VND")
    public void userSelectVND() {
        commonPage.switchToVNDWallet();
    }

    @Then("user must not see any currencies except VND")
    public void userMustNotSeeAnyCurrenciesExceptVND() {
        tournamentPage.userMustNotSeeAnyCurrenciesExceptVND();
    }

    @Then("user see payout section {string}")
    public void userSeePayoutSection(String s) {
        tournamentPage.userSeePayoutSection(s);
    }

    @When("user click tournament dropdown list")
    public void userClickTournamentDropdownList() {
        tournamentPage.clickDropdownList();
    }

    @Then("user can see the dropdown list options")
    public void userCanSeeTheDropdownListOptions() {
        tournamentPage.userCanSeeTheDropdownListOptions();
    }


    @And("user click Daily")
    public void userClickDaily() {
        tournamentPage.clickDaily();
    }

    @Then("user only see daily tournaments")
    public void userOnlySeeDailyTournaments() {
        tournamentPage.userOnlySeeDailyTournaments();
    }

    @And("user click Weekly")
    public void userClickWeekly() {
        tournamentPage.clickWeekly();
    }

    @Then("user only see weekly tournaments")
    public void userOnlySeeWeeklyTournaments() {
    }

    @And("user click Monthly")
    public void userClickMonthly() {
        tournamentPage.clickMonthly();
    }

    @Then("user only see monthly tournaments")
    public void userOnlySeeMonthlyTournaments() {
    }

    @When("user click exclamation mark icon on banner")
    public void userClickExclamationMarkIconOnBanner() {
        tournamentPage.clickExclamationMarkIconBanner();
    }

    @Then("user can see tournament details")
    public void userCanSeeTournamentDetails() {
        tournamentPage.userCanSeeTournamentDetails();
    }

    @When("user click exclamation mark icon of first tournament")
    public void userClickExclamationMarkIconOfFirstTournament() {
        tournamentPage.clickFirstTournament();
    }

    @Then("user can see information tournament detail")
    public void userCanSeeInformationTournamentDetail() {
        tournamentPage.userCanSeeInformationTournament(1);
    }

    @Then("user can see prize pool tournament detail")
    public void userCanSeePrizePoolTournamentDetail() {
        tournamentPage.userCanSeeTopPlayer(1);
        tournamentPage.userCanSeePrizePoolDetail(1);
    }

    @Then("user can see leader board tournament detail")
    public void userCanSeeLeaderBoardTournamentDetail() {
        tournamentPage.userCanSeeDetailLeaderBoard(1);
    }
}
