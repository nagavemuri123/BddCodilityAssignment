package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class TShirtsPage {

	public WebDriver driver;
	CoreActions coreActions;

	public TShirtsPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, TShirtsPage.class);
	}

	@FindBy(xpath = ".//img[@title='Faded Short Sleeve T-shirts']")
	WebElement imgAvailableTShirt;
	
	@FindBy(className = "page-heading")
	WebElement labelPageHeading;
	
	@FindBy(xpath = ".//a[@title='Add to cart']")
	WebElement buttonAddToCart;
	
	@FindBy(xpath = ".//a[@title='Proceed to checkout']")
	WebElement buttonProceedToCheckout;
	
	public void addTShirtToCart()
	{
		coreActions.mouseOverAndClick(imgAvailableTShirt, buttonAddToCart);
		coreActions.click(buttonProceedToCheckout);
	}
	
	public String getPageHeading()
	{
		return coreActions.getText(labelPageHeading);
	}

	
}
