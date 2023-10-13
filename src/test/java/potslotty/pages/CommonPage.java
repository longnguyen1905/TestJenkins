package potslotty.pages;

import lombok.Getter;
import org.openqa.selenium.By;

import static keywords.Keyword.*;


public class CommonPage {
    public By potSlottyLogo = By.xpath("//img[@alt='logo']");
    public By tournaments = By.xpath("//a[normalize-space()='Tournaments']");
    public By results = By.xpath("//a[normalize-space()='Results']");
    public By upcoming = By.xpath("//a[normalize-space()='Upcoming']");
    public By earn = By.xpath("//a[normalize-space()='Earn']");
    public By loginButton = By.xpath("//span[normalize-space()='Login']");
    public By letsGoButton = By.xpath("//button[@class='btndefault bnt-text-1 my-10 w-full']");
    public By depositButtonHeader = By.xpath("//a[normalize-space()='Deposit']");
    public By switchWallet = By.xpath("//button[@class='svelte-1lmjpjc mr-2 flex h-8 !w-auto flex-[0_0_auto] cursor-auto items-center rounded-[10px]" +
            " bg-[#22201c] px-4 pr-2 text-[14px] font-semibold text-white sm:h-11 sm:px-4 sm:py-3 sm:text-xl lg:text-sm  cursor-pointer']");
    public By searchButton = By.xpath("//img[contains(@alt,'icon_search')]");
    public By avatar = By.xpath("//img[@alt='avatar']");
    public By selectMYR = By.xpath("//p[normalize-space()='MYR']");
    public By selectTON = By.xpath("//p[normalize-space()='TON']");
    public By selectVND = By.xpath("//p[normalize-space()='VND']");
    public By reserved = By.xpath("//p[@class='mb-1 mt-4 text-[#8e8d91]']");
    public By termAndCon = By.xpath("//a[normalize-space()='Terms and Conditions']");
    public By support = By.xpath("//p[contains(@class,'ml-1 cursor-pointer')]");


    public void clickLetsGoButton(){
        clickElement(letsGoButton);
    }
    public LoginPage clickLoginButton(){
        clickElement(loginButton);
        return new LoginPage();
    }
    public HomePage clickPotSlottyLogo(){
        clickElement(potSlottyLogo);
        return new HomePage();
    }

    public TournamentPage clickTournaments(){
        clickElement(tournaments);
        return new TournamentPage();
    }

    public ResultsPage clickResults(){
        clickElement(tournaments);
        clickElement(results);
        return new ResultsPage();
    }

    public UpcomingPage clickUpcoming(){
        clickTournaments();
        clickElement(upcoming);
        return new UpcomingPage();
    }

    public EarnPage clickEarn(){
        clickElement(earn);
        return new EarnPage();
    }
    public DepositPage clickDepositButtonHeader(){
        clickElement(depositButtonHeader);
        return new DepositPage();
    }
    public ProfilePage clickAvtar(){
        waitForPageLoaded();
        clickElement(avatar);
        return new ProfilePage();

    }


    public void clickSwitchWallet(){
        clickElement(switchWallet);
    }
    public void clickSelectMYR(){
        clickElement(selectMYR);
    }
    public void switchToTonWallet(){
        clickElement(switchWallet);
        clickElement(selectTON);
    }
    public void switchToVNDWallet(){
        clickElement(switchWallet);
        clickElement(selectVND);
    }
    public void switchToMYRWallet(){
        clickElement(switchWallet);
        clickElement(selectMYR);
    }

    public int getCurrentBalance(){
        return Integer.parseInt(getElementText(switchWallet));
    }

    public  ProfilePage clickOnProfile(){
        clickElement(avatar);
        return new ProfilePage();
    }
    public  TermAndConPage clickOnTermAndCondition(){
        clickElement(termAndCon);
        return new TermAndConPage();
    }
    public  DepositPage clickOnDeposit(){
        clickElement(depositButtonHeader);
        return new DepositPage();
    }
    public  SearchPage clickOnSearchIcon(){
        clickElement(searchButton);
        waitForPageLoaded();
        return new SearchPage();
    }
}
