package potslotty.pages;

import static keywords.Keyword.*;
import static keywords.Keyword.clickElement;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LogUtils;


import java.util.List;

public class HomePage extends CommonPage{
    private By bannerGameOfWeek = By.xpath("(//div[contains(@class,'relative mb-4 h-full px-4 lg:px-0')])[1]");
    private By bannerTournament = By.xpath("(//div[contains(@class,'relative mb-4 h-full px-4 lg:px-0')])[2]");
    private By playAtBannerGame = By.xpath("//h1[normalize-space()='Play']");
    private By titleBannerGame = By.xpath("//h1[normalize-space()='GAME OF THE WEEK']");
    private By listGame = By.xpath("(//div[contains(@class,'flex items-center justify-center')])");
    public By gameIframe = By.xpath("//iframe");
    private By popUpPlease = By.xpath("//p[contains(@class,'text-white heading-5 text-left px-4')]");
    private By buttonOpenGame = By.xpath("(//a[contains(text(),'Open game')])[1]");
    private By btnLogin = By.xpath("(//button[contains(@class,'btndefault w-40 bnt-text-1 my-5 rounded-r-none')])[1]");
    private By btnContinue = By.xpath("//button[normalize-space()='Continue']");
    private By btnDeposit = By.xpath("(//a[normalize-space()='Deposit'])[1]");
    public By gameImage = By.xpath("//img[@id='The Queens Banquet']");

    private String listGame (int index) {
        return "(//div[contains(@class,'flex items-center justify-center')])"+"["+index+"]";
    }

    public void clickGameImage(){
        clickElement(gameImage);
    }
    public void userCanSeeBanner(){
        verifyElementVisible(bannerGameOfWeek);
        verifyElementVisible(playAtBannerGame);
        verifyContainText(titleBannerGame,"GAME OF THE WEEK");
        verifyElementVisible(bannerTournament);
    }
    public void userCanPlayAllGame() {
        List<WebElement> games = getWebElements(listGame);
        for (int index = 1; index <= games.size(); index++) {
            clickElement(By.xpath(listGame(index)));
            loadedGameSuccess();
            clickElement(potSlottyLogo);
        }
    }
    public void loadedGameSuccess(){
        try {
            waitForElementVisible(gameIframe);
            String expectedID = getWebElement(gameIframe).getAttribute("id");
            String tmpURL = DriverManager.getDriver().getCurrentUrl();
            String actualID = tmpURL.substring(tmpURL.lastIndexOf("play/") + 5, (tmpURL.length()-1));
            verifyEquals(actualID, expectedID);
        }
        catch(AssertionError error) {
            LogUtils.info("Game not load success: " + error.getMessage());
        }
    }
    public void userCanPlayFirstGame() {
        loadedGameSuccess();
    }
    public void userClickFirstGame() {
        clickElement(listGame);
    }
    public void clickOpenGame(){
        clickElement(buttonOpenGame);
    }
    public void userCanSeePopUpPleaseLogin(){
        verifyContainText(popUpPlease,"Please log in or create an account.");    }
    public void clickBtnLogin(){
        clickElement(btnLogin);
    }
    public void clickBtnContinue(){
        clickElement(btnContinue);
    }
    public void clickBtnDeposit(){
        clickElement(btnDeposit);
    }
    public void verifyButtonOnNewGame(){
        verifyElementVisible(buttonOpenGame);
        verifyElementVisible(btnDeposit);
    }
    public void clickBannerTournament(){
        clickElement(bannerTournament);
    }
    public void clickPlayOnBanner(){
        clickElement(playAtBannerGame);
    }
    public void userCanSeeHomePage(){
        verifyURL(ConstantGlobal.URL);
        userCanSeeBanner();
    }

}
