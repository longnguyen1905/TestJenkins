package potslotty.pages;

import keywords.Keyword;
import org.openqa.selenium.By;

import static keywords.Keyword.*;

public class LoginPage {
    private By mailOTPButton = By.xpath("//span[normalize-space()='Continue with Mail OTP']");
    private By emailField = By.xpath("//input[@id='email']");
    private By sendButton = By.xpath("//button[normalize-space()='Send']");

    private By checkYourEmailLabel = By.xpath("//h3[normalize-space()='Check your email']");
    private By otpPopup = By.xpath("//div[@class='opt-login']");
    private By errorMessage = By.xpath("//p[@class='mt-1 text-xs italic text-rose-600']");
    private By otpErrorMessage = By.xpath("//p[contains(@class,'mt-2 text-rose-600')]");
    private By otpField = By.xpath("//input[@autocomplete='one-time-code']");
    private By loginButton = By.xpath("//button[normalize-space()='Log in']");
    private By resendButton = By.xpath("//span[normalize-space()='Resend']");
    private By countDown = By.xpath("(//span[@class='mb-6 mt-2 text-sm text-[#f5e544]'])[1]");
    private By popupErrorMessage = By.xpath("(//div[@role='status'])[1]");
    private By openTelegramApp = By.xpath("//span[normalize-space()='Continue with Telegram']");
    private By continueWithLine = By.xpath("//span[normalize-space()='Continue with Line']");
    private By lineLabel = By.xpath("//h1[normalize-space()='LINE']");
    private By lineCorporation = By.xpath("//b[normalize-space()='LINE Corporation']");
    private By titleLogin = By.xpath("//h1[normalize-space()='Log in']");
    private By messageLogin = By.xpath("//p[@class='mb-4 text-center text-sm text-[#949494]']");

    public void clickLoginButton(){
        clickElement(loginButton);
    }
    public void clickMailOTPButton(){
        clickElement(mailOTPButton);
    }
    public void inputEmail(String email){
        setText(emailField, email);
    }
    public void clickSendButton(){
        clickElement(sendButton);
    }
    public void clickOpenTelegramApp(){
        clickElement(openTelegramApp);
    }
    public void clickContinueWithLine(){
        clickElement(continueWithLine);
    }
    public void userCanSeePopUpInputOTP(){
        verifyElementVisible(otpPopup, "OTP pop up is not displayed");
    }
    public void inputOTP(String otp){
        setText(otpField, otp);
    }
    public void userCanSeeCheckYourEmailLabel(){
        verifyElementVisible(checkYourEmailLabel, "checkYourEmail Label is not displayed");
    }
    public void userCanSeeErrorMessage(String message){
        verifyElementVisible(errorMessage, "checkYourEmail Label is not displayed");
        verifyEquals(message, getElementText(errorMessage), "wrong error message");
    }
    public void userCanSeeOTPErrorMessage(String message){
        verifyElementVisible(otpErrorMessage, "OTP Error Message is not displayed");
        verifyEquals(message, getElementText(otpErrorMessage), "wrong error message");
    }
    public void checkSendButtonDisable(){
        verifyElementDisable(sendButton, "Send button is enable");
    }
    public void checkLoginButtonDisable(){
        verifyElementDisable(loginButton, "Send button is enable");
    }
    public void checkResendButtonDisable(){
        //verifyElementDisable(resendButton, "Resend button is enable");
        verifyElementDisable(resendButton, "Resend button is enable");
    }
    public void checkResendButtonEnable(){
        sleep(60);
        verifyElementVisible(resendButton, "Resend button is disable");
    }
    public void checkCountDownDisable(){
        verifyElementDisable(countDown, "Resend button is enable");
    }
    public void checkCountDownEnable(){
        verifyElementVisible(countDown, "Resend button is disable");
    }
    public void userCanSeePopUpErrorMessage(String message){
        verifyElementVisible(popupErrorMessage, "pop up not display");
        verifyEquals(message, getElementText(popupErrorMessage), "message not match");
    }
    public void userCanSeeLineLabelAndLineCorporation(){
        verifyElementVisible(lineLabel, "line label not display");
        verifyElementVisible(lineCorporation, "line corporation not display");
    }
    public void loginTestAccount(){
        CommonPage commonPage = new CommonPage();
        LoginPage loginPage = new LoginPage();
        commonPage.clickLetsGoButton();
        commonPage.clickLoginButton();
        loginPage.clickMailOTPButton();
        loginPage.inputEmail("longuyen@alphanetworks.global");
        loginPage.clickSendButton();
        loginPage.inputOTP("000000");
        loginPage.clickLoginButton();
        Keyword.sleep(2);

    }
    public void verifyPopupLogin(){
        verifyContainText(titleLogin, "Log in");
        verifyContainText(messageLogin, "Select your account to continue");
    }
}
