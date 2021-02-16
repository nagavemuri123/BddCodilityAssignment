package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class ShippingPage {

	public WebDriver driver;
	CoreActions coreActions;

	public ShippingPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, ShippingPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(name = "processCarrier")
	WebElement buttonProceedToCheckout;
	
	@FindBy(xpath = ".//input[@id='cgv']")
	WebElement checkBoxAgreeTermsAndConditions;

	public void clickOnProceedToCheckout() {
		coreActions.click(buttonProceedToCheckout);
	}
	
	public void agreeTermsAndConditions() {
		coreActions.click(checkBoxAgreeTermsAndConditions);
	}

	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

}
