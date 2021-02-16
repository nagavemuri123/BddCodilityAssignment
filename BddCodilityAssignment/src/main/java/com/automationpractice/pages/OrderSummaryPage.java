package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class OrderSummaryPage {

	public WebDriver driver;
	CoreActions coreActions;

	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, OrderSummaryPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;
	
	@FindBy(className = "page-subheading")
	WebElement labelPaymentSubHeading;

	@FindBy(xpath = ".//span[text()='I confirm my order']/parent::button")
	WebElement buttonConfirmOrder;

	public void clickOnConfirmOrder() {
		coreActions.click(buttonConfirmOrder);
	}

	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}
	
	public String getPaymentHeading() {
		return coreActions.getText(labelPaymentSubHeading);
	}

}
