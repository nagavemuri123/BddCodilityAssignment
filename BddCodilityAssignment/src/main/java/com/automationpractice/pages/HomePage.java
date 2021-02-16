package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class HomePage {

	public WebDriver driver;
	CoreActions coreActions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, HomePage.class);
	}

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;
	
	@FindBy(xpath = ".//a[@title='View my customer account']")
	WebElement linkAccountSummaryPage;
	
	@FindBy(linkText = "T-shirts")
	WebElement linkTshirt;
	
	public void clickOnTShirtsLink()
	{
		coreActions.click(linkTshirt);
	}
	
	public void goToAccountPage()
	{
		coreActions.click(linkAccountSummaryPage);
	}
	
	public String getPageHeading()
	{
		return coreActions.getText(labelPageHeading);
	}

	
	
}
