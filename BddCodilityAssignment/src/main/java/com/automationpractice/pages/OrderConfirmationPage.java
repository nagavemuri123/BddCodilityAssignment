package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class OrderConfirmationPage {

	public WebDriver driver;
	CoreActions coreActions;

	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, OrderConfirmationPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//strong[text()='Your order on My Store is complete.']")
	WebElement labelOrderConfirmMsg;

	@FindBy(xpath = ".//strong[text()='RTP']/following-sibling::br[1]")
	WebElement labelOrderRefNumber;
	
	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

	public String getOrderConfirmMessage() {
		return coreActions.getText(labelOrderConfirmMsg);
	}
	
	public String getOrderReferenceNumber()
	{
		return coreActions.getText(labelOrderRefNumber).replace("- Do not forget to insert your order reference", "").trim().substring(0,9);
	}

}
