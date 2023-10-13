package potslotty.steps.bases;

import constants.ConstantGlobal;
import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import potslotty.pages.CommonPage;
import potslotty.pages.LoginPage;

import static keywords.Keyword.openURL;

public class StepsLogin {
    private CommonPage commonPage;
    private LoginPage loginPage;

    public StepsLogin(){
        commonPage = new CommonPage();
        loginPage = new LoginPage();
    }

    @Given("User logged in to lobby")
    public void userLoggedInToLobby() {
        openURL(ConstantGlobal.URL_LOGGED);
        commonPage.clickLetsGoButton();
    }

    @Given("user is not logged in lobby.")
    public void userIsNotLoggedInLobby() {
        openURL(ConstantGlobal.URL);
        commonPage.clickLetsGoButton();
    }

    @Given("user click on Login")
    public void userClickOnLogin() {
        loginPage = commonPage.clickLoginButton();
    }

    @And("user click Continue with mail OTP")
    public void userClickContinueWithMailOTP() {
        loginPage.clickMailOTPButton();
    }

    @When("user enter the email {string}")
    public void userEnterTheEmail(String email) {
        loginPage.inputEmail(email);
    }

    @And("user click Send")
    public void userClickSend() {
        loginPage.clickSendButton();
    }

    @Then("user can see pop up input OTP")
    public void userCanSeePopUpInputOTP() {
        loginPage.userCanSeePopUpInputOTP();
        loginPage.userCanSeeCheckYourEmailLabel();
    }


    @When("user enter email {string}")
    public void userEnterEmail(String email) {
        loginPage.inputEmail(email);
    }

    @Then("user can see error message {string}")
    public void userCanSeeErrorMessage(String message) {
        loginPage.userCanSeeErrorMessage(message);
    }

    @And("Send button is disable")
    public void sendButtonIsDisable() {
        loginPage.checkSendButtonDisable();
    }

    @When("user leave blank email {string}")
    public void userLeaveBlankEmail(String message) {
        loginPage.inputEmail(message);
    }

    @Then("user cannot send email")
    public void userCannotSendEmail() {

    }


    @When("user input valid OTP")
    public void userInputValidOTP() {

    }

    @And("user click log in")
    public void userClickLogIn() {
        loginPage.clickLoginButton();
    }

    @Then("user can see pop up input username")
    public void userCanSeePopUpInputUsername() {
    }

    @And("user enter email existed {string}")
    public void userEnterEmailExisted(String arg0) {
    }

    @Then("user navigate to lobby")
    public void userNavigateToLobby() {
    }

    @When("user input OTP {string}")
    public void userInputOTP(String otp) {

        loginPage.clickSendButton();
        loginPage.userCanSeeCheckYourEmailLabel();
        loginPage.inputOTP(otp);
    }
    @Then("user can see email error message {string}")
    public void userCanSeeEmailErrorMessage(String errorMessage) {
        loginPage.userCanSeeOTPErrorMessage(errorMessage);
    }

    @When("user leave blank OTP")
    public void userLeaveBlankOTP() {
        loginPage.clickSendButton();
        loginPage.userCanSeeCheckYourEmailLabel();
        loginPage.inputOTP("");
    }

    @Then("log in button is disable")
    public void logInButtonIsDisable() {
        loginPage.checkLoginButtonDisable();
    }
    @Then("countdown time is displayed")
    public void countdownTimeIsDisplayed() {
        loginPage.clickSendButton();
        loginPage.userCanSeeCheckYourEmailLabel();
        loginPage.checkCountDownEnable();
    }

    @When("user wait for {int} sec")
    public void userWaitForSec(int time) {
        loginPage.clickSendButton();
        loginPage.userCanSeeCheckYourEmailLabel();
    }

    @Then("resend is enable")
    public void resendIsEnable() {
        loginPage.checkResendButtonEnable();
    }

    @And("countdown time is invisible")
    public void countdownTimeIsInvisible() {
        loginPage.checkCountDownDisable();
    }

    @Then("user can see pop up error message {string}")
    public void userCanSeePopUpErrorMessage(String message) {
        loginPage.userCanSeePopUpErrorMessage(message);
    }

    @When("user click Open telegram app")
    public void userClickOpenTelegramApp() {
        loginPage.clickOpenTelegramApp();
        DriverManager.getDriver().switchTo().parentFrame();
        DriverManager.getDriver().findElement(By.xpath("//input[@id='login-phone']")).sendKeys("5454545");
    }

    @Then("user navigate to telegram url")
    public void userNavigateToTelegramUrl() {

    }

    @And("user should see popup redirection to telegram")
    public void userShouldSeePopupRedirectionToTelegram() {

    }

    @When("user click Continue with Line")
    public void userClickContinueWithLine() {
        loginPage.clickContinueWithLine();
    }

    @Then("user should see only one module login by Line")
    public void userShouldSeeOnlyOneModuleLoginByLine() {
        loginPage.userCanSeeLineLabelAndLineCorporation();
    }

    @And("user navigate to URL line url that contains {string}")
    public void userNavigateToURLLineUrlThatContains(String url) {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains(url));
    }


}
