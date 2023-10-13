package potslotty.tournaments;

import common.BaseTest;
import constants.ConstantGlobal;
import org.testng.annotations.Test;
import potslotty.pages.CommonPage;
import potslotty.pages.HomePage;
import potslotty.pages.TournamentPage;
import utils.LogUtils;

import static keywords.Keyword.openURL;

public class PlayTournament {
    public ScreenManager screenManager;
    public TournamentPage tournamentPage;
    public CommonPage commonPage;
    public HomePage homePage;

    public PlayTournament(){
        screenManager = new ScreenManager();
        tournamentPage = new TournamentPage();
        commonPage = new CommonPage();
    }

    @Test
    public void testGame(){
        for (int n =1 ; n < 100 ; n++){
            LogUtils.info("Profile =======================> " + n);
            BaseTest.createProfileDriver(n);
            openURL(ConstantGlobal.URL);
            for (int tournamentIndex = 1; tournamentIndex < 5 ; tournamentIndex++){
                LogUtils.info("Tounament======================> " +tournamentIndex);
                for (int rejoin = 7; rejoin > 0 ; rejoin--){
                    LogUtils.info("Rejoin ============================> " +rejoin);
                    screenManager.setFilePath(tournamentPage.getGameName(tournamentIndex));
                    screenManager.selectGame(tournamentPage.getGameName(tournamentIndex), tournamentIndex);
                }
            }
        }

    }
}
