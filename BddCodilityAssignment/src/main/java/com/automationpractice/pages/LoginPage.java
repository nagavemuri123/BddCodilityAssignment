package com.automationpractice.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.base.CoreActions;

public class LoginPage {

	public WebDriver driver;
	CoreActions coreActions;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		coreActions = new CoreActions(driver);
		PageFactory.initElements(driver, LoginPage.class);
	}

	@FindBy(id = "email")
	WebElement txtFieldUserName;

	@FindBy(id = "passwd")
	WebElement txtFieldPassword;

	@FindBy(id = "SubmitLogin")
	WebElement buttonLogin;

	public void enteruserName(String userName) {
		coreActions.type(txtFieldUserName, userName);
	}

	public void enterPassword(String password) {
		coreActions.type(txtFieldPassword, password);
	}

	public void clickLogin() {
		coreActions.click(buttonLogin);
	}

	public void login(String username,String password)
	{
		enteruserName(username);
		enterPassword(password);
		clickLogin();
	}
}
