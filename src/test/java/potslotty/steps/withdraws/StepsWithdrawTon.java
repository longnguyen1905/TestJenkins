package potslotty.steps.withdraws;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import keywords.Keyword;
import potslotty.pages.CommonPage;
import potslotty.pages.ProfilePage;

import static keywords.Keyword.sleep;
import static keywords.Keyword.verifyEquals;

public class StepsWithdrawTon {
    private CommonPage commonPage;
    private ProfilePage profilePage;
    public StepsWithdrawTon(){
        commonPage = new CommonPage();
        profilePage = new ProfilePage();
    }
    @And("user added an exits TON address")
    public void userAddedAnExitsTONAddress() {
        
    }

    @Given("user navigate to profile page")
    public void userNavigateToProfilePage() {
        commonPage.clickAvtar();
    }

    @When("user input amount {string} TON")
    public void userInputAmountTON(String amount) {
        profilePage.inputAmount(amount);
    }

    @Then("button withdraw is enable")
    public void buttonWithdrawIsEnable() {
        profilePage.verifyWithdrawButtonEnable();
    }

    @And("user click withdraw")
    public void userClickWithdraw() {
        profilePage.clickWithdrawButton();
    }

    @Then("input amount field is empty")
    public void inputAmountFieldIsEmpty() {
        profilePage.verifyInputFieldIsEmpty();
    }

    @And("button withdraw is disable")
    public void buttonWithdrawIsDisable() {
        profilePage.verifyWithdrawButtonDisable();
    }

    @And("user click withdraw on confirm popup")
    public void userClickWithdrawOnConfirmPopup() {
        profilePage.clickPopupWithdrawButton();
    }

    @Then("pop up Withdraw successfully display")
    public void popUpWithdrawSuccessfullyDisplay() {
        profilePage.verifyPopupWithdrawSuccessDisplay();
        profilePage.clickPopupOkButton();
    }

    @And("display new transaction history")
    public void displayNewTransactionHistory() {

    }

    @And("balance decrease {string} TON")
    public void balanceDecreaseTON(String amount) {

    }

    @And("user click cancel on confirm popup")
    public void userClickCancelOnConfirmPopup() {
        profilePage.clickPopupCancelButton();
    }

    @Then("withdraw process stop")
    public void withdrawProcessStop() {
    }

    @When("user input an amount greater than balance")
    public void userInputAnAmountGreaterThanBalance() {

    }


}
