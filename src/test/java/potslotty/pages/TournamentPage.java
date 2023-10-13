package potslotty.pages;

import constants.ConstantGlobal;
import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static keywords.Keyword.*;

public class TournamentPage {
    private By payoutTotal = By.xpath("//span[@class='pp-count-widget__value']");
    private By payoutIcon = By.xpath("//span[@class='pp-count-widget__icon icon-payout']");
    private By payoutLabel = By.xpath("//span[@class='pp-count-widget__label']");
    private By tournamentDropdownList = By.xpath("//button[@id='dropdown-basic']");
    private By daily = By.xpath("//span[normalize-space()='Daily']");
    private By weekly = By.xpath("//span[normalize-space()='Weekly Qualifier']");
    private By monthly = By.xpath("//span[normalize-space()='Monthly']");
    private By dailyTournaments = By.xpath("//span[@class='pp-tournaments-item_type flex items-center md:m-0 tp-daily']");
    private By weeklyTournaments = By.xpath("//span[@class='pp-tournaments-item_type flex items-center md:m-0 tp-weekly']");
    private By monthlyTournaments = By.xpath("//span[@class='pp-tournaments-item_type flex items-center md:m-0 tp-monthly']");
    private By exclamationMarkIconBanner = By.xpath("(//span[@class='pp-mtournament-widget_card-info-button text-white'])[1]");
    private By information = By.xpath("(//div[@class='pp-tournaments-ext-info !block !bg-[#1d1c22]'])[1]");
    private By prizePool = By.xpath("(//div[@class='pp-tournaments-ext-prizepool !bg-[#1d1c22]'])[1]");
    private By leaderboard = By.xpath("(//div[@class='pp-tournaments-ext-leaderboard max-h-[500px] !bg-[#1d1c22]'])[1]");
    private By firstTournament = By.xpath("(//div[@class='pp-tournaments-item-wrapper collapsed']//child::span[@class='pp-tournaments-item_info sm:!m-0 sm:!mt-2'])[1]");
    private By listPrize = By.xpath("(//div[@class='pp-tournaments-ext !p-5'])[1]//span[@class='pp-tournaments-ext-prizepool_block-cash_item-value ml-2']");
    private By totalPrize = By.xpath("(//span[@class='pp-tournaments-ext_card-titlebar_sub'])[1]");
    private String playTournamentXpath = "(//div[@class=' pp-tournaments-item_action ta-play before:text-[#f5e544] sm:!m-0'])[";
    public By playTournament(int index){
        return By.xpath(playTournamentXpath + index + "]");
    }
    public By play = By.xpath("(//div[@class=' pp-tournaments-item_action ta-play before:text-[#f5e544] sm:!m-0'])[1]");
    public By rejoin = By.xpath("//button[@class='btndefault w-40 bnt-text-1 my-5 rounded-r-none']");
    private String gameNameXpath = "(//span[@class='pp-tournaments-item_countdown-label !mr-0 min-w-[150px] max-w-[150px] text-ellipsis !text-sm'])[";
    private By gameName(int index){
        return By.xpath(gameNameXpath + index + "]");
    }
    private By okButton = By.xpath("//button[normalize-space()='Ok']");

    private String iconTop2 = "(//img[contains(@alt,'crown_silver')])";
    private String imgTop2 = "(//img[contains(@alt,'top2')])";
    private String iconTop3 = "(//img[contains(@alt,'crown_bronze')])";
    private String imgTop3 = "(//img[contains(@alt,'top3')])";
    private String reloadRanking = "(//span[@title='Reload rankings'])";
    private String switchPreviousPage = "(//button[@class='btnprev mr-2 !bg-gradient-to-b !from-[#797A7D] !to-[#545C63]'])";
    private String switchNextPage = "(//button[contains(@class,'btnprev mr-2 !bg-gradient-to-b !from-[#797A7D] !to-[#545C63]')])";
    private String iconTop1 ="(//img[contains(@alt,'crown_gold')])";
    private String imgTop1 ="(//img[contains(@alt,'top1')])";
    //private String listPrize ="(//div[@class='pp-tournaments-ext !p-5'])"+"["+index+"]//span[@class='pp-tournaments-ext-prizepool_block-cash_item-value ml-2']";
    private String informationTournament ="(//span[normalize-space()='Information'])";
    private String prizePoolTournament ="(//span[normalize-space()='Prize Pool'])";
    private String leaderboardTournament ="(//span[normalize-space()='Leaderboard'])";
    private String getInformationType ="(//span[normalize-space()='Type'])";
    private String getInformationStartTime ="(//span[normalize-space()='Start Time'])";
    private String getInformationEndTime ="(//span[normalize-space()='End Time'])";
    private String getInformationBalance ="(//span[normalize-space()='Balance'])";
    private String getInformationCost = "(//span[normalize-space()='Cost'])";
    private String getInformationRejoinLimit = "(//span[normalize-space()='Rejoin Limit'])";
    private String detailTournament ="(//div[contains(@class,'pp-tournaments-item flex flex-col justify-between')])";
    private By listTournament = By.xpath("(//div[contains(@class,'pp-tournaments-item flex flex-col justify-between')])");
    public void clickDaily(){
        clickElement(daily);
    }
    public void clickWeekly(){
        clickElement(weekly);
    }
    public void clickMonthly(){
        clickElement(monthly);
    }
    public void clickFirstTournament(){
        clickElement(firstTournament);
    }
    public void clickExclamationMarkIconBanner(){
        clickElement(exclamationMarkIconBanner);
    }
    public void userCanSeeTheTournamentsList(){
        DepositPage depositPage = new DepositPage();
        verifyElementDisable(depositPage.depositButton);
        verifyElementVisible(tournamentDropdownList);
        verifyURL(ConstantGlobal.URL_TOURNAMENT);
    }
    public void userMustNotSeeAnyCurrenciesExceptTON(){
        Assert.assertTrue(getElementText(payoutTotal).contains("TON"));
    }
    public void userMustNotSeeAnyCurrenciesExceptMYR(){
        Assert.assertTrue(getElementText(payoutTotal).contains("MYR"));
    }
    public void userMustNotSeeAnyCurrenciesExceptVND(){
        Assert.assertTrue(getElementText(payoutTotal).contains("VND"));
    }
    public void userSeePayoutSection(String s){
        verifyElementVisible(payoutIcon);
        verifyElementVisible(payoutTotal);
        verifyEquals(s, getElementText(payoutLabel), "label not match");
    }
    public void clickDropdownList(){
        clickElement(tournamentDropdownList);
    }
    public void userCanSeeTheDropdownListOptions(){
        verifyElementVisible(daily);
        verifyElementVisible(weekly);
        verifyElementVisible(monthly);
    }
    public void userOnlySeeDailyTournaments(){
        verifyElementVisible(dailyTournaments);
        verifyElementDisable(weeklyTournaments);
        verifyElementDisable(monthlyTournaments);
    }
    public void userCanSeeTournamentDetails(){
        verifyElementVisible(information);
        verifyElementVisible(prizePool);
        verifyElementVisible(leaderboard);
    }
    public void userCanSeePrizePoolDetail(int index) {
        verifyContainText(prizePoolTournament ,index  ,"Prize Pool");
        verifyContainText(totalPrize,"TON");
        List<WebElement> elements = getWebElements(listPrize);
        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().contains("TON"));
        }
    }
    public void userCanSeeEachDetailTournament (){
        waitForElementPresent(listTournament);
        List<WebElement> elements = getWebElements(listTournament);
        for (int i=1 ; i<=elements.size() ;i++){
            userCanSeeFullDetailTournament(i);
        }
    }
    public void userCanSeeBoardDetailTournament(int index){
        verifyContainText(informationTournament,index,"Information");
        verifyContainText(prizePoolTournament,index,"Prize Pool");
        verifyContainText(leaderboardTournament,index,"Leaderboard");
    }
    public void userCanSeeInformationTournament(int index){
        verifyContainText(getInformationStartTime,index,"Start Time");
        verifyContainText(getInformationType,index,"Type");
        verifyContainText(getInformationBalance,index,"Balance");
        verifyContainText(getInformationEndTime,index,"End Time");
        verifyContainText(getInformationCost,index,"Cost");
        verifyContainText(getInformationRejoinLimit,index,"Rejoin Limit");
    }
    public void userCanSeeDetailLeaderBoard(int index){
        verifyElementVisible(reloadRanking,index);
        verifyElementVisible(switchPreviousPage,index);
        verifyElementVisible(switchNextPage,index);
    }
    public void userCanSeeTopPlayer(int index){
        List<String> stringList = new ArrayList<>(List.of(iconTop1,imgTop1 ,iconTop2,imgTop2,iconTop3,imgTop3 ));
        verifyListElementVisible(stringList,index);
    }
    public void userCanSeeFullDetailTournament(int index){
        clickElement(detailTournament,index);
        userCanSeeBoardDetailTournament(index);
        userCanSeeInformationTournament(index);
        userCanSeeDetailLeaderBoard(index);
        userCanSeeTopPlayer(index);
    }

    public String getGameName(int index){
        return getElementText(gameName(index));
    }
    public void waitAndClickOkButton(int time){
        waitForElementVisible(okButton, time);
        clickElement(okButton);
        DriverManager.getDriver().navigate().back();
    }
}