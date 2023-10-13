package potslotty.tournaments;

import keywords.Keyword;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import potslotty.pages.CommonPage;
import potslotty.pages.TournamentPage;

import static keywords.Keyword.*;

public class ScreenManager extends TournamentPage {
    private Screen screen;
    private TournamentPage tournamentPage;
    private CommonPage commonPage;
    private String filePath;
    private String inputFilePath = "C:\\Users\\nguyenhuutruonglong\\Desktop\\photo\\";
    private String playGamePath = "playGame.PNG";
    private String autoPlayPath = "autoPlay.PNG";
    private String closePath = "close.PNG";
    private String dragNumberOfAutoSpinPath = "dragNumberOfAutoSpin.PNG";
    private String increaseBetPath = "increaseBet.PNG";
    private String optionPath = "option.PNG";
    private String quickSpinPath = "quickSpin.PNG";
    private String startAutoPlayPath = "startAutoPlay.PNG";
    private String turbo = "turbo.PNG";
    private String spinOneTime = "spinOneTime.PNG";

    public void setFilePath(String path){
        this.filePath = "C:\\Users\\LongLaptop\\Desktop\\photo\\" + path + "\\";
    }
    public String getFilePath(){
        return this.filePath;
    }
    public Pattern playGame(){
        return new Pattern(getFilePath() + playGamePath);
    }
    public Pattern autoPlay(){
        return new Pattern(getFilePath() + autoPlayPath);
    }
    public Pattern close(){
        return new Pattern(getFilePath() + closePath);
    }
    public Pattern dragNumberOfAutoSpin(){
        return new Pattern(getFilePath() + dragNumberOfAutoSpinPath);
    }
    public Pattern increaseBet(){
        return new Pattern(getFilePath() + increaseBetPath);
    }
    public Pattern option(){
        return new Pattern(getFilePath() + optionPath);
    }
    public Pattern quickSpin(){
        return new Pattern(getFilePath() + quickSpinPath);
    }
    public Pattern startAutoPlay(){
        return new Pattern(getFilePath() + startAutoPlayPath);
    }
    public Pattern turbo(){
        return new Pattern(getFilePath() + turbo);
    }
    public Pattern spinOneTime(){
        return new Pattern(getFilePath() + spinOneTime);
    }

    public ScreenManager(){
        screen = new Screen();
        tournamentPage = new TournamentPage();
        commonPage = new CommonPage();
    }
    public void selectGame(String game, int tournamentIndex){
        switch (game.trim().toLowerCase()){
            case "jurassic kingdom":
            case "mystical spirits":
            case "COCKTAIL NIGHTS":
            case "cocktail nights":
            case "the queens banquet":

                playGamePgSoft(tournamentIndex);
                break;
            default:
                break;
        }
    }
    public void playGamePragmatic(){
        scrollToElement(play);
        clickElement(play);
        clickElement(rejoin);
        clickAndWaitImage(playGame());
        clickAndWaitImage(option());
        clickImageMultipleTime(increaseBet());
        clickAndWaitImage(close());
        clickAndWaitImage(autoPlay());
        clickAndWaitImage(autoPlay());
        clickAndWaitImage(quickSpin());
        clickAndWaitImage(dragNumberOfAutoSpin());
        clickAndWaitImage(startAutoPlay());
        tournamentPage.waitAndClickOkButton(3000);
    }
    public void playGamePgSoft(int tournamentIndex){
        scrollToElement(playTournament(tournamentIndex));
        clickElement(playTournament(tournamentIndex));
        clickElement(rejoin);
        clickAndWaitImage(playGame());
        clickAndWaitImage(option());
        clickAndWaitImage(increaseBet());
        clickAndWaitImage(close());
        clickAndWaitImage(turbo());
        clickAndWaitImage(spinOneTime());
        clickAndWaitImage(spinOneTime());
        clickAndWaitImage(autoPlay());
        clickAndWaitImage(quickSpin());
        clickAndWaitImage(dragNumberOfAutoSpin());
        clickAndWaitImage(startAutoPlay());
        tournamentPage.waitAndClickOkButton(3000);
    }
}
