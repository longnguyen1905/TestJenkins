package potslotty.steps.deposits;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.DepositPage;


public class StepsDepositMYR {
    private CommonPage commonPage;
    private DepositPage depositPage;

    public StepsDepositMYR(){
        commonPage = new CommonPage();
        depositPage = new DepositPage();
    }


    @And("user select MYR")
    public void userSelectMYR() {
        commonPage.clickSwitchWallet();
        commonPage.clickSelectMYR();
    }

    @When("user does not select bank")
    public void userDoesNotSelectBank() {
    }

    @And("user switch back to TON wallet")
    public void userSwitchBackToTONWallet() {
        commonPage.switchToTonWallet();
    }

    @And("user select a bank account")
    public void userSelectABankAccount() {
        depositPage.clickSelectBank();
        depositPage.clickMayBank();
    }

    @When("user input {string} MYR")
    public void userInputMYR(String amount) {
        depositPage.inputAmount(amount);
    }
}
