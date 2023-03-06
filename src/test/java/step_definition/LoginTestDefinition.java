package step_definition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.BaseClass;
import util.CommonMethods;
import util.Config;

public class LoginTestDefinition extends CommonMethods{
	
	
	@Given("User is on home page")
	public void user_is_on_home_page() {
	    Assert.assertEquals(BaseClass.getDriver().getCurrentUrl(), Config.getRequiredData("url"));
	}

	@When("User clicks on myaccout link")
	public void user_clicks_on_myaccout_link() {
		if(System.getProperty("os.name").toLowerCase().contains("mac")) {
	    click(hp.myAccountLink);
	    refresh();
	    click(hp.myAccountLink);
		} else if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			click(hp.myAccountLink);
		}
	}

	@Then("Verify my accountlink page")
	public void verify_my_accountlink_page() {
	    Assert.assertEquals(BaseClass.getDriver().getCurrentUrl(), Config.getRequiredData("myAccountLink"));
	}
	
	@When("Login with valid credentials")
	public void login_with_valid_credentials() {
	    doLogin();
	}
	
	@Then("Verify dashboard link is displayed")
	public void verify_dashboard_link_is_displayed() {
	    assertDisplayed(chooseMenu("Dashboard"));
	}
	
	@When("Login with false username and password")
	public void login_with_false_username_and_password() {
	    doLogin(Config.getUserData("falseUserName"), Config.getUserData("falsePassword"));
	}
	@Then("Verify not registered error message")
	public void verify_error_message() {
	    assertDisplayed(hp.notRegisteredError);
	}
	
	@When("Login with valid username and empty password")
	public void login_with_valid_username_and_empty_password() {
	    doLoginUserName(Config.getUserData("userName"));
	}
	
	@Then("Verify password is required error message")
	public void verify_password_is_required_error_message() {
	    assertDisplayed(hp.passwordRequiredError);
	}
	
	@When("Login with empty password and valid password")
	public void login_with_empty_password_and_valid_password() {
	    doLoginPassword(Config.getUserData("userPassword"));
	}
	@Then("Verify user name required error")
	public void verify_user_name_required_error() {
	    assertDisplayed(hp.userNameRequiredError);
	}
	
	@When("Login with empty user name and empty password")
	public void login_with_empty_user_name_and_empty_password() {
	    doLogin("", "");
	}
	
	@When("Enter password in password box field")
	public void enter_password_in_password_box_field() {
	    sendText(map.passwordBoxLogin, Config.getUserData("userPassword"));
	}
	@Then("Verify password is masked")
	public void verify_password_is_masked() {
	    Assert.assertTrue(map.passwordBoxLogin.getAttribute("type").equalsIgnoreCase(Config.getRequiredData("passwordType")));
	}
	
	@When("Enter user name and password all lower case")
	public void enter_user_name_and_password_all_lower_case() {
	    doLogin(Config.getUserData("userName").toLowerCase(), Config.getUserData("userPassword").toLowerCase());
	}
	@Then("Verify lost your password error is displayed")
	public void verify_lost_your_password_error_is_displayed() {
	    assertDisplayed(hp.lostYourPasswordLink);
	}
	
	@When("click signout")
	public void click_signout() {
	    click(up.signOutLink);
	}
	@When("hit back button")
	public void hit_back_button() {
	    BaseClass.getDriver().navigate().back();
	}
	
	@Then("Verify user is on my account page")
	public void verify_user_is_on_my_account_page() {
		Assert.assertEquals(BaseClass.getDriver().getCurrentUrl(), Config.getRequiredData("myAccountLink"));
	}




	
}
