package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import constants.confg.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class AppPage extends BasePage {

	public AppPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	// locators
	By getStartedBtn = By.xpath("//*[@text='Get Started']");
	By continueBtn = By.xpath("//*[@text='Continue']");
	By doneBtn = By.xpath("//*[@text='Done']");
	By teamName = By.id("com.fivemobile.thescore:id/team_name");
	By playerName = By.xpath("//*[@text='P. Siakam']");
	By teamStats = By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]");
	By followIcon = By.xpath("//*[@resource-id=\"com.fivemobile.thescore:id/follow_icon\"]");
	By teamStatsTable = By.id("com.fivemobile.thescore:id/recyclerView");
	By searchBox = By.id("com.fivemobile.thescore:id/search_bar_text_view");
	By searchField = By.id("com.fivemobile.thescore:id/search_src_text");
	By maybeLaterLocationBtn = By.id("com.fivemobile.thescore:id/btn_disallow");
	By cancelPopUp = By.id("com.fivemobile.thescore:id/dismiss_modal");
	By playerStats = By.xpath("//android.widget.LinearLayout[@content-desc=\"Player Stats\"]/android.widget.TextView");


	public void clickOnGetStarted() {
		click(getStartedBtn);
	}

	public void clickOnContinue() {
			click(continueBtn);
	}

	public void clickOnDone() {
		click(doneBtn);
	}

	public void clickOnFollowIcon() {
		click(followIcon);
	}

	public void clickOnTeamStats() {
		click(teamStats);
	}

	public void searchTeam() throws InterruptedException {
		click(searchBox);
		enterData(searchField, Config.TEAM);
	}

	public String getTeamName() {
		return getText(teamName);
	}

	public String getPlayerName(){
		return getText(playerName);
	}

	public Boolean isTeamStatsTablePresent() {
		return isElementPresent(teamStatsTable);
	}

	public Boolean isSearchScreenPresent() {
		return isElementPresent(searchField);
	}

	public Boolean isTeamStatsSelected() {
		return isElementSelected(teamStats);
	}

	public Boolean isPlayerStatsSelected(){
		return isElementSelected(playerStats);
	}

	public void clickOnTeam() {
		By teamName = By.id("com.fivemobile.thescore:id/txt_name");
		click(teamName);
	}

	public void cancelPopup(){
		click(cancelPopUp);
	}

	public void clickOnMayBeLater(){
		click(maybeLaterLocationBtn);
	}
	public void clickOnPlayerStats(){
		click(playerStats);
	}

}
