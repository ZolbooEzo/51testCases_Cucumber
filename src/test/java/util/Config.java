package util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config {

	private static Properties userData;
	private static Properties requiredData;

	static {

		try {

			String userDataFilePath = "src\\test\\resources\\configFolders\\userData.properties";
			String requiredDataFilePath = "src\\test\\resources\\configFolders\\required.properties";

			FileInputStream fisUser = new FileInputStream(userDataFilePath);
			FileInputStream fisRequired = new FileInputStream(requiredDataFilePath);

			userData = new Properties();
			requiredData = new Properties();

			userData.load(fisUser);
			requiredData.load(fisRequired);

			fisUser.close();
			fisRequired.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static String getUserData(String userKey) {
		return userData.getProperty(userKey);
	}
	
	public static String getRequiredData(String requiredKey) {
		return requiredData.getProperty(requiredKey);
	}
}
