package potslotty.steps.withdraws;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import potslotty.pages.CommonPage;
import potslotty.pages.ProfilePage;

public class StepsProfileOverview {
    private CommonPage commonPage;
    private ProfilePage profilePage;

    public StepsProfileOverview(){
        commonPage = new CommonPage();
        profilePage = new ProfilePage();
    }
    @Then("user can see withdraw information details")
    public void userCanSeeWithdrawInformationDetails() {
        profilePage.verifyAutoWithdrawSection();
    }

    @And("user observe account section")
    public void userObserveAccountSection() {

    }

    @Then("user can see account information details")
    public void userCanSeeAccountInformationDetails() {
        profilePage.verifyProfilePlayer();
    }

    @And("user observe withdraw section")
    public void userObserveWithdrawSection() {
    }

    @And("user observe Transactions")
    public void userObserveTransactions() {
    }

    @Then("user can see Transactions details")
    public void userCanSeeTransactionsDetails() {
        profilePage.verifyTransactionHistory();
    }

    @And("user click on Edit")
    public void userClickOnEdit() {
        profilePage.clickEditButton();
    }

    @And("user observe wallet address section")
    public void userObserveWalletAddressSection() {
    }

    @Then("user can see wallet address information")
    public void userCanSeeWalletAddressInformation() {
        profilePage.verifyWalletAddress();
    }

    @Then("Edit button disable, Save button enable")
    public void editButtonDisableSaveButtonEnable() {
        profilePage.verifyEditAndSaveButton();
    }

    @And("user can edit the wallet address")
    public void userCanEditTheWalletAddress() {
        profilePage.userCanEditTheWalletAddress();
    }


    @Then("Edit button enable, Save button disable")
    public void editButtonEnableSaveButtonDisable() {

    }

    @And("user edit the address without saving")
    public void userEditTheAddressWithoutSaving() {

    }

    @And("wallet address was not changed")
    public void walletAddressWasNotChanged() {
    }
}
