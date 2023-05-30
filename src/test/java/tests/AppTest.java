package tests;

import logging.Log;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import constants.confg.Config;
import init.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import listner.ReportListener;
import pages.AppPage;
import pages.LeaguesPage;
import pages.LoginPage;
import pages.TeamDetailsPage;

public class AppTest {
	SoftAssert softAssert;

	public DriverFactory driverFactory;
	public AppiumDriver<MobileElement> driver;
	public AppPage appPage;
	public LoginPage loginPage;
	public LeaguesPage leaguesPage;
	public TeamDetailsPage teamDetailsPage;
	ReportListener reportListener;
	String TAG = this.getClass().getName();
	@BeforeTest(alwaysRun = true)
	public void startUp() throws Exception {
		this.driverFactory = new DriverFactory();
		this.driver = DriverFactory.getDriver();
		appPage = new AppPage(driver);
		leaguesPage = new LeaguesPage(driver);
		loginPage = new LoginPage(driver);
		teamDetailsPage = new TeamDetailsPage(driver);
		softAssert = new SoftAssert();
	}

	@Test(alwaysRun = true)
	public void verifyTeam() throws Exception {
		Log.info(TAG, "Execution is starting");
		loginPage.clickOnGetStarted();
		leaguesPage.clickOnContinue();
		leaguesPage.clickOnFollowIcon();
		Log.debug(TAG,"Marked GSW as fav team");
		leaguesPage.clickOnContinue();
		leaguesPage.clickOnDone();
		Log.debug(TAG,"Navigated to HomePage");
		appPage.cancelPopup();
		Log.debug(TAG,"Clicked on ON region cancel pop");
		appPage.searchTeam();
		appPage.clickOnTeam();
		Log.debug(TAG,"Searched and selected the team");
		softAssert.assertEquals(appPage.getTeamName(), Config.TEAM, "Team page is not opened");
		teamDetailsPage.clickOnTeamStats();
		softAssert.assertTrue(teamDetailsPage.isTeamStatsSelected(), "Team stats is not selected");
		softAssert.assertTrue(teamDetailsPage.isTeamStatsTablePresent(), "Team stats table is not present");
		teamDetailsPage.clickOnPlayerStats();
		Assert.assertTrue(teamDetailsPage.isPlayerStatsSelected(), "Player stats is not selected");
		softAssert.assertTrue(teamDetailsPage.isTeamStatsTablePresent(), "Player stats table is not present");
		Assert.assertEquals(teamDetailsPage.getPlayerName(), Config.PLAYER_NAME, "Player name dosent match with team");

		appPage.backToNavigate();
		softAssert.assertTrue(appPage.isSearchScreenPresent(), "Search screen is not present");
		ReportListener.logToReport("App test completed successfully");
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.closeApp();
	}
}
