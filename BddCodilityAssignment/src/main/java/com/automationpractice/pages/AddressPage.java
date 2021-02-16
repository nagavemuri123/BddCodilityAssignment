package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class AddressPage {

	public WebDriver driver;
	CoreActions coreActions;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, AddressPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//a[@title='Proceed to checkout']")
	WebElement buttonProceedToCheckout;

	public void clickOnProceedToCheckout() {
		coreActions.click(buttonProceedToCheckout);
	}

	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

}
