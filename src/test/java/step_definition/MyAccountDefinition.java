package step_definition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.CommonMethods;

public class MyAccountDefinition extends CommonMethods{
	
	@When("User clicks on order link")
	public void user_clicks_on_order_link() {
	    click(up.ordersLink);
	}
	@When("User clicks on view link")
	public void user_clicks_on_view_link() {
	    click(up.viewLink);
	}
	@Then("Verify order details text is displayed")
	public void verify_order_details_text_is_displayed() {
		assertDisplayed(up.ordersDetailsText);
	}
	@Then("Verify Order details customer details and billing details")
	public void verify_order_details_customer_details_and_billing_details() {
		assertDisplayed(up.ordersDetailsText, up.billingAddressText, up.customerDetailsText);
	}
	
	@Then("Verify orderNumberText orderDateText and orderStatusText")
	public void verify_order_number_text_order_date_text_and_order_status_text() {
		assertDisplayed(up.orderNumberText, up.orderDateText, up.orderStatusText);
	}
	
	@When("User clicks on address link")
	public void user_clicks_on_address_link() {
		click(up.addressLink);
	}
	@Then("Verify billing address and shipping address")
	public void verify_billing_address_and_shipping_address() {
		assertDisplayed(up.billingAddress, up.shippingAddress);
	}
	
	@When("User clicks on shipping address edit button")
	public void user_clicks_on_shipping_address_edit_button() {
		click(up.shippingAddressEditButton);
	}
	@Then("Verify shipping address save button is displayed")
	public void verify_shipping_address_save_button_is_displayed() {
		assertDisplayed(up.saveAddressButton);
	}
	
	@When("User clicks on account details link")
	public void user_clicks_on_account_details_link() {
		click(up.accountDetails);
	}
	@Then("Verify change password options is displayed")
	public void verify_change_password_options_is_displayed() {
		assertDisplayed(up.changePasswordBox);
	}
	
	@When("User clicks logout Link")
	public void user_clicks_logout_link() {
		click(up.logoutLink);
	}
	@Then("Verify if user is landed on login page")
	public void verify_if_user_is_landed_on_login_page() {
		assertDisplayed(map.userNameBoxLogin);
	}






}
