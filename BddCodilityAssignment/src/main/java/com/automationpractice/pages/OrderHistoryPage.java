package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class OrderHistoryPage {

	public WebDriver driver;
	CoreActions coreActions;

	public OrderHistoryPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, OrderHistoryPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//tr[@class='first_item ']/td[1]/a")
	WebElement labelLatestOrderId;

	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

	public String getRecentOrderId() {
		return coreActions.getText(labelLatestOrderId);
	}

}
