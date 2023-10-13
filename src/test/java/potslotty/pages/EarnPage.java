package potslotty.pages;

import constants.ConstantGlobal;
import keywords.Keyword;
import org.openqa.selenium.By;
import static keywords.Keyword.*;
import static keywords.Keyword.verifyURL;

import constants.ConstantGlobal;
import drivers.DriverManager;
import keywords.Keyword;
import org.openqa.selenium.By;

import static keywords.Keyword.verifyEquals;
import static keywords.Keyword.verifyURL;

public class EarnPage {
    private By yourReferralTitle = By.xpath("//h2[normalize-space()='Your Referral']");
    private By referralQRCode = By.xpath("//*[name()='path' and contains(@d,'M 0 0 l 1 ')]");
    private By referralUrl = By.xpath("//span[contains(text(),'lobby.tpotslotty.cc/?start=')]");
    private By telegramIcon = By.xpath("//img[contains(@alt,'telegram icon')]");
    private By facebookIcon = By.xpath("//img[@alt='facebook icon']");
    private By shareIcon = By.xpath("//img[@alt='share icon']");

    public void verifyQRCodeDisplay(){
        verifyElementVisible(referralQRCode);
    }
    public void userCanSeeReferralCode(){
        verifyElementVisible(yourReferralTitle);
        verifyElementVisible(referralQRCode);
        verifyElementVisible(referralUrl);
        verifyContainText(referralUrl, "lobby.tpotslotty.cc/?start=");
        verifyContainText(yourReferralTitle,"YOUR REFERRAL");

    }
    public void verifySocialIconDisplay(){
        verifyElementVisible(telegramIcon);
        verifyElementVisible(facebookIcon);
        verifyElementVisible(shareIcon);
    }
    public void clickTelegramIcon(){
        clickElement(telegramIcon);
    }
    public void clickFacebookIcon(){
        clickElement(facebookIcon);
    }
    public void verifyTelegramPopup(){
        verifyEquals(getCurrentUrlNewTab(), ConstantGlobal.URL_REFERRAL_TELE);
    }
    public void verifyFacebookPopup(){
        verifyEquals(getCurrentUrlNewTab(), ConstantGlobal.URL_REFERRAL_FB);
    }
    private By titleEarn = By.xpath("//h2[normalize-space()='Your Referral']");
    public void userCanSeeEarnTitle(){
        Keyword.verifyElementVisible(titleEarn);
        Keyword.verifyContainText(titleEarn,"YOUR REFERRAL");
        verifyURL(ConstantGlobal.URL_EARN);
    }
}
