package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.BaseClass;
import util.CommonMethods;

public class MyAccountLinkPage extends CommonMethods{
	
	public MyAccountLinkPage(){
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy (xpath = "//*[@id='username']")
	public WebElement userNameBoxLogin;
	
	@FindBy (xpath = "//*[@id='password']")
	public WebElement passwordBoxLogin;
	
	@FindBy (xpath = "//*[@name='login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@id='reg_password']")
	public WebElement registerPasswordBox;
	
	@FindBy(xpath = "//*[@id='reg_email']")
	public WebElement registerUserNameBox;
	
	@FindBy(xpath = "//*[@name='register']")
	public WebElement registerButton;
	
	@FindBy (xpath = "//*[contains(text(),'Please provide a valid email address.')]")
	public WebElement pleaseProvideValidEmaillError;
	
	@FindBy (xpath = "//*[contains(text(),'Username is required')]")
	public WebElement userNameRequiredError;
	
	@FindBy (xpath = "//*[contains(text(),'Please enter an account password.')]")
	public WebElement pleaseEnterPasswordError;
	
	
	
}
