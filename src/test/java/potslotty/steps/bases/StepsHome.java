package potslotty.steps.bases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.HomePage;
import potslotty.pages.LoginPage;
import potslotty.pages.TournamentPage;

public class StepsHome {
    private HomePage homePage;
    private CommonPage commonPage;
    private LoginPage loginPage;
    private TournamentPage tournamentPage;

    public StepsHome(){
        homePage = new HomePage();
        commonPage = new CommonPage();
        loginPage = new LoginPage();
        tournamentPage = new TournamentPage();
    }
    @When("user scroll end of page")
    public void userScrollEndOfPage() {

    }
    @Then("user can see banner")
    public void userCanSeeBanner() {
        homePage.userCanSeeBanner();
    }
    @When("user scroll begin page")
    public void userScrollBeginPage() {
    }

    @When("user choose one game")
    public void userChooseOneGame() {
    }

    @When("user click first game")
    public void userClickFirstGame() {
        homePage.userClickFirstGame();
    }

    @Then("user can play any game")
    public void userCanPlayAnyGame() {
        homePage.userCanPlayAllGame();
    }

    @Then("user can play first game")
    public void userCanPlayFirstGame() {
        homePage.userCanPlayFirstGame();
    }

    @When("user scroll to begin page")
    public void userScrollToBeginPage() {
    }

    @When("user click on open game")
    public void userClickOnOpenGame() {
        homePage.userClickFirstGame();
        homePage.clickOpenGame();
    }

    @Then("user can see pop up please login")
    public void userCanSeePopUpPleaseLogin() {
        homePage.userCanSeePopUpPleaseLogin();
    }

    @And("user click on continue")
    public void userClickOnContinue() {
        homePage.clickBtnContinue();
    }

    @Then("user back to home page")
    public void userBackToHomePage() {
        homePage.userCanSeeBanner();
    }

    @And("user click on login")
    public void userClickOnLogin() {
        homePage.clickBtnLogin();
    }

    @Then("user can see popup login")
    public void userCanSeePopupLogin() {
        loginPage.verifyPopupLogin();
    }

    @When("user click on image game")
    public void userClickOnImageGame() {
        homePage.userClickFirstGame();
    }

    @When("user click on deposit button")
    public void userClickOnDepositButton() {
        homePage.userClickFirstGame();
        homePage.clickBtnDeposit();
    }

    @Then("user can see wallet section")
    public void userCanSeeWalletSection() {
    }


    @Then("user can see two button deposit and open game")
    public void userCanSeeTwoButtonDepositAndOpenGame() {
        homePage.verifyButtonOnNewGame();
    }

    @When("user click play on banner")
    public void userClickPlayOnBanner() {
        homePage.clickPlayOnBanner();
    }

    @Then("user can play game")
    public void userCanPlayGame() {
        homePage.loadedGameSuccess();
    }

    @When("user click on tournament banner")
    public void userClickOnTournamentBanner() {
        homePage.clickBannerTournament();
    }

    @Then("user redirect to tournament")
    public void userRedirectToTournament() {
        tournamentPage.userCanSeeTheTournamentsList();
    }
}
