package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer{
	
	public static String getTimeStamp() {
	       Date date = new Date();
	       SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	       return sdf.format(date.getTime());
	   }
	
	public static byte[] takeScreenshot(String filename) {
	      TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
	      byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

	       File file = ts.getScreenshotAs(OutputType.FILE);
	       String destinationFile = Constants.screenShotPath + filename + getTimeStamp() + ".png";

	       try {
	           FileUtils.copyFile(file, new File(destinationFile));
	       } catch (Exception ex) {
	           System.out.println("Cannot take screenshot!");
	       }

	       return picBytes;
	   }
	
	
	
	public static void assertDisplayed(WebElement element) {
		waitForVisibility(element);
		Assert.assertTrue(element.isDisplayed());
	}

	public static WebElement waitForClick(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static List<WebElement> waitForVisibility(List<WebElement> element) {
		return getWaitObject().until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void click(WebElement element) {
		waitForClick(element).click();
		;
	}

	public static void sendText(WebElement element, String message) {
		waitForVisibility(element).clear();
		element.sendKeys(message);
	}
	
	public static void sendTextPassword(WebElement element, String message) {
		waitForVisibility(element).clear();
		element.sendKeys(message);
		wait(1);
		element.sendKeys("a");
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Constants.explicitWait);
		return wait;
	}

	public static void wait(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static boolean isPalindrome(String str) {
		String storage = "";
		
		for(int i = str.length() -1; i >= 0; i--) {
			storage += str.charAt(i);
		}
		
		if(storage.equalsIgnoreCase(str)) {
			return true;
		} return false;
	}
	
	public static String randomMailGenerator() {
		Random random = new Random();
		String str = "abcdefghijklmnopqrvwxyz";
		String storage = "";
		for(int i = 0; i < 8;i++) {
			storage += str.charAt(random.nextInt(str.length()));
		}
		return storage + "@gmail.com";
	}
	
	public static WebElement chooseMenu(String menuName) {
		for(WebElement each : up.menuList) {
			if(each.getText().equalsIgnoreCase(menuName)) {
				return each;
			}
		}
		return null;
	}
	
	public static WebElement chooseMenu(List<WebElement> list, String menuName) {
		for(WebElement each : list) {
			if(each.getText().equalsIgnoreCase(menuName)) {
				return each;
			}
		}
		return null;
	}
	
	public static WebElement chooseMenuClick(List<WebElement> list, String menuName) {
		for(WebElement each : list) {
			if(each.getText().equalsIgnoreCase(menuName)) {
				each.click();
			}
		}
		return null;
	}
	
	public static void refresh() {
		BaseClass.getDriver().navigate().refresh();
	}
	
	public static void doLogin() {
		sendText(map.userNameBoxLogin, Config.getUserData("userName"));
	    sendText(map.passwordBoxLogin, Config.getUserData("userPassword"));
	    click(map.loginButton);
	}
	
	public static void doLogin(String userName, String password) {
		sendText(map.userNameBoxLogin, userName);
	    sendText(map.passwordBoxLogin, password);
	    click(map.loginButton);
	}
	
	public static void doLoginUserName(String userName) {
		sendText(map.userNameBoxLogin, userName);
	    click(map.loginButton);
	}
	
	public static void doLoginPassword(String password) {
		sendText(map.passwordBoxLogin, password);
	    click(map.loginButton);
	}
	
	public static void doRegistration() {
		sendText(map.registerUserNameBox, randomMailGenerator());
		sendTextPassword(map.registerPasswordBox, Config.getUserData("userPassword"));
		click(map.registerButton);
	}
	
	public static void doRegistration(String userName, String password) {
		sendText(map.registerUserNameBox, userName);
		sendTextPassword(map.registerPasswordBox, password);
		click(map.registerButton);
	}
	
	public static void doRegistrationEmptyPassword(String userName, String password) {
		sendText(map.registerUserNameBox, userName);
		sendText(map.registerPasswordBox, password);
		click(map.registerButton);
	}
	
	public static void assertDisplayed(WebElement e, WebElement e2) {
		waitForVisibility(e);
		waitForVisibility(e2);
		Assert.assertTrue(e.isDisplayed() && e2.isDisplayed());
	}
	
	public static void assertDisplayed(WebElement e, WebElement e2, WebElement e3) {
		waitForVisibility(e);
		waitForVisibility(e2);
		waitForVisibility(e3);
		Assert.assertTrue(e.isDisplayed() && e2.isDisplayed() && e3.isDisplayed());
	}
	
	
	
	
	
	
	
	
	
	

}
