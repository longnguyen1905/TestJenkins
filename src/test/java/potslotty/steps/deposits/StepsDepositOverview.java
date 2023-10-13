package potslotty.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.DepositPage;

import java.util.List;
import java.util.Map;

public class StepsDepositOverview {
    private CommonPage commonPage;
    private DepositPage depositPage;

    public StepsDepositOverview(){
        commonPage = new CommonPage();
        depositPage = new DepositPage();
    }
    @And("user click on Buy Crypto")
    public void userClickOnBuyCrypto() {
        depositPage.clickBuyCrypto();
    }

    @Then("user can see Buy Crypto tab")
    public void userCanSeeBuyCryptoTab() {

    }

    @And("user can switch back to Deposit tab")
    public void userCanSwitchBackToDepositTab() {
        depositPage.clickDepositTab();
        depositPage.userCanSeeDepositSection();
    }

    @And("user observe deposit section")
    public void userObserveDepositSection() {
    }

    @Then("user can see deposit section details")
    public void userCanSeeDepositSectionDetails() {
        depositPage.userCanSeeDepositSectionDetails();
    }

    @When("user can click on pack of amount")
    public void userCanClickOnPackOfAmount(DataTable dataTable) {
        List<Map< String, String >> items = dataTable.asMaps();

        for (Map < String, String > item: items) {
            String amount = item.get("amount");

            depositPage.userCanClickOnPackOf(amount);
            depositPage.userCanSeeInputAmountChangeTo(amount);
        }
    }

    @Then("user can see input amount change")
    public void userCanSeeInputAmountChange() {
        //code defined in method "userCanClickOnPackOfAmount"
    }

    @When("user click on QR Code")
    public void userClickOnQRCode() {
        depositPage.clickButtonQRCode();
    }

    @Then("user can will be able to click on Ton Keeper or Ton Hub")
    public void userCanWillBeAbleToClickOnTonKeeperOrTonHub() {
        depositPage.verifyTonKeeperAndTonHubClickable();
    }

    @And("user can see wallet's icons")
    public void userCanSeeWalletSIcons() {
        //already defined in another test scenario
    }

    @Then("user will see QR code details")
    public void userWillSeeQRCodeDetails() {
        depositPage.verifyQRCodeSection();
    }

    @And("user can tap Ton address to copy")
    public void userCanTapTonAddressToCopy() {
        depositPage.userCanTapTonAddressToCopy();
    }
}
