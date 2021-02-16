package com.automationpractice.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationpractice.utility.Config;

public class BaseTest {

	public static WebDriver driver;

	public static void setUp() throws IOException {
		String browser = Config.getConfigData("browser");
		String URL = Config.getConfigData("URL");
		driver = initiateBrowser(browser.toUpperCase().trim());
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(WaitTime.MIN_WAIT, TimeUnit.SECONDS);

	}

	public static WebDriver initiateBrowser(String browser) {
		String driversPath = System.getProperty("user.dir") + "\\drivers\\";
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", driversPath + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static String capture(WebDriver driver, String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\screenShots\\" + fileName + "_"
				+ new SimpleDateFormat("yyyyMMdd_HH_mm_ss").format(Calendar.getInstance().getTime()) + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}

}
