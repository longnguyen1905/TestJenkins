package potslotty.steps.deposits;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.DepositPage;

public class StepsDepositTon {
    private CommonPage commonPage;
    private DepositPage depositPage;

    public StepsDepositTon(){
        commonPage = new CommonPage();
        depositPage = new DepositPage();
    }
    @Given("user stays at deposit page")
    public void userStaysAtDepositPage() {
        depositPage = commonPage.clickDepositButtonHeader();
    }

    @When("user input {string} TON")
    public void userInputTON(String amount) {
        depositPage.inputAmount(amount);
    }

    @Then("button deposit is enable")
    public void buttonDepositIsEnable() {
        depositPage.verifyDepositButtonEnable();
    }

    @Then("button deposit is disable")
    public void buttonDepositIsDisable() {
        depositPage.verifyDepositButtonDisable();
    }

    @And("user should see error message {string}")
    public void userShouldSeeErrorMessage(String message) {
        depositPage.userShouldSeeErrorMessage(message);
    }

    @And("user is not allowed to enter nun-numeric value")
    public void userIsNotAllowedToEnterNunNumericValue() {
        depositPage.verifyInputFieldIsBlank();
    }

    @And("user click Deposit button")
    public void userClickDepositButton() {
        depositPage.clickDepositButton();
    }

    @Then("user will be redirected to URL begin {string}")
    public void userWillBeRedirectedToURLBegin(String url) {
        depositPage.userWillBeRedirectedToURLBegin(url);
    }

    @And("user can make a payment")
    public void userCanMakeAPayment() {
        depositPage.verifyUserCanMakePaymentViaTonKeeper();
    }

    @And("user select Ton Hub")
    public void userSelectTonHub() {
        depositPage.clickTonHub();
    }

    @And("user should see value ton input is empty")
    public void userShouldSeeValueTonInputIsEmpty() {
        depositPage.verifyInputFieldIsBlank();
    }

    @And("user can make a payment via Ton Hub")
    public void userCanMakeAPaymentViaTonHub() {
        depositPage.verifyUserCanMakePaymentViaTonHub();
    }

    @And("user select QR code")
    public void userSelectQRCode() {
        depositPage.clickButtonQRCode();
    }

    @Then("QR code is visible")
    public void qrCodeIsVisible() {
        depositPage.verifyQRCodeImageVisibility();
    }

    @Then("QR code is invisible")
    public void qrCodeIsInvisible() {
        depositPage.verifyQRCodeImageInvisible();
    }
}
