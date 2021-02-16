package com.automationpractice.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreActions {
	public WebDriver driver;

	public CoreActions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Enter data into a field
	 * 
	 * @param element
	 * @param data
	 * @param elementName
	 */
	public void type(WebElement element, String data) {
		waitForVisibilityOfElement(element);
		element.clear();
		element.sendKeys(data);
	}

	/**
	 * Click on element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void click(WebElement element) {
		waitForVisibilityOfElement(element);
		element.click();
	}

	/**
	 * Wait for visibility of element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void waitForVisibilityOfElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, WaitTime.MAX_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Retrives the text of the element
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	public String getText(WebElement element) {
		waitForVisibilityOfElement(element);
		String text = element.getText().trim();
		return text;
	}
	
	/**
	 * Perform mouse over
	 * @param element
	 */
	public void performMouseOver(WebElement element)
	{
		waitForVisibilityOfElement(element);
		Actions act=new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	/**
	 * Mouse over element1 and click on elemen2
	 * @param element1
	 * @param elemen2
	 */
	public void mouseOverAndClick(WebElement element1,WebElement elemen2)
	{
		waitForVisibilityOfElement(element1);
		Actions act=new Actions(driver);
		act.moveToElement(element1).moveToElement(elemen2).click().build().perform();
	}
}
