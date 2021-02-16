package com.automationpractice.stepdef;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automationpractice.base.BaseTest;
import com.automationpractice.pages.AddressPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.MyAccountPage;
import com.automationpractice.pages.OrderConfirmationPage;
import com.automationpractice.pages.OrderHistoryPage;
import com.automationpractice.pages.OrderSummaryPage;
import com.automationpractice.pages.PaymentPage;
import com.automationpractice.pages.ShippingPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import com.automationpractice.pages.TShirtsPage;
import com.automationpractice.pages.YourPersonalInformationPage;
import com.automationpractice.utility.Config;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationPracticeStepDef {
	public WebDriver driver;
	public String orderRefNumber = "";
	LoginPage loginPage;
	HomePage homePage;
	ShoppingCartSummaryPage shoppingCartSummaryPage;
	TShirtsPage tShirtsPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	MyAccountPage myAccountPage;
	OrderHistoryPage orderHistoryPage;
	YourPersonalInformationPage  yourPersonalInformationPage;

	@Before
	public void initDriver() throws IOException {
		BaseTest.setUp();
		driver = BaseTest.driver;
	}

	@After
	public void teardown() {
		BaseTest.driver.quit();
	}

	@Given("^I am on automationpractice website as login user$")
	public void I_am_on_automationpractice_website_as_login_user() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.login(Config.getConfigData("username"), Config.getConfigData("password"));
		homePage = new HomePage(driver);
	}

	@When("^I search for a t-shirt and add to cart$")
	public void I_search_for_a_t_shirt_and_add_to_cart() throws Throwable {
		homePage.clickOnTShirtsLink();
		tShirtsPage = new TShirtsPage(driver);
		tShirtsPage.addTShirtToCart();
		shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
	}

	@When("^I order the item added to cart$")
	public void I_order_the_item_added_to_cart() throws Throwable {
		Assert.assertEquals("ShoppingCartSummaryPage heading mismatch", "Shopping-cart summary",
				shoppingCartSummaryPage.getPageHeading());
		Assert.assertEquals("ShoppingCartSummaryPage product name mismatch", "Faded Short Sleeve T-shirts",
				shoppingCartSummaryPage.getProductName());
		shoppingCartSummaryPage.clickOnProceedToCheckout();
		addressPage = new AddressPage(driver);
		Assert.assertEquals("AddressPage heading mismatch", "Addresses", addressPage.getPageHeading());
		addressPage.clickOnProceedToCheckout();
		shippingPage = new ShippingPage(driver);
		Assert.assertEquals("ShippingPage heading mismatch", "Shipping", shippingPage.getPageHeading());
		shippingPage.agreeTermsAndConditions();
		shippingPage.clickOnProceedToCheckout();
		paymentPage = new PaymentPage(driver);
		Assert.assertEquals("PaymentPage heading mismatch", "Please choose your payment method",
				paymentPage.getPageHeading());
		paymentPage.selectPayByWrite();
		orderSummaryPage = new OrderSummaryPage(driver);
		Assert.assertEquals("OrderSummaryPage heading mismatch", "Order summary", orderSummaryPage.getPageHeading());
		Assert.assertEquals("Payment type mismatch", "Bank-wire payment.", orderSummaryPage.getPaymentHeading());
		orderSummaryPage.clickOnConfirmOrder();
	}

	@Then("^I shuold see the order confirmaton message$")
	public void I_shuold_see_the_order_confirmaton_message() throws Throwable {
		orderConfirmationPage = new OrderConfirmationPage(driver);
		Assert.assertEquals("OrderConfirmationPage heading mismatch", "Order confirmation",
				orderConfirmationPage.getPageHeading());
		Assert.assertEquals("Order confirmation message mismatch", "Your order on My Store is complete.",
				orderConfirmationPage.getOrderConfirmMessage());
		orderRefNumber = orderConfirmationPage.getOrderReferenceNumber();
	}

	@When("^I navigate to the order histroy section in my account$")
	public void I_navigate_to_the_order_histroy_section_in_my_account() throws Throwable {
		homePage.goToAccountPage();
		myAccountPage = new MyAccountPage(driver);
	}

	@Then("^I should see the item ordered in order history$")
	public void I_should_see_the_item_ordered_in_order_history() throws Throwable {
		myAccountPage.clickOnOrderHistory();
		orderHistoryPage = new OrderHistoryPage(driver);
		Assert.assertEquals("OrderHistoryPage heading mismatch", "Order history", orderHistoryPage.getPageHeading());
		Assert.assertEquals("Order reference number mismatch", orderRefNumber, orderHistoryPage.getRecentOrderId());

	}

	@When("^I navigate to Personal information page$")
	public void I_navigate_to_Personal_information_page() throws Throwable {
		myAccountPage.clickOnPersonalInformation();
		yourPersonalInformationPage = new YourPersonalInformationPage(driver);
		Assert.assertEquals("YourPersonalInformationPage heading mismatch", "Your personal information", yourPersonalInformationPage.getPageHeading());

	}

	@When("^I update the first name of the user$")
	public void I_update_the_first_name_of_the_user() throws Throwable {
		yourPersonalInformationPage.enterFirstName(Config.getConfigData("updatedFirstName"));
		yourPersonalInformationPage.enterOldPassword(Config.getConfigData("password"));
		yourPersonalInformationPage.savePersonalInfo();
	}

	@Then("^I shuold see the \"([^\"]*)\" message$")
	public void I_shuold_see_the_message(String sucessMessage) throws Throwable {
		Assert.assertEquals("First name update success msessage mismatch", "Your personal information has been successfully updated.", yourPersonalInformationPage.getPersonalInfoSucessMessage());
	}

}
