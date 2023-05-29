package constants.confg;

import java.io.File;

import constants.path.Path;
import utils.FileOperations;

public interface Config {
	
	/**VARIABLES**/

	//APP CONFIG DATA
	String PLATFORM_VERSION = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "platformVersion");
	String DEVICE_NAME = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "deviceName");
	String DEVICE_UDID = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "deviceUdid");
	String PORT_NUMBER = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "portNumber");
	String APP = Path.PROJECT_PATH + File.separator + "app" + File.separator+ FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "app");
	String TEAM = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "team");
	String PLAYER_NAME = FileOperations.getConfigValue(Path.CONFIG_MOB_FILE_PATH, "player");
}
