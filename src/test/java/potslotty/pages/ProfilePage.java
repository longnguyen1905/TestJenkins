package potslotty.pages;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import static keywords.Keyword.*;

public class ProfilePage {
    private By inputWithdrawAmount = By.xpath("//input[@placeholder='>= 0.01 TON']");
    private By inputWithdrawAmountMYR = By.xpath("//input[@placeholder='>= 10.00 MYR']");
    private By withdrawButton = By.xpath("//button[normalize-space()='Withdraw']");
    private By popupWithdrawButton = By.xpath("//button[@class='btndefault w-40 bnt-text-1 my-5 rounded-r-none']");
    private By popupCancelButton = By.xpath("//button[normalize-space()='Cancel']");
    private By popupOkButton = By.xpath("//button[normalize-space()='Ok']");
    private By popupWithdrawTitle= By.xpath("//p[@class='text-white heading-5 text-left px-4']");
    private By popupWithdrawSuccessTitle = By.xpath("//p[@class='text-white heading-5 text-left px-4']");
    private By moduleInfo = By.xpath("//div[@class='level-container svelte-13o469e inline-flex w-full items-center p-2 font-semibold']");
    private By withdrawTitle = By.xpath("//h1[normalize-space()='Withdraw']");
    private By imageAvatar = By.xpath("//img[@alt='Logo Image']");
    private By userName = By.xpath("//h2[@class='mr-1 rounded-md border border-[#28293F] bg-[#363127] px-3 text-center text-base']");
    private By userLevel = By.xpath("//h2[@class='rounded-md border border-[#28293F] bg-[#363127] px-3 text-center text-base']");
    private By walletAddressMessage = By.xpath("//div[contains(text(),'Please add your TON wallet address for withdrawal')]");
    private By inputAddress = By.xpath("//input[contains(@placeholder,'TON address here')]");
    private By editButton = By.xpath("//button[normalize-space()='EDIT']");
    private By saveButton = By.xpath("//button[normalize-space()='SAVE']");
    private By autoWithdrawTitle = By.xpath("//h2[normalize-space()='Auto withdraw']");
    private By autoWithdrawMessage = By.xpath("//div[@class='blink_me flex items-center justify-center rounded-lg border border-dashed border-[#fff] p-2 text-[12px] text-[#fff] sm:text-[15px] ']");
    private By signOutButton = By.xpath("//button[normalize-space()='Sign out']");
    private By transactionsTitle = By.xpath("//h1[normalize-space()='Transactions']");
    private By transactionsHistory = By.xpath("//div[@class='setting-container svelte-13o469e mt-2 flex items-center justify-between px-2 py-1 text-white']");




    public void clickWithdrawButton(){
        clickElement(withdrawButton);
    }
    public void clickPopupWithdrawButton(){
        clickElement(popupWithdrawButton);
    }
    public void clickPopupCancelButton(){
        clickElement(popupCancelButton);
    }
    public void clickPopupOkButton(){
        clickElement(popupOkButton);
    }
    public void clickEditButton(){
        clickElement(editButton);
    }
    public void clickSaveButton(){
        clickElement(saveButton);
    }


    public void inputAmount(String amount){
        setText(inputWithdrawAmount, amount);
    }
    public void inputAmountMYR(String amount){
        setText(inputWithdrawAmountMYR, amount);
    }
    public void verifyWithdrawButtonEnable(){
        verifyElementVisible(withdrawButton, "Withdraw button is disable");
    }
    public void verifyWithdrawButtonDisable(){
        verifyElementDisable(withdrawButton, "Withdraw button is enable");
    }
    public void verifyInputFieldIsEmpty(){
        verifyEquals(getElementText(inputWithdrawAmount), "", "Input field is not empty");
    }
    public void verifyInputFieldMyrIsEmpty(){
        verifyEquals(getElementText(inputWithdrawAmountMYR), "", "Input field is not empty");
    }
    public void verifyPopupWithdrawDisplay(){
        verifyElementVisible(popupWithdrawTitle, "Pop up title is not display");
        verifyEquals(getElementText(popupWithdrawTitle), "Please confirm to withdraw your balance to your registered wallet", "title not match");
    }
    public void verifyPopupWithdrawSuccessDisplay(){
        verifyElementVisible(popupWithdrawSuccessTitle, "Pop up title is not display");
//        verifyEquals(getElementText(popupWithdrawSuccessTitle), "Withdraw successfully", "title not match");
    }
    public void verifyProfilePlayer(){
        verifyElementVisible(moduleInfo, "Profile is not displayed");
        verifyElementVisible(withdrawTitle, "Withdraw title is not displayed");
        verifyElementVisible(imageAvatar, "Image avatar is not displayed");
        verifyElementVisible(userName, "User Name is not displayed");
        verifyElementVisible(userLevel, "User level is not displayed");
        verifyURL(ConstantGlobal.URL_PROFILE);
    }
    public void verifyWalletAddress(){
        verifyElementVisible(walletAddressMessage, "wallet address message is not displayed");
        verifyElementVisible(inputAddress, "input address is not displayed");
        verifyElementVisible(editButton, "Edit button is not displayed");
    }
    public void verifyAutoWithdrawSection(){
        verifyElementVisible(autoWithdrawTitle, "Auto Withdraw Title is not displayed");
        verifyElementVisible(autoWithdrawMessage, "Auto Withdraw message is not displayed");
        verifyElementVisible(withdrawButton, "Withdraw Button is not displayed");
        verifyElementVisible(signOutButton, "Sign out Button is not displayed");

    }
    public void verifyTransactionHistory(){
        verifyElementVisible(transactionsTitle);
        verifyElementVisible(transactionsHistory);
        verifyEquals(10, getWebElements(transactionsHistory).size());
    }
    public void verifyEditAndSaveButton(){
        verifyElementVisible(saveButton, "save button is not displayed");
        verifyElementDisable(editButton, "edit button is not disable");
    }
    public void userCanEditTheWalletAddress(){
        clearTextElement(inputAddress);
        setText(inputAddress, "EQC7iX8x6xGxDENaanzdxzwIwgc8AePrpXHuIdUs4mPC_123");
        clickElement(saveButton);
        Assert.assertTrue(getWebElement(inputAddress).getAttribute("value").contains("mPC_123"), "address was not changed");

        clickElement(editButton);
        clearTextElement(inputAddress);
        setText(inputAddress, ConstantGlobal.TON_ADDRESS);
        clickElement(saveButton);
    }
    public void editAddressWithoutSaving(){
        clearTextElement(inputAddress);
        setText(inputAddress, "EQC7iX8x6xGxDENaanzdxzwIwgc8AePrpXHuIdUs4mPC_123");
        DriverManager.getDriver().navigate().refresh();

    }
    public void verifyWalletNotChanged(){
        verifyElementVisible(editButton, "edit button is not displayed");
        verifyElementDisable(saveButton, "save button is not disable");
        Assert.assertTrue(getWebElement(inputAddress).getAttribute("value").contains("mPC_Iw3"), "address was changed");
    }

}
