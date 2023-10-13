package potslotty.pages;

import constants.ConstantGlobal;
import io.cucumber.messages.types.StepKeywordType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static keywords.Keyword.*;

public class ResultsPage extends TournamentPage{
    private By allResultsLabel = By.xpath("//h2[normalize-space()='All Results']");
    private By endingTournaments = By.xpath("//div[@class='col-12']");

    public void userCanSeeAllResultsLabel(){
        verifyElementVisible(allResultsLabel);
    }
    public void userCanSeeEndingTournaments(){
        verifyElementVisible(endingTournaments);
        DepositPage depositPage = new DepositPage();
        verifyElementDisable(depositPage.depositButton);
        verifyURL(ConstantGlobal.URL_RESULTS);
    }

    public void userCanSeeDetailFirstResults(){
        clickFirstTournament();
        userCanSeeInformationTournament(1);
        userCanSeePrizePoolDetail(1);
        userCanSeeDetailLeaderBoard(1);
    }
}
