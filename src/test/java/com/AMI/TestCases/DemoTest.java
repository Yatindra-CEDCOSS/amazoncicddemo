package com.AMI.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ami.resources.BaseClass;

public class DemoTest extends BaseClass{
	
	@Test
	public void testPageIsOpened() {
		WebElement ele = util.getDriver().findElement(By.name("q"));
		boolean eleIsVisible = ele.isDisplayed();
		Assert.assertTrue(eleIsVisible, "Input field is not visible.");
	}

}
