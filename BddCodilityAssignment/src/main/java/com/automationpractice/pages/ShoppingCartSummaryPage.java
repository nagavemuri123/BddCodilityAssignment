package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class ShoppingCartSummaryPage {

	public WebDriver driver;
	CoreActions coreActions;

	public ShoppingCartSummaryPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, ShoppingCartSummaryPage.class);
	}
	
	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//td[@class='cart_description']//p[@class='product-name']")
	WebElement itemInCart;
	
	@FindBy(xpath = ".//a[@title='Add to cart']")
	WebElement buttonAddToCart;
	
	@FindBy(xpath = "(.//a[@title='Proceed to checkout'])[2]")
	WebElement buttonProceedToCheckout;
	
	public void clickOnProceedToCheckout()
	{
		coreActions.click(buttonProceedToCheckout);
	}

	public String getPageHeading()
	{
		return coreActions.getText(labelPageHeading);
	}

	public String getProductName()
	{
		return coreActions.getText(itemInCart);
	}
	
	
}
