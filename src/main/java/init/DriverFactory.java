package init;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import constants.confg.Config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {
	public final static int TIMEOUT_SECONDS = 4000;
	public DesiredCapabilities capability;
	private static ThreadLocal<AppiumDriver<MobileElement>> mobileDriver = new ThreadLocal<AppiumDriver<MobileElement>>();

	public DriverFactory() throws IOException {

		capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", Config.PLATFORM_VERSION);
		capability.setCapability("deviceName", Config.DEVICE_NAME);
		capability.setCapability("udid", Config.DEVICE_UDID);
		capability.setCapability("app", Config.APP);
		capability.setCapability("autoGrantPermissions", true);
		capability.setCapability("gpsEnabled", true);
		capability.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 4000);
		capability.setCapability("newCommandTimeout", TIMEOUT_SECONDS);
		mobileDriver.set(new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:" + Config.PORT_NUMBER + "/wd/hub"),
				capability));
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public static synchronized AppiumDriver<MobileElement> getDriver() {
		return mobileDriver.get();
	}

}
