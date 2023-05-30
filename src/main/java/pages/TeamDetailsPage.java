package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TeamDetailsPage extends BasePage{
    public TeamDetailsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Player Stats\"]/android.widget.TextView")
    WebElement playerStats;

    @AndroidFindBy(id = "com.fivemobile.thescore:id/recyclerView")
    WebElement teamStatsTable;

    @AndroidFindBy(xpath = "//*[@text='P. Siakam']")
    WebElement playerName;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Team Stats\"]")
    WebElement teamStats;

    @AndroidFindBy(id= "com.fivemobile.thescore:id/team_name")
    WebElement teamName;



    public void clickOnTeamStats() {
        clickWhenElementVisible(teamStats, 20);
    }
    public String getPlayerName(){
        return getText(playerName);
    }

    public Boolean isTeamStatsTablePresent() {
        return isElementPresent(teamStatsTable);
    }
    public Boolean isTeamStatsSelected() {
        return isElementSelected(teamStats);
    }

    public Boolean isPlayerStatsSelected(){
        return isElementSelected(playerStats);
    }

    public void clickOnPlayerStats(){
        clickWhenElementVisible(playerStats, 20);
    }

}
