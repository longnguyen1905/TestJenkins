package potslotty.steps.withdraws;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.ProfilePage;

public class StepsWithdrawMYR {
    private CommonPage commonPage;
    private ProfilePage profilePage;
    public StepsWithdrawMYR(){
        commonPage = new CommonPage();
        profilePage = new ProfilePage();
    }


    @And("user added an exits MYR Bank account information")
    public void userAddedAnExitsMYRBankAccountInformation() {
    }

    @When("user input amount {string} MYR")
    public void userInputAmountMYR(String amount) {
        profilePage.inputAmountMYR(amount);

    }

    @And("display new transaction history MYR")
    public void displayNewTransactionHistoryMYR() {
    }

    @And("balance decrease {string} MYR")
    public void balanceDecreaseMYR(String amount) {
    }

    @Then("withdraw MYR process stop")
    public void withdrawMYRProcessStop() {
    }

    @And("input amount MYR field is empty")
    public void inputAmountMYRFieldIsEmpty() {
        profilePage.verifyInputFieldMyrIsEmpty();
    }
}
