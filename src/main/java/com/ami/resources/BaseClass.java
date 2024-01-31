package com.ami.resources;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {

	protected Utilities util = Utilities.getObject();

	protected Properties prop;

	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void launchingMethod(@Optional String browser) {

		util.openLoginPage(browser, "https://www.google.com");

	}

	@AfterClass(alwaysRun = false)
	public void closeBrowser() {
		util.getDriver().quit();
	}

	public String getScreenShotPath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) util.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/ScreenshotFailedTestCases/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
