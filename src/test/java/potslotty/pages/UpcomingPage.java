package potslotty.pages;

import constants.ConstantGlobal;
import org.openqa.selenium.By;
import keywords.Keyword;

import static keywords.Keyword.verifyElementDisable;
import static keywords.Keyword.verifyURL;


public class UpcomingPage {
    private By titleUpcoming = By.xpath("//h2[normalize-space()='Upcoming']");
    public void userCanSeeUpcomingTitle(){
        DepositPage depositPage = new DepositPage();
        verifyElementDisable(depositPage.depositButton);
        Keyword.verifyElementVisible(titleUpcoming);
        Keyword.verifyContainText(titleUpcoming,"UPCOMING");
        verifyURL(ConstantGlobal.URL_UPCOMING);
    }
}
