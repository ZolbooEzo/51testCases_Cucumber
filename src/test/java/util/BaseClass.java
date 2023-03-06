package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			String browser = Config.getRequiredData("browser");
			switch (browser) {

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":
				if (System.getProperty("os.name").toLowerCase().contains("windows"))
					WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			case "safari":
				if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
					throw new WebDriverException("Your os does not support safari");
				}
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			}

			driver.manage().window().maximize();
			driver.get(Config.getRequiredData("url"));
			PageInitializer.initializer();
		}

		return driver;
	}

	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
