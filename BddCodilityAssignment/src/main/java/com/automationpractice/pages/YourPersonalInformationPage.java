package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class YourPersonalInformationPage {

	public WebDriver driver;
	CoreActions coreActions;

	public YourPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, YourPersonalInformationPage.class);
	}

	@FindBy(id = "firstname")
	WebElement textFirstName;

	@FindBy(className = "page-heading")
	WebElement labelPageHeading;

	@FindBy(xpath = ".//input[@name='old_passwd']")
	WebElement txtOldPassword;
	
	@FindBy(xpath = ".//h1[@class='page-subheading']/following-sibling::p")
	WebElement labelPersonalInfoSucess;

	@FindBy(xpath = ".//button[@name='submitIdentity']")
	WebElement buttonSave;


	public String getPageHeading() {
		return coreActions.getText(labelPageHeading);
	}

	public void enterFirstName(String firstName) {
		coreActions.type(textFirstName, firstName);
	}

	public void enterOldPassword(String password) {
		coreActions.type(txtOldPassword, password);
	}

	public String getPersonalInfoSucessMessage() {
		return coreActions.getText(labelPersonalInfoSucess);
	}

	public void savePersonalInfo() {
		coreActions.click(buttonSave);
	}

}
