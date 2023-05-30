package pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import constants.confg.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class AppPage extends BasePage {

	public AppPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	// locators
	@AndroidFindBy(id= "com.fivemobile.thescore:id/team_name")
	WebElement teamName;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_bar_text_view")
	WebElement searchBox;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/search_src_text")
	WebElement searchField;

	@AndroidFindBy(id = "com.fivemobile.thescore:id/dismiss_modal")
	WebElement cancelPopUp;

	@AndroidFindBy(id= "com.fivemobile.thescore:id/txt_name")
	WebElement teamName1;

	//By getStartedBtn = By.xpath("//*[@text='Get Started']");
	//By continueBtn = By.xpath("//*[@text='Continue']");
	//By doneBtn = By.xpath("//*[@text='Done']");
	//By teamName = By.id("com.fivemobile.thescore:id/team_name");
	//By playerName = By.xpath("//*[@text='P. Siakam']");
	//By teamStats = By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]");
	//By followIcon = By.xpath("//*[@resource-id=\"com.fivemobile.thescore:id/follow_icon\"]");
	//By teamStatsTable = By.id("com.fivemobile.thescore:id/recyclerView");
	//By searchBox = By.id("com.fivemobile.thescore:id/search_bar_text_view");
	//By searchField = By.id("com.fivemobile.thescore:id/search_src_text");
	//By maybeLaterLocationBtn = By.id("com.fivemobile.thescore:id/btn_disallow");
	//By cancelPopUp = By.id("com.fivemobile.thescore:id/dismiss_modal");
	//By playerStats = By.xpath("//android.widget.LinearLayout[@content-desc=\"Player Stats\"]/android.widget.TextView");

	public void searchTeam() throws InterruptedException {
		clickWhenElementVisible(searchBox, 20);
		enterData(searchField, Config.TEAM);
	}

	public String getTeamName() {
		return getText(teamName);
	}

	public Boolean isSearchScreenPresent() {
		return isElementPresent(searchField);
	}

	public void clickOnTeam() {
		//By teamName = By.id();
		clickWhenElementVisible(teamName1, 20);
	}

	public void cancelPopup(){
		clickWhenElementVisible(cancelPopUp, 20);
	}


}
