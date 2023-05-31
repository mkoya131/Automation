package tests;

import logging.Log;
import org.apache.logging.log4j.Logger;
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

	private static Logger logger = Log.getNamedLogger(AppTest.class.getSimpleName());

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
		logger.debug("On Get Started Page");
		loginPage.clickOnGetStarted();
		leaguesPage.clickOnContinue();
		leaguesPage.clickOnFollowIcon();
		logger.debug("Marked GSW as fav team");
		leaguesPage.clickOnContinue();
		leaguesPage.clickOnDone();
		logger.debug("Navigated to HomePage");
		appPage.cancelPopup();
		logger.debug("Clicked on ON region cancel pop");
		appPage.searchTeam();
		appPage.clickOnTeam();
		logger.debug("Searched and selected the team");
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
