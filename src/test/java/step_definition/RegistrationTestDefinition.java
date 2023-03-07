package step_definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonMethods;
import util.Config;

public class RegistrationTestDefinition extends CommonMethods{
	
	@When("User creates new account with username and password")
	public void user_creates_new_account_with_username_and_password() {
	    doRegistration();
	}
	@Then("Verify account is created and on dashboard page")
	public void verify_account_is_created_and_on_dashboard_page() {
	    assertDisplayed(up.dashboardLink);
	}
	
	@When("User enter invalid email and valid password in registration fields")
	public void user_enter_invalid_email_and_valid_password_in_registration_fields() {
	    doRegistration(Config.getUserData("falseUserName"),Config.getUserData("userPassword"));
	}
	@Then("Validate please provide valid email error displayed")
	public void validate_please_provide_valid_email_error_displayed() {
	    assertDisplayed(map.pleaseProvideValidEmaillError);
	}
	
	@When("User enter empty email and valid password in registration fields")
	public void user_enter_empty_email_and_valid_password_in_registration_fields() {
	    doRegistration("", Config.getUserData("userPassword"));
	}
	
	@When("User enter valid email and empty password in registration fields")
	public void user_enter_valid_email_and_empty_password_in_registration_window() {
	    doRegistrationEmptyPassword(randomMailGenerator(), "");
	}
	@Then("Validate please enter password error displayed")
	public void validate_please_enter_password_error_displayed() {
	    assertDisplayed(map.pleaseEnterPasswordError);
	}
	
	@When("User enter empty email and empty password in registration fields")
	public void user_enter_empty_email_and_empty_password_in_registration_fields() {
	    doRegistrationEmptyPassword("", "");
	}


}
