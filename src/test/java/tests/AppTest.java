package tests;

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

public class AppTest {
	SoftAssert softAssert;

	public DriverFactory driverFactory;
	public AppiumDriver<MobileElement> driver;
	AppPage appPage;

	@BeforeTest(alwaysRun = true)
	public void startUp() throws Exception {
		this.driverFactory = new DriverFactory();
		this.driver = DriverFactory.getDriver();
		appPage = new AppPage(driver);
		softAssert = new SoftAssert();
	}

	@Test(alwaysRun = true)
	public void verifyTeam() throws Exception {
		appPage.clickOnGetStarted();
		appPage.clickOnContinue();
		appPage.clickOnFollowIcon();
		appPage.clickOnContinue();
		appPage.clickOnDone();
		appPage.cancelPopup();
		appPage.searchTeam();
		appPage.clickOnTeam();
		softAssert.assertEquals(appPage.getTeamName(), Config.TEAM, "Team page is not opened");
		appPage.clickOnTeamStats();
		softAssert.assertTrue(appPage.isTeamStatsSelected(), "Team stats is not selected");
		softAssert.assertTrue(appPage.isTeamStatsTablePresent(), "Team stats table is not present");
		appPage.clickOnPlayerStats();
		Assert.assertTrue(appPage.isPlayerStatsSelected(), "Player stats is not selected");
		softAssert.assertTrue(appPage.isTeamStatsTablePresent(), "Player stats table is not present");
		Assert.assertEquals(appPage.getPlayerName(), Config.PLAYER_NAME, "Player name dosent match with team");

		appPage.backToNavigate();
		softAssert.assertTrue(appPage.isSearchScreenPresent(), "Search screen is not present");
		ReportListener.logToReport("App test completed successfully");
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.closeApp();
	}
}
