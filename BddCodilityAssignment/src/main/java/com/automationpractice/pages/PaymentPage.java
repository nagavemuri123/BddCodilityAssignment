package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class PaymentPage {

	public WebDriver driver;
	CoreActions coreActions;

	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, PaymentPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//a[@title='Proceed to checkout']")
	WebElement buttonProceedToCheckout;
	
	@FindBy(xpath = ".//a[@title='Pay by bank wire']")
	WebElement linkPayByWrite;


	public void clickOnProceedToCheckout() {
		coreActions.click(buttonProceedToCheckout);
	}
	
	public void selectPayByWrite() {
		coreActions.click(linkPayByWrite);
	}


	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

}
