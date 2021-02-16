package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class MyAccountPage {

	public WebDriver driver;
	CoreActions coreActions;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, MyAccountPage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//a[@title='Orders']")
	WebElement linkOrders;
	
	@FindBy(xpath = ".//a[@title='Information']")
	WebElement linkPeronalInformation;

	public void clickOnOrderHistory() {
		coreActions.click(linkOrders);
	}
	
	public void clickOnPersonalInformation() {
		coreActions.click(linkPeronalInformation);
	}

	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

}
