package step_definition;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.BaseClass;
import util.CommonMethods;
import util.Config;
import util.FakerClass;

public class ShopDefinition extends CommonMethods{
	
	@When("User clicks on shop menu")
	public void user_clicks_on_shop_menu() {
		if(System.getProperty("os.name").toLowerCase().contains("mac")) {
		click(hp.shopMenuLink);
		refresh();
		click(hp.shopMenuLink);
		} else if(System.getProperty("os.name").toLowerCase().contains("windows")) {
			click(hp.shopMenuLink);
		}
	}
	@When("User adjust the filter by price between {int} to {int} rps")
	public void user_adjust_the_filter_by_price_between_to_rps(Integer int1, Integer int2) {
		dragAndDrop(hp.rightSlider, -28, 0);
	}
	@When("User clicks on filter button")
	public void user_clicks_on_filter_button() {
		click(hp.filterButton);
	}
	@Then("Verify books priced {int} to {int} only")
	public void verify_books_priced_to_only(Integer int1, Integer int2) {
		ArrayList<Double> pricesAmount = new ArrayList<>();
		justPrice(hp.newPrices, pricesAmount);
		justPrice(hp.prices, pricesAmount);
		Double low = justPrice(hp.fromPrice);
		Double high = justPrice(hp.toPrice);
		
		for (Double unit : pricesAmount) {
			Assert.assertTrue(unit >= low && unit <= high);
		}
	}
	
	@When("User clicks on html link")
	public void user_clicks_on_html_link() {
		click(hp.htmlLink);
	}
	@Then("Verify link contains only html related books")
	public void verify_link_contains_only_html_related_books() {
		String bookCategory = "html";
		for (WebElement element : hp.bookTitles) {
			Assert.assertTrue(element.getText().toLowerCase().contains(bookCategory));
		}
	}
	
	@When("User chooses popular on drop down options")
	public void user_chooses_popular_on_drop_down_options() {
		dropDown("popularity", hp.sortingDropDown);
	}
	
	@Then("Verify user can see popular products only")
	public void verify_user_can_see_popular_products_only() {
//		for (WebElement element : hp.popularBooks) {
//			assertDisplayed(element);
//		}
		menuEachDisplayed(hp.popularBooks);
	}
	
	@When("User chooses average on drop down options")
	public void user_chooses_average_on_drop_down_options() {
		dropDown("rating", hp.sortingDropDown);
	}
	
	@When("User chooses date on drop down options")
	public void user_chooses_date_on_drop_down_options() {
		dropDown("date", hp.sortingDropDown);
	}
	
	@When("User chooses prices on drop down options")
	public void user_chooses_prices_on_drop_down_options() {
		dropDown("price", hp.sortingDropDown);
	}
	
	@When("User clicks on read more button")
	public void user_clicks_on_read_more_button() {
		scrollBy(600);
		click(hp.readMoreButton);
	}
	@Then("Verify out of stock label")
	public void verify_out_of_stock_label() {
		assertDisplayed(hp.outOfStock);
	}
	
	@When("User clicks on sale written product")
	public void user_clicks_on_sale_written_product() {
	    click(hp.onSaleProduct);
	}
	@Then("Verify product has both old and new price")
	public void verify_product_has_both_old_and_new_price() {
		assertDisplayed(hp.bookOnSaleNewPrice, hp.bookOnSaleOldPrice);
	}
	
	@When("User scroll by {int}")
	public void user_scroll_by(Integer int1) {
	    scrollBy(int1);
	}
	
	@When("User clicks on javascript book image")
	public void user_clicks_on_javascript_book_image() {
		click(hp.javaScriptBookLink);
	}
	@When("User clicks on add to basket")
	public void user_clicks_on_add_to_basket() {
		click(hp.addToBasket);
	}
	@When("User clicks on cart link in menu")
	public void user_clicks_on_cart_link_in_menu() {
		click(hp.cartLinkInMenu);
	}
	@Then("Veify total is higher than subtotal")
	public void veify_total_is_higher_than_subtotal() {
		String totalAmountInText = hp.totalAmount.getText().substring(1, hp.totalAmount.getText().length() -1);
		String subtotalAmountInText = hp.subtotalAmount.getText().substring(1, hp.subtotalAmount.getText().length() -1);
		double total = Double.parseDouble(totalAmountInText);
		double subtotal = Double.parseDouble(subtotalAmountInText);
		Assert.assertTrue(total > subtotal);
	}
	@Then("User clicks on proceed to checkout")
	public void user_clicks_on_proceed_to_checkout() {
		click(hp.proceedToCheckOutButton);
	}
	@Then("Verify billing details additional details and your order info is displayed")
	public void verify_billing_details_additional_details_and_your_order_info_is_displayed() {
		assertDisplayed(cp.billingDetails, cp.additionalInfo, cp.yourOrderInfo);
	}
	@Then("Fills all info at checkout page")
	public void fills_all_info_at_checkout_page() {
		sendText(cp.firstNameBox, FakerClass.randomFirstName());
		sendText(cp.lastNameBox, FakerClass.randomLastName());
		sendText(cp.emailBox, randomMailGenerator());
		sendText(cp.phoneBox, FakerClass.randomNumber());
		scrollBy(400);
		click(cp.countryDrop);
		sendTextEnter(cp.countryBoxSearch, Config.getUserData("country"));
		sendText(cp.addressLine1, Config.getUserData("address"));
		sendText(cp.townDistrict, FakerClass.randomCity());
		scrollBy(400);
		click(cp.regionDropDown);
		sendTextEnter(cp.stateSearchBox, Config.getUserData("region"));
		sendText(cp.postCode, FakerClass.randomZip());
		javaClick(cp.cashOnDelivery);
	}
	@Then("User clicks on place order button")
	public void user_clicks_on_place_order_button() {
		javaClick(cp.placeOrder);
	}
	@Then("Verify order confirmation number is dislplayed")
	public void verify_order_confirmation_number_is_dislplayed() {
		assertDisplayed(cp.orderConfirmationNumber);
	}
	
	@When("User refreshes the page")
	public void user_refreshes_the_page() {
	    BaseClass.getDriver().navigate().refresh();
	}

	








	
	



	
	






}
