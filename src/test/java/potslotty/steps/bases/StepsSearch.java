package potslotty.steps.bases;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.HomePage;
import potslotty.pages.SearchPage;

import java.util.List;
import java.util.Map;


public class StepsSearch {
    private SearchPage searchPage;
    private CommonPage commonPage;
    private HomePage homePage;

    public StepsSearch() {
        searchPage = new SearchPage();
        commonPage = new CommonPage();
        homePage = new HomePage();
    }

    @Then("user can see game publisher all")
    public void userCanSeeGamePublisherAll() {
        searchPage.userCanSeeDefaultSearchAll();
    }

    @Given("user stayed at search page")
    public void userStayedAtSearchPage() {
        searchPage = commonPage.clickOnSearchIcon();
    }

    @When("user click on dropdown list")
    public void userClickOnDropdownList() {
        searchPage.clickDropDownListPublisher();
    }

    @Then("user can see list publisher")
    public void userCanSeeListPublisher() {
        searchPage.userCanSeeListPublisher();
    }

    @When("user select PGSoft")
    public void userSelectPGSoft() {
        searchPage.searchByPGSoft();
    }

    @Then("user can see list game PGSoft")
    public void userCanSeeListGamePGSoft() {
        searchPage.userCanSeeListGamePGSoft();
    }

    @When("user select Pragmatic")
    public void userSelectPragmatic() {
        searchPage.searchByPragmatic();
    }

    @Then("user can see list game Pragmatic")
    public void userCanSeeListGamePragmatic() {
        searchPage.userCanSeeListGamePragmatic();
    }

    @Then("user can see search input blank")
    public void userCanSeeSearchInputBlank() {
        searchPage.userCanSeeSearchInputBlank();
    }

    @When("user input search key search")
    public void userInputSearchKeySearch(DataTable dataTable) {
        List<Map<String, String>> items = dataTable.asMaps();

        for (Map<String, String> item : items) {
            String key = item.get("keySearch");
            searchPage.inputSearchKey(key);
            searchPage.userCanSeeListGameHaveContentName(key);
            searchPage.clearText();
        }
    }

    @Then("user can see list game results")
    public void userCanSeeListGameResults() {
        searchPage.clickExitSearch();
    }

    @When("user input search {string}")
    public void userInputSearch(String key) {
        searchPage.inputSearchKey(key);
    }

    @Then("user see results do not any game")
    public void userSeeResultsDoNotAnyGame() {
        searchPage.userDoNotSeeAnyResults();
    }

    @When("user click on search exit")
    public void userClickOnSearchExit() {
        searchPage.clickExitSearch();
    }

    @Then("user can see home page")
    public void userCanSeeHomePage() {
        homePage.userCanSeeHomePage();
    }
    @When("user click on search")
    public void userClickOnSearch() {}
}
