package potslotty.steps.bases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import potslotty.pages.CommonPage;
import potslotty.pages.EarnPage;

public class StepsEarn {
    private CommonPage commonPage;
    private EarnPage earnPage;

    public StepsEarn(){
        commonPage = new CommonPage();
        earnPage= new EarnPage();
    }
    @Given("user navigate to earn page")
    public void userNavigateToEarnPage() {
        commonPage.clickEarn();
        earnPage.verifyQRCodeDisplay();
    }

    @When("user observe Your referral section")
    public void userObserveYourReferralSection() {
    }

    @Then("user can see referral code")
    public void userCanSeeReferralCode() {
        earnPage.userCanSeeReferralCode();
    }

    @And("user can see social button to share referral code")
    public void userCanSeeSocialButtonToShareReferralCode() {
        earnPage.verifySocialIconDisplay();
    }

    @When("user click on telegram icon")
    public void userClickOnTelegramIcon() {
        earnPage.clickTelegramIcon();
    }

    @When("user click on facebook icon")
    public void userClickOnFacebookIcon() {
        earnPage.clickFacebookIcon();
    }

    @Then("user will be redirected to facebook popup contains url {string}")
    public void userWillBeRedirectedToFacebookPopupContainsUrl(String url) {
        earnPage.verifyFacebookPopup();
    }

    @Then("user will be redirected to telegram popup contains url")
    public void userWillBeRedirectedToTelegramPopupContainsUrl() {
        earnPage.verifyTelegramPopup();
    }
}
