package potslotty.pages;

import constants.ConstantGlobal;
import drivers.DriverManager;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.LogUtils;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static keywords.Keyword.*;

public class DepositPage {
    private By inputAmount = By.xpath("//input[@type='text']");
    public By depositButton = By.xpath("//*[@class='button deposit-button common-button svelte-9k01mu flex h-12 items-center justify-center font-bold']");
    private By errorMessageGreaterAmount = By.xpath("//p[normalize-space()='Please enter a smaller number 10000']");
    private By tonKeeperHeaderTitle = By.xpath("//div[@class='page-header-title']");
    private By tonKeeperBodyTitle = By.xpath("//div[normalize-space()='Install Tonkeeper and log in to your wallet']");
    private By tonHubGrid = By.xpath("//img[@alt='icon_tonhub']");
    private By tonKeeperGrid = By.xpath("//img[@alt='icon_tonkeeper']");
    private By tonHubTitle = By.xpath("//h3[normalize-space()='Tonhub']");
    private By openInTonHubButton = By.xpath("//a[normalize-space()='Open in Tonhub']");
    private By buttonQRCode = By.xpath("//p[normalize-space()='QR Code']");
    private By imageQRCode = By.xpath("//*[name()='path' and contains(@d,'M 7 0 l 1 ')]");
    private By selectBank = By.xpath("(//span[normalize-space()='Please Select Bank'])");
    private By mayBank = By.xpath("//span[normalize-space()='Maybank Berhad']");
    private By buyCrypTo = By.xpath("//h3[normalize-space()='Buy Crypto']");
    private By depositTab = By.xpath("//h3[normalize-space()='Deposit']");
    private By currencyUnit = By.xpath("//span[@class='mx-2']");
    private By quickInputAmount = By.xpath("//div[@class='hide-scroll svelte-s8eivf mt-4 flex overflow-x-auto lg:justify-end']");
    private By walletMessage = By.xpath("//*[contains(text(),'Please kindly wait a few seconds after request deposit')]");
    private By walletAddress = By.xpath("//p[@class='break-words']");
    private By tapTonToCopy = By.xpath("//span[normalize-space()='Tap TON address to copy']");
    private By copy = By.xpath("//span[normalize-space()='Copy']");



    public void clickDepositButton(){
        clickElement(depositButton);
    }
    public void clickTonHub(){
        clickElement(tonHubGrid);
    }
    public void clickTonKeeper(){
        clickElement(tonKeeperGrid);
    }
    public void clickButtonQRCode(){
        clickElement(buttonQRCode);
    }
    public void clickSelectBank(){
        clickElement(selectBank);
    }
    public void clickMayBank(){
        clickElement(mayBank);
    }
    public void clickDepositTab(){
        clickElement(depositTab);
    }
    public void clickBuyCrypto(){
        clickElement(buyCrypTo);
    }
    public void inputAmount(String amount){
        clearTextElement(inputAmount);
        setText(inputAmount, amount);
    }

    public void verifyDepositButtonEnable(){
        verifyElementVisible(depositButton);
    }
    public void verifyDepositButtonDisable(){
        verifyElementDisable(depositButton);
    }
    public void userShouldSeeErrorMessage(String message){
        verifyElementVisible(errorMessageGreaterAmount);
        verifyEquals(message , getElementText(errorMessageGreaterAmount), "error message not match");
    }
    public void verifyInputFieldIsBlank(){
         verifyEquals("", getWebElement(inputAmount).getText());
    }
    public void userWillBeRedirectedToURLBegin(String url){
        Assert.assertTrue(getCurrentUrlNewTab().contains(url));
    }
    public void verifyUserCanMakePaymentViaTonKeeper(){
        verifyElementVisible(tonKeeperHeaderTitle);
        verifyElementVisible(tonKeeperBodyTitle);
    }
    public void verifyUserCanMakePaymentViaTonHub(){
        verifyElementVisible(tonHubTitle);
        verifyElementVisible(openInTonHubButton);
    }
    public void verifyQRCodeImageVisibility(){
        verifyElementVisible(imageQRCode, "QR Code is not visible");
    }
    public void verifyQRCodeImageInvisible(){
        verifyElementDisable(imageQRCode, "QR code is displayed");
    }
    public void userCanSeeDepositSection(){
        verifyContainText(depositTab,"Deposit");
        verifyURL(ConstantGlobal.URL_DEPOSIT);
        verifyElementVisible(currencyUnit);
        verifyElementVisible(depositButton);
    }
    public void userCanSeeDepositSectionDetails(){
        verifyElementVisible(inputAmount);
        verifyElementVisible(depositTab);
        verifyElementVisible(buyCrypTo);
        verifyElementVisible(depositButton);
        verifyElementVisible(quickInputAmount);
    }
    public void userCanClickOnPackOf(String amount){
        By element = By.xpath("//div[@class='hide-scroll svelte-s8eivf mt-4 flex overflow-x-auto lg:justify-end']" +
                "//*[normalize-space(text()) = '"+ amount +"']");
        clickElement(element);
    }
    public String getInputAmount(){

        return getWebElement(inputAmount).getAttribute("value");
    }
    public void userCanSeeInputAmountChangeTo(String amount){
        verifyEquals(amount, getInputAmount(), "amount not match");
    }
    public void verifyTonKeeperAndTonHubClickable(){
        verifyElementClickable(tonKeeperGrid);
        verifyElementClickable(tonHubGrid);
    }
    public void verifyQRCodeSection(){
        verifyElementVisible(imageQRCode);
        verifyElementVisible(walletMessage);
        verifyElementVisible(walletAddress);
        verifyElementVisible(tapTonToCopy);
    }
    public void userCanTapTonAddressToCopy(){
        clickElement(walletAddress);
        verifyElementDisable(tapTonToCopy);
        verifyElementVisible(copy);
    }


}
