package potslotty.pages;

import constants.ConstantGlobal;
import keywords.Keyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.LogUtils;

import java.util.List;

import static keywords.Keyword.*;

public class SearchPage {
    private By searchInput = By.xpath("//input[contains(@type,'text')]");
    private By btnExit = By.xpath("//div[contains(@class,'filter-box relative rounded-lg border border-[#f5e544]')]//a");
    private By publisher = By.xpath("//button[contains(@class,'py-2 pr-3 text-lg')]");
    private By listPublisher = By.xpath("//button[contains(@class,'py-2 pr-3 text-lg')]");
    private By PGSoft = By.xpath("//span[normalize-space()='PG Soft']");
    private By pragmatic = By.xpath("//span[normalize-space()='Pragmatic']");
    private By nameListGame = By.xpath("//p[@class='heading-3  w-full  text-ellipsis px-2 text-center text-white sm:text-xl lg:text-lg']");
    public void userCanSeeSearchInput(){
        Keyword.verifyElementVisible(searchInput);
        verifyURL(ConstantGlobal.URL_SEARCH);
    }
    public void clickDropDownListPublisher(){
        clickElement(publisher);
    }
    public void userCanSeeDefaultSearchAll(){
        verifyContainText(publisher, "All");
    }
    public void userCanSeeListPublisher(){
        List<WebElement> publishers = getWebElements(listPublisher);
        verifyEquals(publishers.size()>1,true);
    }
    public void userDoNotSeeAnyResults(){
        List<WebElement> listGame = getWebElements(nameListGame);
        verifyEquals(listGame.size()<1,true);
    }
    public void searchByPGSoft(){
        clickDropDownListPublisher();
        clickElement(PGSoft);
    }
    public void userCanSeeListGamePGSoft(){
        verifyContainText(publisher, "PG Soft");
    }
    public void searchByPragmatic(){
        clickDropDownListPublisher();
        clickElement(pragmatic);
    }
    public void userCanSeeListGamePragmatic(){
        verifyContainText(publisher, "Pragmatic");
    }
    public void inputSearchKey(String searchKey){
        setText(searchInput, searchKey);
    }
    public void userCanSeeSearchInputBlank(){
        verifyEquals(getElementText(searchInput), "");
    }
    public void userCanSeeListGameHaveContentName (String name) {
        List<WebElement> listNameOfGame = getWebElements(nameListGame);
        verifyEquals(listNameOfGame.size()>=1,true );
        for (WebElement nameOfGame : listNameOfGame) {
            verifyContainTextLowerCase(nameOfGame, name.toLowerCase());
        }
    }
    public void clearText(){
        getWebElement(searchInput).clear();
    }
    public void clickExitSearch(){
        clickElement(btnExit);
    }
}
