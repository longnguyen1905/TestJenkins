package potslotty.pages;

import constants.ConstantGlobal;
import org.openqa.selenium.By;

import static keywords.Keyword.*;

public class TermAndConPage {
    private By titleTermAndCondition = By.xpath("//h2[normalize-space()='PotSlotty']");
    public void userWillBeRedirectedToTermAndConditionPage(){
        verifyElementVisible(titleTermAndCondition);
        verifyURL(ConstantGlobal.URL_TERM_AND_CONDITION);
    }
}
